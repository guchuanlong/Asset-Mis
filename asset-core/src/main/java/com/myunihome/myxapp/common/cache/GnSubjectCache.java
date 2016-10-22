package com.myunihome.myxapp.common.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.myunihome.myxapp.common.constants.CacheNSMapper;
import com.myunihome.myxapp.common.dao.mapper.bo.GnSubject;
import com.myunihome.myxapp.common.service.business.subject.IGnSubjectBusiSV;
import com.myunihome.myxapp.common.util.CacheFactoryUtil;
import com.myunihome.myxapp.common.util.GnSubjectUtil;
import com.myunihome.myxapp.paas.cache.client.ICacheClient;
import com.myunihome.myxapp.paas.util.CollectionUtil;
import com.myunihome.myxapp.utils.cache.base.AbstractCache;

/**
 * 科目编码和科目类型缓存类 <br>
 * 缓存key为subjectId 缓存对象融合了FUN_SUBJECT和FUN_SUBJECT_FUND <br>
 * Date: 2015年8月19日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
@Component
public class GnSubjectCache extends AbstractCache {

    private static final Logger logger = LoggerFactory.getLogger(GnSubjectCache.class);

    @Autowired
    private IGnSubjectBusiSV funSubjectBusiSV;

    @Override
    public void write() throws Exception {
        List<GnSubject> funSubjectList = funSubjectBusiSV.queryGnSubject();
        if (CollectionUtil.isEmpty(funSubjectList)) {
            return;
        }
        ICacheClient cacheClient = CacheFactoryUtil.getCacheClient(CacheNSMapper.CACHE_GN_SUBJECT);
        Map<String, List<GnSubject>> subjectTypeMap = new HashMap<String, List<GnSubject>>();
        for (GnSubject funSubject : funSubjectList) {
            logger.debug("缓存GnSubject科目:行业{},租户ID{},科目ID{},名称{}", funSubject.getIndustryCode(),
                    funSubject.getTenantId(), funSubject.getSubjectId(),
                    funSubject.getSubjectName());
            String key1 = GnSubjectUtil.generateKey(funSubject.getIndustryCode(),
                    funSubject.getTenantId(), funSubject.getSubjectId());
            // JSONObject subjectJson = JSON.parseObject(JSON.toJSONString(funSubject));
            // 缓存key1数据
            cacheClient.hset(CacheNSMapper.CACHE_GN_SUBJECT, key1, JSON.toJSONString(funSubject));
            // 组装key2数据
            String key2 = GnSubjectUtil.generateKey(funSubject.getIndustryCode(),
                    funSubject.getTenantId(), funSubject.getSubjectType());
            if (!subjectTypeMap.containsKey(key2)) {
                List<GnSubject> subject = new ArrayList<GnSubject>();
                subjectTypeMap.put(key2, subject);
            }
            subjectTypeMap.get(key2).add(funSubject);
        }
        // 缓存key2
        for (Entry<String, List<GnSubject>> subjectTypeEntry : subjectTypeMap.entrySet()) {
            logger.debug("缓存GnSubject科目【按照科目类型缓存】行业+租户ID+科目类型{},科目数量{}", subjectTypeEntry.getKey(),
                    subjectTypeEntry.getValue().size());
            String key2 = subjectTypeEntry.getKey();
            // JSONArray subjectJson =
            // JSON.parseArray(JSON.toJSONString(subjectTypeEntry.getValue()));
            cacheClient.hset(CacheNSMapper.CACHE_GN_SUBJECT, key2,
                    JSON.toJSONString(subjectTypeEntry.getValue()));
        }
    }

}
