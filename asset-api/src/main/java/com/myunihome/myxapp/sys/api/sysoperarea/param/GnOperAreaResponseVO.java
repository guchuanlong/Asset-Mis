package com.myunihome.myxapp.sys.api.sysoperarea.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 响应信息
 * Date: 2015年10月10日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author liangbs
 */
public class GnOperAreaResponseVO extends BaseInfo implements java.io.Serializable{
	
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
