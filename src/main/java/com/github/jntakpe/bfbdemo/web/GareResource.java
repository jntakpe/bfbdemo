package com.github.jntakpe.bfbdemo.web;

import com.github.jntakpe.bfbdemo.domain.Gare;
import com.github.jntakpe.bfbdemo.service.GareCacheService;
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

    @Autowired
    private GareCacheService gareCacheService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Gare> cacheContent() {
        return gareCacheService.find();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Collection<Gare> clean() {
        gareCacheService.clean();
        return gareCacheService.find();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Collection<Gare> load() throws IOException {
        gareCacheService.load();
        return gareCacheService.find();
    }

}
