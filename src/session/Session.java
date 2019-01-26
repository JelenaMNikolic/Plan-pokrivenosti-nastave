/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import domain.Nastavnik;
import form.FormMode;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Korisnik
 */
public class Session {

    private Nastavnik ulogovan;
    private static Session instance;
    private FormMode mode;
    private int trenutniSlucajKoriscenja;
    private final Map<String, Object> parametriSK;

    private Session() {
        parametriSK = new HashMap<>();
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public Nastavnik getUlogovan() {
        return ulogovan;
    }

    public void setUlogovan(Nastavnik ulogovan) {
        this.ulogovan = ulogovan;
    }

    public FormMode getMode() {
        return mode;
    }

    public void setMode(FormMode mode) {
        this.mode = mode;
    }

    public int getTrenutniSlucajKoriscenja() {
        return trenutniSlucajKoriscenja;
    }

    public void setTrenutniSlucajKoriscenja(int trenutniSlucajKoriscenja) {
        this.trenutniSlucajKoriscenja = trenutniSlucajKoriscenja;
    }

    public Map<String, Object> getParametriSK() {
        return parametriSK;
    }

}
