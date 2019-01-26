/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import form.FormLogin;
import javax.swing.JFrame;

/**
 *
 * @author Korisnik
 */
public class Start {
    
    public static void main(String[] args) {
        JFrame login = new FormLogin();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
    
}
