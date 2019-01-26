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
public class Katedra {
    
    private int katedraId;
    private String nazivKatedre;
    private String delatnostKatedre;

    public Katedra() {
    }

    public Katedra(int katedraId, String nazivKatedre, String delatnostKatedre) {
        this.katedraId = katedraId;
        this.nazivKatedre = nazivKatedre;
        this.delatnostKatedre = delatnostKatedre;
    }

    public int getKatedraId() {
        return katedraId;
    }

    public void setKatedraId(int katedraId) {
        this.katedraId = katedraId;
    }

    public String getNazivKatedre() {
        return nazivKatedre;
    }

    public void setNazivKatedre(String nazivKatedre) {
        this.nazivKatedre = nazivKatedre;
    }

    public String getDelatnostKatedre() {
        return delatnostKatedre;
    }

    public void setDelatnostKatedre(String delatnostKatedre) {
        this.delatnostKatedre = delatnostKatedre;
    }

    @Override
    public String toString() {
        return this.nazivKatedre;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Katedra other = (Katedra) obj;
        if (this.katedraId != other.katedraId) {
            return false;
        }
        if (!this.getNazivKatedre().equals(other.getNazivKatedre())) {
            return false;
        }
        return true;
    }
    
    
    
}
