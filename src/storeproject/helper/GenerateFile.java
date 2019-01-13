/*
 * To change this template file, choose Tools | Templates * To change this license header, choose License Headers in Project Properties.

 * and open the template in the editor.
 */
package storeproject.helper;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import storeproject.list.Lists;
import storeproject.list.SimplyLinkedCircularListProduct;
import storeproject.model.Bill;
import storeproject.model.Offer;
import storeproject.model.Product;
import storeproject.model.User;
import storeproject.view.GraphicWindow;

public class GenerateFile {
    
    String articles = "";
    Product currentProduct, tempProduct, graphicProduct;
    User currentUser, billUser;
    FileWriter filewriter = null;
    PrintWriter printw = null;
    Bill currentBill;
    Offer currentOffer;
    int count;
    int[] numbers;
    
    public void generateBill(String route, Bill bill){
        try {
            String text;
            PdfWriter writter = new PdfWriter(route+ ".pdf");
            PdfDocument pdfDoc = new PdfDocument(writter);
            Document document = new Document(pdfDoc);
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
    
    public File generateProductsPerUserReport() throws IOException, Exception{
        File newFile = new File("C:\\Users\\Omar\\Desktop\\StoreProject\\reports\\Productos comprados por cada usuario.html");
        filewriter = new FileWriter(newFile);
        printw = new PrintWriter(filewriter);
        printw.println("<html>");
        printw.println("<head><title>Listado de productos comprados por usuario</title></head>");
        printw.println("<body>");
        for(int i=1; i<Lists.users.listSize();i++){
            billUser = Lists.users.getUserAt(i);
            if(billUser!=null){
                if(billUser.getPurchasedProducts().listSize()>1){
                printw.println("<center><h1><font color=\"navy\">USUARIO: "+ billUser.getName()+ "</font></h1></center>");   
                    for(int x = 1; x<(billUser.getPurchasedProducts().listSize()-1);x++){
                    tempProduct = billUser.getPurchasedProducts().getProductAt(x);
                        if(tempProduct!=null){
                            printw.println("<center><h3><font color=\"black\">Producto: "+ 
                            tempProduct.getName()+ "</font></h3></center>"); 
                        }
                    }
                } 
            }
        }     
        printw.println("</body>");
        printw.println("</html>");
        printw.close();
        return newFile;
    }
    
    public File generateCanceledPaymentReport(String route) throws FileNotFoundException{
        File newFile = new File(route+ ".pdf");
        PdfWriter writter = new PdfWriter(newFile);
        PdfDocument pdfDoc = new PdfDocument(writter);
        Document document = new Document(pdfDoc);
        Table canceledTable = new Table(new float[]{10,10});
        canceledTable.addHeaderCell(new Cell().add(new Paragraph("Usuario")));
        canceledTable.addHeaderCell(new Cell().add(new Paragraph("No. Cancelaciones")));
        canceledTable.setWidth(100);    
        for(int i=1; i< Lists.users.listSize(); i++){
            try {
                currentUser = Lists.users.getUserAt(i);
            } catch (Exception ex) {
                Logger.getLogger(GenerateFile.class.getName()).log(Level.SEVERE, null, ex);
            } 
            if(currentUser.getCanceled()!=null){
                canceledTable.addCell(new Cell().add(new Paragraph(currentUser.getName())));
                canceledTable.addCell(new Cell().add(new Paragraph(String.valueOf(currentUser.getCanceled().getNoCanceled()))));
            }           
        }        
        document.add(canceledTable);
        document.close();
        return newFile;
    }
    
     private static void burbuja(int[] arreglo){
        for(int i = 0; i < arreglo.length - 1; i++){
            for(int j = 0; j < arreglo.length - 1; j++){
                if (arreglo[j] < arreglo[j + 1]){
                    int tmp = arreglo[j+1];
                    arreglo[j+1] = arreglo[j];
                    arreglo[j] = tmp;
                }
            }
        }
    }
     
     private int usedMatrixPointer(){
         int count=0;
         for(int i: numbers){
             if(i!=0){
                 count++;
             }
         }return count;
     }

    public void generateGraphic() throws Exception{
        JFreeChart graphic;
        numbers = new int[100];
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        for(int i=1;i<=Lists.products.listSize();i++){
            numbers[i-1] = (int)Lists.products.getProductAt(i).getGain();  
        }
        burbuja(numbers);      
        for(int x=0; x<=usedMatrixPointer();x++){        
                graphicProduct = Lists.products.getProductByGain(numbers[x]);
                if(graphicProduct!=null){
                    if(x<10){
                    data.addValue(graphicProduct.getGain(), "10 productos más vendidos", graphicProduct.getName());  
                    }
                }
        }
        graphic = ChartFactory.createBarChart("Top 10 productos más vendidos", 
                "Productos", "Ganancias(Q)", data, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel panel = new ChartPanel(graphic);
        GraphicWindow grafico = new GraphicWindow(panel);
        grafico.setVisible(true);
    }
    
    public File generateProductsWithOffer() throws FileNotFoundException, Exception{
        File newFile = new File("C:\\Users\\Omar\\Desktop\\StoreProject\\reports\\Productos con oferta.pdf");
        PdfWriter writter = new PdfWriter(newFile);
        PdfDocument pdfDoc = new PdfDocument(writter);
        Document document = new Document(pdfDoc);
        Table offeredTable = new Table(new float[]{5,5});
        offeredTable.addHeaderCell(new Cell().add(new Paragraph("Oferta")));
        offeredTable.addHeaderCell(new Cell().add(new Paragraph("Producto")));
        offeredTable.setWidth(100);   
        for(int i=1;i<Lists.offers.listSize();i++){
            currentOffer = Lists.offers.getOfferAt(i);
            if(currentOffer!=null){
                for(int x=1;x<currentOffer.getProducts().listSize();x++){
                    if(currentOffer.getProducts().listSize()>1){
                        offeredTable.addCell(new Cell().add(new Paragraph(currentOffer.getDescription())));
                        offeredTable.addCell(new Cell().add(new Paragraph(currentOffer.getProducts().getProductAt(x).getName())));
                    }   
                }
            }   
        }      
        document.add(offeredTable);
        document.close();  
        return newFile;
    }
}
