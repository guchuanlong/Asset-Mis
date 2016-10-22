package com.myunihome.myxapp.common.api.channel.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.myunihome.myxapp.common.api.channel.interfaces.IGnChlKindQuerySV;
import com.myunihome.myxapp.common.api.channel.param.GnChlKindVo;
import com.myunihome.myxapp.common.service.business.channel.IGnChlKindBusiSV;
@Service
@Component
public class GnChlKindQuerySVImpl implements IGnChlKindQuerySV {

	@Autowired
	private IGnChlKindBusiSV iGnChlKindBusiSV;
	@Override
	public List<GnChlKindVo> queryChlKinds() {
		
		return iGnChlKindBusiSV.queryChlKinds();
	}

}
