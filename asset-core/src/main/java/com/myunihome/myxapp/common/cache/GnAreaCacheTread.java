package com.myunihome.myxapp.common.cache;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.myunihome.myxapp.common.constants.CacheNSMapper;
import com.myunihome.myxapp.common.dao.mapper.bo.GnArea;
import com.myunihome.myxapp.common.util.CacheFactoryUtil;
import com.myunihome.myxapp.paas.cache.client.ICacheClient;

public class GnAreaCacheTread extends Thread{
    private List<GnArea> resultList;
    ICacheClient cacheClient = CacheFactoryUtil.getCacheClient(CacheNSMapper.CACHE_GN_AREA);
    
    public GnAreaCacheTread(List<GnArea> resultList){
        this.resultList=resultList;
    }
    @Override
    public void run() {
        for (GnArea area : resultList) {
          
            String key=(area.getAreaCode()+"."+area.getTenantId()).toUpperCase();
            cacheClient.hset(CacheNSMapper.CACHE_GN_AREA, key, JSON.toJSONString(area));
        } 
    } 
}
