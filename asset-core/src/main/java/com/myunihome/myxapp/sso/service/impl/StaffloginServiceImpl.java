package com.myunihome.myxapp.sso.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.myunihome.myxapp.paas.util.BeanUtils;
import com.myunihome.myxapp.sso.api.stafflogin.param.StaffLoginVo;
import com.myunihome.myxapp.sso.constants.Constants;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnStaffno;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnStaffnoCriteria;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;
import com.myunihome.myxapp.sso.service.IStaffloginService;
import com.myunihome.myxapp.sys.util.DateTimeUtil;

import net.sf.json.JSONObject;

/**
 * 员工登录服务
 * @author Becky
 *
 */
@Component
public class StaffloginServiceImpl implements IStaffloginService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StaffloginServiceImpl.class); 
	@Override
	public StaffLoginVo checkStaffLoginBystaffno(String staffno, String password,String tenantId) {
		String message = "Parameters into checkStaffLoginBystaffno : staffno = "+ staffno + "password = " + password + "tenantId = " + tenantId;
		LOGGER.info(message);
		GnStaffnoCriteria gnStaffnoCriteria=new GnStaffnoCriteria();
		GnStaffnoCriteria.Criteria criteria=gnStaffnoCriteria.createCriteria();
		if(!StringUtils.isEmpty(staffno)&&!StringUtils.isEmpty(password))
		{
			criteria.andStaffNoEqualTo(staffno);
			criteria.andStaffPasswdEqualTo(password);
//			criteria.andTenantIdEqualTo(tenantId);
			criteria.andStateEqualTo(Constants.RecordsState.STATE_NORMAL);
			criteria.andInactiveTimeGreaterThanOrEqualTo(DateTimeUtil.getCurrTimestamp());
		List<GnStaffno> gnStaffnos =	MapperFactory.getGnStaffnoMapper().selectByExample(gnStaffnoCriteria);
		if(gnStaffnos.size()>0)
		{
			GnStaffno gnStaffno=gnStaffnos.get(0);
			StaffLoginVo staffLoginVo=new StaffLoginVo();
			BeanUtils.copyProperties(staffLoginVo, gnStaffno);
			staffLoginVo.setStaffnoId(gnStaffno.getStaffnoId());
			JSONObject returnVo = JSONObject.fromObject(staffLoginVo);
			message = "Result from checkUserLoginBymail :" + returnVo.toString();
			LOGGER.info(message);
			return staffLoginVo;
		}
		else
		{
			message = "Result from checkStaffLoginBystaffno : staffno " + staffno + " not exist.";
			LOGGER.info(message);
			return null;
		}
		}
		
		else{
			message = "Result from checkStaffLoginBystaffno : No values for input parameters. ";
			LOGGER.info(message);
			return null;
		}
	}

	@Override
	public GnStaffno getGnStaffnoByStaffno(String staffno) {
		String message = "Parameters into getGnStaffnoByStaffno : staffno = "+ staffno;
		LOGGER.info(message);
		GnStaffnoCriteria gnStaffnoCriteria=new GnStaffnoCriteria();
		GnStaffnoCriteria.Criteria criteria=gnStaffnoCriteria.createCriteria();
		criteria.andStaffNoEqualTo(staffno);
		List<GnStaffno> gnStaffnos=MapperFactory.getGnStaffnoMapper().selectByExample(gnStaffnoCriteria);
		if(gnStaffnos.size()>0)
		{
			GnStaffno gnStaffno = gnStaffnos.get(0);
			JSONObject returnVo = JSONObject.fromObject(gnStaffno);
			message = "Result from getGnStaffnoByStaffno : gnStaffno = " + returnVo.toString();
			LOGGER.info(message);
			return gnStaffno;
		}
		else
		{
			message = "Result from getGnStaffnoByStaffno : staffno " + staffno + " not exist.";
			LOGGER.info(message);
			return null;	
		}
	}

}
