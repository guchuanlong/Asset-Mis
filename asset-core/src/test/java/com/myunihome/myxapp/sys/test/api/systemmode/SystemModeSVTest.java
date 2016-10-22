package com.myunihome.myxapp.sys.test.api.systemmode;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.myunihome.myxapp.sso.api.systemmode.interfaces.ISystemModeSV;
import com.myunihome.myxapp.sso.api.systemmode.mapper.SystemModeListQueryVO;
import com.myunihome.myxapp.sso.api.systemmode.mapper.SystemModeQueryVO;
import com.myunihome.myxapp.sso.api.systemmode.mapper.SystemModeVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/core-context.xml")
public class SystemModeSVTest {
	
	@Autowired
	ISystemModeSV iSystemModeSV;
	
	@Test
	public void testQuerySystemModeById(){
		System.out.println("<<<<<<<<<<<<<<<<testQuerySystemModeById>>>>>>>>>>>>>>>>");
		SystemModeQueryVO systemModeQueryVO = new SystemModeQueryVO();
		systemModeQueryVO.setSystemModeId("XTGL");
		systemModeQueryVO.setTenantId("BIS-ST");
		SystemModeVO systemModeVO = iSystemModeSV.querySystemModeByID(systemModeQueryVO );
		System.out.println(JSON.toJSONString(systemModeVO));
		System.out.println("<<<<<<<<<<<<<<<<testQuerySystemModeById>>>>>>>>>>>>>>>>");
	}
	
	@Test
	public void testQuerySystemModeList(){
		System.out.println("<<<<<<<<<<<<<<<<testQuerySystemModeList>>>>>>>>>>>>>>>>");
		SystemModeListQueryVO systemModeListQueryVO = new SystemModeListQueryVO();
		systemModeListQueryVO.setTenantId("BIS-ST");
		List<SystemModeVO> systemModeVOList = iSystemModeSV.querySystemModeList(systemModeListQueryVO);
		System.out.println("count:"+systemModeVOList.size());
		System.out.println(JSON.toJSONString(systemModeVOList));
		System.out.println("<<<<<<<<<<<<<<<<testQuerySystemModeList>>>>>>>>>>>>>>>>");
	}

}
