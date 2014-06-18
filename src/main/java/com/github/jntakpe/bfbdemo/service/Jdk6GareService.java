package com.github.jntakpe.bfbdemo.service;

import com.github.jntakpe.bfbdemo.BFBDemo;
import com.github.jntakpe.bfbdemo.domain.Gare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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
        Set<Gare> gares = loadFromCsv();
        Map<Short, Long> mapZoneNb = new TreeMap<Short, Long>();
        for (Gare gare : gares) {
            Short codeNavigo = gare.getCodeNavigo();
            if (mapZoneNb.get(codeNavigo) == null) {
                mapZoneNb.put(codeNavigo, 1L);
            } else {
                Long incrementedNb = mapZoneNb.get(codeNavigo);
                incrementedNb++;
                mapZoneNb.put(codeNavigo, incrementedNb);
            }
        }

        List<Map.Entry<Short, Long>> list = new ArrayList<Map.Entry<Short, Long>>(mapZoneNb.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Short,Long>>() {
            @Override public int compare(Map.Entry<Short,Long> gare1, Map.Entry<Short,Long> gare2) {
                return gare2.getValue().compareTo(gare1.getValue());
            }
        });
        return list;
    }
}
