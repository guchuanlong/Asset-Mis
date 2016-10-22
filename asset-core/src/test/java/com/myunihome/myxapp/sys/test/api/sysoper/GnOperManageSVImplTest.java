package com.myunihome.myxapp.sys.test.api.sysoper;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.sso.api.oper.interfaces.IOperatorSV;
import com.myunihome.myxapp.sso.api.oper.param.OperatorVo;
import com.myunihome.myxapp.sys.api.sysoper.interfaces.IGnOperManageSV;
import com.myunihome.myxapp.sys.api.sysoper.param.GnOperParamsVO;
import com.myunihome.myxapp.sys.api.sysoper.param.GnOperResponseVO;
import com.myunihome.myxapp.sys.api.sysoper.param.GnOperStaffQueryVO;
import com.myunihome.myxapp.sys.api.sysoper.param.GnOperVO;

import net.sf.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/core-context.xml")
public class GnOperManageSVImplTest {
	@Autowired
	private IOperatorSV iOperatorSV;

	@Autowired
	private IGnOperManageSV gnOperManageSV;

	@Test
	@Ignore
	public void testAddOper() throws Exception {
		System.out.println("testAddOper begin>>>>>>>>>>>>>");
		GnOperParamsVO gnOperParamsVO = new GnOperParamsVO();
		// gnOperParamsVO.setOperId(new Long("104"));
		gnOperParamsVO.setTenantId("BIS-ST");
		gnOperParamsVO.setOperCode("ST-TEST-ADD");
		gnOperParamsVO.setOrgId("100001");
		gnOperParamsVO.setOrgType("1");
		gnOperParamsVO.setStaffnoId(new Long("113"));
		gnOperParamsVO.setState("01");
		Long operId = gnOperManageSV.addOper(gnOperParamsVO);
		System.out.println("operId: " + operId);
		System.out.println("testAddOper end>>>>>>>>>>>>>");
	}

	@Test
	@Ignore
	public void testUpdateOper() throws Exception {
		System.out.println("testUpdateOper bengin>>>>>>>>>>>");
		GnOperParamsVO gnOperParamsVO = new GnOperParamsVO();
		gnOperParamsVO.setOperId(new Long("104"));
		gnOperParamsVO.setTenantId("BIS-ST");
		gnOperParamsVO.setOperCode("ST-TEST-UPDATE");
		gnOperParamsVO.setOrgId("100001");
		gnOperParamsVO.setOrgType("1");
		gnOperParamsVO.setStaffnoId(new Long("113"));
		gnOperParamsVO.setState("01");
		GnOperResponseVO result = gnOperManageSV.updateOper(gnOperParamsVO);
		System.out.println("desc:" + result.getRespondeDesc() + ", code:" + result.responseCode);
		System.out.println("testUpdateOper end>>>>>>>>>>>");
	}

	@Test
	@Ignore
	public void testDeleteOper() throws Exception {
		System.out.println("testDeleteOper bengin>>>>>>>>>>>");
		GnOperParamsVO gnOperParamsVO = new GnOperParamsVO();
		gnOperParamsVO.setOperId(new Long("104"));
		gnOperParamsVO.setTenantId("BIS-ST");
		GnOperResponseVO result = gnOperManageSV.delOperByID(gnOperParamsVO);
		System.out.println("desc:" + result.getRespondeDesc() + ", code:" + result.responseCode);
		System.out.println("testDeleteOper end>>>>>>>>>>>");
	}

	@Test
	@Ignore
	public void testQueryOperById() throws Exception {
		System.out.println("testQueryOperById begin>>>>>>>>>>>");
		GnOperParamsVO gnOperParamsVO = new GnOperParamsVO();
		gnOperParamsVO.setOperId(new Long("102"));
		gnOperParamsVO.setTenantId("BIS-ST");
		// gnOperParamsVO.setState("01");
		GnOperVO gnOperVO = gnOperManageSV.queryOperById(gnOperParamsVO);
		JSONObject gnOperVOJson = JSONObject.fromObject(gnOperVO);
		System.out.println("gnOperVOJson:" + gnOperVOJson);
		System.out.println("testQueryOperById end>>>>>>>>>>>");
	}

	@Test
	@Ignore
	public void testQueryOperList() throws Exception {
		System.out.println("testQueryOperList begin>>>>>>>>>>>");
		List<OperatorVo> list = iOperatorSV.checkStaffInfoBystaffno(291L, "BIS-TEST");
		System.out.println("list:" + JSON.toJSONString(list));
		System.out.println("testQueryOperList end>>>>>>>>>>>");
	}

	@Test
	public void testQueryOperPageInfo() throws Exception {
		System.out.println("testQueryOperPageInfo begin>>>>>>>>>>>");
		GnOperParamsVO gnOperParamsVO = new GnOperParamsVO();
		gnOperParamsVO.setTenantId("BIS-ST");
		PageInfo<GnOperVO> pageInfo = new PageInfo<GnOperVO>();
		pageInfo.setPageNo(1);
		pageInfo.setPageSize(5);
		gnOperParamsVO.setPageInfo(pageInfo);
		PageInfo<GnOperVO> gnOperVO = gnOperManageSV.queryOperPageInfo(gnOperParamsVO);
		JSONObject gnOperVOJson = JSONObject.fromObject(gnOperVO);
		System.out.println("gnOperVOJson:" + gnOperVOJson);
		System.out.println("testQueryOperPageInfo end>>>>>>>>>>>");
	}

	@Test
	public void testQueryOperListByStaff() throws Exception {
		System.out.println("testQueryOperListByStaff begin>>>>>>>>>>>");
		GnOperStaffQueryVO staffQueryVO = new GnOperStaffQueryVO();
		staffQueryVO.setTenantId("BIS-ST");
		staffQueryVO.setStaffName("测试");
		List<GnOperVO> gnOperVOList = gnOperManageSV.queryOperListByStaff(staffQueryVO);
		if (gnOperVOList != null) {
			System.out.println("count:" + gnOperVOList.size());
			for(GnOperVO gnOperVO : gnOperVOList){
				System.out.println( JSONObject.fromObject(gnOperVO));
			}
		}
		System.out.println("testQueryOperListByStaff end>>>>>>>>>>>");
	}
}
