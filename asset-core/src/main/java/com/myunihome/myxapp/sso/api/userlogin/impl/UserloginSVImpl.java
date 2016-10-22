package com.myunihome.myxapp.sso.api.userlogin.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.sso.api.userlogin.interfaces.IUserloginSV;
import com.myunihome.myxapp.sso.api.userlogin.param.ResponseParam;
import com.myunihome.myxapp.sso.api.userlogin.param.UpdateUserStateVO;
import com.myunihome.myxapp.sso.api.userlogin.param.UserLoginByTelQueryVO;
import com.myunihome.myxapp.sso.api.userlogin.param.UserLoginVo;
import com.myunihome.myxapp.sso.api.userlogin.param.WithdrawUserLoginVO;
import com.myunihome.myxapp.sso.constants.Constants;
import com.myunihome.myxapp.sso.constants.Constants.ErrorCode;
import com.myunihome.myxapp.sso.service.IUserloginService;
import com.myunihome.myxapp.sso.service.impl.UserloginServiceImpl;

import net.sf.json.JSONObject;

@Service
@Component
public class UserloginSVImpl implements IUserloginSV {

	private static final Logger LOGGER = Logger.getLogger(UserloginServiceImpl.class);

	@Autowired
	private IUserloginService iUserloginService;

	@Override
	public UserLoginVo checkUserLoginByusername(String username, String password, String tenantId) throws CallerException {
		return iUserloginService.checkUserLoginByusername(username, password, tenantId);
	}

	@Override
	public UserLoginVo checkUserLoginByiphone(String iphone, String password, String tenantId) throws CallerException {
		return iUserloginService.checkUserLoginByiphone(iphone, password, tenantId);
	}

	@Override
	public UserLoginVo checkUserLoginBymail(String mail, String password, String tenantId) throws CallerException {
		return iUserloginService.checkUserLoginBymail(mail, password, tenantId);
	}

	@Override
	public int addUserLogin(UserLoginVo vo) throws CallerException {
		return iUserloginService.addUserLogin(vo);
	}

