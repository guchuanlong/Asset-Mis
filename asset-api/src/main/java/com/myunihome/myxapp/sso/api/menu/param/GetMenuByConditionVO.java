package com.myunihome.myxapp.sso.api.menu.param;

import java.io.Serializable;
import java.util.List;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 获取操作员菜单返回VO
 * Date: 2015年9月24日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author liangbs
 */
public class GetMenuByConditionVO extends BaseInfo implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1692228878351893630L;

	/**
	 * 菜单ID
	 */
	private Long menuId;

	/**
	 * 菜单名称
	 */
    private String menuName;

	/**
	 * 菜单描述
	 */
    private String menuDesc;

	/**
	 * 上级菜单编码
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
	 * 系统模块标识
	 */
    private String systemModeId;

	/**
	 * 系统标识
	 */
    private String systemId;

    /**
     * 子菜单 
     */
    private List<GetMenuByConditionVO> childMenu;
 
    
	public List<GetMenuByConditionVO> getChildMenu() {
		return childMenu;
	}

	public void setChildMenu(List<GetMenuByConditionVO> childMenu) {
		this.childMenu = childMenu;
	}

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

    public String getSystemModeId() {
        return systemModeId;
    }

    public void setSystemModeId(String systemModeId) {
        this.systemModeId = systemModeId;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getMenuPic() {
        return menuPic;
    }

    public void setMenuPic(String menuPic) {
        this.menuPic = menuPic;
    }

}
