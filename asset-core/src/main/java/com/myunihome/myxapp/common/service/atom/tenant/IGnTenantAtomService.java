package com.myunihome.myxapp.common.service.atom.tenant;

import java.util.List;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.common.dao.mapper.bo.GnTenant;

public interface IGnTenantAtomService {
	/**
	 * 根据租户id编码查询信息.
	 * <p/>
	 * 按照给定的机构编码，返回租户的详细信息.如果传入的租户ID为空，则抛出异常。
	 *
	 * @param gnTennatConditon
	 *            查询条件
	 * @return 符合条件的租户信息
	 * @throws CallerException
	 * @ApiDocMethod
	 * @ApiCode GN_0335
	 */
	GnTenant selectTenantById(String tenantId);

	/**
	 * 查询所有租户信息
	 * 
	 * @return
	 * @author zhanglh
	 * @ApiDocMethod
	 * @ApiCode GN_0336
	 */
	List<GnTenant> selectAllTenant() throws CallerException;
}
