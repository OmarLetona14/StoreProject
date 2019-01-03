/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.view;

import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import storeproject.controller.DescriptionLabel;
import storeproject.controller.ImageLabel;
import storeproject.controller.ProductButton;
import storeproject.list.Lists;
import storeproject.list.SimplyLinkedCircularListProduct;
import storeproject.model.Product;

public class UserMainWindow extends javax.swing.JFrame implements Runnable{
    
    public static String cartText;
    public static double total = 0.0;
    ImageLabel[][] imageLabelMatrix;
    DescriptionLabel[][] descriptionLabelMatrix;
    ProductButton[][] productButtonMatrix;
    SimplyLinkedCircularListProduct offeredProductsList;
    Product currentProduct;
    private static boolean verified = false;
    ProductsWindow productsWindow;
    int filas, tamaño;
    JPanel conteiner;
    
    public UserMainWindow() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        userNameTxt.setText( "Hola, " + LoginWindow.currentUser.getName());
        cartText = "Carrito" + "("+total+")";
        cartBtn.setText(cartText);
        boolean loaded;
        offeredProductsList = new SimplyLinkedCircularListProduct();
        if(!verified){
            ProgressWindow progressWindow= new ProgressWindow(true);
            progressWindow.setVisible(true);
        }
        
        generateOfferedProductsMatrix();
    }
    
    private int generateListSize(){
        int size=0;
        for(int i= 1; i<Lists.offers.listSize();i++){
            try {
                size += (Lists.offers.getOfferAt(i).getProducts().listSize()-1);
                for(int j=1; j<Lists.offers.getOfferAt(i).getProducts().listSize(); j++){
                    currentProduct = Lists.offers.getOfferAt(i).getProducts().getProductAt(j);
                    offeredProductsList.addToFinal(currentProduct.getIdentifier(), currentProduct.getName(), 
                            currentProduct.getDescription(), currentProduct.getPrice(), currentProduct.getStock(), 
                            currentProduct.getImageDirection());
                }
            } catch (Exception ex) {
                Logger.getLogger(UserMainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return size;
    }
    
    private void generateOfferedProductsMatrix(){
        
        conteiner = new JPanel();
        conteiner.setLayout(null);
        tamaño = generateListSize();
        filas = (tamaño/4)+1;
        imageLabelMatrix = new ImageLabel[filas][4];
        descriptionLabelMatrix = new DescriptionLabel[filas][4];
        productButtonMatrix = new ProductButton[filas][4];
        for(int fila = 0; fila<filas; fila++){
            for(int columna = 0; columna<=3; columna++){
                if(tamaño!=0){
                    try {
                        productButtonMatrix[fila][columna] = new ProductButton((15+190*columna), (180+220*fila),
                                offeredProductsList.getProductAt(tamaño),false, conteiner, this, cartBtn);
                        imageLabelMatrix[fila][columna] = new ImageLabel( (15+ 190*columna),  (15 +220*fila), 
                                offeredProductsList.getProductAt(tamaño), conteiner);
                        descriptionLabelMatrix[fila][columna] = new DescriptionLabel(15+190*columna, (120+220*fila), 
                                offeredProductsList.getProductAt(tamaño), conteiner);
                    } catch (Exception ex) {
                        Logger.getLogger(ProductsWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }         
                    conteiner.setPreferredSize(new Dimension(780, filas*220));
                    offersPanel .setViewportView(conteiner);
                    offersPanel .getViewport().setView(conteiner);                    
                    tamaño--;                   
                }
            }
        }
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userNameTxt = new javax.swing.JLabel();
        cartBtn = new javax.swing.JButton();
        closeSessionBtn = new javax.swing.JButton();
        offersPanel = new javax.swing.JScrollPane();
        editUserBtn = new javax.swing.JButton();
        allProductsBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartBtnActionPerformed(evt);
            }
        });

        closeSessionBtn.setText("Cerrar sesión");
        closeSessionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeSessionBtnActionPerformed(evt);
            }
        });

        editUserBtn.setText("Modificar");
        editUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserBtnActionPerformed(evt);
            }
        });

        allProductsBtn.setText("Ver todos los productos de la tienda");
        allProductsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allProductsBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(offersPanel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(closeSessionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(allProductsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(closeSessionBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cartBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editUserBtn))
                .addGap(57, 57, 57)
                .addComponent(offersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(allProductsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void allProductsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allProductsBtnActionPerformed

        if(!verified){
            this.dispose();
            new Thread(this).start();
            productsWindow = new ProductsWindow();
        }else{ 
            this.dispose();
            productsWindow = new ProductsWindow();
            productsWindow.setVisible(true);
        }
    }//GEN-LAST:event_allProductsBtnActionPerformed

    private void closeSessionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeSessionBtnActionPerformed
        this.dispose();
        LoginWindow login = new LoginWindow();
        login.setVisible(true);
    }//GEN-LAST:event_closeSessionBtnActionPerformed

    private void editUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserBtnActionPerformed
        AddUserWindow editUser = new AddUserWindow(LoginWindow.currentUser.getName(), LoginWindow.currentUser.getEmail(),
        LoginWindow.currentUser.getNickname(), LoginWindow.currentUser.getPassword(), LoginWindow.currentUser.getCreditCard(),true);
        editUser.setVisible(true);
    }//GEN-LAST:event_editUserBtnActionPerformed

    private void cartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartBtnActionPerformed
        this.dispose();
        CartWindow cartWindow = new CartWindow();
        cartWindow.setVisible(true);
    }//GEN-LAST:event_cartBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton allProductsBtn;
    private javax.swing.JButton cartBtn;
    private javax.swing.JButton closeSessionBtn;
    private javax.swing.JButton editUserBtn;
    private javax.swing.JScrollPane offersPanel;
    private javax.swing.JLabel userNameTxt;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while(!verified){
            try {
                if(ProgressWindow.disposed){
                    productsWindow.setVisible(true);
                    ProgressWindow.disposed = false;
                    verified = true;
                }
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
