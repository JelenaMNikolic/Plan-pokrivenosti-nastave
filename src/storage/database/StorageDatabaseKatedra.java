/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.database;

import storage.database.connection.DatabaseConnection;
import domain.Katedra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import storage.AbstractStorageKatedra;

/**
 *
 * @author jelena
 */
public class StorageDatabaseKatedra extends AbstractStorageKatedra {

    @Override
    public String updateKatedra(Katedra katedra) throws Exception {
        try {
            String poruka = "";
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "UPDATE katedra SET naziv_katedre = ?, delatnost_katedre = ? WHERE sifra_katedre = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, katedra.getNazivKatedre());
            statement.setString(2, katedra.getDelatnostKatedre());
            statement.setInt(3, katedra.getKatedraId());
            int updated = statement.executeUpdate();
            if (updated > 0) {
                poruka += "Katedra je uspesno izmenjena.";
                connection.commit();
            }
            statement.close();
            return poruka;
        } catch (SQLException ex) {
            throw new Exception("Neuspela konekcija! " + ex.getMessage(), ex);
        }
    }

    @Override
    public List<Katedra> getAll() throws SQLException {
        List<Katedra> katedre = new LinkedList<>();
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "SELECT * FROM katedra";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int sifra = rs.getInt("sifra_katedre");
                String naziv = rs.getString("naziv_katedre");
                String delatnost = rs.getString("delatnost_katedre");
                Katedra katedra = new Katedra(sifra, naziv, delatnost);
                katedre.add(katedra);
            }
            rs.close();
            statement.close();
            return katedre;
        } catch (SQLException ex) {
            throw new SQLException("Neuspela konekcija! " + ex.getMessage(), ex);
        }
    }

    @Override
    public String deleteKatedra(Katedra katedra) throws SQLException {
        try {
            String poruka = "";
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "DELETE FROM katedra WHERE sifra_katedre = " + katedra.getKatedraId();
            Statement statement = connection.createStatement();
            int deleted = statement.executeUpdate(query);
            if (deleted > 0) {
                poruka += "Katedra je uspesno obrisana.";
                connection.commit();
            } else {
                poruka += "Katedra ne postoji u sistemu.";
            }
            statement.close();
            return poruka;
        } catch (SQLException ex) {
            throw new SQLException("Neuspela konekcija! " + ex.getMessage(), ex);
        }
    }

    @Override
    public Katedra getKatedraById(int id) throws SQLException{
        try {
            Katedra k = null;
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "SELECT * FROM katedra WHERE sifra_katedre = " + id;
            Statement statemnt = connection.createStatement();
            ResultSet rs = statemnt.executeQuery(query);
            while(rs.next()) {
                int katedraId = rs.getInt("sifra_katedre");
                String nazivKatedre = rs.getString("naziv_katedre");
                String delatnostKatedre = rs.getString("delatnost_katedre");
                k = new Katedra(katedraId, nazivKatedre, delatnostKatedre);
            }
            rs.close();
            statemnt.close();
            return k;
        } catch (SQLException ex) {
            throw new SQLException("Neuspela konekcija! " + ex.getMessage(), ex);
        }
    }

    @Override
    public int saveKatedra(Katedra katedra) throws SQLException {
        try {
            int katedraId = -1;
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "INSERT INTO katedra (naziv_katedre, delatnost_katedre) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, katedra.getNazivKatedre());
            ps.setString(2, katedra.getDelatnostKatedre());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                katedraId = rs.getInt(1);
                connection.commit();
            }
            rs.close();
            ps.close();
            return katedraId;
        } catch (SQLException ex) {
            throw new SQLException("Neuspela konekcija! " + ex.getMessage(), ex);
        }
    }

}
