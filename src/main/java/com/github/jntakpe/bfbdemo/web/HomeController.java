package com.github.jntakpe.bfbdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Contrôleur de la page d'accueil
 *
 * @author jntakpe
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayHome() {
        return "test";
    }
}
