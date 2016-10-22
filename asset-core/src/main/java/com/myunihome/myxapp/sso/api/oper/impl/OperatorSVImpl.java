package com.myunihome.myxapp.sso.api.oper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.sso.api.oper.interfaces.IOperatorSV;
import com.myunihome.myxapp.sso.api.oper.param.OperRole;
import com.myunihome.myxapp.sso.api.oper.param.OperatorVo;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOperRole;
import com.myunihome.myxapp.sso.service.IOperService;
import com.myunihome.myxapp.sso.service.IRoleService;

/**
 * 操作员服务
 * 
 * @author Becky
 *
 */
@Service
@Component
public class OperatorSVImpl implements IOperatorSV {

	@Autowired
	private IOperService iOperService;

	@Autowired
	private IRoleService iRoleService;

	@Override
	public List<OperatorVo> checkStaffInfoBystaffno(Long staffNoid, String tenantId) throws CallerException {
		return iOperService.checkOperInfoByStaffno(staffNoid, tenantId);
	}

	@Override
	public List<OperRole> getOperRoleList(Long operId, String tenantId, String operCode) throws CallerException {
		List<GnOperRole> list = iRoleService.getRolesByOperId(operId, tenantId);
		List<OperRole> operRoleList = new ArrayList<OperRole>();
		for (GnOperRole operRole : list) {
			OperRole role = new OperRole();
			BeanUtils.copyProperties(operRole, role);
			operRoleList.add(role);
		}
		return operRoleList;
	}

}
