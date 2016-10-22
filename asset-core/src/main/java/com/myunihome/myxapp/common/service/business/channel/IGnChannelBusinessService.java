package com.myunihome.myxapp.common.service.business.channel;

import java.util.List;

import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.common.api.channel.param.ChannelCondition;
import com.myunihome.myxapp.common.api.channel.param.ChannelIdCondition;
import com.myunihome.myxapp.common.api.channel.param.ChlQueryCond;
import com.myunihome.myxapp.common.api.channel.param.GnChannelVo;
import com.myunihome.myxapp.common.dao.mapper.bo.GnChannel;

public interface IGnChannelBusinessService {
    List<GnChannel> selectChildrenChannelByDepartIdOrChanneldId(ChannelCondition channelCondition);

    GnChannel selectById(String tenantId,String channelID);
    
    /**
     * 分页查询渠道信息
     * @param cond
     * @return 渠道分页信息
     * @author zhanglh
     * @ApiDocMethod
     * @ApiCode GN_0503
     */
    PageInfo<GnChannelVo> queryChannelsByPage(ChlQueryCond cond);
    /**
     * 根据id查询渠道信息
     * @param cond
     * @return 渠道信息
     * @author zhanglh
     * @ApiDocMethod
     * @ApiCode GN_0504
     */
    GnChannel selectByChannelId(ChannelIdCondition channelIdCondition);
}
