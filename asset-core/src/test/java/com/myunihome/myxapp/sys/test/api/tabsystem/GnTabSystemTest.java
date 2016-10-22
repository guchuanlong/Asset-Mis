package com.myunihome.myxapp.sys.test.api.tabsystem;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.myunihome.myxapp.paas.util.JSonUtil;
import com.myunihome.myxapp.sso.api.system.interfaces.ITabSystemSV;
import com.myunihome.myxapp.sso.api.system.mapper.TabSystemQueryVO;
import com.myunihome.myxapp.sso.api.system.mapper.TabSystemVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/core-context.xml")
public class GnTabSystemTest {

	@Autowired
	ITabSystemSV iTabSystemSV;

	@Test
	public void testQueryGnTabSysIpMap() {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<testQueryGnTabSysIpMap>>>>>>>>>>>>>>>>>>>>>");

		TabSystemQueryVO tabSystemQueryVo = new TabSystemQueryVO();
		tabSystemQueryVo.setTenantId("BIS-ST");
		List<TabSystemVO> systemList = iTabSystemSV.queryTabSystemList(tabSystemQueryVo);
		if (systemList != null) {
			System.out.println("count： " + systemList.size());
			System.out.println("结果集： " + JSonUtil.toJSon(systemList));
		}

		System.out.println("<<<<<<<<<<<<<<<<<<<<<testQueryGnTabSysIpMap>>>>>>>>>>>>>>>>>>>>>");
	}
	
	@Test
	public void testGetGnTabSysIpMap() {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<testGetGnTabSysIpMap>>>>>>>>>>>>>>>>>>>>>");

		TabSystemQueryVO tabSystemQueryVo = new TabSystemQueryVO();
		tabSystemQueryVo.setTenantId("BIS-ST");
		tabSystemQueryVo.setSystemId("runner-common-center");
		TabSystemVO systemList = iTabSystemSV.getTabSystem(tabSystemQueryVo);
		
		System.out.println("param： " + JSON.toJSONString(tabSystemQueryVo));
		System.out.println("result： " + JSON.toJSONString(systemList));

		System.out.println("<<<<<<<<<<<<<<<<<<<<<testGetGnTabSysIpMap>>>>>>>>>>>>>>>>>>>>>");
	}


}
