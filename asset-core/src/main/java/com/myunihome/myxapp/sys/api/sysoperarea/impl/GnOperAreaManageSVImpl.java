package com.myunihome.myxapp.sys.api.sysoperarea.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOperArea;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnStaffno;
import com.myunihome.myxapp.sso.model.operarea.OperAreaQueryParams;
import com.myunihome.myxapp.sso.service.IOperAreaService;
import com.myunihome.myxapp.sso.service.IOperService;
import com.myunihome.myxapp.sso.service.IStaffNoService;
import com.myunihome.myxapp.sys.api.sysoperarea.interfaces.IGnOperAreaManageSV;
import com.myunihome.myxapp.sys.api.sysoperarea.param.GnOperAreaParamsVO;
import com.myunihome.myxapp.sys.api.sysoperarea.param.GnOperAreaResponseVO;
import com.myunihome.myxapp.sys.api.sysoperarea.param.GnOperAreaVO;
import com.myunihome.myxapp.sys.api.sysoperarea.param.GnStaffAreaPageQueryVO;
import com.myunihome.myxapp.sys.api.sysoperarea.param.GnStaffAreaQueryVO;
import com.myunihome.myxapp.sys.api.sysoperarea.param.GnStaffOperVO;

@Service
@Component
public class GnOperAreaManageSVImpl implements IGnOperAreaManageSV {

	@Autowired
	private IOperAreaService operAreaService;

	@Autowired
	private IStaffNoService staffNoService;

	@Autowired
	private IOperService operService;

	@Override
	public GnOperAreaResponseVO addAreaToOper(GnOperAreaParamsVO operAreaParamsVO) throws CallerException {
		checkBefAddAreaToOper(operAreaParamsVO);
		GnOperArea gnOperArea = new GnOperArea();
		BeanUtils.copyProperties(gnOperArea, operAreaParamsVO);
		Integer result = operAreaService.addAreaToOper(gnOperArea);
		GnOperAreaResponseVO responseResults = new GnOperAreaResponseVO();
		if (result != null && result > 0) {
			responseResults.setResponseCode(ResponseState.SUCCESS);
			responseResults.setRespondeDesc("操作员区域添加成功！");
		} else {
			responseResults.setResponseCode(ResponseState.FAILED);
			responseResults.setRespondeDesc("操作员区域添加失败！");
		}
		return responseResults;
	}

