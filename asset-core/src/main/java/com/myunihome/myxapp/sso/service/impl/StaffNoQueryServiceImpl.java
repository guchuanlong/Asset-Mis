package com.myunihome.myxapp.sso.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.myunihome.myxapp.paas.util.CollectionUtil;
import com.myunihome.myxapp.sso.api.staffnoquery.param.StaffInfo;
import com.myunihome.myxapp.sso.api.staffnoquery.param.StaffNoInfoQuery;
import com.myunihome.myxapp.sso.api.staffnoquery.param.StaffNoVo;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnStaffno;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnStaffnoCriteria;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;
import com.myunihome.myxapp.sso.service.IStaffNoQueryService;

import net.sf.json.JSONObject;

/**
 * 员工信息查询
 * 
 * @author zhouyy5
 * 
 */
@Component
public class StaffNoQueryServiceImpl implements IStaffNoQueryService {

	private static final Logger LOG = LoggerFactory.getLogger(StaffNoQueryServiceImpl.class);

	/**
	 * 查询员工信息<br>
	 * 
	 * @param vo
	 *            参数 员工id(staffId)和员工名称(staffName)不能同时为空 ，
	 *            pageNumber(查询页码)必填、pageSize(一页显示条数)必填,租户id(tenantId) 必填<br>
	 * @return List<StaffNoInfoQuery><br>
	 * @author zhouyy5<br>
	 * @ApiDocMethod
	 */
	@Override
	public StaffNoInfoQuery queryStaffNo(StaffNoVo vo) {
		StaffNoInfoQuery staffNoInfoQuery = new StaffNoInfoQuery();
		JSONObject paramVo = JSONObject.fromObject(vo);
		LOG.info("查询员工信息接口(StaffNoInfoQuery)请求参数:" + paramVo.toString());
		GnStaffnoCriteria gnStaffnoCriteria = new GnStaffnoCriteria();
		GnStaffnoCriteria.Criteria criteria = gnStaffnoCriteria.createCriteria();
		if (!StringUtils.isEmpty(vo.getTenantId())) {
			criteria.andTenantIdEqualTo(vo.getTenantId());
		}
		if (!StringUtils.isEmpty(vo.getStaffId())) {
			criteria.andStaffIdEqualTo(vo.getStaffId());
		}
		if (!StringUtils.isEmpty(vo.getStaffName())) {
			criteria.andStaffNameLike("%" + vo.getStaffName() + "%");
		}
		int count = MapperFactory.getGnStaffnoMapper().countByExample(gnStaffnoCriteria);

		Integer pageNumber = vo.getPageNumber();
		Integer pageSize = vo.getPageSize();
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
		// List转换格式
		List<StaffInfo> staffNoList = new ArrayList<StaffInfo>();
		List<GnStaffno> gnStaffnoList = MapperFactory.getGnStaffnoMapper().selectByExample(gnStaffnoCriteria);
		if (!CollectionUtil.isEmpty(gnStaffnoList)) {
			Gson gson = new Gson();
			staffNoList = gson.fromJson(gson.toJson(gnStaffnoList), new TypeToken<List<StaffInfo>>() {
			}.getType());
		}
		staffNoInfoQuery.setCount(count);
		staffNoInfoQuery.setStaffInfoList(staffNoList);
		return staffNoInfoQuery;
	}

}
