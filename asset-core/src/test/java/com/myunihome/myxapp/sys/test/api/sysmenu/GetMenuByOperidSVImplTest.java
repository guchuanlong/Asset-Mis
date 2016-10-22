package com.myunihome.myxapp.sys.test.api.sysmenu;

import java.util.List;

import net.sf.json.JSONObject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myunihome.myxapp.sso.api.menu.interfaces.IGetMenuByOperidSV;
import com.myunihome.myxapp.sso.api.menu.param.GetMenuByConditionVO;
import com.myunihome.myxapp.sso.api.menu.param.GetMenuByOperIDVO;
import com.myunihome.myxapp.sso.api.menu.param.GnParamsVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/core-context.xml")
public class GetMenuByOperidSVImplTest {

    @Autowired
    private IGetMenuByOperidSV getMenuByOperidSVImpl;

    @Test

    public void testGetMenuByCondition() throws Exception {
        System.out.println("testGetMenuByCondition begin>>>>>>>>>>>>>");
        
        GnParamsVO paramsVO = new GnParamsVO();
        
        paramsVO.setOperId((long) 412);
        paramsVO.setTenantId("BIS-ST");
        paramsVO.setSystemId("runner-bis-office");
        paramsVO.setSystemModeId("YWSL");
        
        List<GetMenuByConditionVO> resultList = getMenuByOperidSVImpl.getMenuByCondition(paramsVO);
        if(resultList != null){
            System.out.println("count: " + resultList.size());
            for(int i=0; i<resultList.size(); i++){
                GetMenuByConditionVO currVO = resultList.get(i);
                System.out.println("vo: " + JSONObject.fromObject(currVO));
            }
        }
        
        System.out.println("testGetMenuByCondition  end >>>>>>>>>>>>>");
    }
    
    @Test
    @Ignore
    public void testGetMenuByOperID() throws Exception {
        System.out.println("testGetMenuByOperID begin>>>>>>>>>>>>>");
        
        List<GetMenuByOperIDVO> resultList = getMenuByOperidSVImpl.getMenuByOperID((long) 412, "BIS-ST");
        System.out.println("resultList: " + resultList + " size="+resultList.size());
        
        System.out.println("testGetMenuByOperID  end >>>>>>>>>>>>>");
    }
    
}