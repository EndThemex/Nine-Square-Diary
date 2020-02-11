package com.endtheme.ninesquarediary.dao;

import com.endtheme.ninesquarediary.model.Diary;
import com.endtheme.ninesquarediary.model.Pagination;
import com.endtheme.ninesquarediary.model.User;

public interface DiaryDao {

	int save(Diary diary);

	Pagination queryDiary(Integer curentPage, User user);

}
