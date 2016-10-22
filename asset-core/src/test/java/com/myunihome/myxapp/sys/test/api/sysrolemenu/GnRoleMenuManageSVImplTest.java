package com.myunihome.myxapp.sys.test.api.sysrolemenu;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.sys.api.sysrolemenu.interfaces.IGnRoleMenuManageSV;
import com.myunihome.myxapp.sys.api.sysrolemenu.param.GnRoleMenuParamsVO;
import com.myunihome.myxapp.sys.api.sysrolemenu.param.GnRoleMenuResponseVO;
import com.myunihome.myxapp.sys.api.sysrolemenu.param.GnRoleMenuVO;
import com.myunihome.myxapp.sys.util.DateTimeUtil;

import net.sf.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/core-context.xml")
public class GnRoleMenuManageSVImplTest {

    @Autowired
    private IGnRoleMenuManageSV gnRoleMenuManageSVImpl;

    @Test
    @Ignore
    public void testAddMenuToRole() throws Exception {
        System.out.println("testAddMenuToRole begin>>>>>>>>>>>>>");
        
        GnRoleMenuParamsVO gnRoleMenuParamsVO = new GnRoleMenuParamsVO();
        gnRoleMenuParamsVO.setTenantId("BIS-ST");
        gnRoleMenuParamsVO.setMenuId((long) 111);
        gnRoleMenuParamsVO.setMenuName("Junit测试菜单");
        gnRoleMenuParamsVO.setRoleId((long) 111);
        gnRoleMenuParamsVO.setRoleName("Junit测试角色");
        
        gnRoleMenuParamsVO.setCreateOperId((long) 10);
        gnRoleMenuParamsVO.setActiveTime(DateTimeUtil.getCurrTimestamp());
        gnRoleMenuParamsVO.setInactiveTime(DateTimeUtil.stringToTimstamp("2099-12-31"));
        
        Long roleMenuRelId = gnRoleMenuManageSVImpl.addMenuToRole(gnRoleMenuParamsVO);
        System.out.println("roleMenuRelId: " + roleMenuRelId);
        
        System.out.println("testAddMenuToRole  end >>>>>>>>>>>>>");
    }
    
    @Test
    @Ignore
    public void testQueryMenuByRole() throws Exception {
        System.out.println("testQueryMenuByRole begin>>>>>>>>>>>>>");
        
        GnRoleMenuParamsVO gnRoleMenuParamsVO = new GnRoleMenuParamsVO();
        gnRoleMenuParamsVO.setTenantId("BIS-ST");
        //gnRoleMenuParamsVO.setRoleId((long) 111);
        //gnRoleMenuParamsVO.setRoleName("Junit测试角色");
        PageInfo<GnRoleMenuVO> pageInfo = new PageInfo<GnRoleMenuVO>();
        pageInfo.setPageNo(1);
        pageInfo.setPageSize(5);
        gnRoleMenuParamsVO.setPageInfo(pageInfo);
        PageInfo<GnRoleMenuVO> pageResult = gnRoleMenuManageSVImpl.queryMenuByRole(gnRoleMenuParamsVO);
        if(pageResult != null){
            System.out.println("count: " + pageResult.getCount());
            List<GnRoleMenuVO> resultList = pageResult.getResult();
            for(int i=0; i<resultList.size(); i++){
                GnRoleMenuVO currVO = resultList.get(i);
                System.out.println("vo: " + JSONObject.fromObject(currVO));
            }
        }
        
        System.out.println("testQueryMenuByRole  end >>>>>>>>>>>>>");
    }

	// @Test
	// @Ignore
	// public void testQueryRoleFilterIds() throws Exception {
	// System.out.println("testQueryRoleFilterIds begin>>>>>>>>>>>>>");
	// GnRoleMenuParamsVO roleMenuParamsVO = new GnRoleMenuParamsVO();
	// roleMenuParamsVO.setTenantId("BIS-ST");
	// roleMenuParamsVO.setRoleId(new Long("1"));
	// GnMenuParamsVO gnMenuParamsVO = new GnMenuParamsVO();
	// gnMenuParamsVO.setTenantId("BIS-ST");
	// PageInfo<GnMenuVO> pageInfo = new PageInfo<GnMenuVO>();
	// pageInfo.setPageNo(1);
	// pageInfo.setPageSize(5);
	// gnMenuParamsVO.setPageInfo(pageInfo);
	// PageInfo<GnMenuVO> pageResult =
	// gnRoleMenuManageSVImpl.queryMenuFilterIds(roleMenuParamsVO,gnMenuParamsVO);
	// if(pageResult != null){
	// System.out.println("count: " + pageResult.getCount());
	// List<GnMenuVO> resultList = pageResult.getResult();
	// for(int i=0; i<resultList.size(); i++){
	// GnMenuVO currVO = resultList.get(i);
	// System.out.println("vo: " + JSONObject.fromObject(currVO));
	// }
	// }
	// System.out.println("testQueryRoleFilterIds end>>>>>>>>>>>>>");
	// }
	
	@Test
	@Ignore
	public void testDelRoleOper() throws Exception {
		System.out.println("testDelRoleOper begin>>>>>>>>>>>>>");
		GnRoleMenuParamsVO roleMenuParamsVO = new GnRoleMenuParamsVO();
		roleMenuParamsVO.setTenantId("BIS-ST");
		roleMenuParamsVO.setRoleMenuRelId(3081L);
		GnRoleMenuResponseVO result = gnRoleMenuManageSVImpl.deleteRoleMenu(roleMenuParamsVO);
		if (result != null) {
			System.out.println(result.getRespondeDesc());
		}
		System.out.println("testDelRoleOper end>>>>>>>>>>>>>");
	}
	
	@Test
	public void testQueryRoleMenuById() throws Exception {
		System.out.println("testQueryRoleMenuById begin>>>>>>>>>>>>>");
		GnRoleMenuParamsVO roleMenuParamsVO = new GnRoleMenuParamsVO();
		roleMenuParamsVO.setTenantId("BIS-ST");
		roleMenuParamsVO.setRoleId(3071L);
		List<GnRoleMenuVO> roleMenuList = gnRoleMenuManageSVImpl.queryRoleMenuListByRoleId(roleMenuParamsVO);
		if(roleMenuList != null && roleMenuList.size()>0){
            System.out.println("count: " + roleMenuList.size());
            for(GnRoleMenuVO currVO : roleMenuList){
                System.out.println("vo: " + JSONObject.fromObject(currVO));
            }
        }
		System.out.println("testQueryRoleMenuById end>>>>>>>>>>>>>");
	}
}