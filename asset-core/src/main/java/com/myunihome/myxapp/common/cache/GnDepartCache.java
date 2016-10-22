package com.myunihome.myxapp.common.cache;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.myunihome.myxapp.common.constants.CacheNSMapper;
import com.myunihome.myxapp.common.constants.Constants;
import com.myunihome.myxapp.common.dao.mapper.bo.GnDepart;
import com.myunihome.myxapp.common.dao.mapper.bo.GnDepartCriteria;
import com.myunihome.myxapp.common.util.CacheFactoryUtil;
import com.myunihome.myxapp.paas.cache.client.ICacheClient;
import com.myunihome.myxapp.sso.dao.mapper.factory.MapperFactory;
import com.myunihome.myxapp.utils.cache.base.AbstractCache;

@Component
public class GnDepartCache extends AbstractCache {
    @Override
    public void write() throws Exception {
        GnDepartCriteria criteria = new GnDepartCriteria();
        criteria.createCriteria().andStateEqualTo(Constants.DepartState.ACTIVITY);
        List<GnDepart> resultList = MapperFactory.getGnDepartMapper().selectByExample(criteria);

        ICacheClient cacheClient = CacheFactoryUtil.getCacheClient(CacheNSMapper.CACHE_GN_DEPART);
        for (GnDepart depart : resultList) {
            cacheClient.hset(CacheNSMapper.CACHE_GN_DEPART, depart.getDepartId(), JSON.toJSONString(depart));
        }
    }
}
