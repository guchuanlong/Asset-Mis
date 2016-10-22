package com.myunihome.myxapp.sso.api.system.mapper;

import com.myunihome.myxapp.base.vo.BaseInfo;

public class TabSystemQueryVO extends BaseInfo{
    private static final long serialVersionUID = 1L;
    
	private String systemId;

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId == null ? null : systemId.trim();
    }
}