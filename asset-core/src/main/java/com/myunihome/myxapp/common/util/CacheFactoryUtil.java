package com.myunihome.myxapp.common.util;

import com.myunihome.myxapp.paas.cache.CacheFactory;
import com.myunihome.myxapp.paas.cache.client.ICacheClient;

public final class CacheFactoryUtil {

    private CacheFactoryUtil() {
    }

    public static ICacheClient getCacheClient(String namespace) {
        return CacheFactory.getCacheClient(namespace);
    }

}
