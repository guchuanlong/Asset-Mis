package com.myunihome.myxapp.sso.api.stafflogin.interfaces;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.sso.api.stafflogin.param.OperIdVo;
import com.myunihome.myxapp.sso.api.stafflogin.param.StaffLoginVo;
import com.myunihome.myxapp.sso.api.stafflogin.param.StaffNoResponseVO;
import com.myunihome.myxapp.sso.api.stafflogin.param.StaffnoPasswdVo;

/**
 * 员工操作服务
 * @author Becky
 * @ApiDocClass
 */
public interface IStaffLoginSV {
	
	/**
	 * 
	 * 员工工号登录服务
	 * 
	 * @param staffNo
	 *         员工工号
	 * @param password
	 *          密码
	 * @param tenantId
	 * 			租户ID
	 * @return StaffLoginVo
	 * 			工号ID、员工编码、员工工号、员工姓名、租户编码
	 * 
	 * @author Becky
	 * @ApiDocMethod
	 * @ApiCode SYS_0006
	 */
	StaffLoginVo checkStaffLoginBystaffno(String staffNo , String password,String tenantId) throws CallerException;
	
	/**
	 * 根据员工工号获取员工信息
	 * @param staffNo
	 * @return
	 * @author gucl
	 * @ApiDocMethod
	 * @ApiCode SYS_0043
	 */
	StaffLoginVo getStaffLoginBystaffno(String staffNo) throws CallerException;
	
	/**
	 * 根据操作员ID查询员工工号信息
	 * @param operId
	 * @return
	 * @author gucl
	 * @ApiDocMethod
	 * @ApiCode SYS_0044
	 */
	StaffLoginVo getStaffLoginByOperId(OperIdVo operId) throws CallerException;
	
	// /**
	// * 员工工号创建服务（此方法废弃，在sys-api里重新定义了SYS_0009号服务）
	// *
	// * @param staffnoVo
	// * 员工ID、租户编码、生失效时间、创建员工、创建时间、备注、（员工工号、密码后台根据规则自动生成）
	// *
	// * @return String 员工工号
	// *
	// * @author zhangbc
	// * ApiDocMethod
	// * @ApiCode SYS_0009
	// */
	// String createStaffno(StaffnoVo staffnoVo);
	
	/**
	 * 修改员工密码
	 * @param staffnoPasswdVo
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 * @ApiCode SYS_0063
	 */
	StaffNoResponseVO updateStaffPasswd(StaffnoPasswdVo staffnoPasswdVo) throws CallerException;
	
	
	
}