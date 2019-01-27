/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.StavkaPPN;
import java.util.List;

/**
 *
 * @author Sanja
 */
public interface StorageStavkePPN {

    List<StavkaPPN> getAllStavke(int stavkeId) throws Exception;

}
