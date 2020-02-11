package com.endtheme.ninesquarediary.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.endtheme.ninesquarediary.dao.DiaryDao;
import com.endtheme.ninesquarediary.model.Diary;
import com.endtheme.ninesquarediary.model.Pagination;
import com.endtheme.ninesquarediary.model.User;
import com.endtheme.ninesquarediary.util.StringUtil;

public class DiaryDaoImpl implements DiaryDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int save(Diary diary) {
		String sql = "INSERT INTO diary_tb (title, user_id, img_url, create_time, update_time) VALUES (?, ?, ?, NOW(), NOW())";
		int update = 0;
		try {
		update = jdbcTemplate.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement stmt) throws SQLException {
				stmt.setString(1, diary.getTitle());
				stmt.setInt(2, diary.getUserId());
				stmt.setString(3, diary.getImgUrl());
			}
		});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return update;
	}

	@Override
	public Pagination queryDiary(Integer curentPage, User user) {
		Pagination pagination = new Pagination();
		int pageSize = 9;
		pagination.setPageSize(pageSize);
		pagination.setCurentPage(curentPage);
		
		List<Diary> diaryList = new ArrayList<Diary>();
		
		// 将查询结果用 diary 对象封装
		RowMapper<Diary> rowMapper = new RowMapper<Diary>() {
			@Override
			public Diary mapRow(ResultSet rs, int rowNum) throws SQLException {
				Diary diary = new Diary();
				diary.setId(rs.getInt("id"));
				diary.setTitle(rs.getString("title"));
				diary.setCreateTime(rs.getDate("create_time"));
				diary.setImgUrl(rs.getString("img_url"));
				diary.setPublish(rs.getInt("publish"));
				diary.setStarts(rs.getInt("starts"));
				diary.setUserId(rs.getInt("user_id"));
				diary.setNickName(rs.getString("nick_name"));
				diary.setCommentCount(rs.getInt("comment_count"));
				return diary;
			}
		};
		// 查询数据库语句
		String sql = "";
		// 判断是否登录
		if (user == null || StringUtil.isEmpty(user.getUserName())) {
			// 未登录的话
			sql = "SELECT diary_tb.*, user_tb.nick_name FROM diary_tb, user_tb WHERE diary_tb.publish = 1 AND diary_tb.is_deleted = 0 AND diary_tb.user_id = user_tb.id ORDER BY diary_tb.create_time DESC LIMIT ?, ?";
			diaryList = jdbcTemplate.query(sql, new PreparedStatementSetter() {
				
				// 设置分页条件
				@Override
				public void setValues(PreparedStatement stmt) throws SQLException {
					stmt.setInt(1, pagination.getStartNum());
					stmt.setInt(2, pagination.getPageSize());
				}
			}, rowMapper);
		}
		// 查询总日记数
		pagination.setTotalPage(queryTotalPage(user));
		pagination.setDiaryList(diaryList);
		return pagination;
	}
	
	/**
	 * 	查询
	 * @return
	 */
	public int queryTotalPage(User user) {
		String sql = "SELECT COUNT(id) FROM diary_tb WHERE publish = 1 AND is_deleted = 0";
		int count = 0;
		count = jdbcTemplate.queryForInt(sql);
		return count;
	}
	

}
