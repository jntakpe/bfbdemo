package com.github.jntakpe.bfbdemo.service;

import com.github.jntakpe.bfbdemo.BFBDemo;
import com.github.jntakpe.bfbdemo.domain.Gare;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implémentation du JDK6
 *
 * @author jntakpe
 */
@Service
public class Jdk8GareService implements GareService {

    @Override
    public Set<Gare> loadFromCsv() throws IOException {
        return Files.lines(Paths.get(BFBDemo.FICHIER_GARES)).map( line -> {
            String[] split = line.split(";");
            return new Gare(split[5], split[8], new Short(split[12]));
        }).collect(Collectors.toSet());
    }

    @Override
    public List<Map.Entry<Short, Long>> sortGareByZone() throws IOException {
        return loadFromCsv().stream().collect(
                Collectors.groupingBy(
                        Gare::getCodeNavigo,
                        Collectors.counting()
                )
        ).entrySet().stream().sorted(Comparator.comparing(entry -> -entry.getValue())).collect(Collectors.toList());
    }
}
