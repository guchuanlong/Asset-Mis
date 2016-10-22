package com.myunihome.myxapp.sys.api.sysipmap.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

public class GnTabSysIpMapVO extends BaseInfo {
    private static final long serialVersionUID = 1L;
    
    private String systemId;

    private String connectIp;

    private String connectPort;
    
	private String mappedId;

    private String remark;

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getConnectIp() {
		return connectIp;
	}

	public void setConnectIp(String connectIp) {
		this.connectIp = connectIp;
	}

	public String getConnectPort() {
		return connectPort;
	}

	public void setConnectPort(String connectPort) {
		this.connectPort = connectPort;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    public String getMappedId() {
        return mappedId;
    }

    public void setMappedId(String mappedId) {
        this.mappedId = mappedId == null ? null : mappedId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}