package com.myunihome.myxapp.sys.api.framepage.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

public class MenuQuery extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 操作员ID 必填
     */
    private Long operId;
    /**
     * 系统标识 必填
     */
    private String systemId;
    /**
     * 系统模块标识 必填
     */
    private String systemModeId;

    /**
     * 上级菜单
     */
    private Long menuPid;

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
    }

    public Long getMenuPid() {
        return menuPid;
    }

    public void setMenuPid(Long menuPid) {
        this.menuPid = menuPid;
    }

	public String getSystemModeId() {
		return systemModeId;
	}

	public void setSystemModeId(String systemModeId) {
		this.systemModeId = systemModeId;
	}
    
    

}
