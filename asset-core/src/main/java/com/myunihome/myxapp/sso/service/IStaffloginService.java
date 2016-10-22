package com.myunihome.myxapp.sso.service;

import com.myunihome.myxapp.sso.api.stafflogin.param.StaffLoginVo;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnStaffno;

/**
 * 员工登录service
 * @author Becky
 *
 */
public interface IStaffloginService {
	
	/**
	 * 根据员工工号+密码登录 service
	 * @param staffno
	 * @param password
	 * @return
	 */
	StaffLoginVo checkStaffLoginBystaffno(String staffno, String password, String tenantId);
	/**
	 * 员工工号创建
	 * @param staffnoVo
	 * @return
	 */
	/*String  createStaffno(StaffnoVo staffnoVo);*/
	
	/**
	 * 根据员工工号获取工号信息
	 * @param staffno
	 * @return
	 */
	GnStaffno getGnStaffnoByStaffno(String staffno);
}
