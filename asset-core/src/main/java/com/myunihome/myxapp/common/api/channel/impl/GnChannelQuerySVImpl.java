package com.myunihome.myxapp.common.api.channel.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myunihome.myxapp.base.exception.BusinessException;
import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.common.api.channel.interfaces.IGnChannelQuerySV;
import com.myunihome.myxapp.common.api.channel.param.ChannelCondition;
import com.myunihome.myxapp.common.api.channel.param.ChannelIdCondition;
import com.myunihome.myxapp.common.api.channel.param.ChlQueryCond;
import com.myunihome.myxapp.common.api.channel.param.GnChannelVo;
import com.myunihome.myxapp.common.constants.Constants;
import com.myunihome.myxapp.common.dao.mapper.bo.GnChannel;
import com.myunihome.myxapp.common.service.business.channel.IGnChannelBusinessService;
import com.myunihome.myxapp.common.service.business.depart.IGnDepartBusinessService;
import com.myunihome.myxapp.common.service.business.tenant.IGnTenantBusinessService;
import com.myunihome.myxapp.common.util.VoValidateUtils;
import com.myunihome.myxapp.paas.util.CollectionUtil;

@Service
@Component
public class GnChannelQuerySVImpl implements IGnChannelQuerySV {


    @Autowired
    private IGnDepartBusinessService gnDepartBusinessService;

    @Autowired
    private IGnTenantBusinessService gnTenantBusinessService;

    @Autowired
    private IGnChannelBusinessService gnChannelBusinessService;
   

    @Override
    public List<GnChannelVo> selectChildrenChannels(ChannelCondition condition) {
        VoValidateUtils.validateTenantId(condition.getTenantId(), gnTenantBusinessService);
        if (StringUtils.isEmpty(condition.getDepartId()) && StringUtils.isEmpty(condition.getChannelId())) {
            throw new BusinessException(Constants.ErrorCode.RESULT_ERROR, "渠道ID或者部门ID不能同时为空");
        }
        if (!StringUtils.isEmpty(condition.getDepartId())) {
            VoValidateUtils.validateDepartId(condition.getTenantId(),condition.getDepartId(), gnDepartBusinessService);
        }

        if (!StringUtils.isEmpty(condition.getChannelId())) {
            VoValidateUtils.validateChannelId(condition.getTenantId(),condition.getChannelId(), gnChannelBusinessService);
        }

        

        List<GnChannel> result = gnChannelBusinessService.selectChildrenChannelByDepartIdOrChanneldId(condition);

        if (CollectionUtil.isEmpty(result)) {
            return new ArrayList<GnChannelVo>();
        }

        Gson gson = new Gson();

        return gson.fromJson(gson.toJson(result), new TypeToken<List<GnChannelVo>>() {
        }.getType());
    }

	@Override
	public PageInfo<GnChannelVo> queryChannelsByPage(ChlQueryCond cond) {
		VoValidateUtils.valaidateQueryChannelsByPage(cond);
		return gnChannelBusinessService.queryChannelsByPage(cond);
	}

	@Override
	public GnChannelVo selectByChannelId(ChannelIdCondition condition) {
	    VoValidateUtils.validateTenantId(condition.getTenantId(), gnTenantBusinessService);
		if (StringUtils.isEmpty(condition.getChannelId())) {
            throw new BusinessException(Constants.ErrorCode.RESULT_ERROR, "渠道ID不能为空");
        }
		Gson gson = new Gson();
		GnChannelVo result = gson.fromJson(
                gson.toJson(gnChannelBusinessService.selectById(condition.getTenantId(),condition.getChannelId())),
                GnChannelVo.class);
		return result;
	}
}
