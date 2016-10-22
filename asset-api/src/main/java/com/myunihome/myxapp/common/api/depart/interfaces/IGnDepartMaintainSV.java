package com.myunihome.myxapp.common.api.depart.interfaces;

import java.util.List;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.common.api.depart.param.GnDepartCondition;
import com.myunihome.myxapp.common.api.depart.param.GnDepartVo;

/**
 * 公共域-部门管理类，主要功能包括新增，修改，查询，删除，<br>
 * 其中查询包括树查询。 Date: 2015年7月23日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author zhangxin
 */
public interface IGnDepartMaintainSV {

    /**
     * 添加机构.
     * <p/>
     * 部门的部门级别根据传入的省份，地市，区域编码来确定，如果传入的省份编码为00，则为全国级别的部门 如果传入的地市编码为000，则为省份级别部门，其他则是地市级别部门<br/>
     * 校验条件：<br/>
     * 部门的地市编码不能为空 部门的省份编码不能为空 部门的区域编码不能为空 部门的部门性质不能为空 部门的名称不能为空。
     * 
     * @param depart
     *            待添加的机构的信息
     * @throws CallerException
     * @ApiDocMethod
     * @ApiCode GN_0304
     */
    void addDepart(GnDepartVo depart) throws CallerException;

    /**
     * 修改机构.
     * <p/>
     * 部门的部门级别根据传入的省份，地市，区域编码来确定，如果传入的省份编码为00，则为全国级别的部门 如果传入的地市编码为000，则为省份级别部门，其他则是地市级别部门<br/>
     * 校验条件：<br/>
     * 部门的地市编码不能为空 部门的省份编码不能为空 部门的区域编码不能为空 部门的部门性质不能为空 部门的名称不能为空。 <br/>
     * 如果传入的departID节点不存在或传入的租户ID不存在，则抛出异常。
     * 
     * @param depart
     *            待修改的机构的信息
     * @throws CallerException
     * @ApiDocMethod
     * @ApiCode GN_0305
     */
    void modifyDepart(GnDepartVo depart) throws CallerException;

    /**
     * 删除部门.
     * <p/>
     * 根据部门编码来删除相应的机构，如果部门不存在，则跳过。 如果该departId底下也有子机构的话，会抛出异常。
     * <p/>
     * 注意：<strong>删除条件中的机构名称不起任何作用</strong>
     * 
     * @param gnDepartCondition
     *            待删除的机构条件
     * @throws CallerException
     * @ApiDocMethod
     * @ApiCode GN_0306
     */
    void deleteDepart(GnDepartCondition gnDepartCondition) throws CallerException;

    /**
     * 批量删除部门.
     * <p/>
     * 根据部门编码来删除相应的机构，如果部门不存在，则跳过。 如果该departId底下也有子机构的话，会抛出异常。
     * <p/>
     * 注意：<strong>删除条件中的机构名称不起任何作用</strong>
     * 
     * @param gnDepartCondition
     * @throws CallerException
     * @ApiDocMethod
     * @ApiCode GN_0307
     */
    void deleteDeparts(List<GnDepartCondition> gnDepartCondition) throws CallerException;
}
