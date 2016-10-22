package com.myunihome.myxapp.sys.api.sysstaffno.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.paas.util.BeanUtils;
import com.myunihome.myxapp.paas.util.CollectionUtil;
import com.myunihome.myxapp.paas.util.DateUtil;
import com.myunihome.myxapp.sso.constants.Constants.ErrorCode;
import com.myunihome.myxapp.sso.constants.Constants.RecordsState;
import com.myunihome.myxapp.sso.constants.Constants.ResponseState;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOper;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnStaffno;
import com.myunihome.myxapp.sso.service.IOperService;
import com.myunihome.myxapp.sso.service.IStaffNoService;
import com.myunihome.myxapp.sys.api.sysstaffno.interfaces.IGnStaffNoManageSV;
import com.myunihome.myxapp.sys.api.sysstaffno.param.GnStaffNoParamsVO;
import com.myunihome.myxapp.sys.api.sysstaffno.param.GnStaffNoPasswdVO;
import com.myunihome.myxapp.sys.api.sysstaffno.param.GnStaffNoResponseVO;
import com.myunihome.myxapp.sys.api.sysstaffno.param.GnStaffNoVO;
import com.myunihome.myxapp.sys.util.DateTimeUtil;

import net.sf.json.JSONObject;

@Service
@Component
public class GnStaffNoManageSVImpl implements IGnStaffNoManageSV {

	private static final Logger LOGGER = LoggerFactory.getLogger(GnStaffNoManageSVImpl.class);

	@Autowired
	IStaffNoService staffNoService;

	@Autowired
	IOperService operService;

	@Override
	public Long addStaffNo(GnStaffNoParamsVO staffNoParamsVO) throws CallerException {
		LOGGER.info("工号创建服务addStaffNo方法参数列表：" + JSONObject.fromObject(staffNoParamsVO));

		String msg = null;
		Long staffNoId = null;
		if (staffNoParamsVO != null) {
			if (StringUtils.isEmpty(staffNoParamsVO.getTenantId())) {
				msg = "租户编码[tenantId]不能为空！";
			} else if (staffNoParamsVO.getStaffId() == null) {
				msg = "员工id[staffId]不能为空！";
			} else if (StringUtils.isEmpty(staffNoParamsVO.getStaffNo())) {
				msg = "员工工号[staffNo]不能为空！";
			} else if (StringUtils.isEmpty(staffNoParamsVO.getStaffPasswd())) {
				msg = "工号密码[staffPasswd]不能为空！";
			} else {
				GnStaffno gnStaffno = new GnStaffno();
				BeanUtils.copyProperties(gnStaffno, staffNoParamsVO);
				staffNoId = staffNoService.addStaffNo(gnStaffno);
			}
			if (msg != null) {
				LOGGER.error(msg);
				throw new CallerException(ErrorCode.PARAM_NULL_ERROR, msg);
			}
		}

		return staffNoId;
	}

	@Override
	public GnStaffNoResponseVO updateStaffNo(GnStaffNoParamsVO staffNoParamsVO) throws CallerException {
		LOGGER.info("工号更新服务updateStaffNo方法参数列表：" + JSONObject.fromObject(staffNoParamsVO));

		String msg = null;
		Integer index = null;
		if (staffNoParamsVO != null) {
			GnStaffno gnStaffno = new GnStaffno();
			BeanUtils.copyProperties(gnStaffno, staffNoParamsVO);
			if (StringUtils.isEmpty(gnStaffno.getTenantId())) {
				msg = "租户编码[tenantId]不能为空！";
			} else if (gnStaffno.getStaffnoId() == null) {
				msg = "工号ID[staffnoId]不能为空！";
			} else {
				index = staffNoService.updateStaffNo(gnStaffno);
			}
			if (msg != null) {
				LOGGER.error(msg);
				throw new CallerException(ErrorCode.PARAM_NULL_ERROR, msg);
			}
		}
		GnStaffNoResponseVO responseResults = new GnStaffNoResponseVO();
		if (index != null && index > 0) {
			responseResults.setResponseCode(ResponseState.SUCCESS);
			responseResults.setRespondeDesc("工号更新成功！");
		} else {
			responseResults.setResponseCode(ResponseState.FAILED);
			responseResults.setRespondeDesc("工号更新失败！" + msg);
		}
		return responseResults;
	}

