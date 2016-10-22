package com.myunihome.myxapp.common.api.depart.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 机构查询条件对象<br>
 * Date: 2015年8月7日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 *
 * @author zhangxin10
 */
public class GnDepartCondition extends BaseInfo {
    /**
     * 待查询的机构编码
     */
    private String departId;

    /**
     * 待查询的机构名称
     */
    private String departName;

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }
}
