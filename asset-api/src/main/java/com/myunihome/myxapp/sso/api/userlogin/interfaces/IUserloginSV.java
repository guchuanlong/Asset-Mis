package com.myunihome.myxapp.sso.api.userlogin.interfaces;

import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.sso.api.userlogin.param.ResponseParam;
import com.myunihome.myxapp.sso.api.userlogin.param.UpdateUserStateVO;
import com.myunihome.myxapp.sso.api.userlogin.param.UserLoginByTelQueryVO;
import com.myunihome.myxapp.sso.api.userlogin.param.UserLoginVo;
import com.myunihome.myxapp.sso.api.userlogin.param.WithdrawUserLoginVO;

/**
 * 
 * @author zhangbc
 * 
 */
public interface IUserloginSV {

	/**
	 * 用户名登录服务
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @param tenantId
	 *            租户编码
	 * @return UserLoginVo
	 * @author zhangbc
	 * @ApiDocMethod
	 * @ApiCode SYS_0003
	 */

	UserLoginVo checkUserLoginByusername(String username, String password,String tenantId) throws CallerException;

	/**
	 * 用户手机号登录服务
	 * 
	 * @param iphone
	 *            用户名
	 * @param password
	 *            密码
	 * @param tenantId
	 *            租户编码
	 * 
	 * @author zhangbc
	 * @ApiDocMethod
	 * @ApiCode SYS_0001
	 */

	UserLoginVo checkUserLoginByiphone(String iphone, String password,String tenantId) throws CallerException;

	/**
	 * 用户邮箱登录服务
	 * 
	 * @param mail
	 *            用户名
	 * @param password
	 *            密码
	 * @param tenantId
	 *            租户编码
	 * 
	 * @author zhangbc
	 * @ApiDocMethod
	 * @ApiCode SYS_0002
	 */

	UserLoginVo checkUserLoginBymail(String mail, String password,String tenantId) throws CallerException;

	/**
	 * 用户登录信息创建服务
	 * 
	 * @param UserLoginVo
	 *            传入参数
	 * 
	 * @return int
	 * 
	 * @author zhangbc
	 * 
	 * @ApiDocMethod
	 * @ApiCode SYS_0004
	 */
	int addUserLogin(UserLoginVo vo) throws CallerException;

	/**
	 * 用户登录信息更新服务
	 * 
	 * @param UserLoginVo
	 * @return ResponseParam
	 * @author zhangbc
	 * @ApiDocMethod
	 * @ApiCode SYS_0005
	 */
	ResponseParam updateUserLogin(UserLoginVo vo) throws CallerException;
	
	/**
	 * 更新用户密码
	 * 
	 * @param vo (newPassword，userId，tenantId，userPasswd修改密码时传递，密码重置不传递)
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 * @ApiCode SYS_0036
	 */
	ResponseParam updateUserPassword(UserLoginVo vo) throws CallerException;
	
	/**
	 * 根据用户id获得用户信息
	 * @param vo (租户id user_id)
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 * @ApiCode SYS_0037
	 */
	UserLoginVo queryUserLoginById(UserLoginVo vo) throws CallerException;
	
	/**
	 * 注销用户
	 * @param withdrawUserLoginVO
	 * @return
	 * @author fengyj5
	 * @ApiDocMethod
	 * @ApiCode SYS_0042
	 */
	ResponseParam withdrawUserLogin(WithdrawUserLoginVO withdrawUserLoginVO ) throws CallerException;
	
	/**
	 * 修改用户状态
	 * @param updateUserLoginStateVO
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 * @ApiCode SYS_0057
	 */
	ResponseParam updateUserState(UpdateUserStateVO updateUserLoginStateVO ) throws CallerException;
	
	/**
	 * 通过手机号查询登录用户
	 * @param userLoginByTelQueryVO
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 * @ApiCode SYS_0060
	 */
	UserLoginVo queryUserLoginByIphone(UserLoginByTelQueryVO userLoginByTelQueryVO) throws CallerException;

	/**
	 * 修改用户信息通过手机号
	 * @param userLoginVo（手机号码，租户id必填）
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 * @ApiCode SYS_0065
	 */
	ResponseParam updateUserLoginByIphone(UserLoginVo userLoginVo ) throws CallerException;
}
