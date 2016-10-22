package com.myunihome.myxapp.sso.api.userlogin.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

public class UpdateUserStateVO extends BaseInfo
{

	private static final long serialVersionUID = 1L;
	
	private Long userId;
	
	private String state;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
