package com.github.jntakpe.bfbdemo.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.instance.HazelcastInstanceFactory;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Configuration du cache
 *
 * @author jntakpe
 */
@Configuration
@EnableCaching
public class CacheConfig {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private static HazelcastInstance hazelcastInstance;

    @Bean
    public CacheManager cacheManager() {
        return new HazelcastCacheManager(hazelcastInstance);
    }

    @Bean
    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
    }

    public static HazelcastInstance getHazelcastInstance() {
        return hazelcastInstance;
    }

    @PreDestroy
    private void destroy() {
        log.info("Fermeture du CacheManager Hazelcast");
        Hazelcast.shutdownAll();
    }

    @PostConstruct
    private HazelcastInstance buildHazelcast() {
        log.info("Demarrage du CacheManager Hazelcast");
        Config config = new Config();
        config.setInstanceName("demobfb");
        config.getMapConfigs().put("gareCache", initializeDefaultMapConfig());
        hazelcastInstance = HazelcastInstanceFactory.newHazelcastInstance(config);
        return hazelcastInstance;
    }

    private MapConfig initializeDefaultMapConfig() {
        MapConfig mapConfig = new MapConfig();

        /*
            Number of backups. If 1 is set as the backup-count for example,
            then all entries of the map will be copied to another JVM for
            fail-safety. Valid numbers are 0 (no backup), 1, 2, 3.
         */
        mapConfig.setBackupCount(0);

        /*
            Valid values are:
            NONE (no eviction),
            LRU (Least Recently Used),
            LFU (Least Frequently Used).
            NONE is the default.
         */
        mapConfig.setEvictionPolicy(MapConfig.EvictionPolicy.NONE);

        /*
            Maximum size of the map. When max size is reached,
            map is evicted based on the policy defined.
            Any integer between 0 and Integer.MAX_VALUE. 0 means
            Integer.MAX_VALUE. Default is 0.
         */
        mapConfig.setMaxSizeConfig(new MaxSizeConfig(0, MaxSizeConfig.MaxSizePolicy.USED_HEAP_SIZE));

        /*
            When max. size is reached, specified percentage of
            the map will be evicted. Any integer between 0 and 100.
            If 25 is set for example, 25% of the entries will
            get evicted.
         */
        mapConfig.setEvictionPercentage(25);

        return mapConfig;
    }
}
