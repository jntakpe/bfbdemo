package com.github.jntakpe.bfbdemo.service;

import com.github.jntakpe.bfbdemo.BFBDemo;
import com.github.jntakpe.bfbdemo.domain.Gare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Implémentation du JDK6
 * 
 * @author jntakpe
 */
public class Jdk6GareService implements GareService {

    @Override
    public Set<Gare> loadFromCsv() throws IOException {
        Set<Gare> gares = new HashSet<Gare>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(BFBDemo.FICHIER_GARES));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] split = line.split(";");
                gares.add(new Gare(split[5], split[8], new Short(split[12])));
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return gares;
    }

    @Override
    public List<Map.Entry<Short, Long>> sortGareByZone() throws IOException {
        return null;
    }
}
