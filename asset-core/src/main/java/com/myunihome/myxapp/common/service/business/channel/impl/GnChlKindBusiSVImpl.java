package com.myunihome.myxapp.common.service.business.channel.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.myunihome.myxapp.common.api.channel.param.GnChlKindVo;
import com.myunihome.myxapp.common.dao.mapper.bo.GnChlKind;
import com.myunihome.myxapp.common.service.atom.channel.IGnChlKindAtomSV;
import com.myunihome.myxapp.common.service.business.channel.IGnChlKindBusiSV;
import com.myunihome.myxapp.paas.util.BeanUtils;
import com.myunihome.myxapp.paas.util.CollectionUtil;
@Component
@Transactional
public class GnChlKindBusiSVImpl implements IGnChlKindBusiSV {

	@Autowired
	private IGnChlKindAtomSV iGnChlKindAtomSV;
	@Override
	public List<GnChlKindVo> queryChlKinds() {
		List<GnChlKindVo> resultList = new ArrayList<GnChlKindVo>();
		List<GnChlKind> dbList = iGnChlKindAtomSV.queryChlKinds();
		if(!CollectionUtil.isEmpty(dbList)){
			for(GnChlKind dbObj:dbList ){
				GnChlKindVo vo=new GnChlKindVo();
				BeanUtils.copyProperties(vo, dbObj);
				resultList.add(vo);
			}
		}
		
		return resultList;
	}

}
