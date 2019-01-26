/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.database;

import controller.Controller;
import storage.database.connection.DatabaseConnection;
import domain.Katedra;
import domain.Nastavnik;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import storage.AbstractStorageNastavnik;

/**
 *
 * @author jelena
 */
public class StorageDatabaseNastavnik extends AbstractStorageNastavnik {

    @Override
    public List<Nastavnik> getAll() throws Exception {
        List<Nastavnik> nastavnici = new LinkedList<>();
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "SELECT * FROM nastavnik";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int sifra = rs.getInt(1);
                String ime = rs.getString(2);
                String prezime = rs.getString(3);
                String email = rs.getString(4);
                String password = rs.getString(5);
                String pozicija = rs.getString(6);
                String konsultacije = rs.getString(7);
                String kabinet = rs.getString(8);
                Katedra katedra = Controller.getInstance().getKatedra(rs.getInt(9));
                Nastavnik nastavnik = new Nastavnik(sifra, ime, prezime, email, password, pozicija, konsultacije, kabinet, katedra);
                nastavnici.add(nastavnik);
            }
            rs.close();
            statement.close();
            return nastavnici;
        } catch (SQLException ex) {
            throw new Exception("Neuspela konekcija." + ex.getMessage(), ex);
        }
    }

    @Override
    public Nastavnik findById(int nastavnikId) {
        return null;
    }

    @Override
    public Nastavnik findByUserAndPass(String email, String password) throws Exception {
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "SELECT * FROM nastavnik WHERE email = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int sifra = rs.getInt(1);
                String ime = rs.getString(2);
                String prezime = rs.getString(3);
                String mail = rs.getString(4);
                String pass = rs.getString(5);
                String pozicija = rs.getString(6);
                String konsultacije = rs.getString(7);
                String kabinet = rs.getString(8);
                int sifraKatedre = rs.getInt(9);
                Katedra k = Controller.getInstance().getKatedra(sifraKatedre);
                return new Nastavnik(sifra, ime, prezime, mail, pass, pozicija, konsultacije, kabinet, k);
            }
        } catch (SQLException ex) {
            throw new Exception("Neuspela konekcija." + ex.getMessage(), ex);
        }
        throw new Exception("Nastavnik ne postoji u sistemu.");

    }

    @Override
    public String updateNastavnik(Nastavnik novi) throws Exception {
        try {
            String poruka = "";
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "UPDATE nastavnik SET ime = ?, prezime = ?, email = ?, password = ?, pozicija = ?,"
                    + " konsultacije = ?, kabinet = ?, fk_sifra_katedre = ? WHERE sifra_nastavnika = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, novi.getIme());
            statement.setString(2, novi.getPrezime());
            statement.setString(3, novi.geteMail());
            statement.setString(4, novi.getPassword());
            statement.setString(5, novi.getPozicija());
            statement.setString(6, novi.getKonsultacije());
            statement.setString(7, novi.getKabinet());
            statement.setInt(8, novi.getKatedra().getKatedraId());
            statement.setInt(9, novi.getNastavnikId());
            int updated = statement.executeUpdate();
            if (updated > 0) {
                poruka += "Nastavnik je uspesno izmenjen.";
                connection.commit();
            }
            statement.close();
            return poruka;
        } catch (SQLException ex) {
            throw new Exception("Neuspela konekcija! " + ex.getMessage(), ex);
        }
    }

    @Override
    public int saveNastavnik(Nastavnik nastavnik) throws Exception {
        try {
            int nastavnikId = -1;
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "INSERT INTO nastavnik (ime, prezime, email, password, pozicija, konsultacije, kabinet, fk_sifra_katedre)"
                    + " VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nastavnik.getIme());
            ps.setString(2, nastavnik.getPrezime());
            ps.setString(3, nastavnik.geteMail());
            ps.setString(4, nastavnik.getPassword());
            ps.setString(5, nastavnik.getPozicija());
            ps.setString(6, nastavnik.getKonsultacije());
            ps.setString(7, nastavnik.getKabinet());
            ps.setInt(8, nastavnik.getKatedra().getKatedraId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                nastavnikId = rs.getInt(1);
                connection.commit();
            }
            rs.close();
            ps.close();
            return nastavnikId;
        } catch (SQLException ex) {
            throw new SQLException("Neuspela konekcija! " + ex.getMessage(), ex);
        }
    }

    @Override
    public String deleteNastavnik(Nastavnik nastavnik) throws Exception {
        try {
            String poruka = "";
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "DELETE FROM nastavnik WHERE sifra_nastavnika = " + nastavnik.getNastavnikId();
            Statement statement = connection.createStatement();
            int deleted = statement.executeUpdate(query);
            if (deleted > 0) {
                poruka += "Nastavnik je uspesno obrisan.";
                connection.commit();
            } else {
                poruka += "Nastavnik ne postoji u sistemu.";
            }
            statement.close();
            return poruka;
        } catch (SQLException ex) {
            throw new SQLException("Neuspela konekcija! " + ex.getMessage(), ex);
        }
    }

}
