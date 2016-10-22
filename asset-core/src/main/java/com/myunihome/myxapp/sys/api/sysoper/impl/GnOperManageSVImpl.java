package com.myunihome.myxapp.sys.api.sysoper.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.common.utils.StringUtils;
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
import com.myunihome.myxapp.sso.service.impl.OperServiceImpl;
import com.myunihome.myxapp.sys.api.sysoper.interfaces.IGnOperManageSV;
import com.myunihome.myxapp.sys.api.sysoper.param.GnOperParamsVO;
import com.myunihome.myxapp.sys.api.sysoper.param.GnOperResponseVO;
import com.myunihome.myxapp.sys.api.sysoper.param.GnOperStaffQueryVO;
import com.myunihome.myxapp.sys.api.sysoper.param.GnOperVO;

import net.sf.json.JSONObject;

@Service
@Component
public class GnOperManageSVImpl implements IGnOperManageSV {

	private static final Logger LOGGER = LoggerFactory.getLogger(OperServiceImpl.class);

	@Autowired
	IOperService operService;
	
	@Autowired
	IStaffNoService staffNoService;

	@Override
	public Long addOper(GnOperParamsVO operParamsVO) throws CallerException {
		LOGGER.info("操作员信息创建服务addOper方法参数列表：" + JSONObject.fromObject(operParamsVO));
		Long operId = null;
		if (operParamsVO != null) {
			String msg = "";
			if (StringUtils.isEmpty(operParamsVO.getTenantId())) {
				msg += "tenantId不能为空！";
			}
			if (StringUtils.isEmpty(operParamsVO.getOperCode())) {
				msg += "operCode不能为空！";
			}
			if (operParamsVO.getStaffnoId() == null) {
				msg += "staffnoId不能为空！";
			}
			if (StringUtils.isEmpty(operParamsVO.getOrgId())) {
				msg += "orgId不能为空！";
			}
			if (StringUtils.isEmpty(operParamsVO.getOrgType())) {
				msg += "orgTye不能为空！";
			}
			if (StringUtils.isEmpty(operParamsVO.getState())) {
				msg += "state不能为空！";
			}
			if ("".equals(msg)) {
				GnOper gnOper = new GnOper();
				BeanUtils.copyProperties(gnOper, operParamsVO);
				operId = operService.addOper(gnOper);
			} else {
				LOGGER.error(msg);
				throw new CallerException(ErrorCode.PARAM_NULL_ERROR, msg);
			}
		}
		return operId;
	}

	@Override
	public GnOperResponseVO updateOper(GnOperParamsVO operParamsVO) throws CallerException {
		LOGGER.info("操作员信息更新服务updateOper方法参数列表：" + JSONObject.fromObject(operParamsVO));
		Integer result = null;
		String msg = "";
		if (operParamsVO != null) {
			if (operParamsVO.getOperId() == null) {
				msg += "operId不能为空！";
			}
			if (StringUtils.isEmpty(operParamsVO.getTenantId())) {
				msg += "tenantId不能为空！";
			}
			if ("".equals(msg)) {
				GnOper gnOper = new GnOper();
				BeanUtils.copyProperties(gnOper, operParamsVO);
				result = operService.updateOper(gnOper);
			} else {
				LOGGER.error(msg);
				throw new CallerException(ErrorCode.PARAM_NULL_ERROR, msg);
			}

		}
		return getResopnsResults(result, "操作员信息更新成功！", "操作员信息更新失败:" + msg);
	}

	@Override
	public GnOperResponseVO delOperByID(GnOperParamsVO operParamsVO) throws CallerException {
		LOGGER.info("操作员信息删除服务delOperByID方法参数列表：" + JSONObject.fromObject(operParamsVO));
		Integer result = null;
		String errorMsg = "";
		if (operParamsVO != null) {
			if (operParamsVO.getOperId() == null) {
				errorMsg += "operId不能为空！";
			}
			if (StringUtils.isEmpty(operParamsVO.getTenantId())) {
				errorMsg += "tenantId不能为空！";
			}
			if ("".equals(errorMsg)) {
				GnOper gnOper = new GnOper();
				BeanUtils.copyProperties(gnOper, operParamsVO);
				result = operService.delOperByID(gnOper);
			} else {
				LOGGER.error(errorMsg);
				throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
			}
		}
		return getResopnsResults(result, "操作员信息删除成功！", "操作员信息删除失败:" + errorMsg);
	}

	/**
	 * 根据结果返回结果集对象
	 * 
	 * @param result
	 * @param successMsg
	 * @param errorMsg
	 * @return
	 */
	private GnOperResponseVO getResopnsResults(Integer result, String successMsg, String errorMsg) {
		GnOperResponseVO responseResults = new GnOperResponseVO();
		if (result != null && result > 0) {
			responseResults.setResponseCode(ResponseState.SUCCESS);
			responseResults.setRespondeDesc(successMsg);
		} else {
			responseResults.setResponseCode(ResponseState.FAILED);
			responseResults.setRespondeDesc(errorMsg);
		}
		return responseResults;
	}

