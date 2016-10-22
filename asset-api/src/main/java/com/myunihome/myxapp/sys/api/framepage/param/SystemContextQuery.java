package com.myunihome.myxapp.sys.api.framepage.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

public class SystemContextQuery extends BaseInfo{
    private static final long serialVersionUID = 1L;
    
	private String systemId;

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId == null ? null : systemId.trim();
    }
}