package com.github.jntakpe.bfbdemo.service;

import com.github.jntakpe.bfbdemo.domain.Gare;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Publication des méthodes de gestion des gares du transilien
 *
 * @author jntakpe
 */
public interface GareService {

    /**
     * Lecture du fichier de gares et ajout dans un set.
     *
     * @return set de gares
     */
    Set<Gare> loadFromCsv() throws IOException;

    /**
     * Classe les gares par zones et puis renvoi une liste triée par les zones avec le plus de gares
     *
     * @return liste de paires clé/valeur triée par la valeur
     */
    List<Map.Entry<Short, Long>> sortGareByZone() throws IOException;


}
