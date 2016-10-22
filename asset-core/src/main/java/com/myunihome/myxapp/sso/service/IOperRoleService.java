package com.myunihome.myxapp.sso.service;

import java.util.List;

import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOperRole;
import com.myunihome.myxapp.sys.api.sysoperrole.param.GnOperRoleParamsVO;

public interface IOperRoleService {
	
	/**
	 * 操作员赋予角色权限
	 * @param operRoleVO
	 * @return
	 */
	Integer addRoleToOper(GnOperRole operRole);
    
	/**
	 * 查询操作员拥有角色列表
	 * @param operRoleVO
	 * @return
	 */
    PageInfo<GnOperRole> queryRoleByOperId(GnOperRoleParamsVO operRoleParamsVO);
    
    /**
	 * 查询操作员拥有所有角色
	 * @param operRoleParamsVO
	 * @return
	 */
    List<GnOperRole> queryRoleListByOperId(GnOperRoleParamsVO operRoleParamsVO);
    
    /**
     * 更新操作员角色表
     * @param operRoleParamsVO
     * @return
     */
    Integer updateOperRole(GnOperRoleParamsVO operRoleParamsVO);
    
    /**
     * 删除操作员角色关系
     * @param operRoleParamsVO
     * @return
     */
    Integer deleteOperRole(GnOperRoleParamsVO operRoleParamsVO);
}
