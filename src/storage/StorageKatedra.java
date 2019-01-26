/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.Katedra;
import java.util.List;

/**
 *
 * @author Sanja
 */
public interface StorageKatedra {

    List<Katedra> getAll() throws Exception;

    String updateKatedra(Katedra katedra) throws Exception;

    String deleteKatedra(Katedra katedra) throws Exception;

    Katedra getKatedraById(int id) throws Exception;

    int saveKatedra(Katedra katedra) throws Exception;
}
