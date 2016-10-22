package com.myunihome.myxapp.sso.api.system.mapper;

import com.myunihome.myxapp.base.vo.BaseInfo;

public class TabSystemVO extends BaseInfo {
	private static final long serialVersionUID = 1L;

	private String systemId;
	
    private String systemName;

    private String remark;
    
    private String systemUrlContext;

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName == null ? null : systemName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	
	public String getSystemUrlContext() {
        return systemUrlContext;
    }

    public void setSystemUrlContext(String systemUrlContext) {
        this.systemUrlContext = systemUrlContext == null ? null : systemUrlContext.trim();
    }
}