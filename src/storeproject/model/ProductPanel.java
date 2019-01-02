/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.model;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import storeproject.controller.ProductButtonActionListener;

public class ProductPanel extends JPanel {
    
    private Product product;
    private JButton productBtn;
    private JLabel imageLbl;
    private JLabel descriptionLbl;
    ProductButtonActionListener listener;
    
    public ProductPanel(int x, int y, Product product){
        this.product = product;
        setSize(125, 175);
        setLocation(x, y);
        imageLbl = new JLabel();
        descriptionLbl = new JLabel();
        descriptionLbl.setSize(95, 25);
        descriptionLbl.setLocation(15, 100);
        descriptionLbl.setText(product.getDescription());
        imageLbl.setSize(95, 80);
        imageLbl.setLocation(15, 15);
        Image backgroundImages = new ImageIcon(product.getImageDirection()).getImage();
        ImageIcon backgroundImageScaled = new ImageIcon (backgroundImages.getScaledInstance(95,80,Image.SCALE_DEFAULT));
        imageLbl.setIcon(backgroundImageScaled);
        listener = new ProductButtonActionListener();
        productBtn = new JButton();
        productBtn.addActionListener(listener);
        productBtn.setText("Agregar a carrito");
        productBtn.setSize(75, 25);
        productBtn.setLocation(25, 140);
        add(productBtn);
        add(imageLbl);
        add(descriptionLbl);
    }
    
}
