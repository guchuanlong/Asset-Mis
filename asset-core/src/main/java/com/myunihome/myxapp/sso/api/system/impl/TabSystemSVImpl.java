package com.myunihome.myxapp.sso.api.system.impl;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.myunihome.myxapp.base.exception.CallerException;
import com.myunihome.myxapp.paas.util.BeanUtils;
import com.myunihome.myxapp.sso.api.system.interfaces.ITabSystemSV;
import com.myunihome.myxapp.sso.api.system.mapper.TabSystemQueryVO;
import com.myunihome.myxapp.sso.api.system.mapper.TabSystemVO;
import com.myunihome.myxapp.sso.constants.Constants.ErrorCode;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSystem;
import com.myunihome.myxapp.sso.dao.mapper.bo.GnTabSystemKey;
import com.myunihome.myxapp.sso.service.ITabSystemService;

@Service
@Component
public class TabSystemSVImpl implements ITabSystemSV{

	@Autowired
	ITabSystemService tabSystemService;
	
	@Override
	public List<TabSystemVO> queryTabSystemList(TabSystemQueryVO tabSystemQueryVO) throws CallerException {
		checkBefQueryTabSystem(tabSystemQueryVO);
		GnTabSystemKey tabSystemKey = new GnTabSystemKey();
		BeanUtils.copyProperties(tabSystemKey, tabSystemQueryVO);
		List<GnTabSystem> gnTabSystemList = tabSystemService.queryGnTabSystemList(tabSystemKey);
		List<TabSystemVO> tabSystemVOList = null;
		if(gnTabSystemList != null && gnTabSystemList.size() >0){
			tabSystemVOList = new LinkedList<TabSystemVO>();
			for(GnTabSystem gnTabSystem : gnTabSystemList){
				TabSystemVO tabSystemVo = new TabSystemVO();
				BeanUtils.copyProperties(tabSystemVo, gnTabSystem);
				tabSystemVOList.add(tabSystemVo);
			}
		}
		return tabSystemVOList;
	}

	/**
	 * 查询前检查
	 * @param tabSystemQueryVO
	 * @author jiaxs
	 * @ApiDocMethod
	 */
	private void checkBefQueryTabSystem(TabSystemQueryVO tabSystemQueryVO) {
		String errorMessage = "";
		if(tabSystemQueryVO==null){
			errorMessage +="查询参数对象不能为空！";
		}else{
			String tenantId = tabSystemQueryVO.getTenantId();
			if(StringUtils.isEmpty(tenantId)){
				errorMessage +="租户ID（tenantId）不能为空！";
			}
		}
		if(StringUtils.isNotEmpty(errorMessage)){
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMessage);
		}
	}

	@Override
	public TabSystemVO getTabSystem(TabSystemQueryVO tabSystemQueryVO) throws CallerException{
		validateGetTabSystem(tabSystemQueryVO);
		GnTabSystemKey tabSystemKey = new GnTabSystemKey();
		BeanUtils.copyProperties(tabSystemKey, tabSystemQueryVO);
		TabSystemVO vo=null;
		GnTabSystem dbSystem=tabSystemService.getGnTabSystem(tabSystemKey);
		if(dbSystem!=null){
			vo=new TabSystemVO();
			BeanUtils.copyProperties(vo, dbSystem);
		}
		return vo;
	}
	
	private void validateGetTabSystem(TabSystemQueryVO tabSystemQueryVO) {
		String errorMessage = "";
		if(tabSystemQueryVO==null){
			errorMessage +="查询参数对象不能为空！";
		}else{
			String tenantId = tabSystemQueryVO.getTenantId();
			if(StringUtils.isEmpty(tenantId)){
				errorMessage +=" 租户ID（tenantId）不能为空！";
			}
			if(StringUtils.isEmpty(tabSystemQueryVO.getSystemId())){
				errorMessage +=" 系统ID（systemId）不能为空！";
			}
		}
		if(StringUtils.isNotEmpty(errorMessage)){
			throw new CallerException(ErrorCode.PARAM_NULL_ERROR, errorMessage);
		}
	}

}
