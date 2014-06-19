package com.github.jntakpe.bfbdemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Bean représentant une gare
 *
 * @author jntakpe
 */
@Entity
public class Gare implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    private String ville;

    private Short codeNavigo;

    public Gare() {
    }

    public Gare(String nom, String ville, Short codeNavigo) {
        this.nom = nom;
        this.ville = ville;
        this.codeNavigo = codeNavigo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Short getCodeNavigo() {
        return codeNavigo;
    }

    public void setCodeNavigo(Short codeNavigo) {
        this.codeNavigo = codeNavigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gare gare = (Gare) o;

        if (nom != null ? !nom.equals(gare.nom) : gare.nom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return nom != null ? nom.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Gare{" +
                "nom='" + nom + '\'' +
                ", ville='" + ville + '\'' +
                ", codeNavigo=" + codeNavigo +
                '}';
    }
}
