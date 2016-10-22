package com.myunihome.myxapp.sso.service;

import java.util.List;

import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.sso.api.stafflogin.param.StaffnoPasswdVo;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnStaffno;
import com.myunihome.myxapp.sys.api.sysstaffno.param.GnStaffNoParamsVO;
import com.myunihome.myxapp.sys.api.sysstaffno.param.GnStaffNoPasswdVO;
public interface IStaffNoService {
	
	/**
	 * 增加员工工号
	 * @param gnStaffno
	 * @return
	 */
	Long addStaffNo(GnStaffno gnStaffno);
	
	/**
	 * 更新员工工号
	 * @param gnStaffno
	 * @return
	 */
	Integer updateStaffNo(GnStaffno gnStaffno);
	
	/**
	 * 删除员工工号
	 * @param gnStaffno
	 * @return
	 */
	Integer delStaffNoByStaffNoId(GnStaffno gnStaffno);
	
	/**
	 * 
	 * @param gnStaffno
	 * @return
	 */
	GnStaffno queryStaffNoByStaffNoId(GnStaffno gnStaffno);
	
	/**
	 * 
	 * @param gnStaffNoParamsVO
	 * @return
	 */
	PageInfo<GnStaffno> queryStaffNo(GnStaffNoParamsVO gnStaffNoParamsVO);
	
	/**
	 * 获取相同员工工号的个数（判断唯一性）
	 * @param gnStaffno
	 * @return
	 */
	Integer countByStaffNo(GnStaffno gnStaffno);
	
	/**
	 * 通过工号获取除自己之外有效数据个数（判断唯一性）
	 * @param gnStaffno
	 * @return
	 */
	Integer countStaffNoExceptSelf(GnStaffno gnStaffno);

	/**
	 * 修改员工密码
	 * @param staffnoPasswdVo
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	Integer updateStaffPasswd(StaffnoPasswdVo staffnoPasswdVo);

	/**
	 * 重置员工密码
	 * @param staffNoPasswdVO
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	Integer resetStaffPassword(GnStaffNoPasswdVO staffNoPasswdVO);
	
	/**
	 * 查询员工列表
	 * @param gnStaffno
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	List<GnStaffno> queryStaffnoList(GnStaffno gnStaffno);
	
	/**
	 * 获得员工工号对象集
	 * @param tenantId
	 * @param staffnoIdList
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	List<GnStaffno> queryStaffnoList(String tenantId, List<Long> staffnoIdList);
}
