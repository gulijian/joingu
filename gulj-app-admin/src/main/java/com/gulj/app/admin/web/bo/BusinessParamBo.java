package com.gulj.app.admin.web.bo;

import lombok.Data;

@Data
public class BusinessParamBo {

	private String username;
	private String phone;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
