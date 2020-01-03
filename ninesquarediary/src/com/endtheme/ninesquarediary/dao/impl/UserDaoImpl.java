package com.endtheme.ninesquarediary.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.endtheme.ninesquarediary.dao.UserDao;
import com.endtheme.ninesquarediary.model.User;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User login(String userName, String password) {
        User user = null;
        user = queryOne(userName);

        return user;
    }

    public User queryOne(String userName) {
        String sql = "SELECT id, user_name, password FROM user_tb WHERE user_name = ?";
        List<User> userList = new ArrayList<User>();
        User user = null;
        RowMapper<User> rowMapper = new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("user_name"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        };

        userList = jdbcTemplate.query(sql, new PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement stmt) throws SQLException {
                stmt.setString(1, userName);
            }
        }, rowMapper);

        if (userList.size() > 0) {
            user = userList.get(0);
        }

        return user;
    }

}
