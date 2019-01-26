/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import form.nastavnik.FormPretraziNastavnike;
import form.nastavnik.DialogNoviNastavnik;
import form.ppn.FormPretraziPPN;
import form.ppn.DialogNoviPPN;
import form.katedra.DialogNovaKatedra;
import form.katedra.FormPretraziKatedre;
import domain.Nastavnik;
import javax.swing.JDialog;
import javax.swing.JFrame;
import session.Session;
import slucajkoriscenja.SlucajKoriscenja;

/**
 *
 * @author Korisnik
 */
public class FormMain extends javax.swing.JFrame {

    /**
     * Creates new form FormMain
     */
    public FormMain() {
        initComponents();
        this.setLocationRelativeTo(null);
        setUlogovan();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLblImeUlogovanog = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuKatedra = new javax.swing.JMenu();
        jMIPrikaziKatedru = new javax.swing.JMenuItem();
        jMIDodajKatedru = new javax.swing.JMenuItem();
        jMenuNastavnik = new javax.swing.JMenu();
        jMIPrikaziNastavnike = new javax.swing.JMenuItem();
        jMIDodajNastavnika = new javax.swing.JMenuItem();
        jMenuPredmet = new javax.swing.JMenu();
        jMenuPPN = new javax.swing.JMenu();
        jMIPrikaziPPN = new javax.swing.JMenuItem();
        jMIDodajPPN = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nastavnik"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLblImeUlogovanog, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLblImeUlogovanog, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 210, Short.MAX_VALUE))
        );

        jMenuKatedra.setText("Katedra");

        jMIPrikaziKatedru.setText("Prikazi");
        jMIPrikaziKatedru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPrikaziKatedruActionPerformed(evt);
            }
        });
        jMenuKatedra.add(jMIPrikaziKatedru);

        jMIDodajKatedru.setText("Dodaj");
        jMIDodajKatedru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIDodajKatedruActionPerformed(evt);
            }
        });
        jMenuKatedra.add(jMIDodajKatedru);

        jMenuBar1.add(jMenuKatedra);

        jMenuNastavnik.setText("Nastavnik");

        jMIPrikaziNastavnike.setText("Prikazi");
        jMIPrikaziNastavnike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPrikaziNastavnikeActionPerformed(evt);
            }
        });
        jMenuNastavnik.add(jMIPrikaziNastavnike);

        jMIDodajNastavnika.setText("Dodaj");
        jMIDodajNastavnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIDodajNastavnikaActionPerformed(evt);
            }
        });
        jMenuNastavnik.add(jMIDodajNastavnika);

        jMenuBar1.add(jMenuNastavnik);

        jMenuPredmet.setText("Predmet");
        jMenuBar1.add(jMenuPredmet);

        jMenuPPN.setText("Plan pokrivenosti nastave");

        jMIPrikaziPPN.setText("Prikazi");
        jMIPrikaziPPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPrikaziPPNActionPerformed(evt);
            }
        });
        jMenuPPN.add(jMIPrikaziPPN);

        jMIDodajPPN.setText("Dodaj");
        jMIDodajPPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIDodajPPNActionPerformed(evt);
            }
        });
        jMenuPPN.add(jMIDodajPPN);

        jMenuBar1.add(jMenuPPN);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMIDodajKatedruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIDodajKatedruActionPerformed
        JDialog dialogNovaKatedra = new DialogNovaKatedra(this, true, FormMode.NOVI);
        dialogNovaKatedra.setVisible(true);
        Session.getInstance().setTrenutniSlucajKoriscenja(SlucajKoriscenja.SK_DODAJ_NOVU_KATEDRU);
    }//GEN-LAST:event_jMIDodajKatedruActionPerformed

    private void jMIDodajNastavnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIDodajNastavnikaActionPerformed
        JDialog dialogNoviNastavnik = new DialogNoviNastavnik(this, true, FormMode.NOVI);
        dialogNoviNastavnik.setVisible(true);
        Session.getInstance().setTrenutniSlucajKoriscenja(SlucajKoriscenja.SK_DODAJ_NOVOG_NASTAVNIKA);
    }//GEN-LAST:event_jMIDodajNastavnikaActionPerformed

    private void jMIDodajPPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIDodajPPNActionPerformed
        JDialog dialogNoviPPN = new DialogNoviPPN(this, true, FormMode.NOVI);
        dialogNoviPPN.setVisible(true);
        Session.getInstance().setTrenutniSlucajKoriscenja(SlucajKoriscenja.SK_DODAJ_NOVI_PPN);
    }//GEN-LAST:event_jMIDodajPPNActionPerformed

    private void jMIPrikaziKatedruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPrikaziKatedruActionPerformed
        JFrame formPrikaziKatedre = new FormPretraziKatedre();
        formPrikaziKatedre.setLocationRelativeTo(null);
        formPrikaziKatedre.setVisible(true);
        Session.getInstance().setTrenutniSlucajKoriscenja(SlucajKoriscenja.SK_PRETRAZI_KATEDRU);
    }//GEN-LAST:event_jMIPrikaziKatedruActionPerformed

    private void jMIPrikaziNastavnikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPrikaziNastavnikeActionPerformed
        JFrame formPrikaziNastavnike = new FormPretraziNastavnike();
        formPrikaziNastavnike.setLocationRelativeTo(null);
        formPrikaziNastavnike.setVisible(true);
        Session.getInstance().setTrenutniSlucajKoriscenja(SlucajKoriscenja.SK_PRETRAZI_NASTAVNIKA);
    }//GEN-LAST:event_jMIPrikaziNastavnikeActionPerformed

    private void jMIPrikaziPPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPrikaziPPNActionPerformed
        JFrame formPrikaziPPN = new FormPretraziPPN();
        formPrikaziPPN.setLocationRelativeTo(null);
        formPrikaziPPN.setVisible(true);
        Session.getInstance().setTrenutniSlucajKoriscenja(SlucajKoriscenja.SK_PRETRAZI_PPN);
    }//GEN-LAST:event_jMIPrikaziPPNActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormMain().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLblImeUlogovanog;
    private javax.swing.JMenuItem jMIDodajKatedru;
    private javax.swing.JMenuItem jMIDodajNastavnika;
    private javax.swing.JMenuItem jMIDodajPPN;
    private javax.swing.JMenuItem jMIPrikaziKatedru;
    private javax.swing.JMenuItem jMIPrikaziNastavnike;
    private javax.swing.JMenuItem jMIPrikaziPPN;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuKatedra;
    private javax.swing.JMenu jMenuNastavnik;
    private javax.swing.JMenu jMenuPPN;
    private javax.swing.JMenu jMenuPredmet;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void setUlogovan() {
        Nastavnik ulogovan = Session.getInstance().getUlogovan();
        jLblImeUlogovanog.setText(ulogovan.toString());
    }
}