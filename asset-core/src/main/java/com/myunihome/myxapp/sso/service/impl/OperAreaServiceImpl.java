package com.myunihome.myxapp.sso.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.paas.sequence.SeqUtil;
import com.myunihome.myxapp.paas.util.BeanUtils;
import com.myunihome.myxapp.paas.util.DateUtil;
import com.myunihome.myxapp.sso.constants.Constants.CreateType;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOperArea;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOperAreaCriteria;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOperAreaCriteria.Criteria;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;
import com.myunihome.myxapp.sso.dao.mapper.interfaces.GnOperAreaMapper;
import com.myunihome.myxapp.sso.model.operarea.OperAreaQueryParams;
import com.myunihome.myxapp.sso.service.IOperAreaService;
import com.myunihome.myxapp.sys.api.sysoperarea.param.GnOperAreaParamsVO;
import com.myunihome.myxapp.sys.api.sysoperarea.param.GnOperAreaVO;
import com.myunihome.myxapp.sys.util.DateTimeUtil;

import net.sf.json.JSONObject;

@Component
public class OperAreaServiceImpl implements IOperAreaService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OperAreaServiceImpl.class);
	private static final int PAGESIZE = 5;// 默认页面大小

	@Override
	public Integer addAreaToOper(GnOperArea gnOperArea) {
		LOGGER.info("insert operarea data begin..");
		// 设置对象默认值
		setOperAreaDefValues(gnOperArea);
		Integer i = MapperFactory.getGnOperAreaMapper().insertSelective(gnOperArea);
		if (i > 0) {
			Long operareaRelId = gnOperArea.getOperAreaRelId();
			LOGGER.info("insert operarea data success, the new operAreaRelId is " + operareaRelId);
		} else {
			LOGGER.error("insert operarea data failed");
		}
		return i;
	}

	/**
	 * 设置添加记录默认值
	 * @param gnOperArea
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private void setOperAreaDefValues(GnOperArea gnOperArea) {
		gnOperArea.setOperAreaRelId(SeqUtil.getNewId("RUNNER_SYS_OPER_AREA_PAYMENT$ID$SEQ"));
		Timestamp currTimestamp = DateTimeUtil.getCurrTimestamp();
		String currStartTimeStr = DateTimeUtil.timstamp2String(currTimestamp);
		Timestamp currData = DateTimeUtil.stringToTimstamp(2,currStartTimeStr);//时分秒为0
		gnOperArea.setCreateTime(currTimestamp);
		Timestamp activeTime = gnOperArea.getActiveTime();
		if(activeTime == null){
			gnOperArea.setActiveTime(currData);
		}
		Timestamp inactiveTime = gnOperArea.getInactiveTime();
		if(inactiveTime == null){
			inactiveTime = DateUtil.getTimestamp("2099-12-31");
			gnOperArea.setInactiveTime(inactiveTime);
		}
		String createType = gnOperArea.getCreateType();
		if(StringUtils.isEmpty(createType)){
			gnOperArea.setCreateType(CreateType.TYPE_CREATE);
		}
	}

	@Override
	public PageInfo<GnOperArea> queryAreaPageByOperId(GnOperAreaParamsVO operAreaParamsVO) {
		LOGGER.info("Pamater into queryAreaPageByOperId operAreaParamsVO:" + JSONObject.fromObject(operAreaParamsVO));
		PageInfo<GnOperArea> resultPage = new PageInfo<GnOperArea>();

		int count = 0;
		// 单页大小
		Integer pageSize = getPageSize(operAreaParamsVO);
		List<GnOperArea> gnOperAreaList = null;
		if (operAreaParamsVO != null) {
			GnOperAreaCriteria gnOperAreaCriteria = getQueryAreaByOperIdCriterria(operAreaParamsVO, pageSize);
			gnOperAreaList = MapperFactory.getGnOperAreaMapper().selectByExample(gnOperAreaCriteria);
			count = MapperFactory.getGnOperAreaMapper().countByExample(gnOperAreaCriteria);
		}
		if (gnOperAreaList != null) {
			resultPage.setCount(count);
			resultPage.setResult(gnOperAreaList);
			resultPage.setPageSize(pageSize);
		} else {
			resultPage = null;
		}

		return resultPage;
	}
	
	/**
	 * 获得通过操作员id获得拥有的区域查询条件
	 * @param operAreaParamsVO
	 * @param pageSize
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private GnOperAreaCriteria getQueryAreaByOperIdCriterria(GnOperAreaParamsVO operAreaParamsVO, Integer pageSize) {
		GnOperAreaCriteria gnOperAreaCriteria = new GnOperAreaCriteria();
		GnOperAreaCriteria.Criteria criteria = gnOperAreaCriteria.createCriteria();

		if (StringUtils.isNotEmpty(operAreaParamsVO.getTenantId())) {
			criteria.andTenantIdEqualTo(operAreaParamsVO.getTenantId());
		}
		if (operAreaParamsVO.getOperId() != null) {
			criteria.andOperIdEqualTo(operAreaParamsVO.getOperId());
		}
		Timestamp inactiveTime = operAreaParamsVO.getInactiveTime();
		if (inactiveTime != null) {
			criteria.andInactiveTimeGreaterThan(inactiveTime);
		}
		Timestamp activeTime = operAreaParamsVO.getActiveTime();
		if (activeTime != null) {
			criteria.andActiveTimeLessThanOrEqualTo(activeTime);
		}

		Integer pageNumber = operAreaParamsVO.getPageInfo().getPageNo();

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
		gnOperAreaCriteria.setLimitStart(startNum);
		gnOperAreaCriteria.setLimitEnd(endNum);
		gnOperAreaCriteria.setOrderByClause("CREATE_TIME desc,OPER_AREA_REL_ID desc");
		return gnOperAreaCriteria;
	}

	/**
	 * 获取页面大小
	 * @param operAreaParamsVO
	 * @return
	 */
	private Integer getPageSize(GnOperAreaParamsVO operAreaParamsVO) {
		Integer pageSize = null;
		if (operAreaParamsVO != null) {
			PageInfo<GnOperAreaVO> pageInfo = operAreaParamsVO.getPageInfo();
			if (pageInfo != null) {
				pageSize = pageInfo.getPageSize();
			}
		}
		if (pageSize == null) {
			pageSize = PAGESIZE;
		}
		return pageSize;
	}

	@Override
	public List<GnOperArea> queryAreaListByOperId(GnOperAreaParamsVO operAreaParamsVO) {
		LOGGER.info("Pamater into queryAreaListByOperId operAreaParamsVO:" + JSONObject.fromObject(operAreaParamsVO));
		GnOperAreaMapper gnOperAreaMapper = MapperFactory.getGnOperAreaMapper();
		// 获取操作员含有区域的sql条件
		GnOperAreaCriteria OperAreaCriteria = getQueryAreaListCriteria(operAreaParamsVO);
		return gnOperAreaMapper.selectByExample(OperAreaCriteria);
	}

	/**
	 * 获取操作员含有区域的sql条件
	 * @param operAreaParamsVO
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private GnOperAreaCriteria getQueryAreaListCriteria(GnOperAreaParamsVO operAreaParamsVO) {
		GnOperAreaCriteria operAreaCriteria = new GnOperAreaCriteria();
		operAreaCriteria.setOrderByClause("CREATE_TIME desc,OPER_AREA_REL_ID desc");
		Criteria criteria = operAreaCriteria.createCriteria();
		String tenantId = operAreaParamsVO.getTenantId();
		if (StringUtils.isNoneEmpty(tenantId)) {
			criteria.andTenantIdEqualTo(tenantId);
		}
		Long operId = operAreaParamsVO.getOperId();
		if (operId != null) {
			criteria.andOperIdEqualTo(operId);
		}
		Timestamp inactiveTime = operAreaParamsVO.getInactiveTime();
		if (inactiveTime != null) {
			criteria.andInactiveTimeGreaterThan(inactiveTime);
		}else{
			criteria.andInactiveTimeGreaterThan(DateUtil.getSysDate());
		}
		Timestamp activeTime = operAreaParamsVO.getActiveTime();
		if (activeTime != null) {
			criteria.andActiveTimeLessThanOrEqualTo(activeTime);
		}else{
			criteria.andActiveTimeLessThanOrEqualTo(DateUtil.getSysDate());
		}
		return operAreaCriteria;
	}

	@Override
	public Integer deleteOperArea(GnOperAreaParamsVO operAreaParamsVO) {
		LOGGER.info("Pamater into deleteOperArea operAreaParamsVO:" + JSONObject.fromObject(operAreaParamsVO));
		GnOperAreaCriteria operAreaCriteria = getDelOperAreaCriteria(operAreaParamsVO);
		GnOperArea gnOperArea = new GnOperArea();
		BeanUtils.copyProperties(gnOperArea, operAreaParamsVO);
		//设置失效日期为当前
		Timestamp currTimestamp = DateTimeUtil.getCurrTimestamp();
		String currStartTimeStr = DateTimeUtil.timstamp2String(currTimestamp);
		Timestamp inactiveTime = DateTimeUtil.stringToTimstamp(2,currStartTimeStr);
		gnOperArea.setInactiveTime(inactiveTime);
		GnOperAreaMapper gnOperAreaMapper = MapperFactory.getGnOperAreaMapper();
		return gnOperAreaMapper.updateByExampleSelective(gnOperArea, operAreaCriteria);
	}

	/**
	 * 删除操作员区域条件
	 * @param operAreaParamsVO
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private GnOperAreaCriteria getDelOperAreaCriteria(GnOperAreaParamsVO operAreaParamsVO) {
		GnOperAreaCriteria operAreaCriteria = new GnOperAreaCriteria();
		Criteria createCriteria = operAreaCriteria.createCriteria();
		String tenantId = operAreaParamsVO.getTenantId();
		if(StringUtils.isNotEmpty(tenantId)){
			createCriteria.andTenantIdEqualTo(tenantId);
		}
		Long operAreaRelId = operAreaParamsVO.getOperAreaRelId();
		if(operAreaRelId != null){
			createCriteria.andOperAreaRelIdEqualTo(operAreaRelId);
		}
		Long operId = operAreaParamsVO.getOperId();
		if(operId != null){
			createCriteria.andOperIdEqualTo(operId);
		}
		String creaCode = operAreaParamsVO.getAreaCode();
		if(StringUtils.isNotEmpty(creaCode)){
			createCriteria.andAreaCodeEqualTo(creaCode);
		}
		return operAreaCriteria;
	}

	@Override
	public List<GnOperArea> queryAreaListByParams(OperAreaQueryParams operAreaQueryParams) {
		GnOperAreaMapper gnOperAreaMapper = MapperFactory.getGnOperAreaMapper();
		GnOperAreaCriteria example = new GnOperAreaCriteria();
		Criteria criteria = example.createCriteria();
		String tenantId = operAreaQueryParams.getTenantId();
		if(StringUtils.isNotEmpty(tenantId)){
			criteria.andTenantIdEqualTo(tenantId);
		}
		String areaCode = operAreaQueryParams.getAreaCode();
		if(StringUtils.isNoneEmpty(areaCode)){
			criteria.andAreaCodeEqualTo(areaCode);
		}
		List<Long> operIdList = operAreaQueryParams.getOperIdList();
		if(operIdList != null && operIdList.size() >0){
			criteria.andOperIdIn(operIdList);
		}
		Timestamp activeTime = operAreaQueryParams.getActiveTime();
		if(activeTime != null){
			criteria.andActiveTimeLessThanOrEqualTo(activeTime);
		}
		Timestamp inactiveTime = operAreaQueryParams.getInactiveTime();
		if(inactiveTime != null){
			criteria.andInactiveTimeGreaterThan(inactiveTime);
		}
		return gnOperAreaMapper.selectByExample(example );
	}

}
