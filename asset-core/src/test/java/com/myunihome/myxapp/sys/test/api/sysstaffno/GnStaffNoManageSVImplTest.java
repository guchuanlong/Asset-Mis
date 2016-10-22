package com.myunihome.myxapp.sys.test.api.sysstaffno;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.paas.util.Md5Encoder;
import com.myunihome.myxapp.sso.api.stafflogin.interfaces.IStaffLoginSV;
import com.myunihome.myxapp.sso.api.stafflogin.param.OperIdVo;
import com.myunihome.myxapp.sso.api.stafflogin.param.StaffLoginVo;
import com.myunihome.myxapp.sso.api.stafflogin.param.StaffNoResponseVO;
import com.myunihome.myxapp.sso.api.stafflogin.param.StaffnoPasswdVo;
import com.myunihome.myxapp.sys.api.sysstaffno.interfaces.IGnStaffNoManageSV;
import com.myunihome.myxapp.sys.api.sysstaffno.param.GnStaffNoParamsVO;
import com.myunihome.myxapp.sys.api.sysstaffno.param.GnStaffNoPasswdVO;
import com.myunihome.myxapp.sys.api.sysstaffno.param.GnStaffNoResponseVO;
import com.myunihome.myxapp.sys.api.sysstaffno.param.GnStaffNoVO;
import com.myunihome.myxapp.sys.util.DateTimeUtil;

import net.sf.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/core-context.xml")
public class GnStaffNoManageSVImplTest {
    
	@Autowired
	private IGnStaffNoManageSV GnStaffNoManageSVImpl;
	@Autowired
	private IStaffLoginSV iStaffLoginSV;
	
	@Test
    public void testAddStaffNo() throws Exception {
        System.out.println("testAddStaffNo begin>>>>>>>>>>>>>");

        GnStaffNoParamsVO gnStaffNoParamsVO = new GnStaffNoParamsVO();
        gnStaffNoParamsVO.setTenantId("BIS-ST");
        gnStaffNoParamsVO.setRemark("");
        gnStaffNoParamsVO.setCreateOperId(311L);
        gnStaffNoParamsVO.setStaffId("0000000141");
        gnStaffNoParamsVO.setStaffPasswd("E10ADC3949BA59ABBE56E057F20F883E");
        gnStaffNoParamsVO.setStaffNo("ST_009");
        gnStaffNoParamsVO.setStaffName("测试账号");
        
        Timestamp inactiveTime = DateTimeUtil.stringToTimstamp("2099-12-31");
        gnStaffNoParamsVO.setActiveTime(DateTimeUtil.getCurrTimestamp());
        gnStaffNoParamsVO.setInactiveTime(inactiveTime);
        
        Long staffNoId = GnStaffNoManageSVImpl.addStaffNo(gnStaffNoParamsVO);

        System.out.println("staffNoId："  + staffNoId);
        System.out.println("testAddStaffNo  end >>>>>>>>>>>>>");
    }
	
	@Test
	public void testUpdateStaffNo() throws Exception {
	    System.out.println("testUpdateStaffNo begin>>>>>>>>>>>>>");
	    
	    GnStaffNoParamsVO gnStaffNoParamsVO = new GnStaffNoParamsVO();
	    gnStaffNoParamsVO.setStaffnoId((long) 291);
	    
	    gnStaffNoParamsVO.setTenantId("BIS-ST");
        gnStaffNoParamsVO.setRemark("");
        gnStaffNoParamsVO.setCreateOperId(311L);
        gnStaffNoParamsVO.setStaffId("0000000141");
        gnStaffNoParamsVO.setStaffPasswd("E10ADC3949BA59ABBE56E057F20F883E");
        gnStaffNoParamsVO.setStaffNo("ST_009");
        gnStaffNoParamsVO.setStaffName("测试账号");
	    GnStaffNoResponseVO response = GnStaffNoManageSVImpl.updateStaffNo(gnStaffNoParamsVO);
	    
	    System.out.println("response："  + response.responseCode + "，" + response.respondeDesc);
	    System.out.println("testUpdateStaffNo  end >>>>>>>>>>>>>");
	}
	
	@Test
    @Ignore
    public void testDelStaffNoByID() throws Exception {
        System.out.println("testDelStaffNoByID begin>>>>>>>>>>>>>");
        
        GnStaffNoParamsVO gnStaffNoParamsVO = new GnStaffNoParamsVO();
        gnStaffNoParamsVO.setTenantId("BIS-TEST");
        gnStaffNoParamsVO.setStaffnoId((long) 203);
        GnStaffNoResponseVO response = GnStaffNoManageSVImpl.delStaffNoByID(gnStaffNoParamsVO);
        
        System.out.println("response："  + response.responseCode + "，" + response.respondeDesc);
        System.out.println("testDelStaffNoByID  end >>>>>>>>>>>>>");
    }
	
	@Test
	public void testIsStaffNoUnique() throws Exception {
	    System.out.println("testIsStaffNoUnique begin>>>>>>>>>>>>>");
	    
	    GnStaffNoParamsVO gnStaffNoParamsVO = new GnStaffNoParamsVO();
	    gnStaffNoParamsVO.setTenantId("BIS-ST");
	    //gnStaffNoParamsVO.setStaffnoId((long) 21);
	    gnStaffNoParamsVO.setStaffNo("ST_009");
	    Boolean result = GnStaffNoManageSVImpl.isStaffNoUnique(gnStaffNoParamsVO);
	    
	    System.out.println("result（TRUE 唯一，FALSE 不唯一）："  + result);
	    System.out.println("testIsStaffNoUnique  end >>>>>>>>>>>>>");
	}

