/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import storeproject.helper.CustomFileReader;
import storeproject.helper.RandomNumber;
import storeproject.list.Lists;
import storeproject.model.Product;
import storeproject.model.ProductTableModel;

public class ProductAdministrationWindow extends javax.swing.JFrame {
    
    ProductTableModel model = new ProductTableModel();
    RandomNumber random = RandomNumber.getSingletonInstance();
    CustomFileReader fileReader = new CustomFileReader();
    private Product modifyProduct;
    private boolean notSelected = true;
    private static int selected = 0;
    
    public ProductAdministrationWindow() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        productsTable.setModel(model);
        modifyBtn.setEnabled(false);
        productsTable.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
           notSelected = false;
           int fila = productsTable.rowAtPoint(e.getPoint());
           selected = fila;
                try {
                    modifyBtn.setEnabled(true);
                    addProductBtn.setEnabled(false);
                modifyProduct = Lists.products.getProductAt(selected+1);
                nameTxt.setText(modifyProduct.getName());
                descriptionTxt.setText(modifyProduct.getDescription());
                priceTxt.setText(String.valueOf(modifyProduct.getPrice()));
                stockTxt.setText(String.valueOf(modifyProduct.getStock()));
                imageDirectionTxt.setText(modifyProduct.getImageDirection());
                } catch (Exception ex) {
                Logger.getLogger(ProductAdministrationWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
         });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTxt = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        priceTxt = new javax.swing.JTextField();
        nameTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        stockTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        imageDirectionTxt = new javax.swing.JTextField();
        addProductBtn = new javax.swing.JButton();
        modifyBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();
        loadArchiveBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Descripción");

        descriptionTxt.setColumns(20);
        descriptionTxt.setRows(5);
        jScrollPane1.setViewportView(descriptionTxt);

        jLabel3.setText("Precio");

        priceTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                priceTxtKeyTyped(evt);
            }
        });

        jLabel4.setText("Existencia");

        stockTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stockTxtKeyTyped(evt);
            }
        });

        jLabel5.setText("Direccion de la imagen");

        addProductBtn.setText("Agregar");
        addProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductBtnActionPerformed(evt);
            }
        });

        modifyBtn.setText("Modificar");
        modifyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Eliminar");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        backBtn.setText("Atrás");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(productsTable);

        loadArchiveBtn.setText("Cargar archivo");
        loadArchiveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadArchiveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(priceTxt)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(stockTxt)
                    .addComponent(imageDirectionTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loadArchiveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addProductBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modifyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(stockTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addProductBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(imageDirectionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modifyBtn))
                        .addGap(18, 18, 18)
                        .addComponent(deleteBtn)
                        .addGap(18, 18, 18)
                        .addComponent(loadArchiveBtn)
                        .addGap(18, 18, 18)
                        .addComponent(backBtn)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductBtnActionPerformed
        try{
            Lists.products.addToFinal(random.generateIdentifier(), nameTxt.getText(), descriptionTxt.getText(), 
                Double.valueOf(priceTxt.getText()), Integer.valueOf(stockTxt.getText()), imageDirectionTxt.getText());
            JOptionPane.showMessageDialog(this, "Producto agregado correctamente", "Agregado",
                            JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            ProductAdministrationWindow adminWindow = new ProductAdministrationWindow();
            adminWindow.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Ocurrió un error, inténtelo de nuevo", "Error",
                            JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_addProductBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
        AdministratorMainWindow adminMainWindow = new AdministratorMainWindow();
        adminMainWindow.setVisible(true);     
    }//GEN-LAST:event_backBtnActionPerformed

    private void loadArchiveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadArchiveBtnActionPerformed
        JOptionPane.showMessageDialog(this, "Por favor, seleccione el archivo", "Archivo",
                                JOptionPane.INFORMATION_MESSAGE);
        JFileChooser fileChooser = new JFileChooser();
        int optionChoose = fileChooser.showOpenDialog(this);
        if(optionChoose==JFileChooser.APPROVE_OPTION){
            File f = fileChooser.getSelectedFile();
            try{
                fileReader.readArchive(f.toString(), "Products", this);
                JOptionPane.showMessageDialog(this, "Archivo cargado correctamente", "Agregado",
                                JOptionPane.INFORMATION_MESSAGE);
                loadArchiveBtn.setEnabled(false);
                this.dispose();
                ProductAdministrationWindow productsWindow = new ProductAdministrationWindow();
                productsWindow.setVisible(true);
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Ocurrió un error, inténtelo de nuevo", "Error",
                                JOptionPane.ERROR_MESSAGE);
            }                      
        }
    }//GEN-LAST:event_loadArchiveBtnActionPerformed

    private void modifyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyBtnActionPerformed
        if(!notSelected){
           try{
               Lists.products.edit(selected+1, nameTxt.getText().trim(), descriptionTxt.getText().trim(),
                       Double.valueOf(priceTxt.getText().trim()), Integer.valueOf(stockTxt.getText().trim()),
                       imageDirectionTxt.getText());
                JOptionPane.showMessageDialog(this, "Producto editado correctamente", "Editado",
                            JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                ProductAdministrationWindow productsWindow = new ProductAdministrationWindow();
                productsWindow.setVisible(true);
                
           }catch(Exception e){
               JOptionPane.showMessageDialog(this, "Ocurrió un error, inténtelo de nuevo", "Error",
                            JOptionPane.ERROR_MESSAGE);
           }
        }else{
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un elemento", "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_modifyBtnActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        modifyBtn.setEnabled(false);
        addProductBtn.setEnabled(true);
        nameTxt.setText("");
        descriptionTxt.setText("");
        priceTxt.setText("");
        stockTxt.setText("");
        imageDirectionTxt.setText("");
    }//GEN-LAST:event_formMouseClicked

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        if(!notSelected){
            try{
            Lists.products.delete(selected +1);
            JOptionPane.showMessageDialog(this, "Producto eliminado correctamente", "Editado",
                            JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            ProductAdministrationWindow productsWindow = new ProductAdministrationWindow();
            productsWindow.setVisible(true);
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Ocurrió un error, inténtelo de nuevo", "Error",
                            JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un elemento", "Error",
                            JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void priceTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceTxtKeyTyped
        char validChar = evt.getKeyChar();
        if(Character.isLetter(validChar)){
            getToolkit().beep();
            evt.consume();        
        }
    }//GEN-LAST:event_priceTxtKeyTyped

    private void stockTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockTxtKeyTyped
        char validChar = evt.getKeyChar();
        if(Character.isLetter(validChar)){
            getToolkit().beep();
            evt.consume();        
        }
    }//GEN-LAST:event_stockTxtKeyTyped

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
            java.util.logging.Logger.getLogger(ProductAdministrationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductAdministrationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductAdministrationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductAdministrationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductAdministrationWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProductBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextArea descriptionTxt;
    private javax.swing.JTextField imageDirectionTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton loadArchiveBtn;
    private javax.swing.JButton modifyBtn;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JTextField priceTxt;
    private javax.swing.JTable productsTable;
    private javax.swing.JTextField stockTxt;
    // End of variables declaration//GEN-END:variables
}
