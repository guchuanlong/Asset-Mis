package com.myunihome.myxapp.sso.api.stafflogin.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.myunihome.myxapp.base.exception.BusinessException;
import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.paas.util.BeanUtils;
import com.myunihome.myxapp.paas.util.StringUtil;
import com.myunihome.myxapp.sso.api.stafflogin.interfaces.IStaffLoginSV;
import com.myunihome.myxapp.sso.api.stafflogin.param.OperIdVo;
import com.myunihome.myxapp.sso.api.stafflogin.param.StaffLoginVo;
import com.myunihome.myxapp.sso.api.stafflogin.param.StaffNoResponseVO;
import com.myunihome.myxapp.sso.api.stafflogin.param.StaffnoPasswdVo;
import com.myunihome.myxapp.sso.constants.Constants;
import com.myunihome.myxapp.sso.constants.Constants.ErrorCode;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOper;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnStaffno;
import com.myunihome.myxapp.sso.service.IOperService;
import com.myunihome.myxapp.sso.service.IStaffNoService;
import com.myunihome.myxapp.sso.service.IStaffloginService;

@Service
@Component
public class StaffloginSVImpl implements IStaffLoginSV {

	@Autowired
	private IStaffloginService iStaffloginService;
	@Autowired
	private IStaffNoService iStaffNoService;
	@Autowired
	private IOperService iOperService;

	@Override
	public StaffLoginVo checkStaffLoginBystaffno(String staffNo, String password, String tenantId) throws CallerException {
		return iStaffloginService.checkStaffLoginBystaffno(staffNo, password, tenantId);
	}

	@Override
	public StaffLoginVo getStaffLoginBystaffno(String staffNo) throws CallerException {
		GnStaffno staff = iStaffloginService.getGnStaffnoByStaffno(staffNo);
		StaffLoginVo staffLogin = null;
		if (staff != null) {
			staffLogin = new StaffLoginVo();
			BeanUtils.copyProperties(staffLogin, staff);
			staffLogin.setStaffnoId(staff.getStaffnoId());
		}
		return staffLogin;
	}

	@Override
	public StaffLoginVo getStaffLoginByOperId(OperIdVo operId) throws CallerException {
		StaffLoginVo staff = null;
		if (operId == null) {
			throw new BusinessException(Constants.ErrorCode.PARAM_NULL_ERROR, "参数对象不能为空");
		}
		if (StringUtil.isBlank(operId.getTenantId())) {
			throw new BusinessException(Constants.ErrorCode.PARAM_NULL_ERROR, "租户ID不能为空");
		}
		if (operId.getOperId() == null || operId.getOperId().longValue() == 0) {
			throw new BusinessException(Constants.ErrorCode.PARAM_NULL_ERROR, "操作员ID不能为空");
		}
		GnOper operParam = new GnOper();
		operParam.setTenantId(operId.getTenantId());
		operParam.setOperId(operId.getOperId());
		GnOper oper = iOperService.queryOperById(operParam);
		if (oper != null) {
			GnStaffno staffnoParam = new GnStaffno();
			staffnoParam.setTenantId(operId.getTenantId());
			staffnoParam.setStaffnoId(oper.getStaffnoId());
			GnStaffno staffno = iStaffNoService.queryStaffNoByStaffNoId(staffnoParam);
			if (staffno != null) {
				staff = new StaffLoginVo();
				BeanUtils.copyProperties(staff, staffno);
				staff.setStaffnoId(staffno.getStaffnoId());
			}
		}
		return staff;
	}

	@Override
	public StaffNoResponseVO updateStaffPasswd(StaffnoPasswdVo staffnoPasswdVo) throws CallerException {
		checkStaffNoPasswdVO(staffnoPasswdVo);
		StaffNoResponseVO staffNoResponseVO = new StaffNoResponseVO();
		Integer result = iStaffNoService.updateStaffPasswd(staffnoPasswdVo);
		if (result < 0) {
			staffNoResponseVO.setResponseCode(Constants.ResponseState.FAILED);
			staffNoResponseVO.setRespondeDescribe("密码修改失败!");
		} else if (result == 0) {
			staffNoResponseVO.setResponseCode(Constants.ResponseState.FAILED);
			staffNoResponseVO.setRespondeDescribe("帐号或原始密码不正确!");
		} else {
			staffNoResponseVO.setResponseCode(Constants.ResponseState.SUCCESS);
			staffNoResponseVO.setRespondeDescribe("密码修改成功!");
		}
		return staffNoResponseVO;
	}

	/**
	 * 检查修改密码参数是否合法
	 * 
	 * @param staffnoPasswdVo
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private void checkStaffNoPasswdVO(StaffnoPasswdVo staffnoPasswdVo) {
		String errorMsg = "";
		if (StringUtils.isEmpty(staffnoPasswdVo.getTenantId())) {
			errorMsg += "tenantId 不能为空  ";
		}
		if (StringUtils.isEmpty(staffnoPasswdVo.getStaffNo())) {
			errorMsg += "userId 不能为空  ";
		}
		if (StringUtils.isEmpty(staffnoPasswdVo.getNewPassword())) {
			errorMsg += "新密码 不能为空  ";
		}
		if (StringUtils.isEmpty(staffnoPasswdVo.getOldPassword())) {
			errorMsg += "原始密码 不能为空  ";
		}
		if (StringUtils.isNotEmpty(errorMsg)) {
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
	}

	/*
	 * @Override public String createStaffno(StaffnoVo staffnoVo) { return
	 * iStaffloginService.createStaffno(staffnoVo); }
	 */

}
