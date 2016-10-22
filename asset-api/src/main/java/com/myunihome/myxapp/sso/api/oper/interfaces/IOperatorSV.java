package com.myunihome.myxapp.sso.api.oper.interfaces;

import java.util.List;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.sso.api.oper.param.OperRole;
import com.myunihome.myxapp.sso.api.oper.param.OperatorVo;


/**
 * 操作员操作服务
 * @author Becky
 * @ApiDocClass
 */
public interface IOperatorSV {
	
		
	/**
	 * 
	 * 根据用员工工号查询操作员列表服务
	 * 
	 * @param staffNoid
	 *         员工工号
	 * @param tenantId
	 * 			租户编码
	 * @return List<OperatorVo>
	 *          操作员信息列表（操作员ID、操作员编码、归属组织类型、归属组织）
	 * @throws CallerException
	 * 
	 * @author Becky
	 * @ApiDocMethod
	 * @ApiCode SYS_0007
	 */
	List<OperatorVo> checkStaffInfoBystaffno(Long staffNoid , String tenantId) throws CallerException;
	
	
	/**
	 * 根据员工信息获取角色列表
	 * @param operId
	 * @param tenantId
	 * @param operCode
	 * @return
	 * @author zhangbc
	 * @ApiDocMethod
	 * @ApiCode SYS_0031
	 */
	List<OperRole> getOperRoleList(Long operId, String tenantId,String operCode) throws CallerException;
	
		
}
