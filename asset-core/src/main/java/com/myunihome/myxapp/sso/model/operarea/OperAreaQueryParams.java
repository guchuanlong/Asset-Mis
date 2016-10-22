package com.myunihome.myxapp.sso.model.operarea;

import java.sql.Timestamp;
import java.util.List;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 操作员区域查询条件对象
 * Date: 2016年1月6日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author jiaxs
 */
public class OperAreaQueryParams extends BaseInfo {

	private static final long serialVersionUID = 1L;
	
	private String areaCode;
	
	private List<Long> operIdList;
	
	private Timestamp activeTime;
	
	private Timestamp inactiveTime;

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public List<Long> getOperIdList() {
		return operIdList;
	}

	public void setOperIdList(List<Long> operIdList) {
		this.operIdList = operIdList;
	}
	
	public Timestamp getActiveTime() {
    	return activeTime == null?null:new Timestamp(activeTime.getTime());
    }

    public void setActiveTime(Timestamp activeTime) {
        this.activeTime = (activeTime==null?null:new Timestamp(activeTime.getTime()));
    }

    public Timestamp getInactiveTime() {
    	return inactiveTime == null?null:new Timestamp(inactiveTime.getTime());
    }

    public void setInactiveTime(Timestamp inactiveTime) {
        this.inactiveTime = (inactiveTime==null?null:new Timestamp(inactiveTime.getTime()));
    }

}
