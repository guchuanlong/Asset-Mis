package com.myunihome.myxapp.sso.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.myunihome.myxapp.paas.sequence.SeqUtil;
import com.myunihome.myxapp.paas.util.BeanUtils;
import com.myunihome.myxapp.sso.api.userlogin.param.ResponseParam;
import com.myunihome.myxapp.sso.api.userlogin.param.UpdateUserStateVO;
import com.myunihome.myxapp.sso.api.userlogin.param.UserLoginByTelQueryVO;
import com.myunihome.myxapp.sso.api.userlogin.param.UserLoginVo;
import com.myunihome.myxapp.sso.api.userlogin.param.WithdrawUserLoginVO;
import com.myunihome.myxapp.sso.constants.Constants;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnUserLogin;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnUserLoginCriteria;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnUserLoginCriteria.Criteria;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;
import com.myunihome.myxapp.sso.dao.mapper.interfaces.GnUserLoginMapper;
import com.myunihome.myxapp.sso.service.IUserloginService;
import com.myunihome.myxapp.sys.util.DateTimeUtil;

import net.sf.json.JSONObject;

@Component
public class UserloginServiceImpl implements IUserloginService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserloginServiceImpl.class);

	@Override
	public UserLoginVo checkUserLoginByusername(String username, String password, String tenantId) {
		String message = "Parameters into checkUserLoginByusername : username = " + username + "password = " + password + "tenantId = " + tenantId;
		LOGGER.info(message);
		GnUserLoginCriteria gnUserLoginCriteria = new GnUserLoginCriteria();
		GnUserLoginCriteria.Criteria criteria = gnUserLoginCriteria.createCriteria();
		if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password) && !StringUtils.isEmpty(tenantId)) {
			criteria.andUserNameEqualTo(username);
			criteria.andUserPasswdEqualTo(password);
			criteria.andTenantIdEqualTo(tenantId);
			criteria.andStateEqualTo(Constants.RecordsState.STATE_NORMAL);
			criteria.andInactiveTimeGreaterThanOrEqualTo(DateTimeUtil.getCurrTimestamp());
			List<GnUserLogin> gnUserLogins = MapperFactory.getGnUserLoginMapper().selectByExample(gnUserLoginCriteria);
			if (gnUserLogins.size() > 0) {
				GnUserLogin gnUserLogin = gnUserLogins.get(0);
				UserLoginVo userLoginVo = new UserLoginVo();
				BeanUtils.copyProperties(userLoginVo, gnUserLogin);
				JSONObject returnVo = JSONObject.fromObject(userLoginVo);
				message = "Result from checkUserLoginByusername :" + returnVo.toString();
				LOGGER.info(message);
				return userLoginVo;
			} else {
				message = "Result from checkUserLoginByusername : user " + username + " not exist.";
				LOGGER.info(message);
				return null;
			}
		}

		else {
			message = "Result from checkUserLoginByusername : No values for input parameters. ";
			LOGGER.info(message);
			return null;
		}
	}

	@Override
	public UserLoginVo checkUserLoginByiphone(String iphone, String password, String tenantId) {
		String message = "Parameters into checkUserLoginByiphone : iphone = " + iphone + "password = " + password + "tenantId = " + tenantId;
		LOGGER.info(message);
		GnUserLoginCriteria gnUserLoginCriteria = new GnUserLoginCriteria();
		GnUserLoginCriteria.Criteria criteria = gnUserLoginCriteria.createCriteria();
		if (!StringUtils.isEmpty(password) && !StringUtils.isEmpty(tenantId)) {
			criteria.andUserIphoneEqualTo(iphone);
			criteria.andUserPasswdEqualTo(password);
			criteria.andTenantIdEqualTo(tenantId);
			criteria.andStateEqualTo(Constants.RecordsState.STATE_NORMAL);
			criteria.andInactiveTimeGreaterThanOrEqualTo(DateTimeUtil.getCurrTimestamp());
			List<GnUserLogin> gnUserLogins = MapperFactory.getGnUserLoginMapper().selectByExample(gnUserLoginCriteria);
			if (gnUserLogins.size() > 0) {
				GnUserLogin gnUserLogin = gnUserLogins.get(0);
				UserLoginVo userLoginVo = new UserLoginVo();
				BeanUtils.copyProperties(userLoginVo, gnUserLogin);
				JSONObject returnVo = JSONObject.fromObject(userLoginVo);
				message = "Result from checkUserLoginByiphone :" + returnVo.toString();
				LOGGER.info(message);
				return userLoginVo;
			} else {
				message = "Result from checkUserLoginByiphone : user's mobile number " + iphone + " not exist.";
				LOGGER.info(message);
				return null;
			}
		}

		else {
			message = "Result from checkUserLoginByiphone : No values for input parameters. ";
			LOGGER.info(message);
			return null;
		}
	}

	@Override
	public UserLoginVo checkUserLoginBymail(String mail, String password, String tenantId) {
		String message = "Parameters into checkUserLoginBymail : mail = " + mail + "password = " + password + "tenantId = " + tenantId;
		LOGGER.info(message);
		GnUserLoginCriteria gnUserLoginCriteria = new GnUserLoginCriteria();
		GnUserLoginCriteria.Criteria criteria = gnUserLoginCriteria.createCriteria();
		if (!StringUtils.isEmpty(mail) && !StringUtils.isEmpty(password) && !StringUtils.isEmpty(tenantId)) {
			criteria.andUserMailEqualTo(mail);
			criteria.andUserPasswdEqualTo(password);
			criteria.andTenantIdEqualTo(tenantId);
			criteria.andStateEqualTo(Constants.RecordsState.STATE_NORMAL);
			criteria.andInactiveTimeGreaterThanOrEqualTo(DateTimeUtil.getCurrTimestamp());
			List<GnUserLogin> gnUserLogins = MapperFactory.getGnUserLoginMapper().selectByExample(gnUserLoginCriteria);
			if (gnUserLogins.size() > 0) {
				GnUserLogin gnUserLogin = gnUserLogins.get(0);
				UserLoginVo userLoginVo = new UserLoginVo();
				BeanUtils.copyProperties(userLoginVo, gnUserLogin);
				JSONObject returnVo = JSONObject.fromObject(userLoginVo);
				message = "Result from checkUserLoginBymail :" + returnVo.toString();
				LOGGER.info(message);
				return userLoginVo;
			} else {
				message = "Result from checkUserLoginBymail : user's email address " + mail + " not exist.";
				LOGGER.info(message);
				return null;
			}
		}

		else {
			message = "Result from checkUserLoginBymail : No values for input parameters. ";
			LOGGER.info(message);
			return null;
		}
	}

	@Override
	public int addUserLogin(UserLoginVo vo) {
		JSONObject paramVo = JSONObject.fromObject(vo);
		String message = "Parameters into addUserLogin : UserLoginVo = " + paramVo.toString();
		LOGGER.info(message);
		GnUserLogin gnUserLogin = new GnUserLogin();
		BeanUtils.copyProperties(gnUserLogin, vo);
		gnUserLogin.setUserLoginId(SeqUtil.getNewId("RUNNER_SSO_USERLOGIN_PAYMENT$ID$SEQ"));
		int resultId = MapperFactory.getGnUserLoginMapper().insert(gnUserLogin);
		message = "Result from addUserLogin : " + resultId;
		LOGGER.info(message);
		return resultId;
	}

	@Override
	public ResponseParam updateUserLogin(UserLoginVo vo) {
		JSONObject paramVo = JSONObject.fromObject(vo);
		String message = "Parameters into updateUserLogin : UserLoginVo = " + paramVo.toString();
		LOGGER.info(message);
		ResponseParam param = new ResponseParam();
		if (selectUserLoginById(vo.getUserLoginId()) != null) {
			GnUserLogin gnUserLogin = MapperFactory.getGnUserLoginMapper().selectByPrimaryKey(vo.getUserLoginId());
			BeanUtils.copyProperties(gnUserLogin, vo);
			MapperFactory.getGnUserLoginMapper().updateByPrimaryKey(gnUserLogin);
			param.setResponseCode(Constants.ResponseState.SUCCESS);
			param.setRespondeDescribe("更新成功!");
			paramVo = JSONObject.fromObject(param);
			message = "Result from updateUserLogin : " + paramVo.toString();
			LOGGER.info(message);
		} else {
			param.setResponseCode(Constants.ResponseState.FAILED);
			param.setRespondeDescribe("更新失败!");
			paramVo = JSONObject.fromObject(param);
			message = "Result from updateUserLogin : " + paramVo.toString();
			LOGGER.info(message);
		}
		return param;
	}

	@Override
	public GnUserLogin selectUserLoginById(Long userLoginId) {
		String message = "Parameters into selectUserLoginById : userLoginId = " + userLoginId;
		LOGGER.info(message);
		GnUserLogin gnUserLogin = MapperFactory.getGnUserLoginMapper().selectByPrimaryKey(userLoginId);
		JSONObject result = JSONObject.fromObject(gnUserLogin);
		message = "Result from selectUserLoginById : " + result.toString();
		LOGGER.info(message);
		return gnUserLogin;
	}

	@Override
	public Integer updateUserPassword(UserLoginVo vo) {
		JSONObject paramVo = JSONObject.fromObject(vo);
		String message = "Parameters into updateUserLogin : UserLoginVo = " + paramVo.toString();
		LOGGER.info(message);
		Integer result = null;
		GnUserLoginMapper userLoginMapper = MapperFactory.getGnUserLoginMapper();
		// 设置更新数据：新密码
		GnUserLogin gnUserLogin = new GnUserLogin();
		gnUserLogin.setUserPasswd(vo.getNewPassword());
		// 设置条件
		GnUserLoginCriteria userLoginCriteria = new GnUserLoginCriteria();
		Criteria createCriteria = userLoginCriteria.createCriteria();
		String tenantId = vo.getTenantId();// 租户id
		if (StringUtils.isNotEmpty(tenantId)) {
			createCriteria.andTenantIdEqualTo(tenantId);
		}
		Long userId = vo.getUserId();// 用户id
		if (userId != null) {
			createCriteria.andUserIdEqualTo(userId);
		}
		String password = vo.getUserPasswd();// 密码
		if (StringUtils.isNotEmpty(password)) {
			createCriteria.andUserPasswdEqualTo(password);
		}
		// 更新操作
		result = userLoginMapper.updateByExampleSelective(gnUserLogin, userLoginCriteria);
		message = "Result from updateUserPassword : " + result;
		LOGGER.info(message);
		return result;
	}

	@Override
	public UserLoginVo queryUserLoginById(UserLoginVo vo) {
		JSONObject paramVo = JSONObject.fromObject(vo);
		String message = "Parameters into queryUserLoginById : UserLoginVo = " + paramVo.toString();
		LOGGER.info(message);
		GnUserLoginMapper userLoginMapper = MapperFactory.getGnUserLoginMapper();
		//GnUserLogin gnUserLogin = userLoginMapper.selectByUserId(vo.getUserId(),vo.getTenantId(),DateTimeUtil.getCurrTimestamp());
		GnUserLoginCriteria userLoginCriteria = new GnUserLoginCriteria();
		Criteria createCriteria = userLoginCriteria.createCriteria();
		createCriteria.andUserIdEqualTo(vo.getUserId());
		createCriteria.andTenantIdEqualTo(vo.getTenantId());
		//createCriteria.andInactiveTimeGreaterThan(DateTimeUtil.getCurrTimestamp());
		List<GnUserLogin> gnUserLoginList = userLoginMapper.selectByExample(userLoginCriteria);
		UserLoginVo userLoginVo = null;
		if (gnUserLoginList != null&&gnUserLoginList.size()>0) {
			userLoginVo = new UserLoginVo();
			BeanUtils.copyProperties(userLoginVo, gnUserLoginList.get(0));
		}
		message = "Result from queryUserLoginById : " + JSONObject.fromObject(userLoginVo);
		LOGGER.info(message);
		return userLoginVo;
	}

	@Override
	public Integer withdrawLogin(WithdrawUserLoginVO withdrawUserLoginVO) {
		Integer i = null;
		if (withdrawUserLoginVO != null) {
			GnUserLoginCriteria example = new GnUserLoginCriteria();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andTenantIdEqualTo(withdrawUserLoginVO.getTenantId());
			createCriteria.andUserIdEqualTo(withdrawUserLoginVO.getUserId());
			GnUserLogin gnUserLogin = new GnUserLogin();
			gnUserLogin.setState(Constants.RecordsState.STATE_DELETED);
			gnUserLogin.setInactiveTime(DateTimeUtil.getCurrTimestamp());
			i=MapperFactory.getGnUserLoginMapper().updateByExampleSelective(gnUserLogin, example);
		}

		return i;

	}

	@Override
	public Integer updateUserState(UpdateUserStateVO updateUserLoginStateVO) {
		Integer i = null;
		if (updateUserLoginStateVO != null) {
			GnUserLoginCriteria example = new GnUserLoginCriteria();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andTenantIdEqualTo(updateUserLoginStateVO.getTenantId());
			createCriteria.andUserIdEqualTo(updateUserLoginStateVO.getUserId());
			GnUserLogin gnUserLogin = new GnUserLogin();
			gnUserLogin.setState(updateUserLoginStateVO.getState());
			i=MapperFactory.getGnUserLoginMapper().updateByExampleSelective(gnUserLogin, example);
		}
		return i;
	}

	@Override
	public UserLoginVo queryUserLoginByIphone(UserLoginByTelQueryVO userLoginByTelQueryVO) {
		JSONObject paramVo = JSONObject.fromObject(userLoginByTelQueryVO);
		String message = "Parameters into queryUserLoginByIphone :" + paramVo.toString();
		LOGGER.info(message);
		GnUserLoginMapper userLoginMapper = MapperFactory.getGnUserLoginMapper();
		GnUserLoginCriteria userLoginCriteria = new GnUserLoginCriteria();
		Criteria createCriteria = userLoginCriteria.createCriteria();
		createCriteria.andUserIphoneEqualTo(userLoginByTelQueryVO.getUserIphone());
		createCriteria.andTenantIdEqualTo(userLoginByTelQueryVO.getTenantId());
		//createCriteria.andInactiveTimeGreaterThan(DateTimeUtil.getCurrTimestamp());
		List<GnUserLogin> gnUserLoginList = userLoginMapper.selectByExample(userLoginCriteria);
		UserLoginVo userLoginVo = null;
		if (gnUserLoginList != null&&gnUserLoginList.size()>0) {
			userLoginVo = new UserLoginVo();
			BeanUtils.copyProperties(userLoginVo, gnUserLoginList.get(0));
		}
		message = "Result from queryUserLoginByIphone : " + JSONObject.fromObject(userLoginVo);
		LOGGER.info(message);
		return userLoginVo;
	}

	@Override
	public Integer updateUserLoginByIphone(UserLoginVo userLoginVo) {
		LOGGER.info("Parameters into updateUserLoginByIphone :" + JSON.toJSONString(userLoginVo));
		GnUserLoginMapper userLoginMapper = MapperFactory.getGnUserLoginMapper();
		GnUserLogin gnUserLogin = new GnUserLogin();
		BeanUtils.copyProperties(gnUserLogin, userLoginVo);
		GnUserLoginCriteria example = new GnUserLoginCriteria();
		Criteria criteria = example.createCriteria();
		criteria.andTenantIdEqualTo(userLoginVo.getTenantId());
		criteria.andUserIphoneEqualTo(userLoginVo.getUserIphone());
		return userLoginMapper.updateByExampleSelective(gnUserLogin, example );
	}

}
