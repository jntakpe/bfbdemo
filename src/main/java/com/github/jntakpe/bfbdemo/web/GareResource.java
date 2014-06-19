package com.github.jntakpe.bfbdemo.web;

import com.github.jntakpe.bfbdemo.config.CacheConfig;
import com.github.jntakpe.bfbdemo.domain.Gare;
import com.github.jntakpe.bfbdemo.service.GareService;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collection;

/**
 * Publication de la resource {@link com.github.jntakpe.bfbdemo.domain.Gare}
 *
 * @author jntakpe
 */
@RestController
@RequestMapping("/gare")
public class GareResource {

    private static IMap<String, Gare> gareCache = CacheConfig.getHazelcastInstance().getMap(CacheConfig.GARE_CACHE);

    @Autowired
    private GareService gareService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Gare> cacheContent() {
        return gareCache.values();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Collection<Gare> clean() {
        gareCache.clear();
        return gareCache.values();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Collection<Gare> load() throws IOException {
        gareService.loadFromCsv().forEach(gare -> gareCache.put(gare.getNom(), gare));
        return gareCache.values();
    }

}
