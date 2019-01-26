/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domain.Nastavnik;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sanja
 */
public class TableNastavnikModel extends AbstractTableModel{

    List<Nastavnik> nastavnici;
    String[] header = {"Id", "Ime", "Prezime", "Email", "Sifra", "Pozicija", "Konsultacije", "Kabinet", "Katedra"};

    public TableNastavnikModel() {
    }

    public TableNastavnikModel(List<Nastavnik> nastavnici) {
        this.nastavnici = nastavnici;
    }
    
    @Override
    public int getRowCount() {
        return nastavnici.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Nastavnik n = nastavnici.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return n.getNastavnikId();
            case 1:
                return n.getIme();
            case 2:
                return n.getPrezime();
            case 3:
                return n.geteMail();
            case 4:
                return n.getPassword();
            case 5:
                return n.getPozicija();
            case 6:
                return n.getKonsultacije();
            case 7:
                return n.getKabinet();
            case 8:
                return n.getKatedra().getNazivKatedre();
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    public Nastavnik getNastavnik(int row) {
        return nastavnici.get(row);
    }

    public void updateData(Nastavnik novi) {
        for (int i = 0; i<nastavnici.size(); i++) {
            if(nastavnici.get(i).getNastavnikId() == novi.getNastavnikId())
                nastavnici.set(i, novi);
        }
        fireTableDataChanged();
    }

    public void addNastavnik(Nastavnik nastavnik) {
        nastavnici.add(nastavnik);
        fireTableDataChanged();
    }

    public void removeNastavnik(int i) {
        nastavnici.remove(i);
        fireTableDataChanged();
    }
    
}
