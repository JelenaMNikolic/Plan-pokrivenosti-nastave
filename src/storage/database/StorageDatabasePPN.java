/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.database;

import controller.Controller;
import domain.PlanPokrivenostiNastave;
import domain.StavkaPPN;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.AbstractStoragePPN;
import storage.database.connection.DatabaseConnection;

/**
 *
 * @author jelena
 */
public class StorageDatabasePPN extends AbstractStoragePPN {

    @Override
    public String savePPN(PlanPokrivenostiNastave ppn) throws SQLException, Exception {
        Connection connection = null;
        try {
            String poruka = "";
            connection = DatabaseConnection.getInstance().getConnection();
            String query = "INSERT INTO ppn (godina_ppn) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, new Date(ppn.getGodina().getTime()));
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                throw new Exception("Invalid id");
            }
            query = "INSERT INTO stavke_ppn (sifra_stavki_ppn, sifra_predmeta, sifra_nastavnika) VALUES (?,?,?)";
            PreparedStatement psStavka = connection.prepareStatement(query);
            for (StavkaPPN stavka : ppn.getStavkePPN()) {
                psStavka.setInt(1, id);
                psStavka.setInt(2, stavka.getPredmet().getPredmetId());
                psStavka.setInt(3, stavka.getNastavnik().getNastavnikId());
                psStavka.executeUpdate();
            }
            connection.commit();
            poruka = "Uspesno sacuvan plan pokrivenosti nastave.";
            psStavka.close();
            ps.close();
            rs.close();
            return poruka;
        } catch (SQLException ex) {
            if (connection != null) {
                connection.rollback();
            }
            Logger.getLogger(StorageDatabasePPN.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

    }

    @Override
    public List<PlanPokrivenostiNastave> getAllPPN() throws SQLException, Exception {
        try {
            List<PlanPokrivenostiNastave> planovi = new ArrayList<>();
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "SELECT * FROM ppn";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt(1);
                Date date = rs.getDate(2);
                List<StavkaPPN> stavke = Controller.getInstance().getAllStavke(id);
                PlanPokrivenostiNastave ppn = new PlanPokrivenostiNastave(id, date, stavke);
                planovi.add(ppn);
            }
            rs.close();
            statement.close();
            return planovi;
        } catch (SQLException ex) {
            Logger.getLogger(StorageDatabasePPN.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public String izmeniPPN(PlanPokrivenostiNastave ppn) throws Exception {
        Connection connection = null;
        try {
            String poruka = "";
            connection = DatabaseConnection.getInstance().getConnection();
            String query = "DELETE FROM stavke_ppn WHERE sifra_stavki_ppn = " + ppn.getPpnId();
            Statement s = connection.createStatement();
            int rs = s.executeUpdate(query);
            if (rs != 0) {
                query = "INSERT INTO stavke_ppn (sifra_stavki_ppn, sifra_predmeta, sifra_nastavnika) VALUES (?,?,?)";
                PreparedStatement psStavka = connection.prepareStatement(query);
                for (StavkaPPN stavka : ppn.getStavkePPN()) {
                    psStavka.setInt(1, ppn.getPpnId());
                    psStavka.setInt(2, stavka.getPredmet().getPredmetId());
                    psStavka.setInt(3, stavka.getNastavnik().getNastavnikId());
                    psStavka.executeUpdate();
                }
                query = "UPDATE ppn SET godina_ppn = ? WHERE sifra_ppn = ?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setDate(1, new Date(ppn.getGodina().getTime()));
                ps.setInt(2, ppn.getPpnId());
                ps.executeUpdate();
                connection.commit();
                poruka = "Uspesno izmenjen plan pokrivenosti nastave.";
                psStavka.close();
                ps.close();
                return poruka;
            } else {
                connection.rollback();
                throw new Exception("Nije uspesna izmena stavki.");
            }
        } catch (SQLException ex) {
            if (connection != null) {
                connection.rollback();
            }
            Logger.getLogger(StorageDatabasePPN.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public String deletePPN(PlanPokrivenostiNastave ppn) throws SQLException, Exception {
        try {
            String poruka = "";
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "DELETE FROM ppn WHERE sifra_ppn = " + ppn.getPpnId();
            Statement s = connection.createStatement();
            int rs = s.executeUpdate(query);
            if(rs != 0) {
                poruka = "Plan je obrisan.";
            } else {
                throw new Exception("Greska pri brisanju.");
            }
            connection.commit();
            s.close();
            return poruka;
        } catch (SQLException ex) {
            Logger.getLogger(StorageDatabasePPN.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

}
