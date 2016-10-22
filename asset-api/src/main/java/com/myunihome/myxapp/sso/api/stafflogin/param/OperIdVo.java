package com.myunihome.myxapp.sso.api.stafflogin.param;

import java.io.Serializable;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 操作员ID查询参数
 *
 * Date: 2015年11月23日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * @author gucl
 */
public class OperIdVo extends BaseInfo implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 操作员ID
	 */
    private Long operId;

	public Long getOperId() {
		return operId;
	}

	public void setOperId(Long operId) {
		this.operId = operId;
	}


}
