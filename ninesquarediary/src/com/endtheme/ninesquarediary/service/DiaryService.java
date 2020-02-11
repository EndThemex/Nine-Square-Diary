package com.endtheme.ninesquarediary.service;

import com.endtheme.ninesquarediary.model.Diary;
import com.endtheme.ninesquarediary.model.Pagination;
import com.endtheme.ninesquarediary.model.User;

public interface DiaryService {

	int saveDiary(Diary diary);

	Pagination queryDiary(Integer curentPage, User user);

}
