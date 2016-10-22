package com.myunihome.myxapp.sso.api.systemmode.mapper;

import com.myunihome.myxapp.base.vo.BaseInfo;

public class SystemModeQueryVO extends BaseInfo{
    private static final long serialVersionUID = 1L;

	private String systemModeId;

    public String getSystemModeId() {
        return systemModeId;
    }

    public void setSystemModeId(String systemModeId) {
        this.systemModeId = systemModeId == null ? null : systemModeId.trim();
    }
}