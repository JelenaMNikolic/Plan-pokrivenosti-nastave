/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.memory;

import domain.Nastavnik;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class MemoryStorageNastavnik {
    
    private List<Nastavnik> nastavnici;

    public MemoryStorageNastavnik() {
        nastavnici = new ArrayList<>();
    }
    
    public void add(Nastavnik nastavnik) {
        this.nastavnici.add(nastavnik);
    }
        
    public List<Nastavnik> getAll() {
        return nastavnici;
    }
    
}
