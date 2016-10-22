package com.myunihome.myxapp.common.api.staff.interfaces;

import java.util.List;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.common.api.staff.param.GnStaffCondition;
import com.myunihome.myxapp.common.api.staff.param.GnStaffVo;

/**
 * 公共域-人员管理类，主要功能包括新增，修改，查询，删除，<br>
 * Date: 2015年7月24日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 *
 * @author zhangxin
 */
public interface IGnStaffMaintainSV {

    /**
     * 新增人员.
     * <p/>
     * 校验条件：<br/>
     * 员工工号不能为空
     * 员工名称不能为空
     * 员工的部门编码不能为空
     * 员工类型不能为空
     *
     * @param staff 新增人员信息
     * @throws CallerException 校验条件不为空，则抛出异常
     */
    void addStaff(GnStaffVo staff) throws CallerException;

    /**
     * 修改人员.
     * <p/>
     * 校验条件：<br/>
     * 员工编码(员工ID)不能为空
     * 员工工号不能为空
     * 员工名称不能为空
     * 员工的部门编码不能为空
     * 员工类型不能为空
     *
     * @param staff 待修改人员
     */
    void modifyStaff(GnStaffVo staff) throws CallerException;


    /**
     * 根据员工编码(员工ID)删除人员.
     * <p/>
     * 根据传入的员工编码(员工ID)删除人员，如果传入的员工编码(员工ID)为空，则抛出异常。
     * 如果员工编码(员工ID)不存在则不处理。如果员工编码(员工ID)存在，则在逻辑上删除员工。
     *
     * @param condition 员工编码条件
     */
    void deleteStaffById(GnStaffCondition condition) throws CallerException;


    /**
     * 批量根据员工编码(员工ID)删除员工.
     * <p/>
     * 根据传入的员工编码(员工ID)删除人员，如果传入的员工编码(员工ID)为空，则抛出异常。
     * 如果员工编码(员工ID)不存在则不处理。如果员工编码(员工ID)存在，则在逻辑上删除员工。
     *
     * @param condition 所有待删除员工编码
     * @throws CallerException
     */
    void deleteStaffsByIds(List<GnStaffCondition> condition) throws CallerException;
}
