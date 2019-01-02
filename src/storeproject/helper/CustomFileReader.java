/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import storeproject.list.Lists;
import storeproject.list.SimplyLinkedCircularListProduct;
import storeproject.model.Product;

public class CustomFileReader {
    
    
    BufferedReader reader = null;
    FileReader fReader = null;
    String productsStr, offersStr;
    Product currentProduct;
    RandomNumber random = RandomNumber.getSingletonInstance();
    private SimplyLinkedCircularListProduct offeredProducts;
    
    public void readArchive(String direction, String archive) throws IOException{
        fReader = new FileReader(direction);
        reader = new BufferedReader(fReader); 
        String linea;
        while((linea = reader.readLine()) != null){
            if(!(linea == null)){
                switch(archive){
                    case "Products":
                        productsStr += linea;                      
                        break;
                    case "Offers":
                        offersStr += linea;
                        break;
                }
            }
        }
        fReader.close();
        switch(archive){
        case "Products":
            separate(productsStr, archive);
            break;
        case "Offers":
            separate(offersStr,archive);            
            break;     
        }
    }
    
    private void separate(String cadena,String archive){
        if(!cadena.equals("")){
            switch(archive){
                case "Products":
                    String[] products = cadena.split("!!");
                    for(String product: products){
                        String[] elements = product.split(",");
                        try{
                            Lists.products.addToFinal(random.generateIdentifier(), elements[0], elements[1],
                                Double.valueOf(elements[2]), Integer.valueOf(elements[3]), elements[4]);
                        }catch(Exception e){
                        
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
                            offeredProducts.addToFinal(currentProduct.getIdentifier(), currentProduct.getName(), 
                                    currentProduct.getDescription(), currentProduct.getPrice(), currentProduct.getStock(),
                                    currentProduct.getImageDirection());
                        }
                         if(elements[3].equals("Alta")){
                             Lists.offers.addToFinal(elements[0], Double.valueOf(elements[1]), offeredProducts);
                         }else if(elements[3].equals("Baja")){
                         Lists.offers.addToBegin(elements[0], Double.valueOf(elements[1]), offeredProducts);
                         }
                    } 
                break;
            }
        }
    
    }

    
}
