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
import javax.swing.filechooser.FileNameExtensionFilter;
import storeproject.helper.CustomFileReader;
import storeproject.list.Lists;
import storeproject.list.SimplyLinkedCircularListProduct;
import storeproject.model.Offer;
import storeproject.model.OfferTableModel;
import storeproject.model.Product;

public class OfferAdministrationWindow extends javax.swing.JFrame {
    
    CustomFileReader fileReader = new CustomFileReader();
    OfferTableModel model = new OfferTableModel();
    private static int selected = 0;
    Offer currentOffer;
    SimplyLinkedCircularListProduct currentProducts = new SimplyLinkedCircularListProduct();
    private boolean notSelected = true;
    private Product currentProduct;
    
    public OfferAdministrationWindow() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        offersTable.setModel(model);
        generatePriorityCb();
        generateProductsCb();
        offersTable.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
           notSelected = false;
           int fila = offersTable.rowAtPoint(e.getPoint());
           selected = fila;
            }
         });
    }
    
    private void generatePriorityCb(){
        priorityCb.addItem("Alta");
        priorityCb.addItem("Baja");
    }
    
    private void generateProductsCb(){
        for(int i=1; i<Lists.products.listSize();i++){
            try {
                productsCb.addItem(Lists.products.getProductAt(i).getName());
            } catch (Exception ex) {
                Logger.getLogger(OfferAdministrationWindow.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        productsCb = new javax.swing.JComboBox<>();
        descriptionTxt = new javax.swing.JTextField();
        discountTxt = new javax.swing.JTextField();
        addProductBtn = new javax.swing.JButton();
        addOfferBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        offersTable = new javax.swing.JTable();
        loadArchiveBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        priorityCb = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Descripción");

        jLabel2.setText("Descuento");

        jLabel3.setText("Productos a aplicar ");

        productsCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        discountTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                discountTxtKeyTyped(evt);
            }
        });

        addProductBtn.setText("Agregar producto");
        addProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductBtnActionPerformed(evt);
            }
        });

        addOfferBtn.setText("Agregar");
        addOfferBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOfferBtnActionPerformed(evt);
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

        offersTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(offersTable);

        loadArchiveBtn.setText("Carga de datos");
        loadArchiveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadArchiveBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Prioridad");

        priorityCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(productsCb, 0, 155, Short.MAX_VALUE)
                    .addComponent(descriptionTxt)
                    .addComponent(discountTxt)
                    .addComponent(priorityCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(addProductBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addOfferBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadArchiveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(descriptionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addOfferBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(discountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(productsCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addProductBtn)
                    .addComponent(loadArchiveBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(jLabel4)
                    .addComponent(priorityCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadArchiveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadArchiveBtnActionPerformed
        
        JOptionPane.showMessageDialog(this, "Por favor, seleccione el archivo", "Archivo",
                                JOptionPane.INFORMATION_MESSAGE);
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter offerFilter=new FileNameExtensionFilter("Ofertas","proofer");
        fileChooser.setFileFilter(offerFilter);
        int optionChoose = fileChooser.showOpenDialog(this);
        if(optionChoose==JFileChooser.APPROVE_OPTION){
            File f = fileChooser.getSelectedFile();
            try{
                fileReader.readArchive(f.toString(), "Offers", this);
                JOptionPane.showMessageDialog(this, "Archivo cargado correctamente", "Archivo",
                                JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                OfferAdministrationWindow offersWindow = new OfferAdministrationWindow();
                offersWindow.setVisible(true);
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Ocurrió un error, inténtelo de nuevo", "Error",
                                JOptionPane.ERROR_MESSAGE);
            }                     
        }
        
        
    }//GEN-LAST:event_loadArchiveBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.dispose();
        AdministratorMainWindow mainWindow = new AdministratorMainWindow();
        mainWindow.setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        if(!notSelected){
            try{
                Lists.offers.delete(selected+1);
                for(int i = 1;i<=Lists.offers.getOfferAt(selected+1).getProducts().listSize();i++){
                    Lists.offers.getOfferAt(selected+1).getProducts().getProductAt(i).setOffer(null);
                    JOptionPane.showMessageDialog(this, "Oferta eliminada correctamente", "Eliminada",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Ocurrió un error, inténtelo de nuevo", "Error",
                            JOptionPane.ERROR_MESSAGE);
            } 
        }else{
            JOptionPane.showMessageDialog(this, "No ha seleccionado ningun elemento", "Error",
                            JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void addOfferBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOfferBtnActionPerformed
        try{
            if(priorityCb.getSelectedItem().equals("Alta")){
                Lists.offers.addToFinal(descriptionTxt.getText(), Double.valueOf(discountTxt.getText().trim()), currentProducts);
                JOptionPane.showMessageDialog(this, "Oferta agregada correctamente", "Agregada",
                            JOptionPane.INFORMATION_MESSAGE);
                
            }else if(priorityCb.getSelectedItem().equals("Baja")){
                Lists.offers.addToBegin(descriptionTxt.getText(), Double.valueOf(discountTxt.getText().trim()), currentProducts);
                JOptionPane.showMessageDialog(this, "Oferta agregada correctamente", "Agregada",
                            JOptionPane.INFORMATION_MESSAGE);
            } 
            currentOffer = new Offer(Lists.offers.listSize()-1, descriptionTxt.getText(), 
                Double.valueOf(discountTxt.getText().trim()), currentProducts);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Ocurrió un error al intentar agregar la oferta", "Error",
                            JOptionPane.ERROR_MESSAGE);
        }
        for(int i=1; i<=currentProducts.listSize();i++){
            try {
                currentProducts.getProductAt(i).setOffer(currentOffer);
                Lists.products.getProductByName(currentProducts.getProductAt(i).getName()).setOffer(currentOffer);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ocurrió un error al intentar agregar la oferta", "Error",
                            JOptionPane.ERROR_MESSAGE);
            }
        }
        currentProducts = new SimplyLinkedCircularListProduct();
        this.dispose();
        OfferAdministrationWindow window = new OfferAdministrationWindow();
        window.setVisible(true);
        
    }//GEN-LAST:event_addOfferBtnActionPerformed

    private void addProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductBtnActionPerformed
        if(!productsCb.getSelectedItem().equals("")){
            try{
                currentProduct = Lists.products.getProductByName((String) productsCb.getSelectedItem());
                currentProducts.addToFinal(currentProduct.getIdentifier(), currentProduct.getName(),
                    currentProduct.getDescription(), currentProduct.getPrice(), currentProduct.getStock(), 
                        currentProduct.getImageDirection(), currentProduct.getOffer());
                JOptionPane.showMessageDialog(this, "Producto agregado correctamente", "Agregado",
                            JOptionPane.INFORMATION_MESSAGE);
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Ocurrió un error al intentar agregar el producto", "Error",
                            JOptionPane.ERROR_MESSAGE);
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione un producto válido", "Error",
                            JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addProductBtnActionPerformed

    private void discountTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountTxtKeyTyped
        char validChar = evt.getKeyChar();
        if(Character.isLetter(validChar)){
           getToolkit().beep();
           evt.consume();        
        }
        
    }//GEN-LAST:event_discountTxtKeyTyped

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
            java.util.logging.Logger.getLogger(OfferAdministrationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OfferAdministrationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OfferAdministrationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OfferAdministrationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OfferAdministrationWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addOfferBtn;
    private javax.swing.JButton addProductBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField descriptionTxt;
    private javax.swing.JTextField discountTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loadArchiveBtn;
    private javax.swing.JTable offersTable;
    private javax.swing.JComboBox<String> priorityCb;
    private javax.swing.JComboBox<String> productsCb;
    // End of variables declaration//GEN-END:variables
}
