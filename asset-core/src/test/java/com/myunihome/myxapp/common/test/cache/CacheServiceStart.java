package com.myunihome.myxapp.common.test.cache;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myunihome.myxapp.common.cache.GnSysParamCache;
import com.myunihome.myxapp.utils.cache.base.AbstractCache;

public final class CacheServiceStart {

    private static final Logger LOG = LoggerFactory.getLogger(CacheServiceStart.class);

    private static final String PATH = "classpath:context/core-context.xml";
    private CacheServiceStart(){}
    public static void main(String[] args) {
        LOG.info("开始刷新缓存......");
        @SuppressWarnings("resource")
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { PATH });
        context.start();
        Map<String, AbstractCache> caches = context
                .getBeansOfType(AbstractCache.class);
        for (AbstractCache cache : caches.values()) {
           if(cache instanceof GnSysParamCache){
               System.out.println("执行第一次");
               try {
                   cache.write();
               } catch (Exception ex) {
                   LOG.error("缓存写入失败",ex);
               } 
           }
           

        }
        // 刷新缓存结束，需要提示
        LOG.info("缓存刷新结束,请通过日志查看是否刷新成功.....");
    }
}
