package com.myunihome.myxapp.sys.test.api.sysrole;

import java.util.LinkedList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.sys.api.sysrole.interfaces.IGnRoleManageSV;
import com.myunihome.myxapp.sys.api.sysrole.param.GnRoleParamsVO;
import com.myunihome.myxapp.sys.api.sysrole.param.GnRoleResponseVO;
import com.myunihome.myxapp.sys.api.sysrole.param.GnRoleVO;

import net.sf.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/core-context.xml")
public class GnRoleManageSVImplTest {


	@Autowired
    private IGnRoleManageSV gnRoleManageSVImpl;

	@Test
	@Ignore
    public void testQueryRoleById() throws Exception {
        System.out.println("testQueryMenuById begin>>>>>>>>>>>>>");

        GnRoleParamsVO gnRoleParamsVO = new GnRoleParamsVO();
        gnRoleParamsVO.setRoleId(211L);
        gnRoleParamsVO.setTenantId("BIS-ST");
        GnRoleVO gnRoleVO = gnRoleManageSVImpl.queryRoleById(gnRoleParamsVO);

        JSONObject gnRoleVOJson = JSONObject.fromObject(gnRoleVO);
        System.out.println("gnRoleVOJson：" + gnRoleVOJson);

        System.out.println("testQueryMenuById  end >>>>>>>>>>>>>");
    }

    @Test
    @Ignore
    public void testAddRole() throws Exception {
        System.out.println("testAddRole begin>>>>>>>>>>>>>");
        GnRoleParamsVO gnRoleParamsVO = new GnRoleParamsVO();
        gnRoleParamsVO.setRoleCode("testAddRole1");
        gnRoleParamsVO.setRoleName("厅长");
        gnRoleParamsVO.setRoleDesc("Junit测试添加角色");
        gnRoleParamsVO.setRoleLevel("1级");
        gnRoleParamsVO.setRolePid((long) -1);
        gnRoleParamsVO.setSystemId("runner-bis-test");
        gnRoleParamsVO.setSystemModeId("test");
        gnRoleParamsVO.setTenantId("BIS-ST");
        long roleId = gnRoleManageSVImpl.addRole(gnRoleParamsVO);
        System.out.println("roleId: " + roleId);
        System.out.println("testAddRole end>>>>>>>>>>>>>");
    }
    
    @Test
    @Ignore
    public void testUpdateRole() throws Exception {
        System.out.println("testUpdateRole begin>>>>>>>>>>>>>");
        GnRoleParamsVO gnRoleParamsVO = new GnRoleParamsVO();
        gnRoleParamsVO.setRoleId((long) 3031);
        gnRoleParamsVO.setRoleName("测试修改角色");
        gnRoleParamsVO.setRoleDesc("测试修改角色");
        gnRoleParamsVO.setTenantId("BIS-ST");
        GnRoleResponseVO result = gnRoleManageSVImpl.updateRole(gnRoleParamsVO);
        System.out.println("code: "+result.getResponseCode() + ",desc: "+result.getRespondeDesc());
        System.out.println("testUpdateRole end>>>>>>>>>>>>>");
    }
    @Ignore
    @Test
    public void testDelRole() throws Exception {
        System.out.println("testDelRole begin>>>>>>>>>>>>>");
        GnRoleParamsVO gnRoleParamsVO = new GnRoleParamsVO();
        gnRoleParamsVO.setRoleId((long) 201);
        gnRoleParamsVO.setTenantId("BIS-ST");
        GnRoleResponseVO result = gnRoleManageSVImpl.delRoleByID(gnRoleParamsVO);
        System.out.println("code: "+result.getResponseCode() + ",desc: "+result.getRespondeDesc());
        System.out.println("testDelRole end>>>>>>>>>>>>>");
    }

    @Test
    public void testQueryRole() throws Exception {
        System.out.println("testQueryRole begin>>>>>>>>>>>>>");
        
        GnRoleParamsVO gnRoleParamsVO = new GnRoleParamsVO();
        //gnRoleParamsVO.setRoleId((long) 3);
        gnRoleParamsVO.setTenantId("BIS-ST");
        PageInfo<GnRoleVO> pageInfo = new PageInfo<GnRoleVO>();
        pageInfo.setPageNo(1);
        pageInfo.setPageSize(5);
        gnRoleParamsVO.setPageInfo(pageInfo);
        PageInfo<GnRoleVO> pageResult = gnRoleManageSVImpl.queryRole(gnRoleParamsVO);
        if(pageResult != null){
            System.out.println("count: " + pageResult.getCount());
            List<GnRoleVO> resultList = pageResult.getResult();
            for(int i=0; i<resultList.size(); i++){
                GnRoleVO currVO = resultList.get(i);
                System.out.println("vo: " + JSONObject.fromObject(currVO));
            }
        }
        
        System.out.println("testQueryRole  end >>>>>>>>>>>>>");
    }
    
    @Test
    public void testQueryRoleFilterIds() throws Exception {
        System.out.println("testQueryRoleFilterIds begin>>>>>>>>>>>>>");
        
        GnRoleParamsVO gnRoleParamsVO = new GnRoleParamsVO();
        gnRoleParamsVO.setTenantId("BIS-ST");
        PageInfo<GnRoleVO> pageInfo = new PageInfo<GnRoleVO>();
        pageInfo.setPageNo(1);
        pageInfo.setPageSize(5);
        gnRoleParamsVO.setPageInfo(pageInfo);
        List<Long> filterRoleIdList = new LinkedList<Long>();
        filterRoleIdList.add(302L);
        filterRoleIdList.add(2000L);
        filterRoleIdList.add(3052L);
		gnRoleParamsVO.setFilterRoleIdList(filterRoleIdList );
		gnRoleParamsVO.setRoleName("管理1111");
        PageInfo<GnRoleVO> pageResult = gnRoleManageSVImpl.queryRoleFilterIds(gnRoleParamsVO);
        if(pageResult != null){
            System.out.println("count: " + pageResult.getCount());
            List<GnRoleVO> resultList = pageResult.getResult();
            if(resultList!=null)
            for(int i=0; i<resultList.size(); i++){
                GnRoleVO currVO = resultList.get(i);
                System.out.println("vo: " + JSONObject.fromObject(currVO));
            }
        }
        
        System.out.println("testQueryRoleFilterIds  end >>>>>>>>>>>>>");
    }
}