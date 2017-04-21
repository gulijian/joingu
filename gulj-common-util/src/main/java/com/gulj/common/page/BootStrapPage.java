package com.gulj.common.page;

import java.util.List;

public class BootStrapPage {

	private List<?> rows;
	
	// 当前页码
    private Integer page = 1;

    // 总页数
    private Integer totalPage = 0;

    // 总记录数
    private long total = 0;

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

}
