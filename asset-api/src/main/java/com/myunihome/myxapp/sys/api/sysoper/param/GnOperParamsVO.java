package com.myunihome.myxapp.sys.api.sysoper.param;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.myunihome.myxapp.base.vo.BaseInfo;
import com.myunihome.myxapp.base.vo.PageInfo;

/**
 * 操作员操作参数 <br>
 * Date: 2015年10月10日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author liangbs
 */
public class GnOperParamsVO extends BaseInfo implements Serializable {

    private static final long serialVersionUID = -4305979943876069155L;

    /**
     * 操作员id 不能为空
     */
    private Long operId;
    
    /**
     * 操作员编码 不能为空
     */
    private String operCode;

    /**
     * 工号id 不能为空
     */
    private Long staffnoId;

    /**
     * 归属组织类型 不能为空
     */
    private String orgType;

    /**
     * 归属组织 不能为空
     */
    private String orgId;

    /**
     * 状态 不能为空
     */
    private String state;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 创建操作员id
     */
    private Long createOperId;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

    /**
     * 更新员工
     */
    private Long updateOperId;
    
    /**
     * 工号idList
     */
    private List<Long> staffnoIdList;
    
    /**
     * 分页信息
     */
    private PageInfo<GnOperVO> pageInfo;

    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
    }

    public String getOperCode() {
        return operCode;
    }

    public void setOperCode(String operCode) {
        this.operCode = operCode;
    }

    public Long getStaffnoId() {
        return staffnoId;
    }

    public void setStaffnoId(Long staffnoId) {
        this.staffnoId = staffnoId;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public PageInfo<GnOperVO> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<GnOperVO> pageInfo) {
        this.pageInfo = pageInfo;
    }

	public List<Long> getStaffnoIdList() {
		return staffnoIdList;
	}

	public void setStaffnoIdList(List<Long> staffnoIdList) {
		this.staffnoIdList = staffnoIdList;
	}
    
}
