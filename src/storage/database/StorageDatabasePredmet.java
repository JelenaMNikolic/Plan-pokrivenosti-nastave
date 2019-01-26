/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.database;

import controller.Controller;
import storage.database.connection.DatabaseConnection;
import domain.Katedra;
import domain.Predmet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.AbstractStoragePredmet;

/**
 *
 * @author jelena
 */
public class StorageDatabasePredmet extends AbstractStoragePredmet{
    
    @Override
    public List<Predmet> getAll() throws Exception {
        List<Predmet> predmeti = new LinkedList<>();
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "SELECT * FROM predmet";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                int sifra = rs.getInt(1);
                String naziv = rs.getString(2);
                String opis = rs.getString(3);
                String cilj = rs.getString(4);
                int sifraKat = rs.getInt(5);
                Katedra katedra = Controller.getInstance().getKatedra(sifraKat);
                Predmet predmet = new Predmet(sifra, naziv, opis, cilj, katedra);
                predmeti.add(predmet);
            }
            rs.close();
            statement.close();
            return predmeti;
        } catch (SQLException ex) {
            throw new Exception("Neuspela konekcija." + ex.getMessage(), ex);
        }
    }
}
