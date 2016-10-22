package com.myunihome.myxapp.sso.service;

import com.myunihome.myxapp.sso.api.userlogin.param.ResponseParam;
import com.myunihome.myxapp.sso.api.userlogin.param.UpdateUserStateVO;
import com.myunihome.myxapp.sso.api.userlogin.param.UserLoginByTelQueryVO;
import com.myunihome.myxapp.sso.api.userlogin.param.UserLoginVo;
import com.myunihome.myxapp.sso.api.userlogin.param.WithdrawUserLoginVO;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnUserLogin;

public interface IUserloginService {
	
	UserLoginVo checkUserLoginByusername(String username,String password,String tenantId);
	
    UserLoginVo checkUserLoginByiphone(String iphone,String password,String tenantId);
	
	UserLoginVo checkUserLoginBymail(String mail,String password,String tenantId);
	
	int addUserLogin(UserLoginVo vo);
	
	ResponseParam updateUserLogin(UserLoginVo vo);
	
	GnUserLogin selectUserLoginById(Long userLoginId);
	/**
	 * 修改密码
	 * @param vo
	 * @return
	 */
	Integer updateUserPassword(UserLoginVo vo);
	
	/**
	 * 通过用户id获得用户信息
	 * @param vo
	 * @return
	 */
	UserLoginVo queryUserLoginById(UserLoginVo vo);
	/**
	 * 
	 * @param vo
	 * @return
	 */
	Integer withdrawLogin(WithdrawUserLoginVO withdrawUserLoginVO);
	
	/**
	 * 
	 * @param updateUserLoginStateVO
	 * @return
	 */
	Integer updateUserState(UpdateUserStateVO updateUserLoginStateVO );
	
	UserLoginVo queryUserLoginByIphone(UserLoginByTelQueryVO userLoginByTelQueryVO);

	Integer updateUserLoginByIphone(UserLoginVo userLoginVo);

}
