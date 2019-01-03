/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import storeproject.list.Lists;
import storeproject.list.SimplyLinkedCircularListProduct;
import storeproject.model.Offer;
import storeproject.model.Product;

public class CustomFileReader {
    
    BufferedReader reader = null;
    FileReader fReader = null;
    String productsStr, offersStr;
    Product currentProduct;
    Offer currentOffer;
    RandomNumber random = RandomNumber.getSingletonInstance();
    private SimplyLinkedCircularListProduct offeredProducts;
    
    public void readArchive(String direction, String archive, JFrame enviroment) throws IOException{
        fReader = new FileReader(direction);
        reader = new BufferedReader(fReader); 
        String linea;
        while((linea = reader.readLine()) != null){
            if(!(linea == null)){
                switch(archive){
                    case "Products":
                        productsStr += linea.trim();                      
                        break;
                    case "Offers":
                        offersStr += linea.trim();
                        break;
                }
            }
        }
        fReader.close();
        switch(archive){
        case "Products":
            separate(productsStr, archive, enviroment);
            break;
        case "Offers":
            separate(offersStr,archive, enviroment);            
            break;     
        }
    }
    
    private void separate(String cadena,String archive, JFrame enviroment){
        if(!cadena.equals("")){
            switch(archive){
                case "Products":
                    String[] products = cadena.split("!!");
                    for(String product: products){
                        String[] elements = product.split(",");
                        try{
                            Lists.products.addToFinal(random.generateIdentifier(), elements[0], elements[1],
                                Double.valueOf(elements[2].trim()), Integer.valueOf(elements[3].trim()), elements[4]);
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(enviroment, "Ocurrió un error, inténtelo de nuevo", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        }
                    }
                break;
                case "Offers":
                    String[] offers = cadena.split("%");
                    for(String offer: offers){
                        String[] elements = offer.split(",");
                        String[] eleProducts = elements[2].split(";");
                        offeredProducts = new SimplyLinkedCircularListProduct();
                        for(String individualProduct: eleProducts){
                            currentProduct = Lists.products.getProductByName(individualProduct); 
                            try{
                                offeredProducts.addToFinal(currentProduct.getIdentifier(), currentProduct.getName(), 
                                    currentProduct.getDescription(), currentProduct.getPrice(), currentProduct.getStock(),
                                    currentProduct.getImageDirection());
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(enviroment, "Ocurrió un error, inténtelo de nuevo", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            } 
                        }
                        if(elements[3].equals("Alta")){
                            Lists.offers.addToFinal(elements[0], Double.valueOf(elements[1]), offeredProducts);
                        }else if(elements[3].equals("Baja")){
                            Lists.offers.addToBegin(elements[0], Double.valueOf(elements[1]), offeredProducts);
                        }
                         currentOffer = new Offer(Lists.products.listSize()-2, elements[0], Double.valueOf(elements[1].trim()), offeredProducts);
                         for(int i = 1; i<=offeredProducts.listSize();i++){
                            try {
                                offeredProducts.getProductAt(i).setOffer(currentOffer);
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(enviroment, "Ocurrió un error, inténtelo de nuevo", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                            }
                         }
                    } 
                break;
            }
            
        }
    
    }

    
}
