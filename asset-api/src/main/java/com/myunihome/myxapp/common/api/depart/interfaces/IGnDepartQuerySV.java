package com.myunihome.myxapp.common.api.depart.interfaces;

import java.util.List;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.common.api.depart.param.DepartPaginationResult;
import com.myunihome.myxapp.common.api.depart.param.GnDepartCondition;
import com.myunihome.myxapp.common.api.depart.param.GnDepartIdsCondition;
import com.myunihome.myxapp.common.api.depart.param.GnDepartVo;

/**
 * 机构查询服务<br>
 * Date: 2015年8月7日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 *
 * @author zhangxin10
 */
public interface IGnDepartQuerySV {
    /**
     * 根据部门编码查询部门信息.
     * <p/>
     * 按照给定的机构编码，返回机构的详细信息.如果传入的机构ID为空，则抛出异常。 注意：<strong>查询条件中的机构名称不起任何作用</strong>
     *
     * @param gnDepartCondition
     *            机构查询条件
     * @return 符合条件的机构的详细信息
     * @throws CallerException
     * @ApiDocMethod
     * @ApiCode GN_0300
     */
    GnDepartVo selectById(GnDepartCondition gnDepartCondition) throws CallerException;

    /**
     * 查询直属下级部门列表.
     * <p/>
     * 根据指定的机构编码来查询子机构的服务，<strong>如果机构编码为空,则默认查询上级部门为空的机构</strong> 条件的机构名称支持模糊匹配.
     *
     * @param gnDepartCondition
     *            机构查询条件
     * @return 符合条件的机构的详细信息
     * @throws CallerException
     * @ApiDocMethod
     * @ApiCode GN_0301
     */
    List<GnDepartVo> select(GnDepartCondition gnDepartCondition) throws CallerException;

    /**
     * 查询部门分页.
     * <p/>
     * 根据指定的机构编码来查询子机构的服务，<strong>如果机构编码为空,则默认查询所有机构。</strong> 条件的机构名称支持模糊匹配.
     *
     * @param gnDepartCondition
     *            机构查询条件
     * @param start
     *            起始编号
     * @param end
     *            终止编码
     * @return 符合条件的机构的详细信息
     * @throws CallerException
     * @ApiDocMethod
     * @ApiCode GN_0302
     */
    DepartPaginationResult selectByPage(GnDepartCondition gnDepartCondition, int start, int end)
            throws CallerException;

    /**
     * 根据部门id查询所有本级及其所有下级机构.
     * <p/>
     * 
     * @param gnDepartCondition
     *            机构查询条件
     * @return 符合条件的机构的详细信息
     * @throws CallerException
     * @author zhanglh
     * @ApiDocMethod
     * @ApiCode GN_0303
     */
    List<GnDepartVo> selectAllById(GnDepartIdsCondition gnDepartIdsCondition)
            throws CallerException;

    /**
     * 根据部门id查询所有本机构及其所有上级级机构.
     * <p/>
     * @param gnDepartIdsCondition
     *                          部门查询条件，部门ID与租户ID必须传入
     * @return 符合条件的机构的信息
     * @throws CallerException
     * @author zhanglh
     * @ApiDocMethod
     * @ApiCode GN_0405
     */
    List<GnDepartVo> selectParentById(GnDepartIdsCondition gnDepartIdsCondition)
            throws CallerException;

}
