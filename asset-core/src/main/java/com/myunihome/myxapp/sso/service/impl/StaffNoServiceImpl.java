package com.myunihome.myxapp.sso.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.paas.sequence.SeqUtil;
import com.myunihome.myxapp.paas.util.DateUtil;
import com.myunihome.myxapp.sso.api.stafflogin.param.StaffnoPasswdVo;
import com.myunihome.myxapp.sso.constants.Constants.RecordsState;
import com.myunihome.myxapp.sso.constants.Constants.StaffPassword;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnStaffno;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnStaffnoCriteria;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnStaffnoCriteria.Criteria;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;
import com.myunihome.myxapp.sso.dao.mapper.interfaces.GnStaffnoMapper;
import com.myunihome.myxapp.sso.service.IStaffNoService;
import com.myunihome.myxapp.sys.api.sysstaffno.param.GnStaffNoParamsVO;
import com.myunihome.myxapp.sys.api.sysstaffno.param.GnStaffNoPasswdVO;
import com.myunihome.myxapp.sys.util.DateTimeUtil;

@Component
public class StaffNoServiceImpl implements IStaffNoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StaffNoServiceImpl.class);

	@Override
	public Long addStaffNo(GnStaffno gnStaffno) {
		Long staffNoId = null;
		if (gnStaffno != null) {
			gnStaffno.setStaffnoId(SeqUtil.getNewId("RUNNER_SSO_STAFFNO_PAYMENT$ID$SEQ"));
			String state = gnStaffno.getState();
			if (StringUtils.isEmpty(state)) {
				gnStaffno.setState(RecordsState.STATE_NORMAL);
			}
			Timestamp currTime = DateTimeUtil.getCurrTimestamp();
			gnStaffno.setCreateTime(currTime);
			long i = MapperFactory.getGnStaffnoMapper().insertSelective(gnStaffno);
			if (i > 0) {
				staffNoId = gnStaffno.getStaffnoId();
			}
		}

		return staffNoId;
	}

	@Override
	public Integer updateStaffNo(GnStaffno gnStaffno) {
		Integer i = null;
		if (gnStaffno != null) {
			gnStaffno.setUpdateTime(DateTimeUtil.getCurrTimestamp());
			GnStaffnoCriteria example = new GnStaffnoCriteria();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andTenantIdEqualTo(gnStaffno.getTenantId());
			createCriteria.andStaffnoIdEqualTo(gnStaffno.getStaffnoId());
			i = MapperFactory.getGnStaffnoMapper().updateByExampleSelective(gnStaffno, example);
			if (i > 0) {
				LOGGER.info("update staffNo data success");
			} else {
				LOGGER.info("update staffNo data failed");
			}
		}
		return i;
	}

	@Override
	public Integer delStaffNoByStaffNoId(GnStaffno gnStaffno) {
		Integer i = null;
		if (gnStaffno != null) {
			Timestamp currTimestamp = DateTimeUtil.getCurrTimestamp();
			String currStartTimeStr = DateTimeUtil.timstamp2String(currTimestamp);
			Timestamp currData = DateTimeUtil.stringToTimstamp(2, currStartTimeStr);// 时分秒为0
			gnStaffno.setInactiveTime(currData);
			gnStaffno.setUpdateTime(currTimestamp);
			gnStaffno.setState(RecordsState.STATE_DELETED);
			gnStaffno.setUpdateTime(DateTimeUtil.getCurrTimestamp());
			i = MapperFactory.getGnStaffnoMapper().updateByPrimaryKeySelective(gnStaffno);
		}
		return i;
	}

	@Override
	public GnStaffno queryStaffNoByStaffNoId(GnStaffno gnStaffno) {
		GnStaffno result = null;
		if (gnStaffno != null) {
			GnStaffnoMapper gnStaffnoMapper = MapperFactory.getGnStaffnoMapper();
			GnStaffnoCriteria example = new GnStaffnoCriteria();
			Criteria staffnoCriteria = example.createCriteria();
			staffnoCriteria.andStaffnoIdEqualTo(gnStaffno.getStaffnoId());
			staffnoCriteria.andTenantIdEqualTo(gnStaffno.getTenantId());
			String state = gnStaffno.getState();
			if (StringUtils.isNotEmpty(state)) {
				staffnoCriteria.andStateEqualTo(state);
			}
			Timestamp inactiveTime = gnStaffno.getInactiveTime();
			if (inactiveTime != null) {
				staffnoCriteria.andInactiveTimeGreaterThan(inactiveTime);
			}
			Timestamp activeTime = gnStaffno.getActiveTime();
			if (activeTime != null) {
				staffnoCriteria.andActiveTimeLessThanOrEqualTo(activeTime);
			}
			List<GnStaffno> staffnoList = gnStaffnoMapper.selectByExample(example);
			if (staffnoList != null && staffnoList.size() > 0) {
				result = staffnoList.get(0);
			}
		}
		return result;

	}

	@Override
	public PageInfo<GnStaffno> queryStaffNo(GnStaffNoParamsVO gnStaffNoParamsVO) {
		PageInfo<GnStaffno> resultPage = new PageInfo<GnStaffno>();

		int count = 0;
		Integer pageSize = 5;
		List<GnStaffno> gnStaffNoList = null;

		if (gnStaffNoParamsVO != null) {
			GnStaffnoCriteria gnStaffnoCriteria = new GnStaffnoCriteria();
			GnStaffnoCriteria.Criteria criteria = gnStaffnoCriteria.createCriteria();
			String state = gnStaffNoParamsVO.getState();
			if (StringUtils.isNotEmpty(state)) {
				criteria.andStateEqualTo(state);
			} else {
				criteria.andStateEqualTo(RecordsState.STATE_NORMAL);
			}
			if (!StringUtils.isEmpty(gnStaffNoParamsVO.getTenantId())) {
				criteria.andTenantIdEqualTo(gnStaffNoParamsVO.getTenantId());
			}
			if (!StringUtils.isEmpty(gnStaffNoParamsVO.getStaffNo())) {
				criteria.andStaffNoEqualTo(gnStaffNoParamsVO.getStaffNo());
			}
			if (!StringUtils.isEmpty(gnStaffNoParamsVO.getStaffName())) {
				criteria.andStaffNameLike("%" + gnStaffNoParamsVO.getStaffName() + "%");
			}
			if (gnStaffNoParamsVO.getActiveTime() != null) {
				criteria.andActiveTimeLessThanOrEqualTo(gnStaffNoParamsVO.getActiveTime());
			}
			if (gnStaffNoParamsVO.getInactiveTime() != null) {
				criteria.andInactiveTimeGreaterThan(gnStaffNoParamsVO.getInactiveTime());
			}

			Integer pageNumber = gnStaffNoParamsVO.getPageInfo().getPageNo();
			pageSize = gnStaffNoParamsVO.getPageInfo().getPageSize();

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
			gnStaffnoCriteria.setLimitStart(startNum);
			gnStaffnoCriteria.setLimitEnd(endNum);
			gnStaffnoCriteria.setOrderByClause("CREATE_TIME desc,STAFFNO_ID desc");

			gnStaffNoList = MapperFactory.getGnStaffnoMapper().selectByExample(gnStaffnoCriteria);
			count = MapperFactory.getGnStaffnoMapper().countByExample(gnStaffnoCriteria);
		}

		if (gnStaffNoList != null) {
			resultPage.setCount(count);
			resultPage.setResult(gnStaffNoList);
			resultPage.setPageSize(pageSize);
		} else {
			resultPage = null;
		}

		return resultPage;
	}

	@Override
	public Integer countByStaffNo(GnStaffno gnStaffno) {

		Integer count = null;
		if (gnStaffno != null) {
			GnStaffnoCriteria gnStaffnoCriteria = new GnStaffnoCriteria();
			GnStaffnoCriteria.Criteria criteria = gnStaffnoCriteria.createCriteria();

			if (StringUtils.isNotEmpty(gnStaffno.getTenantId())) {
				criteria.andTenantIdEqualTo(gnStaffno.getTenantId());
			}
			if (StringUtils.isNotEmpty(gnStaffno.getStaffNo())) {
				criteria.andStaffNoEqualTo(gnStaffno.getStaffNo());
			}
			if (StringUtils.isNotEmpty(gnStaffno.getState())) {
				criteria.andStateEqualTo(gnStaffno.getState());
			}
			if (gnStaffno.getActiveTime() != null) {
				criteria.andActiveTimeLessThanOrEqualTo(gnStaffno.getActiveTime());
			}
			if (gnStaffno.getInactiveTime() != null) {
				criteria.andInactiveTimeGreaterThan(gnStaffno.getInactiveTime());
			}
			count = MapperFactory.getGnStaffnoMapper().countByExample(gnStaffnoCriteria);
		}

		return count;
	}

	@Override
	public Integer updateStaffPasswd(StaffnoPasswdVo staffnoPasswdVo) {
		LOGGER.info("updateStaffPasswd params :" + JSON.toJSONString(staffnoPasswdVo));
		GnStaffnoMapper gnStaffnoMapper = MapperFactory.getGnStaffnoMapper();
		GnStaffno gnStaffno = new GnStaffno();
		gnStaffno.setStaffPasswd(staffnoPasswdVo.getNewPassword());
		GnStaffnoCriteria example = new GnStaffnoCriteria();
		Criteria criteria = example.createCriteria();
		criteria.andTenantIdEqualTo(staffnoPasswdVo.getTenantId());
		criteria.andStaffNoEqualTo(staffnoPasswdVo.getStaffNo());
		criteria.andStaffPasswdEqualTo(staffnoPasswdVo.getOldPassword());
		return gnStaffnoMapper.updateByExampleSelective(gnStaffno, example);
	}

	@Override
	public Integer resetStaffPassword(GnStaffNoPasswdVO staffNoPasswdVO) {
		LOGGER.info("resetStaffPassword params :" + JSON.toJSONString(staffNoPasswdVO));
		GnStaffnoMapper gnStaffnoMapper = MapperFactory.getGnStaffnoMapper();
		GnStaffnoCriteria example = new GnStaffnoCriteria();
		Criteria criteria = example.createCriteria();
		criteria.andTenantIdEqualTo(staffNoPasswdVO.getTenantId());
		criteria.andStaffNoEqualTo(staffNoPasswdVO.getStaffNo());
		GnStaffno gnStaffno = new GnStaffno();
		gnStaffno.setStaffPasswd(StaffPassword.INIT_PASSWD);
		return gnStaffnoMapper.updateByExampleSelective(gnStaffno, example);
	}

	@Override
	public Integer countStaffNoExceptSelf(GnStaffno gnStaffno) {
		Integer count = null;
		if (gnStaffno != null) {
			GnStaffnoCriteria gnStaffnoCriteria = new GnStaffnoCriteria();
			GnStaffnoCriteria.Criteria criteria = gnStaffnoCriteria.createCriteria();

			if (StringUtils.isNotEmpty(gnStaffno.getTenantId())) {
				criteria.andTenantIdEqualTo(gnStaffno.getTenantId());
			}
			if (StringUtils.isNotEmpty(gnStaffno.getStaffNo())) {
				criteria.andStaffNoEqualTo(gnStaffno.getStaffNo());
			}
			if (StringUtils.isNotEmpty(gnStaffno.getState())) {
				criteria.andStateEqualTo(gnStaffno.getState());
			}
			if (gnStaffno.getActiveTime() != null) {
				criteria.andActiveTimeLessThanOrEqualTo(gnStaffno.getActiveTime());
			}
			if (gnStaffno.getInactiveTime() != null) {
				criteria.andInactiveTimeGreaterThan(gnStaffno.getInactiveTime());
			}
			if (gnStaffno.getStaffnoId() != null) {
				criteria.andStaffnoIdNotEqualTo(gnStaffno.getStaffnoId());
			}
			count = MapperFactory.getGnStaffnoMapper().countByExample(gnStaffnoCriteria);
		}
		return count;
	}

	@Override
	public List<GnStaffno> queryStaffnoList(GnStaffno gnStaffno) {
		List<GnStaffno> selectByExample = null;
		if (gnStaffno != null) {
			GnStaffnoCriteria gnStaffnoCriteria = new GnStaffnoCriteria();
			GnStaffnoCriteria.Criteria criteria = gnStaffnoCriteria.createCriteria();
			String state = gnStaffno.getState();
			if (StringUtils.isNotEmpty(state)) {
				criteria.andStateEqualTo(state);
			} else {
				criteria.andStateEqualTo(RecordsState.STATE_NORMAL);
			}
			if (!StringUtils.isEmpty(gnStaffno.getTenantId())) {
				criteria.andTenantIdEqualTo(gnStaffno.getTenantId());
			}
			if (!StringUtils.isEmpty(gnStaffno.getStaffNo())) {
				criteria.andStaffNoEqualTo(gnStaffno.getStaffNo());
			}
			if (!StringUtils.isEmpty(gnStaffno.getStaffName())) {
				criteria.andStaffNameLike("%" + gnStaffno.getStaffName() + "%");
			}
			if (gnStaffno.getActiveTime() != null) {
				criteria.andActiveTimeLessThanOrEqualTo(gnStaffno.getActiveTime());
			}
			if (gnStaffno.getInactiveTime() != null) {
				criteria.andInactiveTimeGreaterThan(gnStaffno.getInactiveTime());
			}
			gnStaffnoCriteria.setOrderByClause("CREATE_TIME desc,STAFFNO_ID desc");
			selectByExample = MapperFactory.getGnStaffnoMapper().selectByExample(gnStaffnoCriteria);
		}
		return selectByExample;
	}

	@Override
	public List<GnStaffno> queryStaffnoList(String tenantId, List<Long> staffnoIdList) {
		GnStaffnoCriteria example = new GnStaffnoCriteria();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andTenantIdEqualTo(tenantId);
		createCriteria.andStaffnoIdIn(staffnoIdList);
		//只查有效数据
		createCriteria.andStateEqualTo(RecordsState.STATE_NORMAL);
		Timestamp sysDate = DateUtil.getSysDate();
		createCriteria.andActiveTimeLessThanOrEqualTo(sysDate);
		createCriteria.andInactiveTimeGreaterThan(sysDate);
		return MapperFactory.getGnStaffnoMapper().selectByExample(example);
	}

}
