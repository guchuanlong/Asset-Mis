package com.myunihome.myxapp.common.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.myunihome.myxapp.common.api.cache.param.ServiceRouteConfig;
import com.myunihome.myxapp.common.constants.CacheNSMapper;
import com.myunihome.myxapp.common.dao.mapper.bo.GnServiceRouteConfig;
import com.myunihome.myxapp.common.dao.mapper.bo.GnServiceRouteConfigCriteria;
import com.myunihome.myxapp.common.util.CacheFactoryUtil;
import com.myunihome.myxapp.paas.cache.client.ICacheClient;
import com.myunihome.myxapp.paas.util.CollectionUtil;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;
import com.myunihome.myxapp.utils.cache.base.AbstractCache;

@Component
public class GnServiceRouteConfigCache extends AbstractCache {
    private static final Logger logger = LoggerFactory.getLogger(GnServiceRouteConfigCache.class);

    @Override
    public void write() throws Exception {
        List<GnServiceRouteConfig> resultList = MapperFactory.getGnServiceRouteConfigMapper().selectByExample(
                new GnServiceRouteConfigCriteria());
        if (CollectionUtil.isEmpty(resultList)) {
            return;
        }
        ICacheClient cacheClient = CacheFactoryUtil.getCacheClient(CacheNSMapper.CACHE_GN_CFG_PROPERTIES);
        Map<String, List<ServiceRouteConfig>> map = new HashMap<String, List<ServiceRouteConfig>>();

        StringBuilder keyOne;
        StringBuilder keyTwo;
        String strKeyOne = "";
        String strKeyTwo = "";
        for (GnServiceRouteConfig gnServiceRouteConfig : resultList) {
            ServiceRouteConfig routeConfig = new ServiceRouteConfig();
            BeanUtils.copyProperties(routeConfig, gnServiceRouteConfig);
            keyOne = new StringBuilder();
            strKeyOne = keyOne.append(gnServiceRouteConfig.getServiceType()).append(".").append(gnServiceRouteConfig.getRouteParamName())
                    .append(".").append(gnServiceRouteConfig.getTenantId()).toString().toUpperCase();
            keyTwo = new StringBuilder(keyOne);
            strKeyTwo = keyTwo.append(".").append(gnServiceRouteConfig.getRouteParamValue()).toString().toUpperCase();

            if (!map.containsKey(strKeyOne)) {
                map.put(strKeyOne, new ArrayList<ServiceRouteConfig>());
            }
            map.get(strKeyOne).add(routeConfig);

            cacheClient.hset(CacheNSMapper.CACHE_GN_SERVICE_ROUTE_CONFIG, strKeyTwo, JSON.toJSONString(routeConfig));
            //logger.debug("GnServiceRouteConfigCache strKeyOne="+strKeyOne);
            //logger.debug("GnServiceRouteConfigCache strKeyTwo="+strKeyTwo);
        }
        for (Map.Entry<String, List<ServiceRouteConfig>> entry : map.entrySet()) {
            cacheClient.hset(CacheNSMapper.CACHE_GN_SERVICE_ROUTE_CONFIG, entry.getKey(), JSON.toJSONString(entry.getValue()));
        }
    }
}
