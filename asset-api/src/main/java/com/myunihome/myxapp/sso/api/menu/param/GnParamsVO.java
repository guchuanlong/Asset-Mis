package com.myunihome.myxapp.sso.api.menu.param;

import java.io.Serializable;

import com.myunihome.myxapp.base.vo.BaseInfo;

public class GnParamsVO extends BaseInfo implements Serializable {
    
    private static final long serialVersionUID = 7342060336526368764L;

    /**
     * 操作员ID
     */
    private Long operId;
    
    /**
     * 系统ID
     */
    private String systemId;
    
    /**
     * 系统模块标识
     */
    private String systemModeId;

    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getSystemModeId() {
        return systemModeId;
    }

    public void setSystemModeId(String systemModeId) {
        this.systemModeId = systemModeId;
    }
    
}