/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.database;

import controller.Controller;
import domain.Nastavnik;
import domain.Predmet;
import domain.StavkaPPN;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.AbstractStorageStavkePPN;
import storage.database.connection.DatabaseConnection;

/**
 *
 * @author Sanja
 */
public class StorageDatabaseStavkePPN extends AbstractStorageStavkePPN{

    @Override
    public List<StavkaPPN> getAllStavke(int stavkeId) throws SQLException, Exception {
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            List<StavkaPPN> stavke = new ArrayList<>();
            String query = "SELECT * FROM stavke_ppn WHERE sifra_stavki_ppn = " + stavkeId;
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt(1);
                int predmetId = rs.getInt(2);
                Predmet predmet = Controller.getInstance().getPredmetById(predmetId);
                int nastavnikId = rs.getInt(3);
                Nastavnik nastavnik  = Controller.getInstance().getNastavnikById(nastavnikId);
                StavkaPPN stavka = new StavkaPPN(stavkeId, predmet, nastavnik);
                stavke.add(stavka);
            }
            rs.close();
            s.close();
            return stavke;
        } catch (SQLException ex) {
            Logger.getLogger(StorageDatabaseStavkePPN.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(StorageDatabaseStavkePPN.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }


    
}
