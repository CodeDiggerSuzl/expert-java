package org.expert.caffeine;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class CaffeineBuildDemo {
    private static final LoadingCache<String, String> currentStockCache = Caffeine.newBuilder()
            .recordStats()
            .build(key -> {
                log.info("load currentStockCache with key: {}", key);
                String value = getValue(key);
                log.info("load currentStockCache with key: {}, value: {}", key, value);
                return value;
            });


    static String getValue(String key) {
        return StringUtils.reverse(key);
    }

    public static void main(String[] args) {
        String superStr = currentStockCache.get("super");
        System.out.println(superStr);
        System.out.println(currentStockCache.stats());

        String man = currentStockCache.get("man");
        System.out.println(man);
        System.out.println(currentStockCache);
    }
}
