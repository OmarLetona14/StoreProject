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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import storeproject.list.DoubleLinkedCircularListCartProduct;
import storeproject.list.SimplyLinkedCircularListProduct;
import storeproject.model.Product;
import storeproject.view.LoginWindow;
import storeproject.view.UserMainWindow;

public class ProductButton extends JButton implements ActionListener {
    
    String nowPrice;
    private DoubleLinkedCircularListCartProduct cartProduct;
    private final Product product;
    private final JFrame window;
    private JButton cartBtn;
    private boolean offered;
    
    public ProductButton(int x, int y, Product product, JPanel enviroment, JFrame window, JButton cartBtn, boolean offered){
        setText("Agregar a carrito");
        this.product = product;
        this.window = window;
        this.cartBtn = cartBtn;
        this.offered = offered;
        setSize(160, 25);
        setLocation(x, y);
        addActionListener(this);
        enviroment.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(LoginWindow.currentUser.getCart().getCartProducts()!=null){
                if(offered){
                    LoginWindow.currentUser.getCart().getCartProducts().addToFinal(product.getIdentifier(), product.getName(), product.getDescription(), 
                   product.getPrice() - product.getOffer().getDiscount(), product.getStock(), product.getImageDirection(), product.getOffer());
                    
                }else{
                    LoginWindow.currentUser.getCart().getCartProducts().addToFinal(product.getIdentifier(), product.getName(), product.getDescription(), 
                   product.getPrice(), product.getStock(), product.getImageDirection(), product.getOffer());
                    LoginWindow.currentUser.getCart().setTotal(LoginWindow.currentUser.getCart().getTotal()+product.getPrice());
                }
                JOptionPane.showMessageDialog(window, "Se agregó al carrito", "Agregado",
                            JOptionPane.INFORMATION_MESSAGE);
            }else{
                cartProduct = new DoubleLinkedCircularListCartProduct();
                if(offered){
                    cartProduct.addToFinal(product.getIdentifier(), product.getName(), product.getDescription(), 
                            product.getPrice()- product.getOffer().getDiscount(), product.getStock(), product.getImageDirection(), product.getOffer());
                LoginWindow.currentUser.getCart().setTotal(LoginWindow.currentUser.getCart().getTotal()+(product.getPrice()- product.getOffer().getDiscount()));
                }else{
                    cartProduct.addToFinal(product.getIdentifier(), product.getName(), product.getDescription(), 
                        product.getPrice(), product.getStock(), product.getImageDirection(), product.getOffer());
                    LoginWindow.currentUser.getCart().setTotal(LoginWindow.currentUser.getCart().getTotal()+product.getPrice());
                }
                
                LoginWindow.currentUser.getCart().setCartProducts(cartProduct);
                
                JOptionPane.showMessageDialog(window, "Se agregó al carrito", "Agregado",
                            JOptionPane.INFORMATION_MESSAGE);
            }
            if(offered){
                UserMainWindow.total += (product.getPrice()-product.getOffer().getDiscount());
                UserMainWindow.cartText = "Carrito" + "(Q"+UserMainWindow.total+")";
                cartBtn.setText(UserMainWindow.cartText);
            }else{
                UserMainWindow.total += product.getPrice();
                UserMainWindow.cartText = "Carrito" + "(Q"+UserMainWindow.total+")";
                cartBtn.setText(UserMainWindow.cartText);
            }             
        }catch(Exception ex){
            JOptionPane.showMessageDialog(window, "Ocurrió un error, inténtelo de nuevo", "Error",
                                JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
