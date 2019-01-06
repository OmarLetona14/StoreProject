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

public class ProductsWindow extends javax.swing.JFrame {
    
    ImageLabel[][] imageLabelMatrix;
    DescriptionLabel[][] descriptionLabelMatrix;
    ProductButton[][] productButtonMatrix;
    int filas, tamaño;
    boolean loaded;
    JPanel conteiner;
    
    public ProductsWindow(){
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        cartBtn.setText(UserMainWindow.cartText);
        generateProductsMatrix();
        ProgressWindow progressWindow= new ProgressWindow(true);
        progressWindow.setVisible(true);
        userNameTxt.setText( "Hola, " + LoginWindow.currentUser.getName());
        UserMainWindow.cartText = "Carrito" + "("+UserMainWindow.total+")";
    }
    
    private void generateProductsMatrix(){
        conteiner = new JPanel();
        conteiner.setLayout(null);
        tamaño = Lists.products.listSize()-1;
        filas = (tamaño/4)+1;
        imageLabelMatrix = new ImageLabel[filas][4];
        descriptionLabelMatrix = new DescriptionLabel[filas][4];
        productButtonMatrix = new ProductButton[filas][4];
        for(int fila = 0; fila<filas; fila++){
            for(int columna = 0; columna<=3; columna++){
                if(tamaño!=0){
                    try {
                        productButtonMatrix[fila][columna] = new ProductButton((15+190*columna), (180+220*fila),
                                Lists.products.getProductAt(tamaño), conteiner, this, cartBtn, false);
                        imageLabelMatrix[fila][columna] = new ImageLabel( (15+ 190*columna),  (15 +220*fila), Lists.products.getProductAt(tamaño), conteiner);
                        descriptionLabelMatrix[fila][columna] = new DescriptionLabel(15+190*columna, (110+220*fila), Lists.products.getProductAt(tamaño), conteiner,false);
                    } catch (Exception ex) {
                        Logger.getLogger(ProductsWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }         
                    conteiner.setPreferredSize(new Dimension(780, filas*220));
                    scrollProducts .setViewportView(conteiner);
                    scrollProducts .getViewport().setView(conteiner);                    
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

        jProgressBar1 = new javax.swing.JProgressBar();
        userNameTxt = new javax.swing.JLabel();
        cartBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        modifyUserBtn = new javax.swing.JButton();
        scrollProducts = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartBtnActionPerformed(evt);
            }
        });

        backBtn.setText("Atrás");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        modifyUserBtn.setText("Modificar");
        modifyUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyUserBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(modifyUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185)
                .addComponent(cartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollProducts)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(modifyUserBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cartBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(backBtn))
                .addGap(18, 18, 18)
                .addComponent(scrollProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modifyUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyUserBtnActionPerformed
        AddUserWindow editUser = new AddUserWindow(LoginWindow.currentUser.getName(), LoginWindow.currentUser.getEmail(),
        LoginWindow.currentUser.getNickname(), LoginWindow.currentUser.getPassword(), LoginWindow.currentUser.getCreditCard(),true);
        editUser.setVisible(true);
    }//GEN-LAST:event_modifyUserBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
        UserMainWindow userMain = new UserMainWindow();
        userMain.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ProductsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductsWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton cartBtn;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JButton modifyUserBtn;
    private javax.swing.JScrollPane scrollProducts;
    private javax.swing.JLabel userNameTxt;
    // End of variables declaration//GEN-END:variables
}
