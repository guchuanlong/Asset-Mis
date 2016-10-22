package com.myunihome.myxapp.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.myunihome.myxapp.common.constants.CacheNSMapper;
import com.myunihome.myxapp.common.constants.Constants;
import com.myunihome.myxapp.common.dao.mapper.bo.GnDepart;
import com.myunihome.myxapp.paas.cache.client.ICacheClient;

/**
 * Created by astraea on 2015/8/6.
 */
public final class DepartCacheUtil {

    private DepartCacheUtil() {
    }

    private static final Logger logger = LoggerFactory.getLogger(DepartCacheUtil.class);

    public static String getDepartName(String departId) {
        try {
            if (StringUtils.isEmpty(departId)) {
                return null;
            }
            ICacheClient cacheClient = CacheFactoryUtil.getCacheClient(CacheNSMapper.CACHE_GN_DEPART);
            GnDepart result = JSON.parseObject(cacheClient.hget(CacheNSMapper.CACHE_GN_DEPART, departId), GnDepart.class);
            return result.getDepartName();
        } catch (Exception e) {
            logger.error("翻译部门Id[{}]失败.失败原因:{}", departId, e);
            return departId;
        }
    }
    /**
     * 获取指定租户下的departId对应的departName
     * @param tenantId
     * @param departId
     * @return
     * @author gucl
     * @ApiDocMethod
     * @ApiCode
     */
    public static String getDepartName(String tenantId,String departId) {
    	try {
    		if (StringUtils.isEmpty(tenantId)) {
    			return null;
    		}
    		if (StringUtils.isEmpty(departId)) {
    			return null;
    		}
    		ICacheClient cacheClient = CacheFactoryUtil.getCacheClient(CacheNSMapper.CACHE_GN_DEPART);
    		GnDepart result = JSON.parseObject(cacheClient.hget(CacheNSMapper.CACHE_GN_DEPART, departId), GnDepart.class);
    		if(result==null){
    			return null;
    		}
    		String departName=null;
    		if(Constants.TenantId.ALL_TENANT.equalsIgnoreCase(result.getTenantId())
    				||tenantId.equalsIgnoreCase(result.getTenantId())){
    			departName=result.getDepartName();
    		}
    		return departName;
    	} catch (Exception e) {
    		logger.error("翻译部门Id[{}]失败.失败原因:{}", departId, e);
    		return departId;
    	}
    }
    
    public static GnDepart getDepart(String tenantId,String departId) {
    	try {
    		if (StringUtils.isEmpty(tenantId)) {
    			return null;
    		}
    		if (StringUtils.isEmpty(departId)) {
    			return null;
    		}
    		ICacheClient cacheClient = CacheFactoryUtil.getCacheClient(CacheNSMapper.CACHE_GN_DEPART);
    		GnDepart result = JSON.parseObject(cacheClient.hget(CacheNSMapper.CACHE_GN_DEPART, departId), GnDepart.class);
    		if(result==null){
    			return null;
    		}
    		//校验租户的合法性
    		if(Constants.TenantId.ALL_TENANT.equalsIgnoreCase(result.getTenantId())
    				||tenantId.equalsIgnoreCase(result.getTenantId())){
    			return result;
    		}
    		return null;
    	} catch (Exception e) {
    		logger.error("翻译部门Id[{}]失败.失败原因:{}", departId, e);
    		return null;
    	}
    }

    public static void updateDepartCacheData(GnDepart gnDepartVo) {
        try {
            ICacheClient cacheClient = CacheFactoryUtil.getCacheClient(CacheNSMapper.CACHE_GN_DEPART);
            cacheClient.hset(CacheNSMapper.CACHE_GN_DEPART, gnDepartVo.getDepartId(), JSON.toJSONString(gnDepartVo));
        } catch (Exception e) {
            logger.error("更新部门缓存失败，失败原因:{}", e);
        }
    }
}
