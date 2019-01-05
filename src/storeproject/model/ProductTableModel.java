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

public class ProductTableModel extends AbstractTableModel {
    private final String[] columnNames = new String[]{
        "Identificador","Nombre", "Descripcion", "Precio", "Existencia", "Direccion de la imagen"
    };
    
    private final Class[] columnClass = new Class[] {
        Integer.class, String.class, String.class, Double.class, Integer.class, String.class
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
        return Lists.products.listSize();
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Product row = null;
        try {
            if((rowIndex+1)!=getRowCount()){
                row = Lists.products.getProductAt(rowIndex+1);
            } 
        } catch (Exception ex) {
            Logger.getLogger(ProductTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }if(row!=null){
            if(0 == columnIndex) {
            return row.getIdentifier();
            }
            else if(1 == columnIndex) {
                return row.getName();
            }
            else if(2 == columnIndex) {
                return row.getDescription();
            }
            else if(3 == columnIndex) {
                return row.getPrice();
            }
            else if(4 == columnIndex) {
                return row.getStock();
            }
            else if(5 == columnIndex) {
                return row.getImageDirection();
            }
        }
        
        return null;
    }
    @Override
   public void setValueAt(Object aValue, int rowIndex, int columnIndex)
   {    
       Product instance = (Product)aValue;
       Product row = null;
        try {
            row = Lists.products.getProductAt(rowIndex-1); 
        } catch (Exception ex) {
            Logger.getLogger(ProductTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(row!=null){
            switch (columnIndex) {
            case 0:
                row.setIdentifier((Integer) instance.getIdentifier());
                break;
            case 1:
                row.setName((String) instance.getName());
                break;
            case 2:
                row.setDescription((String) instance.getDescription());
                break;
            case 3:
                row.setPrice((Double) instance.getPrice());
                break;
            case 4:
                row.setStock((Integer) instance.getStock());
                break;
            case 5:
                row.setImageDirection((String) instance.getImageDirection());
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