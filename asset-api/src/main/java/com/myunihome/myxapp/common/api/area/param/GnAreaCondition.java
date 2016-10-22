package com.myunihome.myxapp.common.api.area.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 区域查询条件<br>
 * Date: 2015年8月7日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 *
 * @author zhangxin10
 */
public class GnAreaCondition extends BaseInfo {
    private static final long serialVersionUID = 1L;

    /**
     * 区域编码
     */
    private String areaCode;

    /**
     * 区域级别
     */
    private AreaLevel areaLevel;


    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public AreaLevel getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(AreaLevel areaLevel) {
        this.areaLevel = areaLevel;
    }
}
