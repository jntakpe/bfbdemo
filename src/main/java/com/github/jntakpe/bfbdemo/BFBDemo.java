package com.github.jntakpe.bfbdemo;

import com.github.jntakpe.bfbdemo.service.GareService;
import com.github.jntakpe.bfbdemo.service.Jdk6GareService;
import com.github.jntakpe.bfbdemo.service.Jdk8GareService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Classe mère de l'application
 *
 * @author jntakpe
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class BFBDemo {

    public static final String FICHIER_GARES = "C:\\jprojects\\bfbdemo\\src\\main\\resources\\gares-transilien.csv";

    /**
     * Main de l'application
     *
     * @param args paramètres de ligne de commande
     */
    public static void main(String[] args) throws IOException {
        GareService jdk6GareService = new Jdk6GareService();
        GareService jdk8GareService = new Jdk8GareService();
        System.out.println("NB JDK6 Gares : " + jdk6GareService.loadFromCsv().size());
        System.out.println("NB JDK8 Gares : " + jdk8GareService.loadFromCsv().size());
        System.out.println("JDK 6 classement zones : " + jdk6GareService.sortGareByZone());
        System.out.println("JDK 8 classement zones : " + jdk8GareService.sortGareByZone());
        SpringApplication.run(BFBDemo.class, args);
    }
}
