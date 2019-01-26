/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.memory;

import domain.Predmet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class MemoryStoragePredmet {
    List<Predmet> predmeti;

    public MemoryStoragePredmet() {
        predmeti = new ArrayList<>();
    }
    
    public List<Predmet> getAll() {
        return predmeti;
    }
    
}
