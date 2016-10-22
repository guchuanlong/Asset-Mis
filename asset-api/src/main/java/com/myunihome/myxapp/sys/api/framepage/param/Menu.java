package com.myunihome.myxapp.sys.api.framepage.param;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单信息<br>
 * Date: 2015年11月27日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author zhangchao
 */
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单id
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
     * 上级菜单
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
    
    private String systemUrlContext;

    /**
     * 是否有满足条件的下级菜单
     */
    private List<Menu> subMenus = new ArrayList<Menu>();;

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

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public List<Menu> getSubMenus() {
        return subMenus;
    }

	public void setSubMenus(List<Menu> subMenus) {
		this.subMenus = subMenus;
	}
	
	public String getSystemUrlContext() {
        return systemUrlContext;
    }

    public void setSystemUrlContext(String systemUrlContext) {
        this.systemUrlContext = systemUrlContext == null ? null : systemUrlContext.trim();
    }

}
