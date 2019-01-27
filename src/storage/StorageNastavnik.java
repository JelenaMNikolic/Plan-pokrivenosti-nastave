/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.Nastavnik;
import java.util.List;

/**
 *
 * @author Sanja
 */
public interface StorageNastavnik {

    Nastavnik findByUserAndPass(String username, String password) throws Exception;

    List<Nastavnik> getAll() throws Exception;

    String updateNastavnik(Nastavnik novi) throws Exception;

    int saveNastavnik(Nastavnik nastavnik) throws Exception;

    String deleteNastavnik(Nastavnik nastavnik) throws Exception;

    Nastavnik getNastavnikById(int nastavnikId) throws Exception;
}
