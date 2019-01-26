/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class Predmet {
    
    private int predmetId;
    private String nazivPredmeta;
    private String opisPredmeta;
    private String ciljPredmeta;
    private Katedra katedra;

    public Predmet() {
    }

    public Predmet(int predmetId, String nazivPredmeta, String opisPredmeta, String ciljPredmeta, Katedra katedra) {
        this.predmetId = predmetId;
        this.nazivPredmeta = nazivPredmeta;
        this.opisPredmeta = opisPredmeta;
        this.ciljPredmeta = ciljPredmeta;
        this.katedra = katedra;
    }

    public int getPredmetId() {
        return predmetId;
    }

    public void setPredmetId(int predmetId) {
        this.predmetId = predmetId;
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public String getOpisPredmeta() {
        return opisPredmeta;
    }

    public void setOpisPredmeta(String opisPredmeta) {
        this.opisPredmeta = opisPredmeta;
    }

    public String getCiljPredmeta() {
        return ciljPredmeta;
    }

    public void setCiljPredmeta(String ciljPredmeta) {
        this.ciljPredmeta = ciljPredmeta;
    }

    public Katedra getKatedra() {
        return katedra;
    }

    public void setKatedra(Katedra katedra) {
        this.katedra = katedra;
    }

    @Override
    public String toString() {
        return this.nazivPredmeta;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Predmet other = (Predmet) obj;
        if (this.predmetId != other.predmetId) {
            return false;
        }
        if (!Objects.equals(this.nazivPredmeta, other.nazivPredmeta)) {
            return false;
        }
        return true;
    }
    
    
    
}
