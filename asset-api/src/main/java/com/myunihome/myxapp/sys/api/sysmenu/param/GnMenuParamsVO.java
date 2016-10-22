package com.myunihome.myxapp.sys.api.sysmenu.param;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.myunihome.myxapp.base.vo.BaseInfo;
import com.myunihome.myxapp.base.vo.PageInfo;

/**
 * 菜单操作参数 <br>
 * Date: 2015年9月17日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author liangbs
 */
public class GnMenuParamsVO extends BaseInfo implements Serializable {

    private static final long serialVersionUID = -4305979943876069155L;

    /**
     * 菜单id
     */
    private Long menuId;

    /**
     * 菜单名称 不能为空
     */
    private String menuName;
    
    /**
     * 菜单描述
     */
    private String menuDesc;

    /**
     * 上级菜单编码 不能为空
     */
    private Long menuPid;
    
    /**
     * 菜单URL
     */
    private String menuUrl;
    
    /**
     * 菜单图片
     */
    private String menuPic;
    
    /**
     *系统模块标识 不能为空
     */
    private String systemModeId;
    
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
     * 系统标识 不能为空
     */
    private String systemId;
    
    /**
     * 过滤的菜单id集合
     */
    private List<Long> filterMenuIdList;
    
    /**
     * 分页信息
     */
    private PageInfo<GnMenuVO> pageInfo;
    

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public Long getMenuPid() {
        return menuPid;
    }

    public void setMenuPid(Long menuPid) {
        this.menuPid = menuPid;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuPic() {
        return menuPic;
    }

    public void setMenuPic(String menuPic) {
        this.menuPic = menuPic;
    }

    public String getSystemModeId() {
        return systemModeId;
    }

    public void setSystemModeId(String systemModeId) {
        this.systemModeId = systemModeId;
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

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public PageInfo<GnMenuVO> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<GnMenuVO> pageInfo) {
        this.pageInfo = pageInfo;
    }

	public List<Long> getFilterMenuIdList() {
		return filterMenuIdList;
	}

	public void setFilterMenuIdList(List<Long> filterMenuIdList) {
		this.filterMenuIdList = filterMenuIdList;
	}

}
