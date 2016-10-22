package com.myunihome.myxapp.common.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.myunihome.myxapp.common.constants.CacheNSMapper;
import com.myunihome.myxapp.common.dao.mapper.bo.GnSettleRuleKey;
import com.myunihome.myxapp.common.service.business.subject.IGnSubjectBusiSV;
import com.myunihome.myxapp.common.util.CacheFactoryUtil;
import com.myunihome.myxapp.common.util.GnSubjectUtil;
import com.myunihome.myxapp.paas.cache.client.ICacheClient;
import com.myunihome.myxapp.paas.util.CollectionUtil;
import com.myunihome.myxapp.utils.cache.base.AbstractCache;

/**
 * 销账规则缓存
 *
 * Date: 2015年12月7日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
@Component
public class GnSettleRuleCache extends AbstractCache {

    private static final Logger logger = LoggerFactory.getLogger(GnSettleRuleCache.class);

    @Autowired
    private IGnSubjectBusiSV funSubjectBusiSV;

    @Override
    public void write() throws Exception {
        List<GnSettleRuleKey> settleRuleList = funSubjectBusiSV.queryGnSettleRule();
        if (CollectionUtil.isEmpty(settleRuleList)) {
            return;
        }
        ICacheClient cacheClient = CacheFactoryUtil
                .getCacheClient(CacheNSMapper.CACHE_GN_SETTLE_RULE);
        Map<String, List<GnSettleRuleKey>> settleRuleMap = new HashMap<String, List<GnSettleRuleKey>>();
        for (GnSettleRuleKey rule : settleRuleList) {
            String key = GnSubjectUtil.generateKey(rule.getIndustryCode(), rule.getTenantId(),
                    rule.getSubjectId());
            if (!settleRuleMap.containsKey(key)) {
                settleRuleMap.put(key, new ArrayList<GnSettleRuleKey>());
            }
            settleRuleMap.get(key).add(rule);
        }
        for (Entry<String, List<GnSettleRuleKey>> entry : settleRuleMap.entrySet()) {
            logger.info("缓存GnSettleRule科目:行业+租户ID+科目ID[{}],费用科目数量{}", entry.getKey(), entry
                    .getValue().size());
            cacheClient.hset(CacheNSMapper.CACHE_GN_SETTLE_RULE, entry.getKey(),
                    JSON.toJSONString(entry.getValue()));
        }
    }

}
