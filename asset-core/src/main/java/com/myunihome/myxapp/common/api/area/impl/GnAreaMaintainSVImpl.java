package com.myunihome.myxapp.common.api.area.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.common.api.area.interfaces.IGnAreaMaintainSV;
import com.myunihome.myxapp.common.api.area.param.GnAreaCondition;
import com.myunihome.myxapp.common.api.area.param.GnAreaVo;
import com.myunihome.myxapp.common.service.business.area.IGnAreaBusinessService;
import com.myunihome.myxapp.common.util.VoValidateUtils;

@Service
@Component
public class GnAreaMaintainSVImpl implements IGnAreaMaintainSV {
	@Autowired
	private IGnAreaBusinessService iGnAreaBusinessService;
	@Override
	public String addArea(GnAreaVo area) throws CallerException {
		VoValidateUtils.validateAddArea(area);
		return iGnAreaBusinessService.addArea(area);
	}

	@Override
	public void modifyArea(GnAreaVo area) throws CallerException {
		VoValidateUtils.validateModifyArea(area);
		iGnAreaBusinessService.modifyArea(area);
	}

	@Override
	public void deleteArea(GnAreaCondition gnAreaCondition)
			throws CallerException {
		VoValidateUtils.validateDeleteArea(gnAreaCondition);
		iGnAreaBusinessService.deleteArea(gnAreaCondition);
	}

	@Override
	public void deleteAreas(List<GnAreaCondition> gnAreaCondition)
			throws CallerException {
		VoValidateUtils.validateDeleteAreas(gnAreaCondition);
		iGnAreaBusinessService.deleteAreas(gnAreaCondition);

	}

}
