package com.myunihome.myxapp.common.cache;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.myunihome.myxapp.common.constants.CacheNSMapper;
import com.myunihome.myxapp.common.dao.mapper.bo.GnSubjectFund;
import com.myunihome.myxapp.common.service.business.subject.IGnSubjectBusiSV;
import com.myunihome.myxapp.common.util.CacheFactoryUtil;
import com.myunihome.myxapp.common.util.GnSubjectUtil;
import com.myunihome.myxapp.paas.cache.client.ICacheClient;
import com.myunihome.myxapp.paas.util.CollectionUtil;
import com.myunihome.myxapp.utils.cache.base.AbstractCache;

/**
 * 资金科目定义表FUN_SUBJECT_FUND <br>
 * 缓存key为subjectId 缓存对象FUN_SUBJECT_FUND <br>
 * Date: 2015年8月19日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
@Component
public class GnSubjectFundCache extends AbstractCache {

    private static final Logger logger = LoggerFactory.getLogger(GnSubjectFundCache.class);

    @Autowired
    private IGnSubjectBusiSV funSubjectBusiSV;

    @Override
    public void write() throws Exception {
        List<GnSubjectFund> funSubjectFundList = funSubjectBusiSV.queryGnSubjectFund();
        if (CollectionUtil.isEmpty(funSubjectFundList)) {
            return;
        }
        ICacheClient cacheClient = CacheFactoryUtil
                .getCacheClient(CacheNSMapper.CACHE_GN_SUBJECT_FUND);
        for (GnSubjectFund funSubjectFund : funSubjectFundList) {
            logger.info("缓存GnSubjectFund资金科目定义:行业{},租户ID{},科目ID{}",
                    funSubjectFund.getIndustryCode(), funSubjectFund.getTenantId(),
                    funSubjectFund.getSubjectId());
            String key = GnSubjectUtil.generateKey(funSubjectFund.getIndustryCode(),
                    funSubjectFund.getTenantId(), funSubjectFund.getSubjectId());
            JSONObject subjectJson = JSON.parseObject(JSON.toJSONString(funSubjectFund));
            cacheClient.hset(CacheNSMapper.CACHE_GN_SUBJECT_FUND, key, subjectJson.toJSONString());
        }
    }

}
