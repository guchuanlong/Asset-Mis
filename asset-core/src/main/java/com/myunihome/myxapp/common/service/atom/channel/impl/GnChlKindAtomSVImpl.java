package com.myunihome.myxapp.common.service.atom.channel.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.myunihome.myxapp.common.dao.mapper.bo.GnChlKind;
import com.myunihome.myxapp.common.service.atom.channel.IGnChlKindAtomSV;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;
@Component
public class GnChlKindAtomSVImpl implements IGnChlKindAtomSV {

	@Override
	public List<GnChlKind> queryChlKinds() {
		return MapperFactory.getGnChlKindMapper().selectByExample(null);
	}

}
