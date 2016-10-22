package com.myunihome.myxapp.sso.api.menu.param;

import java.io.Serializable;
import java.sql.Timestamp;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 角色菜单关系VO
 * 
 * @author Becky
 * 
 */
public class RoleMenuVO extends BaseInfo implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -7449407064524616078L;

    /**
     * 角色菜单对应ID
     */
    private Long roleMenuRelId;

    /**
     * 角色
     */
    private Long roleId;

    /**
     * 菜单标识
     */
    private Long menuId;

    /**
     * 生效时间
     */
    private Timestamp activeTime;

    /**
     * 失效时间
     */
    private Timestamp inactiveTime;

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

    /**
     * 菜单名称
     */
    private String menuName;

    public Long getRoleMenuRelId() {
        return roleMenuRelId;
    }

    public void setRoleMenuRelId(Long roleMenuRelId) {
        this.roleMenuRelId = roleMenuRelId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
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

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }


    public static Long getSerialversionuid() {
        return serialVersionUID;
    }

}
