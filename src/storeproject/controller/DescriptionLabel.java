/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.controller;

import javax.swing.JLabel;
import javax.swing.JPanel;
import storeproject.model.Product;

public class DescriptionLabel extends JLabel{
    
    public DescriptionLabel(int x, int y, Product product, JPanel enviroment, boolean offer){   
        setSize(160, 75);
        setLocation(x, y);
        if(!offer){
            setText( "<html>"+ product.getDescription() + "<p>" + " Precio: Q"
        +product.getPrice()+"</html>");
        }else{
            setText( "<html>"+ product.getDescription() + "<p>" + " Precio anterior: Q"
        +product.getPrice() + "<p>" + "Precio con descuento: Q"+
                    (product.getPrice()-product.getOffer().getDiscount())+"</html>");
        }
        
        
        enviroment.add(this);
    }
    
}
