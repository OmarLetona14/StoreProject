/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.helper;

import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import storeproject.list.Lists;
import storeproject.model.Bill;
import storeproject.model.Product;
import storeproject.model.User;

public class GenerateFile {
    
    String articles = "";
    Product currentProduct;
    User currentUser;
    
    public void generateBill(String route, Bill bill){
        try {
            String text;
            FileOutputStream archive = new FileOutputStream(route+ ".pdf");
            Document document = new Document();
            PdfWriter.getInstance(document, archive);
            document.open();
            text  = "Factura de compra " + "\n\n"+
                    "Nombre: " + bill.getName() + "\n"+ 
                    "Direccion: " + bill.getAddress() + "\n" +
                     "NIT: " + bill.getNIT()+ "\n" + 
                    "DETALLE DE ARTICULOS COMPRADOS "+ "\n\n"+
                    generateArticlesDetail(bill);           
            document.add(new Paragraph(text));
            document.close();
        } catch (Exception ex) {}
    
    }
    
    private String generateArticlesDetail(Bill bill){
        for(int i=1; i<bill.getUser().getCart().getCartProducts().listSize();i++){
            try {
                currentProduct = bill.getUser().getCart().getCartProducts().getProductAt(i);
                articles += "Articulo: "+ currentProduct.getName() + "||" +  " Precio: " + currentProduct.getPrice() + "\n";
            } catch (Exception ex) {
                Logger.getLogger(GenerateFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
        return articles;
    }
    
    public void generateCanceledPaymentReport(String route) throws DocumentException, FileNotFoundException{
        FileOutputStream archive;
        archive = new FileOutputStream(route+ ".pdf");
        Document document = new Document();
        PdfWriter.getInstance(document, archive);
        Table canceledTable = new Table(new float[]{5,5});
        canceledTable.addHeaderCell(new Cell().add("Usuario"));
        canceledTable.addHeaderCell(new Cell().add("Veces cancelada"));
        canceledTable.setWidth(100);    
        for(int i=1; i<= Lists.users.listSize(); i++){
            try {
                currentUser = Lists.users.getUserAt(i);
            } catch (Exception ex) {
                Logger.getLogger(GenerateFile.class.getName()).log(Level.SEVERE, null, ex);
            }  
            if(currentUser.getCanceled().isCanceled()){
                    
               canceledTable.addCell(new Cell().add(currentUser.getName()));
            }         
        }
        document.open();          
        document.add((Element) canceledTable);
        document.close();
    }
    
}
