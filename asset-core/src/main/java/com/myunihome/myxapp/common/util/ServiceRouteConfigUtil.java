package com.myunihome.myxapp.common.util;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.myunihome.myxapp.common.api.cache.param.ServiceRouteConfig;
import com.myunihome.myxapp.common.constants.CacheNSMapper;
import com.myunihome.myxapp.paas.cache.client.ICacheClient;

public final class ServiceRouteConfigUtil {

    private ServiceRouteConfigUtil() {
    }

    public static List<ServiceRouteConfig> getServiceRouteConfigs(String tenantId, String serviceType, String routeParamName) {
        ICacheClient cacheClient = CacheFactoryUtil
                .getCacheClient(CacheNSMapper.CACHE_GN_SERVICE_ROUTE_CONFIG);
        String key = (serviceType + "." + routeParamName + "." + tenantId).toUpperCase();
        String data = cacheClient.hget(CacheNSMapper.CACHE_GN_SERVICE_ROUTE_CONFIG, key);
        return JSONArray.parseArray(data, ServiceRouteConfig.class);
    }

    public static ServiceRouteConfig getServiceRouteConfig(String tenantId, String serviceType, String routeParamName,
                                       String routeParamValue) {
        ICacheClient cacheClient = CacheFactoryUtil
                .getCacheClient(CacheNSMapper.CACHE_GN_SERVICE_ROUTE_CONFIG);
        String key = (serviceType + "." + routeParamName + "." + tenantId + "." + routeParamValue)
                .toUpperCase();
        String data = cacheClient.hget(CacheNSMapper.CACHE_GN_SERVICE_ROUTE_CONFIG, key);
        return JSON.parseObject(data, ServiceRouteConfig.class);
    }

}
