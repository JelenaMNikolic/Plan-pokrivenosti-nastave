/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class PlanPokrivenostiNastave {
    
    private int ppnId;
    private Date godina;
    private List<StavkaPPN> stavkePPN;

    public PlanPokrivenostiNastave() {
    }

    public PlanPokrivenostiNastave(int ppnId, Date godina, List<StavkaPPN> stavkePPN) {
        this.ppnId = ppnId;
        this.godina = godina;
        this.stavkePPN = stavkePPN;
    }

    public int getPpnId() {
        return ppnId;
    }

    public void setPpnId(int ppnId) {
        this.ppnId = ppnId;
    }

    public Date getGodina() {
        return godina;
    }

    public void setGodina(Date godina) {
        this.godina = godina;
    } 

    public List<StavkaPPN> getStavkePPN() {
        return stavkePPN;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PlanPokrivenostiNastave other = (PlanPokrivenostiNastave) obj;
        if (this.ppnId != other.ppnId) {
            return false;
        }
        return true;
    }
    
    
    
}
