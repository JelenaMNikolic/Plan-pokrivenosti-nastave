/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import domain.PlanPokrivenostiNastave;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sanja
 */
public class PlanoviTableModel extends AbstractTableModel {

    List<PlanPokrivenostiNastave> planovi;
    String[] header = {"Sifra plana", "Godina"};

    public PlanoviTableModel(List<PlanPokrivenostiNastave> planovi) {
        this.planovi = planovi;
    }

    @Override
    public int getRowCount() {
        return planovi.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PlanPokrivenostiNastave ppn = planovi.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ppn.getPpnId();
            case 1:
                Date date = ppn.getGodina();
                Calendar c = Calendar.getInstance();
                c.setTime(date);
                return c.get(Calendar.YEAR);
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    public PlanPokrivenostiNastave getPlan(int row) {
        return planovi.get(row);
    }

    public void updatePlanovi(PlanPokrivenostiNastave ppn) {
        for (int i = 0; i < planovi.size(); i++) {
            if(planovi.get(i).equals(ppn)) {
                planovi.set(i, ppn);
            }
        }
        fireTableDataChanged();
    }

    public void removePPN(int row) {
        planovi.remove(row);
        fireTableDataChanged();
    }

}
