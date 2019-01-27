/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.PlanPokrivenostiNastave;
import java.util.List;

/**
 *
 * @author jelena
 */
public interface StoragePPN {

    String savePPN(PlanPokrivenostiNastave ppn) throws Exception;

    List<PlanPokrivenostiNastave> getAllPPN() throws Exception;

    String izmeniPPN(PlanPokrivenostiNastave ppn) throws Exception;

    String deletePPN(PlanPokrivenostiNastave ppn) throws Exception;
    
}
