package com.myunihome.myxapp.sys.api.sysoperrole.interfaces;

import java.util.List;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.sys.api.sysoperrole.param.GnOperRoleParamsVO;
import com.myunihome.myxapp.sys.api.sysoperrole.param.GnOperRoleResponseVO;
import com.myunihome.myxapp.sys.api.sysoperrole.param.GnOperRoleVO;

public interface IGnOperRoleManageSV {
    
    /**
     * 操作员赋予角色权限服务
     * @param GnOperRoleParamsVO  待处理操作员信息
     * <p/>
     * 参数列表：<br>
     * 租户编码<br>
     * 操作员id<br>
     * 对应的角色id列表<br>
     * 创建操作员id<br>
     * 创建类型<br>
     * 生效时间<br>
     * 失效时间<br>
     * <p/>
     * @return  响应信息
     * @author liangbs
     * @ApiDocMethod
     * @ApiCode SYS_0029
     */
    GnOperRoleResponseVO addRoleToOper(GnOperRoleParamsVO operRoleParamsVO) throws CallerException;
    
    /**
     * 操作员拥有角色列表服务
     * @param operRoleParamsVO  操作员拥有角色操作参数
     * <p/>
     * 参数列表：<br>
     * 租户编码<br>
     * 操作员id<br>
     * 分页参数<br>
     * <p/>
     * @return  列表（角色id、角色名称）
     * @author liangbs
     * @ApiDocMethod
     * @ApiCode SYS_0030
     */
    PageInfo<GnOperRoleVO> queryRoleByOperId(GnOperRoleParamsVO operRoleParamsVO) throws CallerException;
    
	// /**
	// * 操作员可赋角色查询（过滤已有角色）
	// * @param operRoleParamsVO (租户id,操作员id)
	// * @param roleParamsVO (租户id,页面信息,查询条件)
	// * @return
	// * @author jiaxs
	// * @ApiDocMethod
	// * @ApiCode SYS_0038
	// */
	// PageInfo<GnRoleVO> queryRoleFilterIds(GnOperRoleParamsVO
	// operRoleParamsVO, GnRoleParamsVO roleParamsVO);
    
    /**
     * 删除操作员角色信息
     * @param operRoleParamsVO
     * @return
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode SYS_0040
     */
    GnOperRoleResponseVO deleteOperRole(GnOperRoleParamsVO operRoleParamsVO) throws CallerException;
    
    
    /**
     * 通过操作员ID获得所有操作员角色列表
     * @param operRoleParamsVO
     * @return
     * @author jiaxs
     * @ApiDocMethod
     * @ApiCode SYS_0058
     */
    List<GnOperRoleVO> queryOperRoleListByOperId(GnOperRoleParamsVO operRoleParamsVO) throws CallerException;
    
}
