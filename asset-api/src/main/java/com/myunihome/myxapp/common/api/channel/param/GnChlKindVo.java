package com.myunihome.myxapp.common.api.channel.param;

import java.io.Serializable;
/**
 * 渠道类型信息.<br>
 *
 * Date: 2015年10月12日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * @author zhanglh
 */
public class GnChlKindVo implements Serializable{
	/**
	 * 渠道类型编码
	 */
    private String kindId;
    /**
     * 渠道类型值
     */
    private String kindValue;
    /**
     * 上级类型编码
     */
    private String upKindId;
    /**
     * 类型级别
     */
    private String kindLevel;
    /**
     * 省份代码
     */
    private String provinceCode;
	/**
	 * 状态
	 */
    private String state;
	/**
	 * 租户id
	 */
    private String tenantId;

    public String getKindId() {
        return kindId;
    }

    public void setKindId(String kindId) {
        this.kindId = kindId == null ? null : kindId.trim();
    }

    public String getKindValue() {
        return kindValue;
    }

    public void setKindValue(String kindValue) {
        this.kindValue = kindValue == null ? null : kindValue.trim();
    }

    public String getUpKindId() {
        return upKindId;
    }

    public void setUpKindId(String upKindId) {
        this.upKindId = upKindId == null ? null : upKindId.trim();
    }

    public String getKindLevel() {
        return kindLevel;
    }

    public void setKindLevel(String kindLevel) {
        this.kindLevel = kindLevel == null ? null : kindLevel.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }
}