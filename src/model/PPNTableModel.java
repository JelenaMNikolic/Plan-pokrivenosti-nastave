/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domain.Nastavnik;
import domain.Predmet;
import domain.StavkaPPN;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Korisnik
 */
// cela ova klasa nije dobra, ideja je tu ali realizacija nije ok
public class PPNTableModel extends AbstractTableModel {

    private List<StavkaPPN> stavke;
    private String[] header = {"Predmet", "Nastavnik"};

    public PPNTableModel(List<StavkaPPN> stavke) {
        this.stavke = stavke;
    }

    @Override
    public int getRowCount() {
        if (stavke != null && stavke.size() != 0) {
            return stavke.size();
        }
        return 0;
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
                return stavka.getPredmet();
            case 1:
                return stavka.getNastavnik();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    public void addStavka(StavkaPPN stavka) {
        stavke.add(stavka);
        fireTableDataChanged();
    }

    public void obrisiStavku(int row) {
        stavke.remove(row);
        fireTableDataChanged();
    }

    public void izmeniStavku(StavkaPPN stavka, int row) {
        stavke.set(row, stavka);
        fireTableDataChanged();
    }

}
