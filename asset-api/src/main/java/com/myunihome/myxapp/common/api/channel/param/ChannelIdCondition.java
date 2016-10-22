package com.myunihome.myxapp.common.api.channel.param;

import com.myunihome.myxapp.base.vo.BaseInfo;


/**
 * 渠道查询条件对象<br>
 * Date: 2015年10月29日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * @author zhanglh
 */


public class ChannelIdCondition extends BaseInfo {

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
}
