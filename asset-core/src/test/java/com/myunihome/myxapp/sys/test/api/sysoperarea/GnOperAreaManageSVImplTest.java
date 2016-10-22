package com.myunihome.myxapp.sys.test.api.sysoperarea;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.sys.api.sysoperarea.interfaces.IGnOperAreaManageSV;
import com.myunihome.myxapp.sys.api.sysoperarea.param.GnOperAreaParamsVO;
import com.myunihome.myxapp.sys.api.sysoperarea.param.GnOperAreaResponseVO;
import com.myunihome.myxapp.sys.api.sysoperarea.param.GnOperAreaVO;
import com.myunihome.myxapp.sys.api.sysoperarea.param.GnStaffAreaPageQueryVO;
import com.myunihome.myxapp.sys.api.sysoperarea.param.GnStaffAreaQueryVO;
import com.myunihome.myxapp.sys.api.sysoperarea.param.GnStaffOperVO;

import net.sf.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/core-context.xml")
public class GnOperAreaManageSVImplTest {

	@Autowired
	private IGnOperAreaManageSV operAreaManageSV;

	@Test
	public void testAddRoleToOper() throws Exception {
		System.out.println("testAddRoleToOper begin>>>>>>>>>>>>>");
		GnOperAreaParamsVO operAreaParamsVO = new GnOperAreaParamsVO();
		operAreaParamsVO.setTenantId("BIS-ST");
		operAreaParamsVO.setOperId(3031L);
		operAreaParamsVO.setAreaCode("100002");
		GnOperAreaResponseVO result = operAreaManageSV.addAreaToOper(operAreaParamsVO);
		System.out.println("desc:" + result.getRespondeDesc() + ", code:" + result.responseCode);
		System.out.println("testAddRoleToOper end>>>>>>>>>>>>>");
	}

	@Test
	public void testQueryAreaByOper() throws Exception {
		System.out.println("testQueryAreaByOper begin>>>>>>>>>>>>>");
		GnOperAreaParamsVO operAreaParamsVO = new GnOperAreaParamsVO();
		operAreaParamsVO.setTenantId("BIS-ST");
		operAreaParamsVO.setOperId(30312L);
		PageInfo<GnOperAreaVO> pageInfo = new PageInfo<GnOperAreaVO>();
		pageInfo.setPageNo(1);
		pageInfo.setPageSize(5);
		operAreaParamsVO.setPageInfo(pageInfo);
		PageInfo<GnOperAreaVO> pageResult = operAreaManageSV.queryAreaPageByOperId(operAreaParamsVO);
		if (pageResult != null) {
			System.out.println("count: " + pageResult.getCount());
			List<GnOperAreaVO> resultList = pageResult.getResult();
			for (int i = 0; i < resultList.size(); i++) {
				GnOperAreaVO currVO = resultList.get(i);
				System.out.println("vo: " + JSONObject.fromObject(currVO));
			}
		}
		System.out.println("testQueryAreaByOper end>>>>>>>>>>>>>");
	}

	@Test
	public void testQueryAreaListByOper() throws Exception {
		System.out.println("testQueryAreaListByOper begin>>>>>>>>>>>>>");
		GnOperAreaParamsVO operAreaParamsVO = new GnOperAreaParamsVO();
		operAreaParamsVO.setTenantId("BIS-ST");
		operAreaParamsVO.setOperId(3031L);
		List<GnOperAreaVO> resultList = operAreaManageSV.queryAreaListByOperId(operAreaParamsVO);
		if (resultList != null) {
			System.out.println("count: " + resultList.size());
			for (int i = 0; i < resultList.size(); i++) {
				GnOperAreaVO currVO = resultList.get(i);
				System.out.println("vo: " + JSONObject.fromObject(currVO));
			}
		}
		System.out.println("testQueryAreaListByOper end>>>>>>>>>>>>>");
	}

	@Test
	public void testDelRoleArea() throws Exception {
		System.out.println("testDelRoleArea begin>>>>>>>>>>>>>");
		GnOperAreaParamsVO operAreaParamsVO = new GnOperAreaParamsVO();
		operAreaParamsVO.setTenantId("BIS-ST");
		operAreaParamsVO.setOperAreaRelId(31L);
		// operAreaParamsVO.setOperId(3031L);
		GnOperAreaResponseVO result = operAreaManageSV.deleteOperArea(operAreaParamsVO);
		if (result != null) {
			System.out.println(result.getRespondeDesc());
		}
		System.out.println("testDelRoleArea end>>>>>>>>>>>>>");
	}
	
	@Test
	public void testQueryStaffOperListByOper() throws Exception {
		System.out.println("testQueryAreaListByOper begin>>>>>>>>>>>>>");
		GnStaffAreaQueryVO sataffAreaParamsVO = new GnStaffAreaQueryVO();
		sataffAreaParamsVO.setTenantId("BIS-ST");
		sataffAreaParamsVO.setAreaCode("500014");
		sataffAreaParamsVO.setStaffName("张");
		//sataffAreaParamsVO.setStaffNo("ST_lizhe");
		List<GnStaffOperVO> resultList = operAreaManageSV.queryStaffOperListByArea(sataffAreaParamsVO);
		if (resultList != null) {
			System.out.println("count: " + resultList.size());
			for (int i = 0; i < resultList.size(); i++) {
				GnStaffOperVO currVO = resultList.get(i);
				System.out.println("vo: " + JSONObject.fromObject(currVO));
			}
		}
		System.out.println("testQueryAreaListByOper end>>>>>>>>>>>>>");
	}
	
	@Test
	public void testQueryStaffOperPageByOper() throws Exception {
		System.out.println("testQueryStaffOperPageByOper begin>>>>>>>>>>>>>");
		GnStaffAreaPageQueryVO sataffAreaParamsVO = new GnStaffAreaPageQueryVO();
		sataffAreaParamsVO.setTenantId("BIS-ST");
		sataffAreaParamsVO.setAreaCode("500014");
		sataffAreaParamsVO.setPageSize(5);
		sataffAreaParamsVO.setPageNo(1);
		sataffAreaParamsVO.setStaffName("李");
		//sataffAreaParamsVO.setStaffNo("ST_lizhe");
		PageInfo<GnStaffOperVO> resultData = operAreaManageSV.queryStaffOperPageInfoByArea(sataffAreaParamsVO);
		if (resultData != null) {
			System.out.println("count: " + resultData.getCount());
			List<GnStaffOperVO> resultList = resultData.getResult();
			for (int i = 0; i < resultList.size(); i++) {
				GnStaffOperVO currVO = resultList.get(i);
				System.out.println("vo: " + JSONObject.fromObject(currVO));
			}
		}
		System.out.println("testQueryStaffOperPageByOper end>>>>>>>>>>>>>");
	}

}
