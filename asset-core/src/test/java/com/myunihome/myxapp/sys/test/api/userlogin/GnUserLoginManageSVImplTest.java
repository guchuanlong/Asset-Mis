package com.myunihome.myxapp.sys.test.api.userlogin;

import net.sf.json.JSONObject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myunihome.myxapp.sso.api.userlogin.interfaces.IUserloginSV;
import com.myunihome.myxapp.sso.api.userlogin.param.ResponseParam;
import com.myunihome.myxapp.sso.api.userlogin.param.UpdateUserStateVO;
import com.myunihome.myxapp.sso.api.userlogin.param.UserLoginByTelQueryVO;
import com.myunihome.myxapp.sso.api.userlogin.param.UserLoginVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/core-context.xml")
public class GnUserLoginManageSVImplTest {

	@Autowired
	IUserloginSV userloginSV;

	@Test
	@Ignore
	public void testUpdatePassword() throws Exception {
		System.out.println("testUpdatePassword begin>>>>>>>>>>>>>");
		UserLoginVo userLoginVo = new UserLoginVo();
		userLoginVo.setTenantId("BIS-ST");
		userLoginVo.setUserId(new Long("31510190003984"));
		//userLoginVo.setUserPasswd("E10ADC3949BA59ABBE56E057F20F883E");
		userLoginVo.setNewPassword("96E79218965EB72C92A549DD5A330112");
		ResponseParam result = userloginSV.updateUserPassword(userLoginVo);
		System.out.println("code: " + result.getResponseCode() + ",desc: " + result.getRespondeDescribe());
		System.out.println("testUpdatePassword end>>>>>>>>>>>>>");
	}
	
	@Test
	public void testQueryUserLoginById() throws Exception {
		System.out.println("testQueryUserLoginById begin>>>>>>>>>>>>>");
		UserLoginVo userLoginVo = new UserLoginVo();
		userLoginVo.setTenantId("BIS-ST");
		userLoginVo.setUserId(new Long("31510260004412"));
		UserLoginVo result = userloginSV.queryUserLoginById(userLoginVo);
		System.out.println("result: " +JSONObject.fromObject(result));
		System.out.println("testQueryUserLoginById end>>>>>>>>>>>>>");
	}
	
	@Test
	public void testUpdateState() throws Exception {
		System.out.println("testUpdateState begin>>>>>>>>>>>>>");
		UpdateUserStateVO userLoginVo = new UpdateUserStateVO();
		userLoginVo.setTenantId("BIS-ST");
		userLoginVo.setUserId(10012L);
		userLoginVo.setState("02");
		ResponseParam result = userloginSV.updateUserState(userLoginVo);
		System.out.println("code: " + result.getResponseCode() + ",desc: " + result.getRespondeDescribe());
		System.out.println("testUpdateState end>>>>>>>>>>>>>");
	}
	
	@Test
	public void testQueryUserLoginByIphone() throws Exception {
		System.out.println("testQueryUserLoginByIphone begin>>>>>>>>>>>>>");
		UserLoginByTelQueryVO userLoginByTelQueryVO = new UserLoginByTelQueryVO();
		userLoginByTelQueryVO.setTenantId("BIS-ST");
		userLoginByTelQueryVO.setUserIphone("18888888888");
		UserLoginVo result = userloginSV.queryUserLoginByIphone(userLoginByTelQueryVO);
		System.out.println("result: " +JSONObject.fromObject(result));
		System.out.println("testQueryUserLoginByIphone end>>>>>>>>>>>>>");
	}
	
	@Test
	public void testUpdateUserLoginByIphone() throws Exception {
		System.out.println("testUpdateUserLoginByIphone begin>>>>>>>>>>>>>");
		UserLoginVo userLoginByTelQueryVO = new UserLoginVo();
		userLoginByTelQueryVO.setTenantId("BIS-ST");
		userLoginByTelQueryVO.setUserIphone("18888888881");
		userLoginByTelQueryVO.setRemark("1111");
		userLoginByTelQueryVO.setUserMail("xxxxx@163.com");
		ResponseParam result = userloginSV.updateUserLoginByIphone(userLoginByTelQueryVO);
		System.out.println("result: " +JSONObject.fromObject(result));
		System.out.println("testUpdateUserLoginByIphone end>>>>>>>>>>>>>");
	}
}
