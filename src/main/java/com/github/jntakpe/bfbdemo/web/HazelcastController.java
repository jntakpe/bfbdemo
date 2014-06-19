package com.github.jntakpe.bfbdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Contrôleur de l'écran relatif à Hazelcast
 *
 * @author jntakpe
 */
@Controller
@RequestMapping("/hazelcast")
public class HazelcastController {

    @RequestMapping(method = RequestMethod.GET)
    public String display() {
        return "hazelcast";
    }


}
