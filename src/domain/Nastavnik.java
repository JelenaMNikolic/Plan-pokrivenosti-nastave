/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class Nastavnik {

    private int nastavnikId;
    private String ime;
    private String prezime;
    private String eMail;
    private String password;
    private String pozicija;
    private String konsultacije;
    private String kabinet;
    private Katedra katedra;

    public Nastavnik() {
    }

    public Nastavnik(int nastavnikId, String ime, String prezime, String eMail, String password,
            String pozicija, String konsultacije, String kabinet, Katedra katedra) {
        this.nastavnikId = nastavnikId;
        this.ime = ime;
        this.prezime = prezime;
        this.eMail = eMail;
        this.password = password;
        this.pozicija = pozicija;
        this.konsultacije = konsultacije;
        this.kabinet = kabinet;
        this.katedra = katedra;
    }

    public int getNastavnikId() {
        return nastavnikId;
    }

    public void setNastavnikId(int nastavnikId) {
        this.nastavnikId = nastavnikId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    
    

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public String getKonsultacije() {
        return konsultacije;
    }

    public void setKonsultacije(String konsultacije) {
        this.konsultacije = konsultacije;
    }

    public String getKabinet() {
        return kabinet;
    }

    public void setKabinet(String kabinet) {
        this.kabinet = kabinet;
    }

    public Katedra getKatedra() {
        return katedra;
    }

    public void setKatedra(Katedra katedra) {
        this.katedra = katedra;
    }

    @Override
    public String toString() {
        return this.ime + " " + this.prezime;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nastavnik other = (Nastavnik) obj;
        if (this.nastavnikId != other.nastavnikId) {
            return false;
        }
        if (!Objects.equals(this.eMail, other.eMail)) {
            return false;
        }
        return true;
    }
    
    

}
