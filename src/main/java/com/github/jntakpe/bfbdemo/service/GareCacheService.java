package com.github.jntakpe.bfbdemo.service;

import com.github.jntakpe.bfbdemo.config.CacheConfig;
import com.github.jntakpe.bfbdemo.domain.Gare;
import com.github.jntakpe.bfbdemo.repository.GareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Collection;

/**
 * Services de gestion du cache
 *
 * @author jntakpe
 */
@Service
@Transactional
public class GareCacheService {

    @Autowired
    private GareRepository gareRepository;

    @Autowired
    private GareService gareService;

    @Cacheable(value = CacheConfig.GARE_CACHE)
    public Collection<Gare> find() {
        try {
            Thread.sleep(5000L); //Ne pas faire à la maison
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return gareRepository.findAll();
    }

    @CacheEvict(value = CacheConfig.GARE_CACHE, allEntries = true)
    public void clean() {
        gareRepository.deleteAll();
    }

    @CacheEvict(value = CacheConfig.GARE_CACHE, allEntries = true)
    public void load() throws IOException {
        gareRepository.save(gareService.loadFromCsv());
    }
}
