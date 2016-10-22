package com.myunihome.myxapp.sso.api.ipmap.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

public class TabSysIpMapQueryVO extends BaseInfo{
    private static final long serialVersionUID = 1L;

	private String systemId;

    private String connectIp;

    private String connectPort;

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId == null ? null : systemId.trim();
    }

    public String getConnectIp() {
        return connectIp;
    }

    public void setConnectIp(String connectIp) {
        this.connectIp = connectIp == null ? null : connectIp.trim();
    }

    public String getConnectPort() {
        return connectPort;
    }

    public void setConnectPort(String connectPort) {
        this.connectPort = connectPort == null ? null : connectPort.trim();
    }
}