	/**
	 * 添加操作员区域前检查
	 * 
	 * @param operAreaParamsVO
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private void checkBefAddAreaToOper(GnOperAreaParamsVO operAreaParamsVO) {
		String errorMsg = "";
		if (operAreaParamsVO == null) {
			errorMsg += "参数实体不能为空！";
		} else {
			if (StringUtils.isBlank(operAreaParamsVO.getTenantId())) {
				errorMsg += "租户id（tenantId）不能为空！";
			}
			if (operAreaParamsVO.getOperId() == null) {
				errorMsg += "操作员id（operId）不能为空！";
			}
			if (StringUtils.isBlank(operAreaParamsVO.getAreaCode())) {
				errorMsg += "区域编码（areaCode）不能为空！";
			}
		}
		if (!"".equals(errorMsg)) {
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
	}

	@Override
	public PageInfo<GnOperAreaVO> queryAreaPageByOperId(GnOperAreaParamsVO operAreaParamsVO) throws CallerException {
		checkBefQueryAreaPageByOperId(operAreaParamsVO);
		PageInfo<GnOperArea> pageInfo = operAreaService.queryAreaPageByOperId(operAreaParamsVO);
		PageInfo<GnOperAreaVO> resultPage = new PageInfo<GnOperAreaVO>();
		if (pageInfo != null) {
			resultPage.setPageNo(pageInfo.getPageNo());
			resultPage.setPageSize(pageInfo.getPageSize());
			resultPage.setCount(pageInfo.getCount());

			List<GnOperAreaVO> gnOperAreaVOList = new ArrayList<GnOperAreaVO>();
			if (!CollectionUtil.isEmpty(pageInfo.getResult())) {
				Gson gson = new Gson();
				gnOperAreaVOList = gson.fromJson(gson.toJson(pageInfo.getResult()), new TypeToken<List<GnOperAreaVO>>() {
				}.getType());
			}
			resultPage.setResult(gnOperAreaVOList);
		} else {
			resultPage = null;
		}
		return resultPage;
	}

	/**
	 * 查询操作员区域前检查
	 * 
	 * @param operAreaParamsVO
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private void checkBefQueryAreaPageByOperId(GnOperAreaParamsVO operAreaParamsVO) {
		String errorMsg = "";
		if (operAreaParamsVO == null) {
			errorMsg += "参数实体不能为空！";
		} else {
			if (StringUtils.isBlank(operAreaParamsVO.getTenantId())) {
				errorMsg += "租户id（tenantId）不能为空！";
			}
			Long operId = operAreaParamsVO.getOperId();
			if (operId == null) {
				errorMsg += "操作员id（operId）不能为空！";
			}
			PageInfo<GnOperAreaVO> pageInfo = operAreaParamsVO.getPageInfo();
			if (pageInfo == null) {
				errorMsg += "页面信息（pageInfo）不能为空！";
			} else {
				Integer pageNo = pageInfo.getPageNo();
				if (pageNo == null) {
					errorMsg += "当前页数（pageNo）不能为空！";
				}
			}
		}
		if (!"".equals(errorMsg)) {
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
	}

	@Override
	public List<GnOperAreaVO> queryAreaListByOperId(GnOperAreaParamsVO operAreaParamsVO) throws CallerException {
		checkBefQueryAreaListByOperId(operAreaParamsVO);
		List<GnOperArea> queryAreaPageByOperId = operAreaService.queryAreaListByOperId(operAreaParamsVO);
		Gson gson = new Gson();
		return gson.fromJson(gson.toJson(queryAreaPageByOperId), new TypeToken<List<GnOperAreaVO>>() {
		}.getType());
	}

	/**
	 * 查询操作员区域前检查
	 * 
	 * @param operAreaParamsVO
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private void checkBefQueryAreaListByOperId(GnOperAreaParamsVO operAreaParamsVO) {
		String errorMsg = "";
		if (operAreaParamsVO == null) {
			errorMsg += "参数实体不能为空！";
		} else {
			if (StringUtils.isBlank(operAreaParamsVO.getTenantId())) {
				errorMsg += "租户id（tenantId）不能为空！";
			}
			Long operId = operAreaParamsVO.getOperId();
			if (operId == null) {
				errorMsg += "操作员id（operId）不能为空！";
			}
		}
		if (!"".equals(errorMsg)) {
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
	}

	@Override
	public GnOperAreaResponseVO deleteOperArea(GnOperAreaParamsVO operAreaParamsVO) throws CallerException {
		checkBefDelperArea(operAreaParamsVO);
		Integer result = operAreaService.deleteOperArea(operAreaParamsVO);
		GnOperAreaResponseVO responseResults = new GnOperAreaResponseVO();
		if (result != null && result > 0) {
			responseResults.setResponseCode(ResponseState.SUCCESS);
			responseResults.setRespondeDesc("操作员区域删除成功！");
		} else {
			responseResults.setResponseCode(ResponseState.FAILED);
			responseResults.setRespondeDesc("操作员区域删除失败！");
		}
		return responseResults;
	}

	/**
	 * 删除操作员区域前检查
	 * 
	 * @param operAreaParamsVO
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private void checkBefDelperArea(GnOperAreaParamsVO operAreaParamsVO) {
		String errorMsg = "";
		if (operAreaParamsVO == null) {
			errorMsg += "参数实体不能为空！";
		} else {
			if (StringUtils.isBlank(operAreaParamsVO.getTenantId())) {
				errorMsg += "租户id（tenantId）不能为空！";
			}
			Long operAreaRelId = operAreaParamsVO.getOperAreaRelId();
			Long operId = operAreaParamsVO.getOperId();
			String areaCode = operAreaParamsVO.getAreaCode();
			if (operAreaRelId == null && operId == null && StringUtils.isEmpty(areaCode)) {
				errorMsg += "operAreaRelId、operId、areaCode 不能同时为空！";
			}
		}
		if (!"".equals(errorMsg)) {
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
	}

	/**
	 * 根据小区查询人员的服务
	 */
	@Override
	public List<GnStaffOperVO> queryStaffOperListByArea(GnStaffAreaQueryVO staffnoAreaQueryVO) throws CallerException {
		checkBefQueryStaffOperByArea(staffnoAreaQueryVO);
		List<GnStaffOperVO> staffOperList = null;

		List<GnOperArea> operAreaList = getOperAreaList(staffnoAreaQueryVO);
		if (operAreaList != null && operAreaList.size() > 0) {
			List<Long> operIdList = new LinkedList<Long>();
			for (GnOperArea operArea : operAreaList) {
				operIdList.add(operArea.getOperId());
			}
			String tenantId = staffnoAreaQueryVO.getTenantId();
			// 获得操作员信息集
			List<GnOper> operList = operService.queryOperListByOperIds(tenantId, operIdList);
			if (operList != null && operList.size() > 0) {
				List<Long> staffnoIdList = getstaffnoIdList(operList);
				// 获得员工工号信息集
				Map<Long, GnStaffno> staffnoMap = getStaffnoMap(tenantId, staffnoIdList);
				staffOperList = new LinkedList<GnStaffOperVO>();
				for (GnOper gnOper : operList) {
					GnStaffOperVO staffOperVO = new GnStaffOperVO();
					staffOperVO.setOrgType(gnOper.getOrgType());
					staffOperVO.setOrgId(gnOper.getOrgId());
					Long staffnoId = gnOper.getStaffnoId();
					GnStaffno gnStaffno = staffnoMap.get(staffnoId);
					staffOperVO.setStaffId(gnStaffno.getStaffId());
					staffOperVO.setStaffNo(gnStaffno.getStaffNo());
					staffOperVO.setStaffName(gnStaffno.getStaffName());
					staffOperList.add(staffOperVO);
				}
			}
		}
		return staffOperList;
	}

