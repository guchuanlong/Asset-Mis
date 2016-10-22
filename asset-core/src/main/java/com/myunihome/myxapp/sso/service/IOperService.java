package com.myunihome.myxapp.sso.service;

import java.util.List;

import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.sso.api.oper.param.OperatorVo;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOper;
import com.myunihome.myxapp.sys.api.sysoper.param.GnOperParamsVO;



public interface IOperService {
	
	/**
	 * 根据员工工号、租户编码 查询操作员信息列表(只查有效数据)
	 * @param staffNo
	 * 			员工工号
	 * @param tenantId
	 * 			租户编码
	 * @return
	 */
	List<OperatorVo> checkOperInfoByStaffno(Long staffNoid, String tenantId);
	
	/**
	 * 根据员工工号、租户编码、状态 查询操作员信息列表
	 * @param staffNo
	 * 			员工工号
	 * @param tenantId
	 * 			租户编码
	 * @param state
	 * 			状态 01：生效 02 失效 null：所有
	 * @return
	 */
	List<OperatorVo> checkOperInfoByStaffno(Long staffNoid, String tenantId, String state);
	
	/**
     * 创建操作员服务（操作员id为序列主键系统生成；创建时间系统生成。）
     */
    Long addOper(GnOper gnOper);
    
    /**
     * 修改操作员服务
     */
    Integer updateOper(GnOper gnOper);

    /**
     * 删除操作员服务（删除为逻辑删除，状态置为注销02）
     */
    Integer delOperByID(GnOper gnOper);
    
    /**
     * 删除操作员服务（删除为逻辑删除，状态置为注销02）
     */
    Integer delOperByStaffNoID(GnOper gnOper);
    
    /**
     * 根据操作员id获取操作信息服务
     */
    GnOper queryOperById(GnOper gnOper);
    
    /**
     * 分页查询
     */
    PageInfo<GnOper> queryOperPageInfo(GnOperParamsVO operParamsVO);

    /**
     * 通过员工信息查询操作员信息
     * @param staffQueryVO
     * @return
     * @author jiaxs
     * @ApiDocMethod
     */
	List<GnOper> queryOperListByStaffnoIds(String tenantId, List<Long> staffnoIdList);
	
	/**
	 * 通过工号id获得员工工号信息
	 * @param tenantId
	 * @param operIdList
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	List<GnOper> queryOperListByOperIds(String tenantId, List<Long> operIdList);
	
	/**
	 * 通过工号id及指定查询阶段获得员工工号信息
	 * @param tenantId
	 * @param operIdList
	 * @param limitStart
	 * @param limitEnd
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	List<GnOper> queryOperListByOperIds(String tenantId, List<Long> operIdList, int limitStart, int limitEnd);

	/**
	 * 通过工号id获得员工工号信息个数
	 * @param tenantId
	 * @param operIdList
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	Integer queryCountByOperIds(String tenantId, List<Long> operIdList);
}
