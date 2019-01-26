/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Katedra;
import domain.Nastavnik;
import domain.Predmet;
import domain.StavkaPPN;
import java.util.List;
import storage.StorageKatedra;
import storage.StorageNastavnik;
import storage.StoragePPN;
import storage.StoragePredmet;
import storage.memory.MemoryStoragePredmet;
import storage.database.StorageDatabaseKatedra;
import storage.database.StorageDatabaseNastavnik;
import storage.database.StorageDatabasePPN;
import storage.database.StorageDatabasePredmet;

/**
 *
 * @author Korisnik
 */
public class Controller {
    
    private final StorageKatedra storageKatedra;
    private final StorageNastavnik storageNastavnik;
    private final StoragePredmet storagePredmet;
    private final StoragePPN storagePPN;
    private static Controller instance;

    public Controller() {
        storageKatedra = new StorageDatabaseKatedra();
        storageNastavnik = new StorageDatabaseNastavnik();
        storagePredmet = new StorageDatabasePredmet();
        storagePPN = new StorageDatabasePPN();
    }
    
    public static Controller getInstance() {
        if(instance == null) {
            instance = new Controller();
        }
        return instance;
    }
    
    public Nastavnik login(String email, String password) throws Exception {
        return storageNastavnik.findByUserAndPass(email, password);
    }

    public List<Katedra> getAllKatedre() throws Exception {
        return storageKatedra.getAll();
    }

    public List<Nastavnik> getAllNastavnici() throws Exception {
        return storageNastavnik.getAll();
    }

    public List<Predmet> getAllPredmeti() throws Exception {
        return storagePredmet.getAll();
    }

    public int saveKatedra(Katedra katedra) throws Exception {
        return storageKatedra.saveKatedra(katedra);
    }

    public int saveNastavnik(Nastavnik nastavnik) throws Exception {
        return storageNastavnik.saveNastavnik(nastavnik);
    }

    public String azurirajKatedru(Katedra katedra) throws Exception {
        return storageKatedra.updateKatedra(katedra);
    }

    public String obrisiKatedru(Katedra katedra) throws Exception {
        return storageKatedra.deleteKatedra(katedra);
    }

    public Katedra getKatedra(int id) throws Exception {
        return storageKatedra.getKatedraById(id);
    }

    public String azurirajNastavnika(Nastavnik novi) throws Exception {
        return storageNastavnik.updateNastavnik(novi);
    }

    public String obrisiNastavnika(Nastavnik nastavnik) throws Exception {
        return storageNastavnik.deleteNastavnik(nastavnik);
    }

    public void dodajStavku(StavkaPPN stavka) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
