/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.controller;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import storeproject.model.Product;

public class DescriptionLabel extends JLabel{
    
    public DescriptionLabel(int x, int y, Product product, JPanel enviroment){       
        setSize(160, 75);
        setLocation(x, y);
        setAlignmentY(CENTER);
        setText( "<html>"+ product.getDescription() + "<p>" + " Precio: Q"
        +product.getPrice()+"</html>");
        enviroment.add(this);
    }
    
}