	@Override
	public GnOperVO queryOperById(GnOperParamsVO operParamsVO) throws CallerException {
		LOGGER.info("根据操作员ID获取操作信息服务OperById方法参数列表：" + JSONObject.fromObject(operParamsVO));
		String msg = null;
		GnOper gnOper = null;
		if (operParamsVO != null) {
			if (operParamsVO.getOperId() == null) {
				msg = "getOperId不能为空！";
			} else if (StringUtils.isEmpty(operParamsVO.getTenantId())) {
				msg = "tenantId不能为空！";
			} else {
				GnOper param = new GnOper();
				BeanUtils.copyProperties(param, operParamsVO);
				// param.setState(RecordsState.STATE_NORMAL);
				gnOper = operService.queryOperById(param);
			}
			if (msg != null) {
				LOGGER.error(msg);
				throw new CallerException(ErrorCode.PARAM_NULL_ERROR, msg);
			}
		}
		GnOperVO gnOperVO = new GnOperVO();
		if (gnOper != null) {
			BeanUtils.copyProperties(gnOperVO, gnOper);
		} else {
			gnOperVO = null;
		}
		return gnOperVO;
	}

	@Override
	public PageInfo<GnOperVO> queryOperPageInfo(GnOperParamsVO operParamsVO) throws CallerException {
		checkBefQueryOperPageInfo(operParamsVO);
		PageInfo<GnOper> pageInfo = operService.queryOperPageInfo(operParamsVO);
		
		PageInfo<GnOperVO> resultPage = new PageInfo<GnOperVO>();
		if (pageInfo != null) {
			resultPage.setPageNo(pageInfo.getPageNo());
			resultPage.setPageSize(pageInfo.getPageSize());
			resultPage.setCount(pageInfo.getCount());

			List<GnOperVO> gnOperVOList = new ArrayList<GnOperVO>();
			if (!CollectionUtil.isEmpty(pageInfo.getResult())) {
				Gson gson = new Gson();
				gnOperVOList = gson.fromJson(gson.toJson(pageInfo.getResult()), new TypeToken<List<GnOperVO>>() {
				}.getType());
			}
			resultPage.setResult(gnOperVOList);
		} else {
			resultPage = null;
		}
		return resultPage;
	}
	
	/**
	 * 查询操作员区域前检查
	 * @param operParamsVO
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private void checkBefQueryOperPageInfo(GnOperParamsVO operParamsVO) {
		String errorMsg = "";
		if(operParamsVO == null){
			errorMsg += "参数实体不能为空！";
		}else{
			if(StringUtils.isBlank(operParamsVO.getTenantId())){
				errorMsg += "租户id（tenantId）不能为空！";
			}
			PageInfo<GnOperVO> pageInfo = operParamsVO.getPageInfo();
			if(pageInfo == null){
				errorMsg += "页面信息（pageInfo）不能为空！";
			}else{
				Integer pageNo = pageInfo.getPageNo();
				if(pageNo == null){
					errorMsg += "当前页数（pageNo）不能为空！";
				}
			}
		}
		if(!"".equals(errorMsg)){
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
	}

	@Override
	public List<GnOperVO> queryOperListByStaff(GnOperStaffQueryVO staffQueryVO) throws CallerException {
		checkBefQueryOperListByStaff(staffQueryVO);
		List<GnOperVO> gnOperVoList = null;
		GnStaffno gnStaffno = new GnStaffno();
		BeanUtils.copyProperties(gnStaffno, staffQueryVO);
		//设置只查有效数据
		Timestamp sysDate = DateUtil.getSysDate();
		gnStaffno.setInactiveTime(sysDate);
		gnStaffno.setActiveTime(sysDate);
		gnStaffno.setState(RecordsState.STATE_NORMAL);
		//获取员工list对象
		List<GnStaffno> staffnoList = staffNoService.queryStaffnoList(gnStaffno );
		if(staffnoList != null && staffnoList.size()>0){
			List<Long> staffnoIdList = getStaffnoIdList(staffnoList);
			if(staffnoIdList != null && staffnoIdList.size()>0){
				//获得操作员List对象
				List<GnOper>  operList = operService.queryOperListByStaffnoIds(staffQueryVO.getTenantId(), staffnoIdList);
				if(operList !=null && operList.size()>0){
					gnOperVoList = new LinkedList<GnOperVO>();
					for(GnOper gnOper : operList){
						GnOperVO gnOperVO = new GnOperVO();
						BeanUtils.copyProperties(gnOperVO, gnOper);
						gnOperVoList.add(gnOperVO);
					}
				}
			}
		}
		return gnOperVoList;
	}

	private List<Long> getStaffnoIdList(List<GnStaffno> staffnoList) {
		List<Long> staffnoIdList = new LinkedList<Long>();
		if(staffnoList != null){
			for(GnStaffno gnStaffno : staffnoList){
				Long staffnoId = gnStaffno.getStaffnoId();
				staffnoIdList.add(staffnoId);
			}
		}
		return staffnoIdList;
	}

	/**
	 * 通过员工相关信息查询操作员列表
	 * @param staffQueryVO
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private void checkBefQueryOperListByStaff(GnOperStaffQueryVO staffQueryVO) {
		String errorMsg = "";
		if(staffQueryVO == null){
			errorMsg += "查询参数对象不能为空！";
		}else {
			if(StringUtils.isEmpty(staffQueryVO.getTenantId())){
				errorMsg +="租户id（tenantId）不能为空！";
			}
			if(StringUtils.isEmpty(staffQueryVO.getStaffName())){
				errorMsg +="员工名称（staffName）不能为空！";
			}
		}
		if(StringUtils.isNotEmpty(errorMsg)){
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
	}


}
