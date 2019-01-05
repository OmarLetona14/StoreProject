/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import storeproject.list.Lists;

public class OfferTableModel extends AbstractTableModel {
    
    private final String[] columnNames = new String[]{
        "Descripcion","Descuento"
    };
    
    private final Class[] columnClass = new Class[] {
        String.class, Double.class
    };
    
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
    @Override
    public int getRowCount()
    {
        return Lists.offers.listSize();
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Offer row = null;
        try {
            if((rowIndex+1)!=getRowCount()){
                row = Lists.offers.getOfferAt(rowIndex+1);
            } 
        } catch (Exception ex) {
            Logger.getLogger(ProductTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }if(row!=null){
            if(0 == columnIndex) {
            return row.getDescription();
            }
            else if(1 == columnIndex) {
                return row.getDiscount();
            }
        }
        
        return null;
    }
    @Override
   public void setValueAt(Object aValue, int rowIndex, int columnIndex)
   {    
       Offer instance = (Offer)aValue;
       Offer row = null;
        try {
            row = Lists.offers.getOfferAt(rowIndex+1); 
        } catch (Exception ex) {
            Logger.getLogger(ProductTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(row!=null){
            switch (columnIndex) {
            case 0:
                row.setDescription((String) instance.getDescription());
                break;
            case 1:
                row.setDiscount((Double) instance.getDiscount());
                break;
            default:
                break;
            }
        }        
   }
   
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }
    
}
