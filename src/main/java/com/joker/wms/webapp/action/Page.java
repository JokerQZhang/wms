package com.joker.wms.webapp.action;

public class Page {
	private Integer pageSize;
	private Integer pageIndex;
	private Integer pageNum;
	private Integer allRecordNum;
	
    public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getAllRecordNum() {
		return allRecordNum;
	}
	//设置总计路数即设置总页数
	public void setAllRecordNum(Integer allRecordNum) {
		this.allRecordNum = allRecordNum;
		Double calculageNum = Math.ceil((double)allRecordNum/pageSize);
		this.pageNum = calculageNum.intValue();
	}
}
