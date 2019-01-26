/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.memory;

import domain.Katedra;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class MemoryStorageKatedra {

    static List<Katedra> katedre;

    public MemoryStorageKatedra() {
        katedre = new ArrayList<>();
        initKatedre();
    }

    private void initKatedre() {
        katedre.add(new Katedra(1, "ELAB", "Web dev"));
        katedre.add(new Katedra(2, "Silab", "soft dev"));
    }

    public List<Katedra> getAll() {
        return katedre;
    }

}
