package com.myunihome.myxapp.sys.test.api.sysmenu;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.myunihome.myxapp.sys.api.framepage.interfaces.IProviderForFramePageSV;
import com.myunihome.myxapp.sys.api.framepage.param.Menu;
import com.myunihome.myxapp.sys.api.framepage.param.MenuQuery;
import com.myunihome.myxapp.sys.api.framepage.param.SystemContext;
import com.myunihome.myxapp.sys.api.framepage.param.SystemContextQuery;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/core-context.xml")
public class FramePageMenuTest {

    @Autowired
    private IProviderForFramePageSV framePageMenuSV;

    @Test
    public void testFramePageFirstLevelMenuByCondition() throws Exception {
        System.out.println("testFramePageMenuByCondition begin>>>>>>>>>>>>>");
        
        MenuQuery query = new MenuQuery();
        //query.setSystemId("runner-common-center");
        query.setTenantId("VIV-BYD");
        query.setOperId(200L);
        //query.setSystemModeId("GGGL");
        
        List<Menu> resultList = framePageMenuSV.queryFirstLevelMenusByLimited(query);
        System.out.println("param: " + JSON.toJSONString(query));
        System.out.println("vo: " + JSON.toJSONString(resultList));
        System.out.println("testFramePageMenuByCondition  end >>>>>>>>>>>>>");
    }
    @Test
    public void testFramePageSubsMenuByCondition() throws Exception {
    	System.out.println("testFramePageMenuByCondition begin>>>>>>>>>>>>>");
    	
    	MenuQuery query = new MenuQuery();
    	query.setSystemId("runner-common-center");
    	query.setTenantId("BIS-ST");
    	query.setOperId(311L);
    	query.setSystemModeId("GGGL");
    	query.setMenuPid(-1L);
    	
    	List<Menu> resultList = framePageMenuSV.queryFirstLevelMenusByLimited(query);
    	System.out.println("param: " + JSON.toJSONString(query));
    	System.out.println("vo: " + JSON.toJSONString(resultList));
    	System.out.println("testFramePageMenuByCondition  end >>>>>>>>>>>>>");
    }
    
    @Test
    public void testFramePageSystemContext() throws Exception {
    	System.out.println("testFramePageSystemContext begin>>>>>>>>>>>>>");
    	
    	SystemContextQuery query = new SystemContextQuery();
    	query.setTenantId("CLC-BYD");
    	
    	List<SystemContext> resultList = framePageMenuSV.querySystemContextList(query);
    	System.out.println("param: " + JSON.toJSONString(query));
    	System.out.println("vo: " + JSON.toJSONString(resultList));
    	System.out.println("testFramePageSystemContext  end >>>>>>>>>>>>>");
    }
    
}