	@Override
	public GnStaffNoResponseVO delStaffNoByID(GnStaffNoParamsVO staffNoParamsVO) throws CallerException {
		LOGGER.info("工号删除服务delStaffNoByID方法参数列表：" + JSONObject.fromObject(staffNoParamsVO));

		String msg = null;
		Integer index = null;
		if (staffNoParamsVO != null) {
			GnStaffno gnStaffno = new GnStaffno();
			BeanUtils.copyProperties(gnStaffno, staffNoParamsVO);
			if (StringUtils.isEmpty(gnStaffno.getTenantId())) {
				msg = "租户编码[tenantId]不能为空！";
			} else if (gnStaffno.getStaffnoId() == null) {
				msg = "工号ID[staffnoId]不能为空！";
			} else {
				index = staffNoService.delStaffNoByStaffNoId(gnStaffno);
				// 注销对应的操作员
				if (index != null && index > 0) {
					GnOper gnOper = new GnOper();
					gnOper.setTenantId(staffNoParamsVO.getTenantId());
					gnOper.setStaffnoId(staffNoParamsVO.getStaffnoId());
					operService.delOperByStaffNoID(gnOper);
				}
			}
			if (msg != null) {
				LOGGER.error(msg);
				throw new CallerException(ErrorCode.PARAM_NULL_ERROR, msg);
			}
		}

		GnStaffNoResponseVO responseResults = new GnStaffNoResponseVO();
		if (index != null && index > 0) {
			responseResults.setResponseCode(ResponseState.SUCCESS);
			responseResults.setRespondeDesc("工号删除成功！");
		} else {
			responseResults.setResponseCode(ResponseState.FAILED);
			responseResults.setRespondeDesc("工号删除失败！" + msg);
		}
		return responseResults;
	}

	@Override
	public GnStaffNoVO queryStaffNoById(GnStaffNoParamsVO staffNoParamsVO) throws CallerException {
		LOGGER.info("根据员工号ID获取工号信息服务queryStaffNoById方法参数列表：" + JSONObject.fromObject(staffNoParamsVO));
		String msg = null;
		GnStaffno gnStaffno = null;
		if (staffNoParamsVO != null) {
			if (staffNoParamsVO.getStaffnoId() == null) {
				msg = "staffnoId不能为空！";
			} else if (StringUtils.isEmpty(staffNoParamsVO.getTenantId())) {
				msg = "tenantId不能为空！";
			} else {
				GnStaffno param = new GnStaffno();
				BeanUtils.copyProperties(param, staffNoParamsVO);
				// param.setInactiveTime(DateTimeUtil.getCurrTimestamp());
				// param.setState(RecordsState.STATE_NORMAL);
				gnStaffno = staffNoService.queryStaffNoByStaffNoId(param);
			}
			if (msg != null) {
				LOGGER.error(msg);
				throw new CallerException(ErrorCode.PARAM_NULL_ERROR, msg);
			}
		}
		GnStaffNoVO gnStaffNoVO = new GnStaffNoVO();
		if (gnStaffno != null) {
			BeanUtils.copyProperties(gnStaffNoVO, gnStaffno);
		} else {
			gnStaffNoVO = null;
		}
		return gnStaffNoVO;
	}

	@Override
	public PageInfo<GnStaffNoVO> queryStaffNo(GnStaffNoParamsVO staffNoParamsVO) throws CallerException {
		LOGGER.info("根据查询条件获取工号列表服务queryStaffNo方法参数列表：" + JSONObject.fromObject(staffNoParamsVO));

		PageInfo<GnStaffno> pageInfo = null;
		if (staffNoParamsVO != null) {
			if (StringUtils.isEmpty(staffNoParamsVO.getTenantId())) {
				LOGGER.error("tenantId不能为空！");
				throw new CallerException(ErrorCode.PARAM_NULL_ERROR, "tenantId不能为空！");
			} else {
				pageInfo = staffNoService.queryStaffNo(staffNoParamsVO);
			}
		}
		PageInfo<GnStaffNoVO> resultPage = new PageInfo<GnStaffNoVO>();
		if (pageInfo != null) {
			resultPage.setPageNo(pageInfo.getPageNo());
			resultPage.setPageSize(pageInfo.getPageSize());
			resultPage.setCount(pageInfo.getCount());

			List<GnStaffNoVO> gnStaffNoVO = new ArrayList<GnStaffNoVO>();
			if (!CollectionUtil.isEmpty(pageInfo.getResult())) {
				Gson gson = new Gson();
				gnStaffNoVO = gson.fromJson(gson.toJson(pageInfo.getResult()), new TypeToken<List<GnStaffNoVO>>() {
				}.getType());
			}
			resultPage.setResult(gnStaffNoVO);
		}

		return resultPage;
	}

