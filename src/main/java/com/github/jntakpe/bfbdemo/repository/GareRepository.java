package com.github.jntakpe.bfbdemo.repository;

import com.github.jntakpe.bfbdemo.domain.Gare;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Méthode permettant de manipuler {@link com.github.jntakpe.bfbdemo.domain.Gare}
 *
 * @author jntakpe
 */
public interface GareRepository extends JpaRepository<Gare, Integer> {
}
