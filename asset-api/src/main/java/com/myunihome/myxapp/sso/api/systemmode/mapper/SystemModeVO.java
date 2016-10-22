package com.myunihome.myxapp.sso.api.systemmode.mapper;

import com.myunihome.myxapp.base.vo.BaseInfo;

public class SystemModeVO extends BaseInfo{
    private static final long serialVersionUID = 1L;

	private String systemModeId;

    private String systemModeName;

    private String systemUrlContext;

    public String getSystemModeId() {
        return systemModeId;
    }

    public void setSystemModeId(String systemModeId) {
        this.systemModeId = systemModeId == null ? null : systemModeId.trim();
    }

    public String getSystemModeName() {
        return systemModeName;
    }

    public void setSystemModeName(String systemModeName) {
        this.systemModeName = systemModeName == null ? null : systemModeName.trim();
    }

    public String getSystemUrlContext() {
        return systemUrlContext;
    }

    public void setSystemUrlContext(String systemUrlContext) {
        this.systemUrlContext = systemUrlContext == null ? null : systemUrlContext.trim();
    }
}