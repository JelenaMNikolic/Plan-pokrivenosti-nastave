/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domain.Katedra;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sanja
 */
public class TableKatedreModel extends AbstractTableModel{

    List<Katedra> katedre;
    String[] header = {"Id", "Naziv katedre", "Delatnost katedre"};

    public TableKatedreModel() {
    }

    public TableKatedreModel(List<Katedra> katedre) {
        this.katedre = katedre;
    }
    
    public void setData(List<Katedra> katedre){
        this.katedre = katedre;
    }
    
    @Override
    public int getRowCount() {
        return katedre.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Katedra k = katedre.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getKatedraId();
            case 1:
                return k.getNazivKatedre();
            case 2:
                return k.getDelatnostKatedre();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    public Katedra getKatedra(int red) {
        return katedre.get(red);
    }

    public void updateKatedra(Katedra katedra) {
        for (int i = 0; i<katedre.size(); i++) {
            if(katedre.get(i).getKatedraId() == katedra.getKatedraId())
                katedre.set(i, katedra);
        }
        fireTableDataChanged();
    }

    public void addKatedra(Katedra katedra) {
        katedre.add(katedra);
        fireTableDataChanged();
    }

    public void removeKatedra(int red) {
        katedre.remove(red);
        fireTableDataChanged();
    }
    
    
    
}
