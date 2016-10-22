package com.myunihome.myxapp.sys.test.api.tabsysipmap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.paas.util.JSonUtil;
import com.myunihome.myxapp.sso.api.ipmap.interfaces.ITabSysIpMapSV;
import com.myunihome.myxapp.sso.api.ipmap.param.TabSysIpMapQueryVO;
import com.myunihome.myxapp.sso.api.ipmap.param.TabSysIpMapVO;
import com.myunihome.myxapp.sys.api.sysipmap.interfaces.IGnTabSysIpMapSV;
import com.myunihome.myxapp.sys.api.sysipmap.param.GnTabSysIpMapParamVO;
import com.myunihome.myxapp.sys.api.sysipmap.param.GnTabSysIpMapResponseVO;
import com.myunihome.myxapp.sys.api.sysipmap.param.GnTabSysIpMapVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/core-context.xml")
public class GnTabSysIpMapSVTest {

	@Autowired
	ITabSysIpMapSV tabSysIpMapSV;
	
	@Autowired
	IGnTabSysIpMapSV gnTabSysIpMap;
	
	@Test
	public void testQueryGnTabSysIpMap(){
		System.out.println("<<<<<<<<<<<<<<<<<<<<<testQueryGnTabSysIpMap>>>>>>>>>>>>>>>>>>>>>");
		
		TabSysIpMapQueryVO tabSysIpMapKey = new TabSysIpMapQueryVO();
		tabSysIpMapKey.setTenantId("BIS-ST");
		tabSysIpMapKey.setConnectIp("10.1.228.222");
		tabSysIpMapKey.setConnectPort("14141");
		tabSysIpMapKey.setSystemId("runner-channel-center");
		TabSysIpMapVO queryTabSysIpMap = tabSysIpMapSV.queryTabSysIpMap(tabSysIpMapKey );
		System.out.println("结果集： "+JSonUtil.toJSon(queryTabSysIpMap));
		
		System.out.println("<<<<<<<<<<<<<<<<<<<<<testQueryGnTabSysIpMap>>>>>>>>>>>>>>>>>>>>>");
	}
	
	@Test
	public void testQueryGnTabSysIpMapPageInfo(){
		System.out.println("<<<<<<<<<<<<<<<<<<<<<testQueryGnTabSysIpMapPageInfo>>>>>>>>>>>>>>>>>>>>>");
		
		GnTabSysIpMapParamVO tabSysIpMapKey = new GnTabSysIpMapParamVO();
		tabSysIpMapKey.setTenantId("BIS-ST");
		// tabSysIpMapKey.setConnectIp("10.1.228.222");
		// tabSysIpMapKey.setConnectPort("14141");
		// tabSysIpMapKey.setSystemId("runner-channel-center");
		PageInfo<GnTabSysIpMapVO> pageInfo = new PageInfo<GnTabSysIpMapVO>();
		pageInfo.setPageNo(1);
		pageInfo.setPageSize(5);
		tabSysIpMapKey.setPageInfo(pageInfo);
		PageInfo<GnTabSysIpMapVO> queryTabSysIpMapPageInfo = gnTabSysIpMap.queryTabSysIpMapPageInfo(tabSysIpMapKey);
		System.out.println("count： "+queryTabSysIpMapPageInfo.getCount());
		System.out.println("结果集： "+JSonUtil.toJSon(queryTabSysIpMapPageInfo));
		
		System.out.println("<<<<<<<<<<<<<<<<<<<<<testQueryGnTabSysIpMapPageInfo>>>>>>>>>>>>>>>>>>>>>");
	}
	
	@Test
	public void testAddGnTabSysIpMap(){
		System.out.println("<<<<<<<<<<<<<<<<<<<<<testAddGnTabSysIpMap>>>>>>>>>>>>>>>>>>>>>");
		
		GnTabSysIpMapParamVO tabSysIpMapParamVO = new GnTabSysIpMapParamVO();
		tabSysIpMapParamVO.setTenantId("BIS-ST");
		tabSysIpMapParamVO.setConnectIp("10.1.228.222");
		tabSysIpMapParamVO.setConnectPort("14141");
		tabSysIpMapParamVO.setSystemId("test");
		tabSysIpMapParamVO.setMappedId("http://10.1.228.222/test");
		GnTabSysIpMapResponseVO addTabSysIpMapPageInfo = gnTabSysIpMap.addTabSysIpMapPageInfo(tabSysIpMapParamVO);
		System.out.println("结果集： "+addTabSysIpMapPageInfo.getResponseCode() + "  " +addTabSysIpMapPageInfo.getRespondeDesc());
		
		System.out.println("<<<<<<<<<<<<<<<<<<<<<testAddGnTabSysIpMap>>>>>>>>>>>>>>>>>>>>>");
	}
	
	@Test
	public void testUpdateGnTabSysIpMap(){
		System.out.println("<<<<<<<<<<<<<<<<<<<<<testUpdateGnTabSysIpMap>>>>>>>>>>>>>>>>>>>>>");
		
		GnTabSysIpMapParamVO tabSysIpMapParamVO = new GnTabSysIpMapParamVO();
		tabSysIpMapParamVO.setTenantId("BIS-ST");
		tabSysIpMapParamVO.setConnectIp("10.1.228.222");
		tabSysIpMapParamVO.setConnectPort("14141");
		tabSysIpMapParamVO.setSystemId("test");
		tabSysIpMapParamVO.setMappedId("http://10.1.228.222/test");
		tabSysIpMapParamVO.setRemark("修改测试");
		GnTabSysIpMapResponseVO addTabSysIpMapPageInfo = gnTabSysIpMap.updateTabSysIpMapPageInfo(tabSysIpMapParamVO);
		System.out.println("结果集： "+addTabSysIpMapPageInfo.getResponseCode() + "  " +addTabSysIpMapPageInfo.getRespondeDesc());
		
		System.out.println("<<<<<<<<<<<<<<<<<<<<<testUpdateGnTabSysIpMap>>>>>>>>>>>>>>>>>>>>>");
	}
}
