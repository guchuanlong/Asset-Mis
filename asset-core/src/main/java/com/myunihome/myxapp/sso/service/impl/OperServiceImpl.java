package com.myunihome.myxapp.sso.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.paas.sequence.SeqUtil;
import com.myunihome.myxapp.paas.util.BeanUtils;
import com.myunihome.myxapp.sso.api.oper.param.OperatorVo;
import com.myunihome.myxapp.sso.constants.Constants.RecordsState;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOper;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOperCriteria;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOperCriteria.Criteria;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;
import com.myunihome.myxapp.sso.dao.mapper.interfaces.GnOperMapper;
import com.myunihome.myxapp.sso.service.IOperService;
import com.myunihome.myxapp.sys.api.sysoper.param.GnOperParamsVO;
import com.myunihome.myxapp.sys.api.sysoper.param.GnOperVO;
import com.myunihome.myxapp.sys.util.DateTimeUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 操作员服务
 * 
 * @author Becky
 *
 */
@Component
public class OperServiceImpl implements IOperService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OperServiceImpl.class);
	
	private static final int PAGESIZE = 5;// 默认页面大小

	@Override
	public List<OperatorVo> checkOperInfoByStaffno(Long staffNoid, String tenantId) {
		String message = "Parameters into checkStaffInfoBystaffno : staffNoid = " + staffNoid + "tenantId = " + tenantId;
		LOGGER.info(message);
		List<OperatorVo> operVos = null;
		if (StringUtils.isNotEmpty(tenantId)) {
			operVos = getOperInfoByStaffno(staffNoid, tenantId, RecordsState.STATE_NORMAL);
		}
		if (operVos != null && operVos.size() > 0) {
			JSONArray returnVo = JSONArray.fromObject(operVos);
			message = "Result from checkStaffInfoBystaffno :" + returnVo.toString();
			LOGGER.info(message);
		} else {
			message = "Result from checkStaffInfoBystaffno : staffNoid " + staffNoid + " not exist.";
			LOGGER.info(message);
		}
		return operVos;
	}

	@Override
	public List<OperatorVo> checkOperInfoByStaffno(Long staffNoid, String tenantId, String state) {
		String message = "Parameters into checkStaffInfoBystaffno : staffNoid = " + staffNoid + "tenantId = " + tenantId + " state=" + state;
		LOGGER.info(message);
		List<OperatorVo> operVos = null;
		if (StringUtils.isNotEmpty(tenantId)) {
			operVos = getOperInfoByStaffno(staffNoid, tenantId, state);
		}
		if (operVos != null && operVos.size() > 0) {
			JSONArray returnVo = JSONArray.fromObject(operVos);
			message = "Result from checkStaffInfoBystaffno :" + returnVo.toString();
			LOGGER.info(message);
		} else {
			message = "Result from checkStaffInfoBystaffno : staffNoid " + staffNoid + " not exist.";
			LOGGER.info(message);
		}
		return operVos;
	}

	/**
	 * 通过员工号获得操作员信息
	 * 
	 * @param staffNoid
	 * @param tenantId
	 * @param state
	 * @return
	 */
	private List<OperatorVo> getOperInfoByStaffno(Long staffNoid, String tenantId, String state) {
		GnOperCriteria gnOperCriteria = new GnOperCriteria();
		GnOperCriteria.Criteria criteria = gnOperCriteria.createCriteria();
		List<OperatorVo> operVos = null;
		if (!StringUtils.isEmpty(tenantId)) {
			if (staffNoid != null) {
				criteria.andStaffnoIdEqualTo(staffNoid);
			}
			if (StringUtils.isNotEmpty(tenantId)) {
				criteria.andTenantIdEqualTo(tenantId);
			}
			if (StringUtils.isNotEmpty(state)) {
				criteria.andStateEqualTo(state);
			}
			List<GnOper> gnOpers = MapperFactory.getGnOperMapper().selectByExample(gnOperCriteria);
			if (gnOpers.size() > 0) {
				operVos = new ArrayList<OperatorVo>();
				for (int i = 0; i < gnOpers.size(); i++) {
					GnOper gnOper = gnOpers.get(i);
					OperatorVo operatorVo = new OperatorVo();
					BeanUtils.copyProperties(operatorVo, gnOper);
					operVos.add(operatorVo);
				}
			}
		}
		return operVos;
	}

	@Override
	public Long addOper(GnOper gnOper) {
		LOGGER.info("insert oper data begin..");
		Long operId = null;
		// 设置对象默认值
		gnOper.setOperId(SeqUtil.getNewId("RUNNER_SYS_OPER_PAYMENT$ID$SEQ"));
		Timestamp currTimestamp = DateTimeUtil.getCurrTimestamp();
		gnOper.setCreateTime(currTimestamp);
		int i = MapperFactory.getGnOperMapper().insertSelective(gnOper);
		if (i > 0) {
			operId = gnOper.getOperId();
			LOGGER.info("insert oper data success, the new operid is " + operId);
		} else {
			LOGGER.info("insert oper data failed");
		}
		return operId;
	}

	@Override
	public Integer updateOper(GnOper gnOper) {
		LOGGER.info("update oper data begin..");
		// 设置对象默认值
		Timestamp currTimestamp = DateTimeUtil.getCurrTimestamp();
		gnOper.setUpdateTime(currTimestamp);
		GnOperCriteria example = new GnOperCriteria();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andTenantIdEqualTo(gnOper.getTenantId());
		createCriteria.andOperIdEqualTo(gnOper.getOperId());
		Integer i = MapperFactory.getGnOperMapper().updateByExampleSelective(gnOper, example);
		if (i > 0) {
			LOGGER.info("update oper data success");
		} else {
			LOGGER.info("update oper data failed");
		}
		return i;
	}

	@Override
	public Integer delOperByID(GnOper gnOper) {
		LOGGER.info("delete oper data by id begin..");
		// 设置对象默认值
		Timestamp currTimestamp = DateTimeUtil.getCurrTimestamp();
		gnOper.setUpdateTime(currTimestamp);
		gnOper.setState(RecordsState.STATE_DELETED);// 删除操作员为逻辑删除，状态置为注销02
		Integer i = MapperFactory.getGnOperMapper().updateByPrimaryKeySelective(gnOper);
		if (i > 0) {
			LOGGER.info("delete oper data by id success");
		} else {
			LOGGER.info("delete oper data by id failed");
		}
		return i;
	}

	@Override
	public Integer delOperByStaffNoID(GnOper gnOper) {
		LOGGER.info("delete oper data by staffnoId begin..");
		// 设置对象默认值
		Timestamp currTimestamp = DateTimeUtil.getCurrTimestamp();
		gnOper.setUpdateTime(currTimestamp);
		gnOper.setState(RecordsState.STATE_DELETED);// 删除操作员为逻辑删除，状态置为注销02
		GnOperCriteria gnOperCriteria = new GnOperCriteria();
		GnOperCriteria.Criteria criteria = gnOperCriteria.createCriteria();
		criteria.andStaffnoIdEqualTo(gnOper.getStaffnoId());
		Integer i = MapperFactory.getGnOperMapper().updateByExampleSelective(gnOper, gnOperCriteria);
		if (i > 0) {
			LOGGER.info("delete oper data by staffnoId success");
		} else {
			LOGGER.info("delete oper data by staffnoId failed");
		}
		return i;
	}

	@Override
	public GnOper queryOperById(GnOper gnOper) {
		GnOper result = null;
		if (gnOper != null) {
			GnOperMapper gnOperMapper = MapperFactory.getGnOperMapper();
			GnOperCriteria example = new GnOperCriteria();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andOperIdEqualTo(gnOper.getOperId());
			createCriteria.andTenantIdEqualTo(gnOper.getTenantId());
			String state = gnOper.getState();
			if (StringUtils.isNoneEmpty(state)) {
				createCriteria.andStateEqualTo(state);
			}
			List<GnOper> gnOperList = gnOperMapper.selectByExample(example);
			if (gnOperList != null && gnOperList.size() > 0) {
				result = gnOperList.get(0);
			}
		}
		return result;
	}

	@Override
	public PageInfo<GnOper> queryOperPageInfo(GnOperParamsVO operParamsVO) {
		LOGGER.info("Pamater into queryAreaPageByOperId operAreaParamsVO:" + JSONObject.fromObject(operParamsVO));
		PageInfo<GnOper> resultPage = new PageInfo<GnOper>();

		int count = 0;
		// 单页大小
		Integer pageSize = getPageSize(operParamsVO);
		List<GnOper> gnOperList = null;
		if (operParamsVO != null) {
			GnOperCriteria gnOperCriteria = getQueryOperPageInfoCriterria(operParamsVO, pageSize);
			gnOperList = MapperFactory.getGnOperMapper().selectByExample(gnOperCriteria);
			count = MapperFactory.getGnOperMapper().countByExample(gnOperCriteria);
		}
		if (gnOperList != null) {
			resultPage.setCount(count);
			resultPage.setResult(gnOperList);
			resultPage.setPageSize(pageSize);
		} else {
			resultPage = null;
		}

		return resultPage;
	}
	
	/**
	 * 分页查询条件
	 * @param operParamsVO
	 * @param pageSize
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private GnOperCriteria getQueryOperPageInfoCriterria(GnOperParamsVO operParamsVO, Integer pageSize) {
		GnOperCriteria gnOperCriteria = new GnOperCriteria();
		GnOperCriteria.Criteria criteria = gnOperCriteria.createCriteria();

		if (StringUtils.isNotEmpty(operParamsVO.getTenantId())) {
			criteria.andTenantIdEqualTo(operParamsVO.getTenantId());
		}
		if (operParamsVO.getOperId() != null) {
			criteria.andOperIdEqualTo(operParamsVO.getOperId());
		}
		String operCode = operParamsVO.getOperCode();
		if(StringUtils.isNotEmpty(operCode)){
			criteria.andOperCodeEqualTo(operCode);
		}
		
		String state = operParamsVO.getState();
		if(StringUtils.isEmpty(state)){
			criteria.andStateEqualTo(RecordsState.STATE_NORMAL);
		}
		
		List<Long> staffnoIdList = operParamsVO.getStaffnoIdList();
		if(staffnoIdList != null && staffnoIdList.size()>0){
			criteria.andStaffnoIdIn(staffnoIdList);
		}

		Integer pageNumber = operParamsVO.getPageInfo().getPageNo();

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
		gnOperCriteria.setLimitStart(startNum);
		gnOperCriteria.setLimitEnd(endNum);
		gnOperCriteria.setOrderByClause("CREATE_TIME desc,OPER_ID desc");
		return gnOperCriteria;
	}

	/**
	 * 获取页面大小
	 * @param operParamsVO
	 * @return
	 */
	private Integer getPageSize(GnOperParamsVO operParamsVO) {
		Integer pageSize = null;
		if (operParamsVO != null) {
			PageInfo<GnOperVO> pageInfo = operParamsVO.getPageInfo();
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
	public List<GnOper> queryOperListByStaffnoIds(String tenantId, List<Long> staffnoIdList) {
		GnOperCriteria example = new GnOperCriteria();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andTenantIdEqualTo(tenantId);
		createCriteria.andStaffnoIdIn(staffnoIdList);
		createCriteria.andStateEqualTo(RecordsState.STATE_NORMAL);
		example.setOrderByClause("CREATE_TIME desc,OPER_ID desc");
		return MapperFactory.getGnOperMapper().selectByExample(example );
	}

	@Override
	public List<GnOper> queryOperListByOperIds(String tenantId, List<Long> operIdList) {
		GnOperCriteria example = new GnOperCriteria();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andTenantIdEqualTo(tenantId);
		createCriteria.andOperIdIn(operIdList);
		createCriteria.andStateEqualTo(RecordsState.STATE_NORMAL);
		example.setOrderByClause("CREATE_TIME desc,OPER_ID desc");
		return MapperFactory.getGnOperMapper().selectByExample(example);
	}

	@Override
	public List<GnOper> queryOperListByOperIds(String tenantId, List<Long> operIdList, int limitStart, int limitEnd) {
		GnOperCriteria example = new GnOperCriteria();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andTenantIdEqualTo(tenantId);
		createCriteria.andOperIdIn(operIdList);
		createCriteria.andStateEqualTo(RecordsState.STATE_NORMAL);
		example.setOrderByClause("CREATE_TIME desc,OPER_ID desc");
		example.setLimitStart(limitStart);
		example.setLimitEnd(limitEnd);
		return MapperFactory.getGnOperMapper().selectByExample(example);
	}

	@Override
	public Integer queryCountByOperIds(String tenantId, List<Long> operIdList) {
		GnOperCriteria example = new GnOperCriteria();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andTenantIdEqualTo(tenantId);
		createCriteria.andOperIdIn(operIdList);
		createCriteria.andStateEqualTo(RecordsState.STATE_NORMAL);
		example.setOrderByClause("CREATE_TIME desc,OPER_ID desc");
		return MapperFactory.getGnOperMapper().countByExample(example);
	}

}
