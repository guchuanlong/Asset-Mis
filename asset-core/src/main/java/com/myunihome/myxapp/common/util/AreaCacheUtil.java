package com.myunihome.myxapp.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.myunihome.myxapp.common.api.cache.param.Area;
import com.myunihome.myxapp.common.constants.CacheNSMapper;
import com.myunihome.myxapp.common.constants.Constants;
import com.myunihome.myxapp.common.dao.mapper.bo.GnArea;
import com.myunihome.myxapp.paas.cache.client.ICacheClient;
import com.myunihome.myxapp.paas.util.StringUtil;

/**
 * Area
 *
 * Date: 2015年11月11日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * @author gucl
 */
public final class AreaCacheUtil {

    private AreaCacheUtil() {
    }

    private static final Logger logger = LoggerFactory.getLogger(AreaCacheUtil.class);

    public static String getAreaName(String tenantId,String areaCode) {
        try {
        	if (StringUtils.isEmpty(tenantId)) {
    			return null;
    		}
            if (StringUtils.isEmpty(areaCode)) {
                return null;
            }
            String key=(areaCode+"."+tenantId).toUpperCase();
            ICacheClient cacheClient = CacheFactoryUtil.getCacheClient(CacheNSMapper.CACHE_GN_AREA);
            String data=cacheClient.hget(CacheNSMapper.CACHE_GN_AREA, key);
            if(StringUtil.isBlank(data)){
            	key=(areaCode+"."+Constants.TenantId.ALL_TENANT).toUpperCase();
            	data=cacheClient.hget(CacheNSMapper.CACHE_GN_AREA, key);
            }
            GnArea result = JSON.parseObject(data, GnArea.class);
            return result.getAreaName();
        } catch (Exception e) {
            logger.error("翻译区域AreaCode[{}]失败.失败原因:{}", areaCode, e);
            return areaCode;
        }
    }
    public static Area getArea(String tenantId,String areaCode) {
    	try {
    		
    		if (StringUtils.isEmpty(tenantId)) {
    			return null;
    		}
    		if (StringUtils.isEmpty(areaCode)) {
    			return null;
    		}
    		String key=(areaCode+"."+tenantId).toUpperCase();
    		ICacheClient cacheClient = CacheFactoryUtil.getCacheClient(CacheNSMapper.CACHE_GN_AREA);
    		String data=cacheClient.hget(CacheNSMapper.CACHE_GN_AREA, key);
            if(StringUtil.isBlank(data)){
            	key=(areaCode+"."+Constants.TenantId.ALL_TENANT).toUpperCase();
            	data=cacheClient.hget(CacheNSMapper.CACHE_GN_AREA, key);
            }
            return  JSON.parseObject(data, Area.class);
    	} catch (Exception e) {
    		logger.error("获取区域Area[{}]失败.失败原因:{}", areaCode, e);
    	    return null;
    	}
    }

    public static void updateAreaCacheData(GnArea area) {
        try {
            ICacheClient cacheClient = CacheFactoryUtil.getCacheClient(CacheNSMapper.CACHE_GN_AREA);
            String key=(area.getAreaCode()+"."+area.getTenantId()).toUpperCase();
            cacheClient.hset(CacheNSMapper.CACHE_GN_AREA, key, JSON.toJSONString(area));
        } catch (Exception e) {
            logger.error("更新区域缓存失败，失败原因:{}", e);
        }
    }
}