	@Override
	public ResponseParam updateUserLogin(UserLoginVo vo) throws CallerException {
		ResponseParam responseParam = null;
		String errorMsg = "";
		if (StringUtils.isEmpty(vo.getTenantId())) {
			errorMsg += "tenantId 不能为空  ";
		}
		if ("".equals(errorMsg)) {
			responseParam = iUserloginService.updateUserLogin(vo);
		} else {
			LOGGER.error(errorMsg);
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
		return responseParam;
	}

	@Override
	public ResponseParam updateUserPassword(UserLoginVo vo) throws CallerException {
		LOGGER.info("密码更新服务updateRole方法参数列表：" + JSONObject.fromObject(vo));
		String errorMsg = "";
		ResponseParam param = new ResponseParam();
		if (StringUtils.isEmpty(vo.getTenantId())) {
			errorMsg += "tenantId 不能为空  ";
		}
		if (vo.getUserId() == null) {
			errorMsg += "userId 不能为空  ";
		}
		if (StringUtils.isEmpty(vo.getNewPassword())) {
			errorMsg += "新密码 不能为空  ";
		}
		if ("".equals(errorMsg)) {
			Integer result = iUserloginService.updateUserPassword(vo);
			if (result < 0) {
				param.setResponseCode(Constants.ResponseState.FAILED);
				param.setRespondeDescribe("密码设置失败!");
			} else if (result == 0) {
				param.setResponseCode(Constants.ResponseState.FAILED);
				String message = vo.getUserPasswd() == null ? "帐号不正确!" : "帐号或原始密码不正确!";
				param.setRespondeDescribe(message);
			} else {
				param.setResponseCode(Constants.ResponseState.SUCCESS);
				param.setRespondeDescribe("密码设置成功!");
			}
		} else {
			LOGGER.error(errorMsg);
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
		JSONObject paramVo = JSONObject.fromObject(param);
		LOGGER.info("Result from updateUserLogin : " + paramVo.toString());
		return param;
	}

	@Override
	public UserLoginVo queryUserLoginById(UserLoginVo vo) throws CallerException {
		LOGGER.info("用户管理服务queryUserLoginById方法参数列表：" + JSONObject.fromObject(vo));
		String errorMsg = "";
		UserLoginVo userLoginVo = null;
		if (StringUtils.isEmpty(vo.getTenantId())) {
			errorMsg += "tenantId 不能为空  ";
		}
		if (vo.getUserId() == null) {
			errorMsg += "userId 不能为空  ";
		}
		if ("".equals(errorMsg)) {
			userLoginVo = iUserloginService.queryUserLoginById(vo);
			JSONObject paramVo = JSONObject.fromObject(userLoginVo);
			LOGGER.info("Result from queryUserLoginById : " + paramVo.toString());
		} else {
			LOGGER.error(errorMsg);
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
		return userLoginVo;
	}

	public ResponseParam withdrawUserLogin(WithdrawUserLoginVO withdrawUserLoginVO) {
		ResponseParam responseParam = new ResponseParam();
		String errorMsg = "";
		if (StringUtils.isEmpty(withdrawUserLoginVO.getTenantId())) {
			errorMsg += "tenantId 不能为空  ";
		}
		if (withdrawUserLoginVO.getUserId() == null) {
			errorMsg += "UserId 不能为空  ";
		}
		if ("".equals(errorMsg)) {
			Integer result = iUserloginService.withdrawLogin(withdrawUserLoginVO);
			if (result > 0) {
				responseParam.setResponseCode(Constants.ResponseState.SUCCESS);
				responseParam.setRespondeDescribe("用户注销成功!");
			} else {
				responseParam.setResponseCode(Constants.ResponseState.FAILED);
				responseParam.setRespondeDescribe("用户注销失败!");
			}
		} else {
			LOGGER.error(errorMsg);
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
		return responseParam;
	}

	@Override
	public ResponseParam updateUserState(UpdateUserStateVO updateUserLoginStateVO)  throws CallerException{
		ResponseParam responseParam = new ResponseParam();
		String errorMsg = "";
		if (updateUserLoginStateVO == null) {
			errorMsg += "参数对象不能为空！";
		} else {
			if (StringUtils.isEmpty(updateUserLoginStateVO.getTenantId())) {
				errorMsg += "tenantId 不能为空  ";
			}
			if (updateUserLoginStateVO.getUserId() == null) {
				errorMsg += "userId 不能为空  ";
			}
			if (StringUtils.isEmpty(updateUserLoginStateVO.getState())) {
				errorMsg += "state 不能为空  ";
			}
		}
		if ("".equals(errorMsg)) {
			Integer result = iUserloginService.updateUserState(updateUserLoginStateVO);
			if (result > 0) {
				responseParam.setResponseCode(Constants.ResponseState.SUCCESS);
				responseParam.setRespondeDescribe("用户状态修改成功!");
			} else {
				responseParam.setResponseCode(Constants.ResponseState.FAILED);
				responseParam.setRespondeDescribe("用户状态修改失败!");
			}
		} else {
			LOGGER.error(errorMsg);
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
		return responseParam;
	}

	@Override
	public UserLoginVo queryUserLoginByIphone(UserLoginByTelQueryVO userLoginByTelQueryVO) throws CallerException {
		LOGGER.info("用户管理服务queryUserLoginByIphone方法参数列表：" + JSONObject.fromObject(userLoginByTelQueryVO));
		String errorMsg = "";
		UserLoginVo userLoginVo = null;
		if (StringUtils.isEmpty(userLoginByTelQueryVO.getTenantId())) {
			errorMsg += "tenantId 不能为空  ";
		}
		if (userLoginByTelQueryVO.getUserIphone() == null) {
			errorMsg += "userIphone 不能为空  ";
		}
		if ("".equals(errorMsg)) {
			userLoginVo = iUserloginService.queryUserLoginByIphone(userLoginByTelQueryVO);
			JSONObject paramVo = JSONObject.fromObject(userLoginVo);
			LOGGER.info("Result from queryUserLoginById : " + paramVo.toString());
		} else {
			LOGGER.error(errorMsg);
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
		return userLoginVo;
	}

	@Override
	public ResponseParam updateUserLoginByIphone(UserLoginVo userLoginVo) throws CallerException {
		ResponseParam responseParam = new ResponseParam();
		String errorMsg = "";
		if(userLoginVo == null){
			errorMsg += "参数对象不能为空 ！ ";
		}else{
			if (StringUtils.isEmpty(userLoginVo.getTenantId())) {
				errorMsg += "tenantId 不能为空!  ";
			}
			if (StringUtils.isEmpty(userLoginVo.getUserIphone())) {
				errorMsg += "userIphone 不能为空! ";
			}
		}
		if (StringUtils.isNotEmpty(errorMsg)) {
			LOGGER.error(errorMsg);
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		} else {
			Integer count = iUserloginService.updateUserLoginByIphone(userLoginVo);
			if(count > 0){
				responseParam.setResponseCode(Constants.ResponseState.SUCCESS);
				responseParam.setRespondeDescribe("修改成功！");
			}else{
				responseParam.setResponseCode(Constants.ResponseState.FAILED);
				responseParam.setRespondeDescribe("修改失败！");
			}
		}
		return responseParam;
	}
}
