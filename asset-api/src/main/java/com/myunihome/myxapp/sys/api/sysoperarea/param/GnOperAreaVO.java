package com.myunihome.myxapp.sys.api.sysoperarea.param;

import java.io.Serializable;
import java.sql.Timestamp;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 操作员区域实体类
 * Date: 2015年11月26日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author jiaxs
 */
public class GnOperAreaVO extends BaseInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long operAreaRelId;

    private Long operId;

    private String areaCode;

    private Timestamp activeTime;

    private Timestamp inactiveTime;

    private String createType;

    private Timestamp createTime;

    private Long createOperId;

    private Timestamp updateTime;

    private Long updateOperId;

    public Long getOperAreaRelId() {
        return operAreaRelId;
    }

    public void setOperAreaRelId(Long operAreaRelId) {
        this.operAreaRelId = operAreaRelId;
    }

    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
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

    public String getCreateType() {
        return createType;
    }

    public void setCreateType(String createType) {
        this.createType = createType == null ? null : createType.trim();
    }

    public Timestamp getCreateTime() {
    	return createTime == null?null:new Timestamp(createTime.getTime());
    }

    public void setCreateTime(Timestamp createTime) {
    	this.createTime = (createTime==null?null:new Timestamp(createTime.getTime()));
    }

    public Long getCreateOperId() {
        return createOperId;
    }

    public void setCreateOperId(Long createOperId) {
        this.createOperId = createOperId;
    }

    public Timestamp getUpdateTime() {
    	return updateTime == null?null:new Timestamp(updateTime.getTime());
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = (updateTime==null?null:new Timestamp(updateTime.getTime()));
    }

    public Long getUpdateOperId() {
        return updateOperId;
    }

    public void setUpdateOperId(Long updateOperId) {
        this.updateOperId = updateOperId;
    }

}
