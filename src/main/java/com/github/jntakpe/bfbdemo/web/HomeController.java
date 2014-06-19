package com.github.jntakpe.bfbdemo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Contrôleur de la page d'accueil
 *
 * @author jntakpe
 */
@Controller
public class HomeController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView displayHome() {
        return new ModelAndView("home").addObject("port", port).addObject("salle", "Paris");
    }
}
