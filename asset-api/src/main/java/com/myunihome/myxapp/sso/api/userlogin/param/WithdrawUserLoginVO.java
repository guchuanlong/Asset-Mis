package com.myunihome.myxapp.sso.api.userlogin.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

public class WithdrawUserLoginVO extends BaseInfo{
	private static final long serialVersionUID = 1L;
	private Long userId;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