	@Test
	@Ignore
	public void testQueryStaffNoByStaffNoId() throws Exception {
		System.out.println("testQueryStaffNoByStaffNoId begin>>>>>>>>>>>>>");

		GnStaffNoParamsVO gnStaffNoParamsVO = new GnStaffNoParamsVO();
		gnStaffNoParamsVO.setStaffnoId((long) 21);
		gnStaffNoParamsVO.setTenantId("BIS-ST");
		GnStaffNoVO gnStaffNoVO = GnStaffNoManageSVImpl.queryStaffNoById(gnStaffNoParamsVO);

		JSONObject gnStaffNoVOJson = JSONObject.fromObject(gnStaffNoVO);
		System.out.println("gnRoleVOJson："  + gnStaffNoVOJson);

		System.out.println("testQueryStaffNoByStaffNoId  end >>>>>>>>>>>>>");
	}
	
	@Test
	@Ignore
	public void testQueryStaffNo(){
		System.out.println("testQueryStaffNo  end >>>>>>>>>>>>>");
		GnStaffNoParamsVO gnStaffNoParamsVO = new GnStaffNoParamsVO();
		
		gnStaffNoParamsVO.setTenantId("BIS-ST");
		gnStaffNoParamsVO.setStaffNo("ST_002");
		gnStaffNoParamsVO.setStaffName("白淑");
		gnStaffNoParamsVO.setInactiveTime(DateTimeUtil.getCurrTimestamp());
		PageInfo<GnStaffNoVO> pageInfo = new PageInfo<GnStaffNoVO>();
		pageInfo.setPageNo(1);
		pageInfo.setPageSize(5);
		gnStaffNoParamsVO.setPageInfo(pageInfo);
		PageInfo<GnStaffNoVO> pageResult = GnStaffNoManageSVImpl.queryStaffNo(gnStaffNoParamsVO);
		if(pageResult != null){
			System.out.println("count: " + pageResult.getCount());
			List<GnStaffNoVO> resultList = pageResult.getResult();
			for(int i=0; i<resultList.size(); i++){
				GnStaffNoVO currVO = resultList.get(i);
				System.out.println("vo: " + JSONObject.fromObject(currVO));
			}
		}

		System.out.println("testQueryStaffNo  end >>>>>>>>>>>>>");

	}
	
	@Test
	public void testQueryStaffNoInfoByStaffNo(){
		System.out.println("testQueryStaffNoInfoByStaffNo  end >>>>>>>>>>>>>");
		String staffNo="ST_001";
		StaffLoginVo vo= iStaffLoginSV.getStaffLoginBystaffno(staffNo);
		System.out.println("vo="+JSON.toJSONString(vo));
		System.out.println("testQueryStaffNoInfoByStaffNo  end >>>>>>>>>>>>>");

	}
	@Test
	public void testQueryStaffNoInfoByOperId(){
		System.out.println("testQueryStaffNoInfoByOperId  end >>>>>>>>>>>>>");
		String tenantId="BIS-ST";
		Long operId=3042L;
		
		OperIdVo operIdVo=new OperIdVo();
		operIdVo.setTenantId(tenantId);
		operIdVo.setOperId(operId);
		StaffLoginVo vo= iStaffLoginSV.getStaffLoginByOperId(operIdVo);
		
		
		System.out.println("vo="+JSON.toJSONString(vo));
		System.out.println("testQueryStaffNoInfoByOperId  end >>>>>>>>>>>>>");
		
	}
	
	@Test
	public void testupdateStaffPasswd(){
		System.out.println("testupdateStaffPasswd  end >>>>>>>>>>>>>");
		StaffnoPasswdVo staffnoPasswdVo=new StaffnoPasswdVo();
		staffnoPasswdVo.setTenantId("BIS-TEST");
		staffnoPasswdVo.setStaffNo("JXS_TEST_01");
		staffnoPasswdVo.setOldPassword("81dc9bdb52d04dc20036dbd8313ed055");
		String newPasswd = Md5Encoder.encodePassword("123456");
		System.out.println("new password :"+newPasswd);
		staffnoPasswdVo.setNewPassword(newPasswd);
		StaffNoResponseVO vo= iStaffLoginSV.updateStaffPasswd(staffnoPasswdVo);
		System.out.println("vo="+JSON.toJSONString(vo));
		System.out.println("testupdateStaffPasswd  end >>>>>>>>>>>>>");
		
	}
	
	@Test
	public void testResetStaffPasswd(){
		System.out.println("testResetStaffPasswd  end >>>>>>>>>>>>>");
		GnStaffNoPasswdVO staffnoPasswdVo=new GnStaffNoPasswdVO();
		staffnoPasswdVo.setTenantId("BIS-TEST");
		staffnoPasswdVo.setStaffNo("JXS_TEST_01");
		GnStaffNoResponseVO vo= GnStaffNoManageSVImpl.resetStaffPassword(staffnoPasswdVo);
		System.out.println("vo="+JSON.toJSONString(vo));
		System.out.println("testResetStaffPasswd  end >>>>>>>>>>>>>");
	}
}
