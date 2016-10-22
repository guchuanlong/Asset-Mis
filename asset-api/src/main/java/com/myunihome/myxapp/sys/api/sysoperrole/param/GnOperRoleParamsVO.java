package com.myunihome.myxapp.sys.api.sysoperrole.param;

import java.io.Serializable;
import java.sql.Timestamp;

import com.myunihome.myxapp.base.vo.BaseInfo;
import com.myunihome.myxapp.base.vo.PageInfo;

/**
 * 操作员拥有角色操作参数 <br>
 * Date: 2015年10月10日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author liangbs
 */
public class GnOperRoleParamsVO extends BaseInfo implements Serializable {

    private static final long serialVersionUID = -4305979943876069155L;

    /** 操作员角色关系id（非空） **/
    private Long operRoleRelId;

    /** 工号id（非空） **/
    private Long staffnoId;
    
    /** 角色id（非空） **/
    private Long roleId;

    /** 角色名称 **/
    private String roleName;

    /** 生效时间 **/
    private Timestamp activeTime;

    /** 失效时间 **/
    private Timestamp inactiveTime;

    /** 创建类型 **/
    private String createType;

    /** 创建时间 **/
    private Timestamp createTime;

    /** 创建操作员id **/
    private Long createOperId;

    /** 更新时间 **/
    private Timestamp updateTime;

    /** 更新操作员id **/
    private Long updateOperId;
    
    /**
     * 分页信息
     */
    private PageInfo<GnOperRoleVO> pageInfo;

    public Long getOperRoleRelId() {
        return operRoleRelId;
    }

    public void setOperRoleRelId(Long operRoleRelId) {
        this.operRoleRelId = operRoleRelId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getStaffnoId() {
		return staffnoId;
	}

	public void setStaffnoId(Long staffnoId) {
		this.staffnoId = staffnoId;
	}

	public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Timestamp getActiveTime() {
    	return activeTime == null?null:new Timestamp(activeTime.getTime());
    }

    public void setActiveTime(Timestamp activeTime) {
        this.activeTime = (activeTime == null?null:new Timestamp(activeTime.getTime()));
    }

    public Timestamp getInactiveTime() {
        return inactiveTime == null?null:new Timestamp(inactiveTime.getTime());
    }

    public void setInactiveTime(Timestamp inactiveTime) {
        this.inactiveTime = (inactiveTime == null?null:new Timestamp(inactiveTime.getTime()));;
    }

    public String getCreateType() {
        return createType;
    }

    public void setCreateType(String createType) {
        this.createType = createType;
    }

    public Timestamp getCreateTime() {
        return createTime == null?null:new Timestamp(createTime.getTime());
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = (createTime == null?null:new Timestamp(createTime.getTime()));
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
        this.updateTime = (updateTime == null?null:new Timestamp(updateTime.getTime()));
    }

    public Long getUpdateOperId() {
        return updateOperId;
    }

    public void setUpdateOperId(Long updateOperId) {
        this.updateOperId = updateOperId;
    }

    public PageInfo<GnOperRoleVO> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<GnOperRoleVO> pageInfo) {
        this.pageInfo = pageInfo;
    }
    
}
