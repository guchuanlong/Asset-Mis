package com.myunihome.myxapp.common.api.area.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 区域查询条件<br>
 * Date: 2015年11月09 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 *
 * @author gucl
 */
public class GnAreaCodeCondition extends BaseInfo {
    private static final long serialVersionUID = 1L;

    /**
     * 区域编码
     */
    private String areaCode;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

}
