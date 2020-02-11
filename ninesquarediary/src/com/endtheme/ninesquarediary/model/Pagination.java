package com.endtheme.ninesquarediary.model;

import java.util.List;

public class Pagination {

	private List<Diary> diaryList; // 查到的日记list

	private int curentPage; // 当前页
	private int totalPage; // 总页数
	private int pageSize; // 一页显示多少
	
	private int startNum; // 查询起始条数
	

	// 根据当前页 计算从第几行开始查询
	public int getStartNum() {
		startNum = (getCurentPage() - 1) * getPageSize();
		return startNum;
	}

	public List<Diary> getDiaryList() {
		return diaryList;
	}

	public void setDiaryList(List<Diary> diaryList) {
		this.diaryList = diaryList;
	}

	public int getCurentPage() {
		return curentPage;
	}

	public void setCurentPage(int curentPage) {
		this.curentPage = curentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
