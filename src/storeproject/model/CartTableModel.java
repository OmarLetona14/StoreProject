/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import storeproject.view.LoginWindow;

public class CartTableModel extends AbstractTableModel{
    
    private final String[] columnNames = new String[]{
        "Producto","Precio(Q)"
    };
    
    private final Class[] columnClass = new Class[] {
        String.class, Double.class
    };
    
    @Override
    public String getColumnName(int column){
        return columnNames[column];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        return columnClass[columnIndex];
    }
    
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    
    @Override
    public int getRowCount(){
        if(LoginWindow.currentUser.getCart().getCartProducts()!=null){
            return LoginWindow.currentUser.getCart().getCartProducts().listSize();
        }else{
            return 1;
        }  
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        Product row = null;
        try {
            if((rowIndex+1)!=getRowCount()){
                if(LoginWindow.currentUser.getCart().getCartProducts()!=null){
                    row = LoginWindow.currentUser.getCart().getCartProducts().getProductAt(rowIndex+1);
                }
            } 
        } catch (Exception ex) {
            Logger.getLogger(ProductTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }if(row!=null){
            if(0 == columnIndex) {
            return row.getName();
            }
            else if(1 == columnIndex) {
                return row.getPrice();
            }
        }
        return null;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){    
       Product instance = (Product)aValue;
       Product row = null;
        try {
            if(LoginWindow.currentUser.getCart().getCartProducts()!=null){
                row = LoginWindow.currentUser.getCart().getCartProducts().getProductAt(rowIndex+1);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(row!=null){
            switch (columnIndex) {
            case 0:
                row.setName((String) instance.getName());
                break;
            case 1:
                row.setPrice((Double) instance.getPrice() - instance.getOffer().getDiscount());
                break;
            default:
                break;
            }
        }        
    }
   
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false;
    }
}
