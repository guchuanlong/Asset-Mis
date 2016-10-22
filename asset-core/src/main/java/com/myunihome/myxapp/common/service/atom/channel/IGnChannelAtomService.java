package com.myunihome.myxapp.common.service.atom.channel;

import java.util.List;

import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.common.api.channel.param.ChlQueryCond;
import com.myunihome.myxapp.common.dao.mapper.bo.GnChannel;

/**
 * Created by astraea on 2015/9/25.
 */
public interface IGnChannelAtomService {

    List<GnChannel> searchChildrenChannel(String tenantId,String departId, String channelId);

    GnChannel selectChannelById(String tenantId,String channelID);

    /**
     * 分页查询渠道信息
     * 
     * @param cond
     * @return 渠道分页信息
     * @author zhanglh
     * @ApiDocMethod
     * @ApiCode GN_0503
     */
    PageInfo<GnChannel> queryChannelsByPage(ChlQueryCond cond);
}
