/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class PlanPokrivenostiNastave {
    
    private int ppnId;
    private String godina;
    private List<StavkaPPN> stavkePPN;

    public PlanPokrivenostiNastave() {
    }

    public PlanPokrivenostiNastave(int ppnId, String godina, List<StavkaPPN> stavkePPN) {
        this.ppnId = ppnId;
        this.godina = godina;
        stavkePPN = new ArrayList<>();
    }

    public int getPpnId() {
        return ppnId;
    }

    public void setPpnId(int ppnId) {
        this.ppnId = ppnId;
    }

    public String getGodina() {
        return godina;
    }

    public void setGodina(String godina) {
        this.godina = godina;
    } 
    
    
}
