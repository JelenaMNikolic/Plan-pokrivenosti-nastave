/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.katedra;

import controller.Controller;
import domain.Katedra;
import domain.Nastavnik;
import form.FormMode;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.TableKatedreModel;
import session.Session;
import slucajkoriscenja.SlucajKoriscenja;
import validator.Validator;

/**
 *
 * @author jelena
 */
public class FormPretraziKatedre extends javax.swing.JFrame {

    /**
     * Creates new form FormPrikaziKatedre
     */
    public FormPretraziKatedre() {
        initComponents();
        Nastavnik ulogovan = Session.getInstance().getUlogovan();
        jLblUlogovan.setText(ulogovan.toString());
        setTitle("Katedre");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        popuniTabelu();
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
        jLblUlogovan = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKatedre = new javax.swing.JTable();
        btnPrikazi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nastavnik"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblUlogovan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblUlogovan, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Katedre"));

        tblKatedre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblKatedre);

        btnPrikazi.setText("Prikazi");
        btnPrikazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrikaziActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrikazi, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrikazi)
                    .addComponent(btnIzmeni)
                    .addComponent(btnObrisi)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrikaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrikaziActionPerformed
        int red = tblKatedre.getSelectedRow();
        if (Validator.getInstance().izabranRed(red)) {
            TableKatedreModel model = (TableKatedreModel) tblKatedre.getModel();
            Katedra katedra = model.getKatedra(red);
            Session.getInstance().setTrenutniSlucajKoriscenja(SlucajKoriscenja.SK_PRIKAZI_KATEDRU);
            Session.getInstance().getParametriSK().clear();
            Session.getInstance().getParametriSK().put("katedra", katedra);
            JDialog dialogKatedra = new DialogNovaKatedra(this, true, FormMode.PRIKAZI);
            dialogKatedra.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Izaberite katedru!");
        }
    }//GEN-LAST:event_btnPrikaziActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        int red = tblKatedre.getSelectedRow();
        if (Validator.getInstance().izabranRed(red)) {
            TableKatedreModel model = (TableKatedreModel) tblKatedre.getModel();
            Katedra katedra = model.getKatedra(red);
            Session.getInstance().setTrenutniSlucajKoriscenja(SlucajKoriscenja.SK_IZMENI_KATEDRU);
            Session.getInstance().getParametriSK().clear();
            Session.getInstance().getParametriSK().put("katedra", katedra);
            JDialog dialogKatedra = new DialogNovaKatedra(this, true, FormMode.IZMENI);
            dialogKatedra.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Izaberite katedru!");
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        int red = tblKatedre.getSelectedRow();
        if (Validator.getInstance().izabranRed(red)) {
            try {
                TableKatedreModel model = (TableKatedreModel) tblKatedre.getModel();
                Katedra katedra = model.getKatedra(red);
                String poruka = Controller.getInstance().obrisiKatedru(katedra);
                if (!poruka.isEmpty()) {
                    Session.getInstance().setTrenutniSlucajKoriscenja(SlucajKoriscenja.SK_OBRISI_KATEDRU);
                    Session.getInstance().getParametriSK().clear();
                    JOptionPane.showMessageDialog(this, poruka);
                    model.removeKatedra(red);
                }
            } catch (Exception ex) {
                Logger.getLogger(FormPretraziKatedre.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Izaberite katedru!");
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormPretraziKatedre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPretraziKatedre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPretraziKatedre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPretraziKatedre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPretraziKatedre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPrikazi;
    private javax.swing.JLabel jLblUlogovan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKatedre;
    // End of variables declaration//GEN-END:variables

    private void popuniTabelu() {
        try {
            TableKatedreModel model = new TableKatedreModel(Controller.getInstance().getAllKatedre());
            tblKatedre.setModel(model);
        } catch (Exception ex) {
        }

    }

    public void updateData(Katedra katedra) {
        try {
            TableKatedreModel tm = (TableKatedreModel) tblKatedre.getModel();
            tm.updateKatedra(katedra);
        } catch (Exception ex) {
            Logger.getLogger(FormPretraziKatedre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void addKatedra(Katedra katedra) {
        TableKatedreModel tm = (TableKatedreModel) tblKatedre.getModel();
        tm.addKatedra(katedra);
    }
}