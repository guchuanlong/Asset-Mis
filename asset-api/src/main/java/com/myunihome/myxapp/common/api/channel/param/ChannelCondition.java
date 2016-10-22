package com.myunihome.myxapp.common.api.channel.param;

import com.myunihome.myxapp.base.vo.BaseInfo;

/**
 * 渠道查询条件<br>
 * Date: 2015年9月25日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 *
 * @author zhangxin10
 */
public class ChannelCondition extends BaseInfo {
    /**
     * 部门ID
     */
    private String departId;

    /**
     * 渠道ID
     */
    private String channelId;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }
}
