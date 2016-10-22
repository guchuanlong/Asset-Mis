package com.myunihome.myxapp.sys.api.sysrole.interfaces;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.sys.api.sysrole.param.GnRoleParamsVO;
import com.myunihome.myxapp.sys.api.sysrole.param.GnRoleResponseVO;
import com.myunihome.myxapp.sys.api.sysrole.param.GnRoleVO;

public interface IGnRoleManageSV {
    
    /**
     * 角色创建服务
     * @param roleParamsVO  待添加角色信息
     * <p/>
     * 参数列表：<br>
     * 系统标识<br>
     * 租户编码<br>
     * 角色编码<br>
     * 角色名称<br>
     * 角色级别<br>
     * 角色描述<br>
     * 父角色id<br>
     * 系统模块编码<br>
     * 生效时间<br>
     * 失效时间<br>
     * 创建操作员编码<br>
     * 创建类型<br>
     * <p/>
     * @return  角色ID
     * @author liangbs
     * @ApiDocMethod
     * @ApiCode SYS_0020
     */
    Long addRole(GnRoleParamsVO roleParamsVO) throws CallerException;
    
    /**
     * 角色更新服务
     * @param roleParamsVO  待更新角色信息
     * <p/>
     * 参数列表：<br>
     * 系统标识<br>
     * 租户编码<br>
     * 角色编码<br>
     * 角色名称<br>
     * 角色级别<br>
     * 角色描述<br>
     * 父角色id<br>
     * 系统模块编码<br>
     * 生效时间<br>
     * 失效时间<br>
     * 更新操作员编码<br>
     * 创建类型<br>
     * <p/>
     * @return  响应信息
     * @author liangbs
     * @ApiDocMethod
     * @ApiCode SYS_0021
     */
    GnRoleResponseVO updateRole(GnRoleParamsVO roleParamsVO) throws CallerException;

    /**
     * 角色删除服务
     * @param roleParamsVO  角色操作参数类
     * <p/>
     * 参数列表：<br>
     * 角色id<br>
     * 租户编码<br>
     * <p/>
     * @return  响应信息
     * @author liangbs
     * @ApiDocMethod
     * @ApiCode SYS_0022
     */
    GnRoleResponseVO delRoleByID(GnRoleParamsVO roleParamsVO) throws CallerException;
    
    /**
     * 根据角色编码获取角色信息服务
     * @param roleParamsVO  角色操作参数类
     * <p/>
     * 参数列表：<br>
     * 角色id<br>
     * 租户编码<br>
     * <p/>
     * @return  实体类（系统标识、租户编码、角色id、角色编码、角色名称、角色级别、角色描述、父角色id、系统模块编码、生效时间、失效时间、创建类型）
     * @author liangbs
     * @ApiDocMethod
     * @ApiCode SYS_0023
     */
    GnRoleVO queryRoleById(GnRoleParamsVO roleParamsVO) throws CallerException;
    
    /**
     * 根据查询条件获取角色列表服务
     * @param roleParamsVO  角色操作参数类（租户编码、分页参数、角色id、角色名称）
     * @return  列表（租户编码、角色id、角色编码、角色名称、角色描述、生效时间、失效时间）
     * @author liangbs
     * @ApiDocMethod
     * @ApiCode SYS_0024
     */
    PageInfo<GnRoleVO> queryRole(GnRoleParamsVO roleParamsVO) throws CallerException;
    
    /**
     * 过滤指定id查询角色列表
     * @param roleParamsVO
     * @return
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode SYS_0038
     */
    PageInfo<GnRoleVO> queryRoleFilterIds(GnRoleParamsVO roleParamsVO) throws CallerException;
}
