package com.myunihome.myxapp.common.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.myunihome.myxapp.common.api.cache.param.SysParam;
import com.myunihome.myxapp.common.constants.CacheNSMapper;
import com.myunihome.myxapp.common.dao.mapper.bo.GnSysParam;
import com.myunihome.myxapp.common.dao.mapper.bo.GnSysParamCriteria;
import com.myunihome.myxapp.common.util.CacheFactoryUtil;
import com.myunihome.myxapp.paas.cache.client.ICacheClient;
import com.myunihome.myxapp.paas.util.CollectionUtil;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;
import com.myunihome.myxapp.utils.cache.base.AbstractCache;

@Component
public class GnSysParamCache extends AbstractCache {
    private static final Logger logger = LoggerFactory.getLogger(GnSysParamCache.class);

    @Override
    public void write() throws Exception {
        GnSysParamCriteria sql = new GnSysParamCriteria();
        sql.setOrderByClause(" dispord asc");
        List<GnSysParam> paramList = MapperFactory.getGnSysParamMapper().selectByExample(sql);
        if (CollectionUtil.isEmpty(paramList)) {
            return;
        }
        ICacheClient cacheClient = CacheFactoryUtil
                .getCacheClient(CacheNSMapper.CACHE_GN_SYS_PARAM);
        Map<String, List<SysParam>> map = new HashMap<String, List<SysParam>>();
        // List<GnTenant> gnTenants = null;

        for (GnSysParam gnSysParam : paramList) {
            SysParam sysParam = new SysParam();
            BeanUtils.copyProperties(sysParam, gnSysParam);
            String tenantId = gnSysParam.getTenantId();
            setSingleCache(cacheClient, map, gnSysParam, sysParam, tenantId);
        }
        for (Map.Entry<String, List<SysParam>> entry : map.entrySet()) {
            cacheClient.hset(CacheNSMapper.CACHE_GN_SYS_PARAM, entry.getKey(),
                    JSON.toJSONString(entry.getValue()));
        }
    }

    private void setSingleCache(ICacheClient cacheClient, Map<String, List<SysParam>> map,
            GnSysParam gnSysParam, SysParam sysParam, String tenantId) {
        StringBuilder keyOne = new StringBuilder();
        StringBuilder keyTwo;
        String strKeyOne;
        String strKeyTwo;
        strKeyOne = keyOne.append(gnSysParam.getTypeCode()).append(".")
                .append(gnSysParam.getParamCode()).append(".").append(tenantId).toString()
                .toUpperCase();
        keyTwo = new StringBuilder(keyOne);
        strKeyTwo = keyTwo.append(".").append(gnSysParam.getColumnValue()).toString().toUpperCase();
        if (!map.containsKey(strKeyOne)) {
            map.put(strKeyOne, new ArrayList<SysParam>());
        }
        map.get(strKeyOne).add(sysParam);

        cacheClient.hset(CacheNSMapper.CACHE_GN_SYS_PARAM, strKeyTwo, JSON.toJSONString(sysParam));
    }
}
