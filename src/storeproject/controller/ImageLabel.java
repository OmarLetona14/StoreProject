/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.controller;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import storeproject.model.Product;

public class ImageLabel extends JLabel {
    
    
    public ImageLabel(int x, int y, Product product, JPanel enviroment){
        setSize(160, 90);
        setLocation(x, y);
        Image backgroundImages = new ImageIcon(product.getImageDirection()).getImage();
        ImageIcon backgroundImageScaled = new ImageIcon (backgroundImages.getScaledInstance(160,90,Image.SCALE_DEFAULT));
        setIcon(backgroundImageScaled);
        enviroment.add(this);
    }
    
}
