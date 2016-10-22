package com.myunihome.myxapp.common.api.channel.interfaces;


import java.util.List;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.common.api.channel.param.ChannelCondition;
import com.myunihome.myxapp.common.api.channel.param.ChannelIdCondition;
import com.myunihome.myxapp.common.api.channel.param.ChlQueryCond;
import com.myunihome.myxapp.common.api.channel.param.GnChannelVo;

/**
 * 公共域-渠道管理类<br>
 * Date: 2015年9月25日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 *
 * @author zhangxin
 */
public interface IGnChannelQuerySV {

    /**
     * 根据传入的部门ID或者渠道ID获取所有下级渠道列表.
     * <p/>
     * 如果部门ID不为空，则查询该部门下的所有子渠道，
     * 如果渠道ID不为空，则查询该渠道下的所有子渠道，
     * 如果两个ID都不为空，则查询该渠道下或者归属该部门下的所有子渠道，
     * *
     *
     * @param condition 查询条件
     * @return 所有符合条件的渠道
     * @ApiDocMethod
     * @ApiCode GN_0501
     */
    List<GnChannelVo> selectChildrenChannels(ChannelCondition condition) throws CallerException;

    
    /**
     * 分页查询渠道信息
     * @param cond
     * @return 渠道分页信息
     * @author zhanglh
     * @ApiDocMethod
     * @ApiCode GN_0503
     */
    PageInfo<GnChannelVo> queryChannelsByPage(ChlQueryCond cond) throws CallerException;
    
    /**
     * 根据id进行查询
     * @param condition
     * @return 渠道信息
     * @author zhanglh
     * @ApiDocMethod
     * @ApiCode GN_0504
     */
    GnChannelVo selectByChannelId(ChannelIdCondition condition) throws CallerException;

}
