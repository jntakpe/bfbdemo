package com.github.jntakpe.bfbdemo.web;

import com.github.jntakpe.bfbdemo.domain.Gare;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Publication de la resource {@link com.github.jntakpe.bfbdemo.domain.Gare}
 *
 * @author jntakpe
 */
@RestController
@RequestMapping("/gare")
public class GareResource {

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Gare> cacheContent() {
        System.out.println("GET");
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Collection<Gare> clean() {
        System.out.println("DELETE");
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Collection<Gare> load() {
        System.out.println("POST");
        return new ArrayList<>();
    }

}
