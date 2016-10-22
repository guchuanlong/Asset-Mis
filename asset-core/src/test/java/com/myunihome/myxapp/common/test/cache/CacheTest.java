package com.myunihome.myxapp.common.test.cache;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.myunihome.myxapp.common.api.cache.impl.CacheSVImpl;
import com.myunihome.myxapp.common.api.cache.interfaces.ICacheSV;
import com.myunihome.myxapp.common.api.cache.param.Area;
import com.myunihome.myxapp.common.api.cache.param.CfgProperties;
import com.myunihome.myxapp.common.api.cache.param.Depart;
import com.myunihome.myxapp.common.api.cache.param.SysParam;
import com.myunihome.myxapp.common.cache.GnCfgPropertiesCache;
import com.myunihome.myxapp.common.cache.GnSysParamCache;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class CacheTest {
	@Autowired
	private GnCfgPropertiesCache cfgSV;
	@Autowired
	private GnSysParamCache paramSV;
	@Autowired
	private ICacheSV iCacheSV;
	
    @Test
    public void testWrite() throws Exception {
        CacheServiceStart.main(new String[] {});
    }

    @Test
    public void testWriteGnSysParam() throws Exception {

        ICacheSV cache = new CacheSVImpl();
        List<SysParam> clist = cache.getSysParams("ALL", "SERVICE_FETCH", "BUSI_CODE");
        SysParam cobj = cache.getSysParam("ALL", "SERVICE_FETCH", "BUSI_CODE", "fwbg-yysl");
        System.out.println("GnSysParam clist=" + JSON.toJSONString(clist));
        System.out.println("GnSysParam cobj=" + JSON.toJSONString(cobj.getDescb()));
    }

    @Test
    public void testWriteGnCfgProperties() throws Exception {

        ICacheSV cache = new CacheSVImpl();
        //List<CfgProperties> clist = (List<CfgProperties>) cache.getCfgProperties("BIS-ST", "FLOW_USER_AUDIT", "BUSI_CODE");
        CfgProperties cobj = cache
                .getCfgProperties("BIS-ST", "FLOW_USER_AUDIT", "BUSI_CODE");
        //System.out.println("GnCfgProperties clist=" + JSON.toJSONString(clist));
        System.out.println("GnCfgProperties cobj=" + JSON.toJSONString(cobj));
    }
    

    @Test
    public void getUUID() {
        System.out.println(UUID.randomUUID().toString());
    }
    
    @Test
    public void testReadGnSysParam() throws Exception {
    	//测试证件号码转换
        SysParam singleParam=iCacheSV.getSysParam("BIS-ST", "CHL_CHANNEL", "STATE", "1");
		List<SysParam> paramList=iCacheSV.getSysParams("BIS-ST", "CHL_CHANNEL", "STATE");
        		
		System.out.println("singleParam="+JSON.toJSONString(singleParam));
		System.out.println("paramList="+JSON.toJSONString(paramList));
    }
    
    @Test
	public void testCacheGnCfgProperties(){
		
		ICacheSV sv=new CacheSVImpl();
		CfgProperties cfg=sv.getCfgProperties("asdf", "FLOW_USER_AUDIT", "BUSI_CODE");
        		
		System.out.println("GnCfgProperties="+JSON.toJSONString(cfg));
	}
    
    @Test
	public void testCacheSysParam(){
		
		ICacheSV sv=new CacheSVImpl();
		SysParam singleParam=sv.getSysParam("all1", "CM_CUST", "STATE", "1");
		List<SysParam> paramList=sv.getSysParams("all1", "CM_CUST", "STATE");
        		
		System.out.println("singleParam="+JSON.toJSONString(singleParam));
		System.out.println("paramList="+JSON.toJSONString(paramList));
	}
    
    @Test
    public void testReadGnSysParam2() throws Exception {
    	//测试证件号码转换
        ICacheSV sv = new CacheSVImpl();
        SysParam singleParam=sv.getSysParam("BIS-TEST", "ORD_ORDER", "STATE", "11");
		System.out.println("singleParam="+JSON.toJSONString(singleParam));
    }
    
    @Test
    public void writeGnCfgProperties(){
    	try {
    		cfgSV.write();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Test
    public void writeGnSysParam(){
    	try {
    		paramSV.write();
    		System.out.println("wriete ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @Test
    public void testAreaCache(){
    	Area a=iCacheSV.getArea("BIS-ST", "500003");
    	System.out.println("a="+JSON.toJSONString(a));
    }
    @Test
    public void testDepartCache(){
    	String departName=iCacheSV.getDepartName("BIS-ST", "1100000071");
    	System.out.println("departName="+departName);
    }
    @Test
    public void testDepartAreaCache(){
    	Depart depart=iCacheSV.getDepart("BIS-ST", "1100000071");
    	System.out.println("depart="+JSON.toJSONString(depart));
    }
    
    
}