package com.github.jntakpe.bfbdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Contrôleur de gestion des métriques
 *
 * @author jntakpe
 */
@Controller
public class MetricsController {

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String administration() {
        return "metrics";
    }
}
