package com.myunihome.myxapp.common.api.cache.param;

import java.io.Serializable;

/**
 * 系统配置对象.<br>
 * Date: 2015年7月20日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * @author gucl
 *
 */
public class CfgProperties implements Serializable {
	
	/**
	 * 配置类型
	 */
    private String cfgtype;

    /**
     * 配置属性
     */
    private String property;

    /**
     * 配置取值
     */
    private String value;

    /**
     * 配置描述
     */
    private String cfgdesc;

    public String getCfgtype() {
        return cfgtype;
    }

    public void setCfgtype(String cfgtype) {
        this.cfgtype = cfgtype == null ? null : cfgtype.trim();
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property == null ? null : property.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getCfgdesc() {
        return cfgdesc;
    }

    public void setCfgdesc(String cfgdesc) {
        this.cfgdesc = cfgdesc == null ? null : cfgdesc.trim();
    }
}