	@Override
	public Boolean isStaffNoUnique(GnStaffNoParamsVO staffNoParamsVO) throws CallerException {
		LOGGER.info("员工工号唯一性校验服务isStaffNoUnique方法参数列表：" + JSONObject.fromObject(staffNoParamsVO));

		Boolean flag = true; // TRUE 唯一，FALSE 不唯一

		if (staffNoParamsVO != null) {

			if (StringUtils.isEmpty(staffNoParamsVO.getTenantId())) {
				LOGGER.error("租户编码[tenantId]不能为空！");
				throw new CallerException(ErrorCode.PARAM_NULL_ERROR, "租户编码[tenantId]不能为空！");
			} else if (StringUtils.isEmpty(staffNoParamsVO.getStaffNo())) {
				LOGGER.error("员工工号[staffNo]为空！");
				throw new CallerException(ErrorCode.PARAM_NULL_ERROR, "员工工号[staffNo]为空！");
			} else {
				GnStaffno param = new GnStaffno();
				param.setTenantId(staffNoParamsVO.getTenantId());
				param.setStaffNo(staffNoParamsVO.getStaffNo());
				param.setStaffnoId(staffNoParamsVO.getStaffnoId());
				param.setState(RecordsState.STATE_NORMAL);
				param.setInactiveTime(DateTimeUtil.getCurrTimestamp());
				Integer count = staffNoService.countStaffNoExceptSelf(param);
				if (count > 0) {
					flag = false;
				} else {
					flag = true;
				}
				// Integer count = staffNoService.countByStaffNo(param);
				//
				// if (count != null) {
				// if (count > 1) {
				// flag = false;// 数据库里多于一条，重复
				// } else if (count == 1) {
				// Long staffnoId = staffNoParamsVO.getStaffnoId();
				// if (staffnoId == null) {// 新增操作时
				// flag = false;
				// } else {// 更新操作时
				// param.setStaffNo(null);
				// param.setStaffnoId(staffnoId);
				// GnStaffno gnStaffno =
				// staffNoService.queryStaffNoByStaffNoId(param);
				// if (gnStaffno != null &&
				// staffNoParamsVO.getStaffNo().equals(gnStaffno.getStaffNo()))
				// {
				// flag = true;// 数据库里只有一条且属于更新操作，不重复
				// } else {
				// flag = false;// 数据库里只有一条且不属于更新操作，重复
				// }
				// }
				// } else {
				// flag = true;// 数据库里只少于一条，不重复
				// }
				// }
			}

		}

		return flag;
	}

	@Override
	public GnStaffNoResponseVO resetStaffPassword(GnStaffNoPasswdVO staffNoPasswdVO) throws CallerException {
		checkResetStaffNoPasswdParams(staffNoPasswdVO);
		Integer result = staffNoService.resetStaffPassword(staffNoPasswdVO);
		GnStaffNoResponseVO staffNoResponseVO = new GnStaffNoResponseVO();
		if (result > 0) {
			staffNoResponseVO.setResponseCode(ResponseState.SUCCESS);
			staffNoResponseVO.setRespondeDesc("密码重置成功！");
		} else if (result == 0) {
			staffNoResponseVO.setResponseCode(ResponseState.FAILED);
			staffNoResponseVO.setRespondeDesc("账号错误！");
		} else {
			staffNoResponseVO.setResponseCode(ResponseState.FAILED);
			staffNoResponseVO.setRespondeDesc("密码重置失败！");
		}
		return staffNoResponseVO;
	}

	/**
	 * 检查重置密码参数
	 * 
	 * @param staffNoPasswdVO
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private void checkResetStaffNoPasswdParams(GnStaffNoPasswdVO staffNoPasswdVO) {
		String errorMsg = "";
		if (staffNoPasswdVO == null) {
			errorMsg += "条件参数不能为空！";
		} else {
			if (StringUtils.isEmpty(staffNoPasswdVO.getTenantId())) {
				errorMsg += "租户id（tenantId）不能为空！";
			}
			if (StringUtils.isEmpty(staffNoPasswdVO.getStaffNo())) {
				errorMsg += "员工工号（saffNo）不能为空！";
			}
		}
		if (StringUtils.isNotEmpty(errorMsg)) {
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
	}

	@Override
	public List<GnStaffNoVO> queryStaffNoList(GnStaffNoParamsVO staffNoParamsVO) throws CallerException {
		checkBefQueryStaffNoList(staffNoParamsVO);
		List<GnStaffNoVO> gnstaffnoList = null;
		GnStaffno gnStaffnoParams = new GnStaffno();
		BeanUtils.copyProperties(gnStaffnoParams, staffNoParamsVO);
		// 设置只查有效数据
		Timestamp sysDate = DateUtil.getSysDate();
		gnStaffnoParams.setInactiveTime(sysDate);
		gnStaffnoParams.setActiveTime(sysDate);
		gnStaffnoParams.setState(RecordsState.STATE_NORMAL);
		// 获取员工list对象
		List<GnStaffno> staffnoList = staffNoService.queryStaffnoList(gnStaffnoParams);
		if(staffnoList != null && staffnoList.size()>0){
			gnstaffnoList = new LinkedList<GnStaffNoVO>();
			for(GnStaffno gnStaffno : staffnoList){
				GnStaffNoVO gnStaffNoVO = new GnStaffNoVO();
				BeanUtils.copyProperties(gnStaffNoVO, gnStaffno);
				gnstaffnoList.add(gnStaffNoVO);
			}
		}
		return gnstaffnoList;
	}

	/**
	 * 通过员工相关信息查询操作员列表
	 * 
	 * @param staffNoParamsVO
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private void checkBefQueryStaffNoList(GnStaffNoParamsVO staffNoParamsVO) {
		String errorMsg = "";
		if (staffNoParamsVO == null) {
			errorMsg += "查询参数对象不能为空！";
		} else {
			if (StringUtils.isEmpty(staffNoParamsVO.getTenantId())) {
				errorMsg += "租户id（tenantId）不能为空！";
			}
		}
		if (StringUtils.isNotEmpty(errorMsg)) {
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
	}

}
