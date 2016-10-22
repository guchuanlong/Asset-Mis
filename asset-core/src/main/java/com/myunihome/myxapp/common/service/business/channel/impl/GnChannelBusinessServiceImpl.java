package com.myunihome.myxapp.common.service.business.channel.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.common.api.channel.param.ChannelCondition;
import com.myunihome.myxapp.common.api.channel.param.ChannelIdCondition;
import com.myunihome.myxapp.common.api.channel.param.ChlQueryCond;
import com.myunihome.myxapp.common.api.channel.param.GnChannelVo;
import com.myunihome.myxapp.common.dao.mapper.bo.GnChannel;
import com.myunihome.myxapp.common.service.atom.channel.IGnChannelAtomService;
import com.myunihome.myxapp.common.service.business.channel.IGnChannelBusinessService;
import com.myunihome.myxapp.paas.util.BeanUtils;
import com.myunihome.myxapp.paas.util.CollectionUtil;

@Component
@Transactional
public class GnChannelBusinessServiceImpl implements IGnChannelBusinessService {

    @Autowired
    private IGnChannelAtomService gnChannelAtomService;

    @Override
    public List<GnChannel> selectChildrenChannelByDepartIdOrChanneldId(
            ChannelCondition channelCondition) {
        return gnChannelAtomService.searchChildrenChannel(channelCondition.getTenantId(),
                channelCondition.getDepartId(), channelCondition.getChannelId());
    }

    @Override
    public GnChannel selectById(String tenantId, String channelID) {
        return gnChannelAtomService.selectChannelById(tenantId, channelID);
    }

    @Override
    public PageInfo<GnChannelVo> queryChannelsByPage(ChlQueryCond cond) {
        // 查询渠道信息
        PageInfo<GnChannel> pageInfo = gnChannelAtomService.queryChannelsByPage(cond);
        // 创建返回的分页对象
        PageInfo<GnChannelVo> resultPage = new PageInfo<GnChannelVo>();
        resultPage.setPageNo(pageInfo.getPageNo());
        resultPage.setPageSize(pageInfo.getPageSize());
        resultPage.setCount(pageInfo.getCount());
        // 获取返回的渠道数据的集合
        List<GnChannel> gnChannelList = pageInfo.getResult();
        List<GnChannelVo> resultList = new ArrayList<GnChannelVo>();
        if (!CollectionUtil.isEmpty(gnChannelList)) {
            for (GnChannel dbObj : gnChannelList) {
                GnChannelVo vo = new GnChannelVo();
                BeanUtils.copyProperties(vo, dbObj);
                resultList.add(vo);
            }
        }
        resultPage.setResult(resultList);
        return resultPage;
    }

    @Override
    public GnChannel selectByChannelId(ChannelIdCondition channelIdCondition) {
        return gnChannelAtomService.selectChannelById(channelIdCondition.getTenantId(),
                channelIdCondition.getChannelId());
    }
}
