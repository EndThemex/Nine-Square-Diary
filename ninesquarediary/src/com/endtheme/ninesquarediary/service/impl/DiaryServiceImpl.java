package com.endtheme.ninesquarediary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.endtheme.ninesquarediary.dao.DiaryDao;
import com.endtheme.ninesquarediary.model.Diary;
import com.endtheme.ninesquarediary.model.Pagination;
import com.endtheme.ninesquarediary.model.User;
import com.endtheme.ninesquarediary.service.DiaryService;

public class DiaryServiceImpl implements DiaryService {

	@Autowired
	private DiaryDao diaryDao;

	public void setDiaryDao(DiaryDao diaryDao) {
		this.diaryDao = diaryDao;
	}

	/**
	 * 	保存图片日记
	 */
	@Override
	public int saveDiary(Diary diary) {
		diaryDao.save(diary);
		return 0;
	}

	/**
	 * 	查询日记
	 */
	@Override
	public Pagination queryDiary(Integer curentPage, User user) {
		Pagination pagination = diaryDao.queryDiary(curentPage, user);
		return pagination;
	}
	
}
