package com.myunihome.myxapp.sys.api.sysipmap.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 
 * Date: 2015年12月1日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author jiaxs
 */
public class GnTabSysIpMapResponseVO extends BaseInfo implements java.io.Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 响应码（成功or失败or其他）
	 */
	public String responseCode;
	
	/**
	 * 响应描述
	 */
	public String respondeDesc;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getRespondeDesc() {
        return respondeDesc;
    }

    public void setRespondeDesc(String respondeDesc) {
        this.respondeDesc = respondeDesc;
    }

}
