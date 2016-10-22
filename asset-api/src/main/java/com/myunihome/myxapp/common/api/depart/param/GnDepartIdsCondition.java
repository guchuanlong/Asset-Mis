package com.myunihome.myxapp.common.api.depart.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 机构查询条件对象<br>
 * Date: 2015年10月21日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * @author zhanglh
 */
 
public class GnDepartIdsCondition extends BaseInfo {
    /**
     * 待查询的机构编码
     */
    private String departId;

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }
    
}
