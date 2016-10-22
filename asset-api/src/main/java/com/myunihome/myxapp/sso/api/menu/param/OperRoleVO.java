package com.myunihome.myxapp.sso.api.menu.param;

import java.io.Serializable;
import java.sql.Timestamp;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 操作员角色关系VO
 * 
 * @author Becky
 * 
 */
public class OperRoleVO extends BaseInfo implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7906710570605249312L;

	/**
	 * 操作员角色关系ID
	 */
	private Long operRoleRelId;

	/**
	 * 操作员ID
	 */
	private Long operId;

	/**
	 * 角色ID
	 */
	private Long roleId;

	/**
	 * 生效时间
	 */
	private Timestamp activeTime;

	/**
	 * 失效时间
	 */
	private Timestamp inactiveTime;

	/**
	 * 创建类型
	 * 1：前台创建
	 * 0：接口同步创建
	 */
	private String createType;

	/**
	 * 创建时间
	 */
	private Timestamp createTime;

	/**
	 * 创建操作员ID
	 */
	private Long createOperId;

	/**
	 * 更新时间
	 */
	private Timestamp updateTime;

	/**
	 * 更新操作员ID
	 */
	private Long updateOperId;


	/**
	 * 角色名称
	 */
	private String roleName;

	public Long getOperRoleRelId() {
		return operRoleRelId;
	}

	public void setOperRoleRelId(Long operRoleRelId) {
		this.operRoleRelId = operRoleRelId;
	}

	public Long getOperId() {
		return operId;
	}

	public void setOperId(Long operId) {
		this.operId = operId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
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
		this.inactiveTime = (inactiveTime == null?null:new Timestamp(inactiveTime.getTime()));
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


	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public static Long getSerialversionuid() {
		return serialVersionUID;
	}

}
