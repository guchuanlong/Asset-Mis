package com.myunihome.myxapp.sso.api.staffnoquery.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.paas.constants.MyXAppPaaSConstant;
import com.myunihome.myxapp.sso.api.staffnoquery.interfaces.IStaffNoQuerySV;
import com.myunihome.myxapp.sso.api.staffnoquery.param.StaffNoInfoQuery;
import com.myunihome.myxapp.sso.api.staffnoquery.param.StaffNoVo;
import com.myunihome.myxapp.sso.service.IStaffNoQueryService;

/**
 * 员工信息查询
 * 
 * @author zhouyy5
 * 
 */
@Service
@Component
public class StaffNoQuerySVImpl implements IStaffNoQuerySV {

	@Autowired
	private transient IStaffNoQueryService iStaffNoQueryService;

	@Override
	public StaffNoInfoQuery queryStaffNo(StaffNoVo vo) throws CallerException {
		if (StringUtils.isEmpty(vo.getTenantId())) {
			throw new CallerException(
					MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "租户id不能为空");
		}
		if (StringUtils.isEmpty(vo.getStaffId())
				&& StringUtils.isEmpty(vo.getStaffName())) {
			throw new CallerException(
					MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL,
					"员工id和员工名称不能同时为空");
		}
		if (null == vo.getPageNumber()) {
			throw new CallerException(
					MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "查询页码不能为空");

		}
		if (null == vo.getPageSize()) {
			throw new CallerException(
					MyXAppPaaSConstant.ExceptionCode.PARAM_IS_NULL, "每页显示条数不能为空");

		}
		return iStaffNoQueryService.queryStaffNo(vo);
	}

}
