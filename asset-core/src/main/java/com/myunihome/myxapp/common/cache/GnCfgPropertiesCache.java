package com.myunihome.myxapp.common.cache;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.myunihome.myxapp.common.api.cache.param.CfgProperties;
import com.myunihome.myxapp.common.constants.CacheNSMapper;
import com.myunihome.myxapp.common.dao.mapper.bo.GnCfgProperties;
import com.myunihome.myxapp.common.dao.mapper.bo.GnCfgPropertiesCriteria;
import com.myunihome.myxapp.common.util.CacheFactoryUtil;
import com.myunihome.myxapp.paas.cache.client.ICacheClient;
import com.myunihome.myxapp.paas.util.CollectionUtil;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;
import com.myunihome.myxapp.utils.cache.base.AbstractCache;

@Component
public class GnCfgPropertiesCache extends AbstractCache {

    @Override
    public void write() throws Exception {
        List<GnCfgProperties> resultList = MapperFactory.getGnCfgPropertiesMapper()
                .selectByExample(new GnCfgPropertiesCriteria());
        if (CollectionUtil.isEmpty(resultList)) {
            return;
        }
        ICacheClient cacheClient = CacheFactoryUtil
                .getCacheClient(CacheNSMapper.CACHE_GN_CFG_PROPERTIES);

        for (GnCfgProperties gnCfgProperties : resultList) {
            CfgProperties cfgProperties = new CfgProperties();
            BeanUtils.copyProperties(cfgProperties, gnCfgProperties);
            String key = (gnCfgProperties.getCfgtype() + "." + gnCfgProperties.getProperty() + "."
                    + gnCfgProperties.getTenantId()).toUpperCase();
            cacheClient.hset(CacheNSMapper.CACHE_GN_CFG_PROPERTIES, key,
                    JSON.toJSONString(cfgProperties));
        }
    }
}
