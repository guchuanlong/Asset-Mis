package com.myunihome.myxapp.sso.api.stafflogin.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 工号服务返回对象
 * Date: 2015年12月14日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author jiaxs
 */
public class StaffNoResponseVO extends BaseInfo implements java.io.Serializable{
	

	private static final long serialVersionUID = 1L;

	/**
	 * 返回编码
	 */
	public String responseCode;
	
	/**
	 * 返回信息
	 */
	public String respondeDescribe;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getRespondeDescribe() {
		return respondeDescribe;
	}

	public void setRespondeDescribe(String respondeDescribe) {
		this.respondeDescribe = respondeDescribe;
	}

}
