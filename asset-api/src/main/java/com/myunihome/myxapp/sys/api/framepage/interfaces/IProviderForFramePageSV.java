package com.myunihome.myxapp.sys.api.framepage.interfaces;

import java.util.List;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.sys.api.framepage.param.Menu;
import com.myunihome.myxapp.sys.api.framepage.param.MenuQuery;
import com.myunihome.myxapp.sys.api.framepage.param.SystemContext;
import com.myunihome.myxapp.sys.api.framepage.param.SystemContextQuery;

/**
 * 为框架页面提供的服务<br>
 * Date: 2015年11月27日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author zhangchao
 */
public interface IProviderForFramePageSV {

    /**
     * 获取指定租户指定系统指定操作员具备权限查看的一级菜单目录
     * 
     * @param query 查询条件，租户ID，系统ID，操作员ID必填，上级菜单不填，后台默认-1
     * @return
     * @throws CallerException
     * @author zhangchao
     * @ApiCode SYS_0055
     */
    List<Menu> queryFirstLevelMenusByLimited(MenuQuery query) throws CallerException;
    
    /**
     * 获取指定租户指定系统指定操作员具备权限查看的一级菜单下面的二级菜单信息
     * 
     * @param query 查询条件，租户ID，系统ID，操作员ID，上级菜单必填
     * @return
     * @throws CallerException
     * @author zhangchao
     * @ApiCode SYS_0050
     */
    List<Menu> querySubMenusByLimited(MenuQuery query) throws CallerException;
    
    List<SystemContext> querySystemContextList(SystemContextQuery query) throws CallerException;
}
