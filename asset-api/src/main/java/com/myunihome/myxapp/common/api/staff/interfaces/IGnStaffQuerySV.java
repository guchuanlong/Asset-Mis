package com.myunihome.myxapp.common.api.staff.interfaces;

import java.util.List;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.common.api.staff.param.GnStaffAreaQuery;
import com.myunihome.myxapp.common.api.staff.param.GnStaffCondition;
import com.myunihome.myxapp.common.api.staff.param.GnStaffInfo;
import com.myunihome.myxapp.common.api.staff.param.GnStaffVo;
import com.myunihome.myxapp.common.api.staff.param.StaffPaginationResult;

/**
 * 公共域-人员管理类，主要功能包括查询类服务<br>
 * Date: 2015年7月28日 <br>
 * Copyright (c) throws CallerException 2015 asiainfo.com <br>
 *
 * @author zhangxin
 */
public interface IGnStaffQuerySV {
    /**
     * 查询部门下所有的有效人员.
     * <p/>
     * 根据部门Id查询所有归属该部门的人员，其中不包括已经失效的人员。 如果传入的部门ID不存在或是已经失效，则抛出异常。
     *
     * @param departId
     *            正常的DepartID
     * @return 所有符合条件的人员
     * @ApiDocMethod
     * @ApiCode GN_0401
     */
    List<GnStaffVo> queryStaffsByDepartId(GnStaffCondition condition) throws CallerException;

    /**
     * 按照查询条件查询员工.
     * <p/>
     * 其中租户ID为必传字段。否则则抛出异常
     *
     * @param condition
     *            查询条件
     * @param start
     *            起始行
     * @param end
     *            终止行
     * @return 所有符合条件的人员
     * @ApiDocMethod
     * @ApiCode GN_0403
     */
    StaffPaginationResult selectByPage(GnStaffCondition condition, int start, int end)
            throws CallerException;

    /**
     * 查询单个员工信息.
     * <p/>
     * 如果传入的人员ID为null，则抛出异常
     *
     * @param condition
     *            人员编码
     * @return 符合条件的人员
     * @ApiDocMethod
     * @ApiCode GN_0402
     */
    GnStaffVo selectById(GnStaffCondition condition) throws CallerException;

    /**
     * 根据所属机构对应的地区查询员工信息
     * <p/>
     * @param condition
     *            员工查询条件，地区代码与租户ID必须传入
     * @return 符合条件的人员
     * @throws CallerException
     * @author zhanglh
     * @ApiDocMethod
     * @ApiCode GN_0406
     */
    List<GnStaffInfo> selectByArea(GnStaffAreaQuery condition) throws CallerException;
}
