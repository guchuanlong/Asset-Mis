package com.myunihome.myxapp.sso.api.userlogin.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

public class UserLoginByTelQueryVO extends BaseInfo{

	private static final long serialVersionUID = 1L;
	
	private String userIphone;

	public String getUserIphone() {
		return userIphone;
	}

	public void setUserIphone(String userIphone) {
		this.userIphone = userIphone;
	}

}
