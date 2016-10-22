package com.myunihome.myxapp.sys.test.api.sysoperrole;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.sys.api.sysoperrole.interfaces.IGnOperRoleManageSV;
import com.myunihome.myxapp.sys.api.sysoperrole.param.GnOperRoleParamsVO;
import com.myunihome.myxapp.sys.api.sysoperrole.param.GnOperRoleResponseVO;
import com.myunihome.myxapp.sys.api.sysoperrole.param.GnOperRoleVO;

import net.sf.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/core-context.xml")
public class GnOperRoleManageSVImplTest {

	@Autowired
	private IGnOperRoleManageSV operRoleManageSV;

	@Test
	@Ignore
	public void testAddRoleToOper() throws Exception {
		System.out.println("testAddRoleToOper begin>>>>>>>>>>>>>");
		GnOperRoleParamsVO operRoleParamsVO = new GnOperRoleParamsVO();
		operRoleParamsVO.setTenantId("BIS-ST");
		operRoleParamsVO.setStaffnoId(new Long("104"));
		operRoleParamsVO.setRoleId(new Long("302"));
		operRoleParamsVO.setRoleName("厅长");
		GnOperRoleResponseVO result = operRoleManageSV.addRoleToOper(operRoleParamsVO);
		System.out.println("desc:" + result.getRespondeDesc() + ", code:" + result.responseCode);
		System.out.println("testAddRoleToOper end>>>>>>>>>>>>>");
	}

	@Test
	@Ignore
	public void testQueryRoleByOper() throws Exception {
		System.out.println("testQueryRoleByOper begin>>>>>>>>>>>>>");
		GnOperRoleParamsVO operRoleParamsVO = new GnOperRoleParamsVO();
		operRoleParamsVO.setTenantId("BIS-ST");
		operRoleParamsVO.setStaffnoId(new Long("104"));
		PageInfo<GnOperRoleVO> pageInfo = new PageInfo<GnOperRoleVO>();
		pageInfo.setPageNo(1);
		pageInfo.setPageSize(5);
		operRoleParamsVO.setPageInfo(pageInfo);
		PageInfo<GnOperRoleVO> pageResult = operRoleManageSV.queryRoleByOperId(operRoleParamsVO);
		if (pageResult != null) {
			System.out.println("count: " + pageResult.getCount());
			List<GnOperRoleVO> resultList = pageResult.getResult();
			for (int i = 0; i < resultList.size(); i++) {
				GnOperRoleVO currVO = resultList.get(i);
				System.out.println("vo: " + JSONObject.fromObject(currVO));
			}
		}
		System.out.println("testQueryRoleByOper end>>>>>>>>>>>>>");
	}

	// @Test
	// public void testQueryRoleFilterIds() throws Exception {
	// System.out.println("testQueryRoleFilterIds begin>>>>>>>>>>>>>");
	// GnOperRoleParamsVO operRoleParamsVO = new GnOperRoleParamsVO();
	// operRoleParamsVO.setTenantId("BIS-ST");
	// operRoleParamsVO.setOperId(new Long("211"));
	// GnRoleParamsVO gnRoleParamsVO = new GnRoleParamsVO();
	// gnRoleParamsVO.setTenantId("BIS-ST");
	// gnRoleParamsVO.setRoleName("1111");
	// PageInfo<GnRoleVO> pageInfo = new PageInfo<GnRoleVO>();
	// pageInfo.setPageNo(1);
	// pageInfo.setPageSize(5);
	// gnRoleParamsVO.setPageInfo(pageInfo);
	// PageInfo<GnRoleVO> pageResult =
	// operRoleManageSV.queryRoleFilterIds(operRoleParamsVO, gnRoleParamsVO);
	// if (pageResult != null) {
	// System.out.println("count: " + pageResult.getCount());
	// List<GnRoleVO> resultList = pageResult.getResult();
	// if(resultList!=null)
	// for (int i = 0; i < resultList.size(); i++) {
	// GnRoleVO currVO = resultList.get(i);
	// System.out.println("vo: " + JSONObject.fromObject(currVO));
	// }
	// }
	// System.out.println("testQueryRoleFilterIds end>>>>>>>>>>>>>");
	// }
	
	@Test
	@Ignore
	public void testDelRoleOper() throws Exception {
		System.out.println("testDelRoleOper begin>>>>>>>>>>>>>");
		GnOperRoleParamsVO operRoleParamsVO = new GnOperRoleParamsVO();
		operRoleParamsVO.setTenantId("BIS-ST");
		operRoleParamsVO.setOperRoleRelId(3045L);
		GnOperRoleResponseVO result = operRoleManageSV.deleteOperRole(operRoleParamsVO);
		if (result != null) {
			System.out.println(result.getRespondeDesc());
		}
		System.out.println("testDelRoleOper end>>>>>>>>>>>>>");
	}
	
	@Test
	public void testQueryOperRoleListById() throws Exception {
		System.out.println("testQueryOperRoleListById begin>>>>>>>>>>>>>");
		GnOperRoleParamsVO operRoleParamsVO = new GnOperRoleParamsVO();
		operRoleParamsVO.setTenantId("BIS-ST");
		operRoleParamsVO.setStaffnoId(3031L);
		List<GnOperRoleVO> operRoleList = operRoleManageSV.queryOperRoleListByOperId(operRoleParamsVO);
		if (operRoleList != null && operRoleList.size() > 0) {
			System.out.println("cout:"+ operRoleList.size());
			for(GnOperRoleVO operRoleVO : operRoleList){
				System.out.println("vo: " + JSONObject.fromObject(operRoleVO));
			}
		}
		System.out.println("testQueryOperRoleListById end>>>>>>>>>>>>>");
	}

}
