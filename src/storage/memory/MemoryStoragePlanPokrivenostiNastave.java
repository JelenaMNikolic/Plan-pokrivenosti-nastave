/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.memory;

import domain.PlanPokrivenostiNastave;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class MemoryStoragePlanPokrivenostiNastave {
    
    List<PlanPokrivenostiNastave> predmetNastavnik;

    public MemoryStoragePlanPokrivenostiNastave() {
        predmetNastavnik = new ArrayList<>();
        predmetNastavnik.add(new PlanPokrivenostiNastave(1, "2016", null));
    }
    
    
    
}
