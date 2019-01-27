/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domain.StavkaPPN;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sanja
 */
public class TableStavkeModel extends AbstractTableModel{

    List<StavkaPPN> stavke;
    String[] header = {"Sifra", "Predmet", "Nastavnik"};

    public TableStavkeModel(List<StavkaPPN> stavke) {
        this.stavke = stavke;
    }

    public TableStavkeModel() {
        stavke = new ArrayList<>();
    }

    
    @Override
    public int getRowCount() {
        return stavke.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaPPN stavka = stavke.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return stavka.getStavkaPPNId();
            case 1:
                return stavka.getPredmet();
            case 2:
                return stavka.getNastavnik();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
    
    public void setData(List<StavkaPPN> stavke) {
        this.stavke = stavke;
        fireTableDataChanged();
    }

    public void clearStavke() {
        stavke.clear();
        fireTableDataChanged();
    }
    
}
