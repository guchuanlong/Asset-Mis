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
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOperRole;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOperRoleCriteria;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnOperRoleCriteria.Criteria;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;
import com.myunihome.myxapp.sso.dao.mapper.interfaces.GnOperRoleMapper;
import com.myunihome.myxapp.sso.service.IOperRoleService;
import com.myunihome.myxapp.sys.api.sysoperrole.param.GnOperRoleParamsVO;
import com.myunihome.myxapp.sys.api.sysoperrole.param.GnOperRoleVO;
import com.myunihome.myxapp.sys.util.DateTimeUtil;

import net.sf.json.JSONObject;

@Component
public class OperRoleServiceImpl implements IOperRoleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OperRoleServiceImpl.class);
	private static final int PAGESIZE = 5;// 默认页面大小

	@Override
	public Integer addRoleToOper(GnOperRole operRole) {
		LOGGER.info("insert operrole data begin..");
		// 设置对象默认值
		setOperRoleDefValues(operRole);
		Integer i = MapperFactory.getGnOperRoleMapper().insertSelective(operRole);
		if (i > 0) {
			Long operRoleRelId = operRole.getOperRoleRelId();
			LOGGER.info("insert operrole data success, the new operRoleRelId is " + operRoleRelId);
		} else {
			LOGGER.error("insert operrole data failed");
		}
		return i;
	}

	/**
	 * 设置对象默认值
	 * 
	 * @param operRole
	 */
	private void setOperRoleDefValues(GnOperRole operRole) {
		operRole.setOperRoleRelId(SeqUtil.getNewId("RUNNER_SYS_OPER_ROLE_PAYMENT$ID$SEQ"));
		Timestamp currTimestamp = DateTimeUtil.getCurrTimestamp();
		operRole.setCreateTime(currTimestamp);
		Timestamp activeTime = operRole.getActiveTime();
		if(activeTime == null){
			String currStartTimeStr = DateTimeUtil.timstamp2String(currTimestamp);
			Timestamp currData = DateTimeUtil.stringToTimstamp(2,currStartTimeStr);//时分秒为0
			operRole.setActiveTime(currData);
		}
		Timestamp inactiveTime = operRole.getInactiveTime();
		if(inactiveTime == null){
			inactiveTime = DateUtil.getTimestamp("2099-12-31");
			operRole.setInactiveTime(inactiveTime);
		}
		String createType = operRole.getCreateType();
		if(StringUtils.isEmpty(createType)){
			operRole.setCreateType(CreateType.TYPE_CREATE);
		}
	}

	@Override
	public PageInfo<GnOperRole> queryRoleByOperId(GnOperRoleParamsVO operRoleParamsVO) {
		PageInfo<GnOperRole> resultPage = new PageInfo<GnOperRole>();

		int count = 0;
		// 单页大小
		Integer pageSize = getPageSize(operRoleParamsVO);
		List<GnOperRole> gnOperRoleList = null;

		if (operRoleParamsVO != null) {
			GnOperRoleCriteria gnOperRoleCriteria = getQueryRoleByOperIdCriterria(operRoleParamsVO, pageSize);
			gnOperRoleList = MapperFactory.getGnOperRoleMapper().selectByExample(gnOperRoleCriteria);
			count = MapperFactory.getGnOperRoleMapper().countByExample(gnOperRoleCriteria);
		}

		if (gnOperRoleList != null) {
			resultPage.setCount(count);
			resultPage.setResult(gnOperRoleList);
			resultPage.setPageSize(pageSize);
		} else {
			resultPage = null;
		}

		return resultPage;
	}

	/**
	 * 获取页面大小
	 * 
	 * @param operRoleParamsVO
	 * @return
	 */
	private Integer getPageSize(GnOperRoleParamsVO operRoleParamsVO) {
		Integer pageSize = null;
		if (operRoleParamsVO != null) {
			PageInfo<GnOperRoleVO> pageInfo = operRoleParamsVO.getPageInfo();
			if (pageInfo != null) {
				pageSize = pageInfo.getPageSize();
			}
		}
		if (pageSize == null) {
			pageSize = PAGESIZE;
		}
		return pageSize;
	}

	/**
	 * 获得查询sql的条件拼接对象
	 * 
	 * @param operRoleParamsVO
	 * @return
	 */
	private GnOperRoleCriteria getQueryRoleByOperIdCriterria(GnOperRoleParamsVO operRoleParamsVO, int pageSize) {
		GnOperRoleCriteria gnOperRoleCriteria = new GnOperRoleCriteria();
		GnOperRoleCriteria.Criteria criteria = gnOperRoleCriteria.createCriteria();

		if (StringUtils.isNotEmpty(operRoleParamsVO.getTenantId())) {
			criteria.andTenantIdEqualTo(operRoleParamsVO.getTenantId());
		}
		if (operRoleParamsVO.getStaffnoId() != null) {
			criteria.andStaffnoIdEqualTo(operRoleParamsVO.getStaffnoId());
		}
		Timestamp inactiveTime = operRoleParamsVO.getInactiveTime();
		if (inactiveTime != null) {
			criteria.andInactiveTimeGreaterThan(inactiveTime);
		}
		Timestamp activeTime = operRoleParamsVO.getActiveTime();
		if (activeTime != null) {
			criteria.andActiveTimeLessThanOrEqualTo(activeTime);
		}

		Integer pageNumber = operRoleParamsVO.getPageInfo().getPageNo();

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
		gnOperRoleCriteria.setLimitStart(startNum);
		gnOperRoleCriteria.setLimitEnd(endNum);
		gnOperRoleCriteria.setOrderByClause("CREATE_TIME desc,OPER_ROLE_REL_ID desc");
		return gnOperRoleCriteria;
	}

	@Override
	public Integer updateOperRole(GnOperRoleParamsVO operRoleParamsVO) {
		LOGGER.info("Parameters into updateOperRole  GnOperRoleParamsVO :" + JSONObject.fromObject(operRoleParamsVO));
		GnOperRoleMapper operRoleMapper = MapperFactory.getGnOperRoleMapper();
		GnOperRole operRoleVO = new GnOperRole();
		BeanUtils.copyProperties(operRoleVO, operRoleParamsVO);
		operRoleVO.setUpdateTime(DateUtil.getSysDate());
		GnOperRoleCriteria operRoleCriteria = getUpdateOperRoleCriteria(operRoleParamsVO);
		return operRoleMapper.updateByExampleSelective(operRoleVO, operRoleCriteria);
	}

	/**
	 * 获得更新操作员角色信息的条件
	 * 
	 * @param operRoleParamsVO
	 * @return
	 */
	private GnOperRoleCriteria getUpdateOperRoleCriteria(GnOperRoleParamsVO operRoleParamsVO) {
		GnOperRoleCriteria operRoleCriteria = new GnOperRoleCriteria();
		Criteria criteria = operRoleCriteria.createCriteria();
		String tenantId = operRoleParamsVO.getTenantId();
		if (StringUtils.isNoneEmpty(tenantId)) {
			criteria.andTenantIdEqualTo(tenantId);
		}
		Long operRoleRelId = operRoleParamsVO.getOperRoleRelId();
		if (operRoleRelId != null) {
			criteria.andOperRoleRelIdEqualTo(operRoleRelId);
		}
		Long staffnoId = operRoleParamsVO.getStaffnoId();
		if (staffnoId != null) {
			criteria.andStaffnoIdEqualTo(staffnoId);
		}
		Long roleId = operRoleParamsVO.getRoleId();
		if (roleId != null) {
			criteria.andRoleIdEqualTo(roleId);
		}
		return operRoleCriteria;
	}

	@Override
	public List<GnOperRole> queryRoleListByOperId(GnOperRoleParamsVO operRoleParamsVO) {
		LOGGER.info("Pamater into queryRoleListByOperId GnOperRoleParamsVO:" + JSONObject.fromObject(operRoleParamsVO));
		GnOperRoleMapper gnOperRoleMapper = MapperFactory.getGnOperRoleMapper();
		// 获取操作员含有角色的sql条件
		GnOperRoleCriteria operRoleCriteria = getQueryRoleListCriteria(operRoleParamsVO);
		return gnOperRoleMapper.selectByExample(operRoleCriteria);
	}

	/**
	 * 获取操作员含有角色的sql条件
	 * 
	 * @param operRoleParamsVO
	 * @return
	 */
	private GnOperRoleCriteria getQueryRoleListCriteria(GnOperRoleParamsVO operRoleParamsVO) {
		GnOperRoleCriteria operRoleCriteria = new GnOperRoleCriteria();
		operRoleCriteria.setOrderByClause("CREATE_TIME desc,OPER_ROLE_REL_ID desc");
		Criteria criteria = operRoleCriteria.createCriteria();
		String tenantId = operRoleParamsVO.getTenantId();
		if (StringUtils.isNoneEmpty(tenantId)) {
			criteria.andTenantIdEqualTo(tenantId);
		}
		Long staffnoId = operRoleParamsVO.getStaffnoId();
		if (staffnoId != null) {
			criteria.andStaffnoIdEqualTo(staffnoId);
		}
		Timestamp inactiveTime = operRoleParamsVO.getInactiveTime();
		if (inactiveTime != null) {
			criteria.andInactiveTimeGreaterThan(inactiveTime);
		}
		Timestamp activeTime = operRoleParamsVO.getActiveTime();
		if (activeTime != null) {
			criteria.andActiveTimeLessThanOrEqualTo(activeTime);
		}
		return operRoleCriteria;
	}

	@Override
	public Integer deleteOperRole(GnOperRoleParamsVO operRoleParamsVO) {
		GnOperRoleCriteria operRoleCriteria = getDelOperRoleCriteria(operRoleParamsVO);
		GnOperRole gnOperRole = new GnOperRole();
		BeanUtils.copyProperties(gnOperRole, operRoleParamsVO);
		//设置失效日期为当前
		Timestamp currTimestamp = DateTimeUtil.getCurrTimestamp();
		String currStartTimeStr = DateTimeUtil.timstamp2String(currTimestamp);
		Timestamp currData = DateTimeUtil.stringToTimstamp(2,currStartTimeStr);//时分秒为0
		gnOperRole.setInactiveTime(currData);
		GnOperRoleMapper gnOperRoleMapper = MapperFactory.getGnOperRoleMapper();
		return gnOperRoleMapper.updateByExampleSelective(gnOperRole, operRoleCriteria);
	}

	/**
	 * 获取删除条件
	 * @param operRoleParamsVO
	 * @return
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private GnOperRoleCriteria getDelOperRoleCriteria(GnOperRoleParamsVO operRoleParamsVO) {
		GnOperRoleCriteria operRoleCriteria = new GnOperRoleCriteria();
		Criteria createCriteria = operRoleCriteria.createCriteria();
		String tenantId = operRoleParamsVO.getTenantId();
		if(StringUtils.isNotEmpty(tenantId)){
			createCriteria.andTenantIdEqualTo(tenantId);
		}
		Long operRoleRelId = operRoleParamsVO.getOperRoleRelId();
		if(operRoleRelId != null){
			createCriteria.andOperRoleRelIdEqualTo(operRoleRelId);
		}
		Long staffnoId = operRoleParamsVO.getStaffnoId();
		if(staffnoId != null){
			createCriteria.andOperIdEqualTo(staffnoId);
		}
		Long roleId = operRoleParamsVO.getRoleId();
		if(roleId != null){
			createCriteria.andRoleIdEqualTo(roleId);
		}
		return operRoleCriteria;
	}

}
