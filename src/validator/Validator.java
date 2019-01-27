/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import domain.Nastavnik;
import domain.PlanPokrivenostiNastave;
import domain.Predmet;
import domain.StavkaPPN;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sanja
 */
public class Validator {
    
    private static Validator instance;

    private Validator() {
    }

    public static Validator getInstance() {
        if(instance == null)
            instance = new Validator();
        return instance;
    }

    public boolean izabranRed(int red) {
        return red != -1;
    }

    public boolean podaciZaKatedru(String nazivKatedre, String delatnostKatedre) {
        return !nazivKatedre.isEmpty() && !delatnostKatedre.isEmpty();
    }

    public boolean dobarEmailIPass(String eMail, String password) {
        return !eMail.isEmpty() && !password.isEmpty();
    }

    public boolean nastavnikOK(Nastavnik novi) {
        //implementacija
        return true;
    }

    public boolean imaStavka(List<StavkaPPN> stavke, Predmet predmet, Nastavnik nastavnik) {
        for (StavkaPPN stavkaPPN : stavke) {
            if(stavkaPPN.getPredmet().equals(predmet) && stavkaPPN.getNastavnik().equals(nastavnik))
                return false;
        }
        return true;
    }

    public boolean postoji(PlanPokrivenostiNastave ppn) {
        //proveri da li ima vec plan za tu godinu u bazi
        return false;
    }

    public boolean uneteStavke(List<StavkaPPN> stavke) {
        return !stavke.isEmpty();
    }

    
}
