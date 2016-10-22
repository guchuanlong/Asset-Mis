package com.myunihome.myxapp.sso.api.userlogin.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 返回参数
 * @author Becky
 *
 */
public class ResponseParam extends BaseInfo implements java.io.Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6324903212152408853L;

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
