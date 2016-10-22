package com.myunihome.myxapp.sso.service;

import com.myunihome.myxapp.sso.api.staffnoquery.param.StaffNoInfoQuery;
import com.myunihome.myxapp.sso.api.staffnoquery.param.StaffNoVo;

/**
 * 员工信息查询service
 * 
 * @author zhouyy5
 * 
 */
public interface IStaffNoQueryService {

	/**
	 * 查询员工信息<br>
	 * 
	 * @param vo
	 *            参数 员工id(staffId)和员工名称(staffName)不能同时为空 ，
	 *            pageNumber(查询页码)必填、pageSize(一页显示条数)必填,租户id(tenantId) 必填<br>
	 * @return StaffNoInfoQuery <br>
	 * @author zhouyy5
	 * @ApiDocMethod
	 */

	StaffNoInfoQuery queryStaffNo(StaffNoVo vo);
	
}
