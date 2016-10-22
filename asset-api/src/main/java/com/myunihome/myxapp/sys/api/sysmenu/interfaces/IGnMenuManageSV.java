package com.myunihome.myxapp.sys.api.sysmenu.interfaces;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.sys.api.sysmenu.param.GnMenuParamsVO;
import com.myunihome.myxapp.sys.api.sysmenu.param.GnMenuResponseVO;
import com.myunihome.myxapp.sys.api.sysmenu.param.GnMenuVO;

public interface IGnMenuManageSV {
    
    /**
     * 菜单创建服务
     * @param menuParamsVO  待添加菜单信息
     * <p/>
     * 参数列表：<br>
     * 系统标识<br>
     * 租户编码<br>
     * 菜单名称<br>
     * 菜单描述<br>
     * 上级菜单编码<br>
     * 菜单URL<br>
     * 系统模块标识<br>
     * 生效时间<br>
     * 失效时间<br>
     * 创建操作员编码<br>
     * <p/>
     * @return  菜单ID
     * @author liangbs
     * @ApiDocMethod
     * @ApiCode SYS_0015
     */
    Long addMenu(GnMenuParamsVO menuParamsVO) throws CallerException;
    
    /**
     * 菜单更新服务
     * @param menuParamsVO  待更新菜单信息
     * <p/>
     * 参数列表：<br>
     * 系统标识<br>
     * 租户编码<br>
     * 菜单名称<br>
     * 菜单描述<br>
     * 上级菜单编码<br>
     * 菜单URL<br>
     * 系统模块标识<br>
     * 生效时间<br>
     * 失效时间<br>
     * 更新时间<br>
     * 创建操作员编码<br>
     * <p/>
     * @return  响应信息
     * @author liangbs
     * @ApiDocMethod
     * @ApiCode SYS_0016
     */
    GnMenuResponseVO updateMenu(GnMenuParamsVO menuParamsVO) throws CallerException;

    /**
     * 菜单删除服务
     * @param menuParamsVO  菜单操作参数类
     * <p/>
     * 参数列表：<br>
     * 菜单id<br>
     * 租户编码<br>
     * <p/>
     * @return  响应信息
     * @author liangbs
     * @ApiDocMethod
     * @ApiCode SYS_0017
     */
    GnMenuResponseVO delMenuByID(GnMenuParamsVO menuParamsVO) throws CallerException;
    
    /**
     * 根据菜单编码获取菜单信息服务
     * @param menuParamsVO  菜单操作参数类
     * <p/>
     * 参数列表：<br>
     * 菜单id<br>
     * 租户编码<br>
     * <p/>
     * @return  实体类（系统标识、租户编码、菜单id、菜单名称、菜单描述、上级菜单id、菜单URL、菜单图片、系统模块标识、生效时间、失效时间）
     * @author liangbs
     * @ApiDocMethod
     * @ApiCode SYS_0018
     */
    GnMenuVO queryMenuById(GnMenuParamsVO menuParamsVO) throws CallerException;
    
    /**
     * 根据查询条件获取菜单列表服务
     * @param menuParamsVO  菜单操作参数类（租户编码、分页参数、菜单id、菜单名称）
     * @return  列表（租户编码、菜单id、菜单名称、菜单URL、生效时间、失效时间）
     * @author liangbs
     * @ApiDocMethod
     * @ApiCode SYS_0019
     */
    PageInfo<GnMenuVO> queryMenu(GnMenuParamsVO menuParamsVO) throws CallerException;
    
    /**
     * 根据查询条件获取菜单列表服务(过滤指定id)
     * @param menuParamsVO  菜单操作参数类（租户编码、分页参数、菜单id、菜单名称、过滤的menuid）
     * @return  列表（租户编码、菜单id、菜单名称、菜单URL、生效时间、失效时间）
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode SYS_0039
     */
    PageInfo<GnMenuVO> queryMenuFilterIds(GnMenuParamsVO menuParamsVO) throws CallerException;
    
}