	private List<GnOperArea> getOperAreaList(GnStaffAreaQueryVO staffnoAreaQueryVO) {
		// 设置查询operarea表条件
		OperAreaQueryParams operAreaQueryParams = new OperAreaQueryParams();
		String tenantId = staffnoAreaQueryVO.getTenantId();
		operAreaQueryParams.setTenantId(tenantId);
		operAreaQueryParams.setAreaCode(staffnoAreaQueryVO.getAreaCode());
		// 只查有效数据
		Timestamp sysDate = DateUtil.getSysDate();
		operAreaQueryParams.setActiveTime(sysDate);
		operAreaQueryParams.setInactiveTime(sysDate);

		// 获得操作员区域对象集
		String staffNo = staffnoAreaQueryVO.getStaffNo();
		String staffName = staffnoAreaQueryVO.getStaffName();
		List<GnOperArea> operAreaList = null;
		if (StringUtils.isNoneEmpty(staffNo) || StringUtils.isNotEmpty(staffName)) {
			List<Long> operIdList = queryOperIdList(tenantId, staffNo, staffName);
			if (operIdList != null && operIdList.size() > 0) {
				operAreaQueryParams.setOperIdList(operIdList);
				operAreaList = operAreaService.queryAreaListByParams(operAreaQueryParams);
			}
		} else {
			operAreaList = operAreaService.queryAreaListByParams(operAreaQueryParams);
		}
		return operAreaList;
	}

