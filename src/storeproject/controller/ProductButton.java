/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import storeproject.list.SimplyLinkedCircularListProduct;
import storeproject.model.Product;
import storeproject.view.LoginWindow;
import storeproject.view.UserMainWindow;

public class ProductButton extends JButton implements ActionListener {
    
    String nowPrice;
    private SimplyLinkedCircularListProduct cartProduct;
    private final Product product;
    private final JFrame window;
    private JButton cartBtn;
    
    public ProductButton(int x, int y, Product product, boolean offer, JPanel enviroment, JFrame window, JButton cartBtn){
        if(!offer){
            setText("Agregar a carrito");
        }else{
            nowPrice = String.valueOf(product.getPrice()- product.getOffer().getDiscount());
            setText("Agregar a carrito"+" antes: "+product.getPrice()+ " ahora: "
                    +nowPrice);
        }
        this.product = product;
        this.window = window;
        this.cartBtn = cartBtn;
        setSize(160, 25);
        setLocation(x, y);
        addActionListener(this);
        enviroment.add(this);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(LoginWindow.currentUser.getCart().getCartProducts()!=null){
           LoginWindow.currentUser.getCart().getCartProducts().addToFinal(product.getIdentifier(), product.getName(), product.getDescription(), 
                   product.getPrice(), product.getStock(), product.getImageDirection());
           
             LoginWindow.currentUser.getCart().setTotal(LoginWindow.currentUser.getCart().getTotal()+product.getPrice());
             
           JOptionPane.showMessageDialog(window, "Se agregó al carrito", "Agregado",
                            JOptionPane.INFORMATION_MESSAGE);
            }else{
                cartProduct = new SimplyLinkedCircularListProduct();
                cartProduct.addToFinal(product.getIdentifier(), product.getName(), product.getDescription(), 
                        product.getPrice(), product.getStock(), product.getImageDirection());
                LoginWindow.currentUser.getCart().setCartProducts(cartProduct);
                LoginWindow.currentUser.getCart().setTotal(LoginWindow.currentUser.getCart().getTotal()+product.getPrice());
                JOptionPane.showMessageDialog(window, "Se agregó al carrito", "Agregado",
                            JOptionPane.INFORMATION_MESSAGE);
            }
            UserMainWindow.total += product.getPrice();
            UserMainWindow.cartText = "Carrito" + "("+UserMainWindow.total+")";
            cartBtn.setText(UserMainWindow.cartText);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(window, "Ocurrió un error, inténtelo de nuevo", "Error",
                                JOptionPane.ERROR_MESSAGE);
        }
       
       
    }
    
}
