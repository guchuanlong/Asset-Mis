package com.myunihome.myxapp.common.util;

import com.alibaba.fastjson.JSON;
import com.myunihome.myxapp.common.api.cache.param.CfgProperties;
import com.myunihome.myxapp.common.constants.CacheNSMapper;
import com.myunihome.myxapp.common.constants.Constants;
import com.myunihome.myxapp.paas.cache.client.ICacheClient;
import com.myunihome.myxapp.paas.util.StringUtil;

public final class CfgPropertiesUtil {

    private CfgPropertiesUtil() {
    }

    public static CfgProperties getCfgProperties(String tenantId, String cfgType, String cfgProperty) {
        ICacheClient cacheClient = CacheFactoryUtil
                .getCacheClient(CacheNSMapper.CACHE_GN_CFG_PROPERTIES);
        String key = (cfgType + "." + cfgProperty + "." + tenantId).toUpperCase();
        String data = cacheClient.hget(CacheNSMapper.CACHE_GN_CFG_PROPERTIES, key);
        if(StringUtil.isBlank(data)){//若查不到数据，则查询租户为ALL的缓存
        	key = (cfgType + "." + cfgProperty + "." + Constants.TenantId.ALL_TENANT).toUpperCase();
            data = cacheClient.hget(CacheNSMapper.CACHE_GN_CFG_PROPERTIES, key);
        }
        return JSON.parseObject(data, CfgProperties.class);
    }

}
