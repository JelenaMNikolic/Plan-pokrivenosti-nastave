/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author jelena
 */
public class StavkaPPN {
    
    private int stavkaPPNId;
    private Predmet predmet;
    private Nastavnik nastavnik;

    public StavkaPPN() {
    }

    public StavkaPPN(int stavkaPPNId, Predmet predmet, Nastavnik nastavnik) {
        this.stavkaPPNId = stavkaPPNId;
        this.predmet = predmet;
        this.nastavnik = nastavnik;
    }

    

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public Nastavnik getNastavnik() {
        return nastavnik;
    }

    public void setNastavnik(Nastavnik nastavnik) {
        this.nastavnik = nastavnik;
    }

    public int getStavkaPPNId() {
        return stavkaPPNId;
    }

    public void setStavkaPPNId(int stavkaPPNId) {
        this.stavkaPPNId = stavkaPPNId;
    }
    
    
    
}