	/**
	 * 获得员工工号映射对象 staffnoId为key
	 * 
	 * @param staffnoIdList
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private Map<Long, GnStaffno> getStaffnoMap(String tenantId, List<Long> staffnoIdList) {
		Map<Long, GnStaffno> staffnoMap = null;
		if (staffnoIdList != null && staffnoIdList.size() > 0) {
			List<GnStaffno> staffnoList = staffNoService.queryStaffnoList(tenantId, staffnoIdList);
			if (staffnoList != null && staffnoList.size() > 0) {
				staffnoMap = new HashMap<Long, GnStaffno>();
				for (GnStaffno gnStaffno : staffnoList) {
					staffnoMap.put(gnStaffno.getStaffnoId(), gnStaffno);
				}
			}
		}
		return staffnoMap;
	}

	/**
	 * 获得员工工号idList
	 * 
	 * @param operList
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private List<Long> getstaffnoIdList(List<GnOper> operList) {
		List<Long> staffnoIdList = null;
		if (operList != null && operList.size() > 0) {
			staffnoIdList = new LinkedList<Long>();
			for (GnOper gnOper : operList) {
				staffnoIdList.add(gnOper.getStaffnoId());
			}
		}
		return staffnoIdList;
	}

	/**
	 * 根据员工工号，员工姓名获得所有操作员Id
	 * 
	 * @param tenantId
	 * @param staffNo
	 * @param staffName
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private List<Long> queryOperIdList(String tenantId, String staffNo, String staffName) {
		List<Long> operIdList = null;
		GnStaffno gnStaffno = new GnStaffno();
		gnStaffno.setTenantId(tenantId);
		gnStaffno.setStaffNo(staffNo);
		gnStaffno.setStaffName(staffName);
		// 设置只查有效数据
		Timestamp sysDate = DateUtil.getSysDate();
		gnStaffno.setInactiveTime(sysDate);
		gnStaffno.setActiveTime(sysDate);
		gnStaffno.setState(RecordsState.STATE_NORMAL);
		// 获取员工list对象
		List<GnStaffno> staffnoList = staffNoService.queryStaffnoList(gnStaffno);
		if (staffnoList != null && staffnoList.size() > 0) {
			List<Long> staffnoIdList = getStaffnoIdList(staffnoList);
			if (staffnoIdList != null && staffnoIdList.size() > 0) {
				// 获得操作员List对象
				List<GnOper> gnOperList = operService.queryOperListByStaffnoIds(tenantId, staffnoIdList);
				if (gnOperList != null && gnOperList.size() > 0) {
					operIdList = new LinkedList<Long>();
					for (GnOper gnOper : gnOperList) {
						operIdList.add(gnOper.getOperId());
					}
				}
			}
		}
		return operIdList;
	}

	/**
	 * 获取工号id List
	 * 
	 * @param staffnoList
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private List<Long> getStaffnoIdList(List<GnStaffno> staffnoList) {
		List<Long> staffnoIdList = new LinkedList<Long>();
		if (staffnoList != null) {
			for (GnStaffno gnStaffno : staffnoList) {
				Long staffnoId = gnStaffno.getStaffnoId();
				staffnoIdList.add(staffnoId);
			}
		}
		return staffnoIdList;
	}

	/**
	 * 根据小区查询人员的服务前检查查询条件
	 * 
	 * @param staffnoAreaQueryVO
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private void checkBefQueryStaffOperByArea(GnStaffAreaQueryVO staffnoAreaQueryVO) {
		String errorMsg = "";
		if (staffnoAreaQueryVO == null) {
			errorMsg += "查询条件对象不能为空！";
		} else {
			if (StringUtils.isEmpty(staffnoAreaQueryVO.getTenantId())) {
				errorMsg += "租户id（tenantId）不能为空！";
			}
			if (StringUtils.isEmpty(staffnoAreaQueryVO.getAreaCode())) {
				errorMsg += "区域编码（areaCode）不能为空！";
			}
		}
		if (StringUtils.isNotEmpty(errorMsg)) {
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
	}

	@Override
	public PageInfo<GnStaffOperVO> queryStaffOperPageInfoByArea(GnStaffAreaPageQueryVO staffnoAreaPageQueryVO) throws CallerException {
		checkBefQueryStaffOperPageInfoByArea(staffnoAreaPageQueryVO);
		PageInfo<GnStaffOperVO> staffOperPageInfo = new PageInfo<GnStaffOperVO>();
		Integer operCount = 0;
		Integer pageNumber = staffnoAreaPageQueryVO.getPageNo();
		Integer pageSize = staffnoAreaPageQueryVO.getPageSize();
		List<GnStaffOperVO> staffOperList = new LinkedList<GnStaffOperVO>();
		
		List<GnOperArea> operAreaList = getOperAreaList(staffnoAreaPageQueryVO);
		if (operAreaList != null && operAreaList.size() > 0) {
			List<Long> operIdList = new LinkedList<Long>();
			for (GnOperArea operArea : operAreaList) {
				operIdList.add(operArea.getOperId());
			}
			// 分页计算出分页的开始条数和结束条数
			int startNum = 0;
			int endNum = 0;
			if (pageNumber <= 0 || pageSize <= 0) {
				startNum = 0;
				endNum = 0;
			} else {
				startNum = (pageNumber * pageSize - pageSize);
				if (startNum < 0) {
					startNum = 0;
				}
				endNum = pageSize;
				if (endNum < 0) {
					endNum = 0;
				}
			}
			// 获得操作员信息集
			String tenantId = staffnoAreaPageQueryVO.getTenantId();
			operCount = operService.queryCountByOperIds(tenantId, operIdList);
			staffOperPageInfo.setCount(operCount);
			List<GnOper> operList = operService.queryOperListByOperIds(tenantId, operIdList, startNum, endNum);
			if (operList != null && operList.size() > 0) {
				List<Long> staffnoIdList = getstaffnoIdList(operList);
				// 获得员工工号信息集
				Map<Long, GnStaffno> staffnoMap = getStaffnoMap(tenantId, staffnoIdList);
				for (GnOper gnOper : operList) {
					GnStaffOperVO staffOperVO = new GnStaffOperVO();
					staffOperVO.setOrgType(gnOper.getOrgType());
					staffOperVO.setOrgId(gnOper.getOrgId());
					Long staffnoId = gnOper.getStaffnoId();
					GnStaffno gnStaffno = staffnoMap.get(staffnoId);
					staffOperVO.setStaffId(gnStaffno.getStaffId());
					staffOperVO.setStaffNo(gnStaffno.getStaffNo());
					staffOperVO.setStaffName(gnStaffno.getStaffName());
					staffOperList.add(staffOperVO);
				}
				staffOperPageInfo.setResult(staffOperList);
			}
		}
		staffOperPageInfo.setCount(operCount);
		staffOperPageInfo.setPageNo(pageNumber);
		staffOperPageInfo.setPageSize(pageSize);
		staffOperPageInfo.setResult(staffOperList);
		return staffOperPageInfo;
	}

	/**
	 * 获得操作员区域集合
	 * 
	 * @param staffnoAreaPageQueryVO
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private List<GnOperArea> getOperAreaList(GnStaffAreaPageQueryVO staffnoAreaPageQueryVO) {
		// 设置查询operarea表条件
		OperAreaQueryParams operAreaQueryParams = new OperAreaQueryParams();
		String tenantId = staffnoAreaPageQueryVO.getTenantId();
		operAreaQueryParams.setTenantId(tenantId);
		operAreaQueryParams.setAreaCode(staffnoAreaPageQueryVO.getAreaCode());
		// 只查有效数据
		Timestamp sysDate = DateUtil.getSysDate();
		operAreaQueryParams.setActiveTime(sysDate);
		operAreaQueryParams.setInactiveTime(sysDate);

		// 获得操作员区域对象集
		String staffNo = staffnoAreaPageQueryVO.getStaffNo();
		String staffName = staffnoAreaPageQueryVO.getStaffName();
		List<GnOperArea> operAreaList = null;
		if (StringUtils.isNoneEmpty(staffNo) || StringUtils.isNotEmpty(staffName)) {
			List<Long> operIdList = queryOperIdList(tenantId, staffNo, staffName);
			if (operIdList != null && operIdList.size() > 0) {
				operAreaQueryParams.setOperIdList(operIdList);
				operAreaList = operAreaService.queryAreaListByParams(operAreaQueryParams);
			}
		} else {
			operAreaList = operAreaService.queryAreaListByParams(operAreaQueryParams);
		}
		return operAreaList;
	}

	/**
	 * 根据区域查询员工 查询前检查
	 * 
	 * @param staffnoAreaPageQueryVO
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private void checkBefQueryStaffOperPageInfoByArea(GnStaffAreaPageQueryVO staffnoAreaPageQueryVO) {
		String errorMsg = "";
		if (staffnoAreaPageQueryVO == null) {
			errorMsg += "查询条件对象不能为空！";
		} else {
			if (StringUtils.isEmpty(staffnoAreaPageQueryVO.getTenantId())) {
				errorMsg += "租户id（tenantId）不能为空！";
			}
			if (StringUtils.isEmpty(staffnoAreaPageQueryVO.getAreaCode())) {
				errorMsg += "区域编码（areaCode）不能为空！";
			}
			if (staffnoAreaPageQueryVO.getPageNo() == null) {
				errorMsg += "当前页数（pageNo）不能为空！";
			}
			if (staffnoAreaPageQueryVO.getPageSize() == null) {
				errorMsg += "当前页数（pageSize）不能为空！";
			}
		}
		if (StringUtils.isNotEmpty(errorMsg)) {
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMsg);
		}
	}

}
