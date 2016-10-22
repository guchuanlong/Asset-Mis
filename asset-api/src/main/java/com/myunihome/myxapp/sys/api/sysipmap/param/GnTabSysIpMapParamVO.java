package com.myunihome.myxapp.sys.api.sysipmap.param;

import com.myunihome.myxapp.base.vo.BaseInfo;
import com.myunihome.myxapp.base.vo.PageInfo;

public class GnTabSysIpMapParamVO extends BaseInfo {
    private static final long serialVersionUID = 1L;
    
    private String systemId;

    private String connectIp;

    private String connectPort;
    
	private String mappedId;

    private String remark;
    
    /**
     * 分页信息
     */
    private PageInfo<GnTabSysIpMapVO> pageInfo;

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

	public PageInfo<GnTabSysIpMapVO> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<GnTabSysIpMapVO> pageInfo) {
		this.pageInfo = pageInfo;
	}
}