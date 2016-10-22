package com.myunihome.myxapp.sso.api.menu.interfaces;

import java.util.List;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.sso.api.menu.param.GetMenuByConditionVO;
import com.myunihome.myxapp.sso.api.menu.param.GetMenuByOperIDVO;
import com.myunihome.myxapp.sso.api.menu.param.GnParamsVO;

public interface IGetMenuByOperidSV {

	/**
	 * 根据登录信息获取拥有菜单列表服务
	 * @param staffnoId
	 * 			操作员ID
	 * @param tenantId
	 * 			租户ID
	 * @return String JSON格式的List<GetMenuByOperIDVO>
	 *        
	 * @author Becky
	 * @ApiDocMethod
	 * @ApiCode SYS_0008
	 */
	List<GetMenuByOperIDVO> getMenuByOperID(Long staffnoId, String tenantId) throws CallerException;
	
	/**
	 * 根据登录信息获取对应频道拥有菜单列表服务
	 * @param paramsVO 参数封装类
	 * <p/>
     * 参数列表：<br>
     * 操作员编码<br>
     * 系统标识<br>
     * 租户编码<br>
     * 系统模块编码<br>
     * <p/>
	 * @return  String JSON格式的List<GetMenuByConditionVO>
	 * @author liangbs
	 * @ApiDocMethod
	 * @ApiCode SYS_0032
	 */
	List<GetMenuByConditionVO> getMenuByCondition(GnParamsVO paramsVO) throws CallerException;
}
