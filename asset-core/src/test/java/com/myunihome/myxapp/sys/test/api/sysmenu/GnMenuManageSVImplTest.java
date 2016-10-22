package com.myunihome.myxapp.sys.test.api.sysmenu;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myunihome.myxapp.base.vo.PageInfo;
import com.myunihome.myxapp.sys.api.sysmenu.interfaces.IGnMenuManageSV;
import com.myunihome.myxapp.sys.api.sysmenu.param.GnMenuParamsVO;
import com.myunihome.myxapp.sys.api.sysmenu.param.GnMenuResponseVO;
import com.myunihome.myxapp.sys.api.sysmenu.param.GnMenuVO;
import com.myunihome.myxapp.sys.util.DateTimeUtil;

import net.sf.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/core-context.xml")
public class GnMenuManageSVImplTest {

    @Autowired
    private IGnMenuManageSV gnMenuManageSVImpl;

    @Test
    @Ignore
    public void testAddMenu() throws Exception {
        System.out.println("testAddMenu begin>>>>>>>>>>>>>");
        
        GnMenuParamsVO gnMenuParamsVO = new GnMenuParamsVO();
        gnMenuParamsVO.setMenuPid((long) -1);
        gnMenuParamsVO.setMenuUrl("aaa/bbb/ccc");
        gnMenuParamsVO.setMenuName("Junit测试菜单");
        gnMenuParamsVO.setSystemModeId("YWSL");
        gnMenuParamsVO.setTenantId("BIS-ST");
        gnMenuParamsVO.setCreateOperId((long) 10);
        Timestamp str = DateTimeUtil.getCurrTimestamp();
        gnMenuParamsVO.setInactiveTime(str);
        gnMenuParamsVO.setSystemId("runner-sys-menu");
        
        long menuId = gnMenuManageSVImpl.addMenu(gnMenuParamsVO);
        System.out.println("menuId: "+menuId);
        
        System.out.println("testAddMenu  end >>>>>>>>>>>>>");
    }
    
    @Test
    public void testUpdateMenu() throws Exception {
        System.out.println("testUpdateMenu begin>>>>>>>>>>>>>");
        
        GnMenuParamsVO gnMenuParamsVO = new GnMenuParamsVO();
        gnMenuParamsVO.setMenuId((long) 33);
        gnMenuParamsVO.setTenantId("BIS-ST");
        gnMenuParamsVO.setMenuName("订单开通处理1");
        
        GnMenuResponseVO result = gnMenuManageSVImpl.updateMenu(gnMenuParamsVO);
        System.out.println("code: "+result.getResponseCode() + ", desc: "+result.getRespondeDesc());
        
        System.out.println("testUpdateMenu  end >>>>>>>>>>>>>");
    }
    
    @Test
    public void testDelMenuByID() throws Exception {
        System.out.println("testDelMenuByID begin>>>>>>>>>>>>>");
        
        GnMenuParamsVO gnMenuParamsVO = new GnMenuParamsVO();
        gnMenuParamsVO.setMenuId((long) 3151);
        gnMenuParamsVO.setTenantId("BIS-ST");
        
        GnMenuResponseVO result = gnMenuManageSVImpl.delMenuByID(gnMenuParamsVO);
        System.out.println("code: "+result.getResponseCode() + ",desc: "+result.getRespondeDesc());
        
        System.out.println("testDelMenuByID  end >>>>>>>>>>>>>");
    }
    
    @Test
    @Ignore
    public void testQueryMenuById() throws Exception {
        System.out.println("testQueryMenuById begin>>>>>>>>>>>>>");
        
        GnMenuParamsVO gnMenuParamsVO = new GnMenuParamsVO();
        gnMenuParamsVO.setMenuId((long) 286);
        gnMenuParamsVO.setTenantId("BIS-ST");
        GnMenuVO gnMenuVO = gnMenuManageSVImpl.queryMenuById(gnMenuParamsVO);
        
        JSONObject gnMenuVOJson = JSONObject.fromObject(gnMenuVO);
        System.out.println("gnMenuVOJson：" + gnMenuVOJson);
        
        System.out.println("testQueryMenuById  end >>>>>>>>>>>>>");
    }
    
    @Test
    @Ignore
    public void testQueryMenu() throws Exception {
        System.out.println("testQueryMenu begin>>>>>>>>>>>>>");
        
        GnMenuParamsVO gnMenuParamsVO = new GnMenuParamsVO();
        //gnMenuParamsVO.setMenuId((long) 261);
        gnMenuParamsVO.setTenantId("BIS-ST");
        PageInfo<GnMenuVO> pageInfo = new PageInfo<GnMenuVO>();
        pageInfo.setPageNo(1);
        pageInfo.setPageSize(5);
        gnMenuParamsVO.setPageInfo(pageInfo);
        PageInfo<GnMenuVO> pageResult = gnMenuManageSVImpl.queryMenu(gnMenuParamsVO);
        if(pageResult != null){
            System.out.println("count: " + pageResult.getCount());
            List<GnMenuVO> resultList = pageResult.getResult();
            for(int i=0; i<resultList.size(); i++){
                GnMenuVO currVO = resultList.get(i);
                System.out.println("vo: " + JSONObject.fromObject(currVO));
            }
        }
        
        System.out.println("testQueryMenu  end >>>>>>>>>>>>>");
    }
    
    
    @Test
    public void testQueryMenuFilterIds() throws Exception {
        System.out.println("testQueryMenuFilterIds begin>>>>>>>>>>>>>");
        
        GnMenuParamsVO gnMenuParamsVO = new GnMenuParamsVO();
        gnMenuParamsVO.setTenantId("BIS-ST");
        PageInfo<GnMenuVO> pageInfo = new PageInfo<GnMenuVO>();
        pageInfo.setPageNo(1);
        pageInfo.setPageSize(5);
        gnMenuParamsVO.setPageInfo(pageInfo);
        List<Long> filterMenuIdList = new LinkedList<Long>();
        filterMenuIdList.add(3051L);
        filterMenuIdList.add(3052L);
        filterMenuIdList.add(3053L);
		gnMenuParamsVO.setFilterMenuIdList(filterMenuIdList );
        PageInfo<GnMenuVO> pageResult = gnMenuManageSVImpl.queryMenuFilterIds(gnMenuParamsVO);
        if(pageResult != null){
            System.out.println("count: " + pageResult.getCount());
            List<GnMenuVO> resultList = pageResult.getResult();
            for(int i=0; i<resultList.size(); i++){
                GnMenuVO currVO = resultList.get(i);
                System.out.println("vo: " + JSONObject.fromObject(currVO));
            }
        }
        
        System.out.println("testQueryMenuFilterIds  end >>>>>>>>>>>>>");
    }
}