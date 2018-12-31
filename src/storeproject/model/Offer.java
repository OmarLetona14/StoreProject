/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.model;

import storeproject.list.SimplyLinkedCircularListProduct;

public class Offer {
    
    private int idOffer;
    private String description;
    private double discount;
    private SimplyLinkedCircularListProduct products;    

    public Offer(int idOffer, String description, double discount, SimplyLinkedCircularListProduct products) {
        this.idOffer = idOffer;
        this.description = description;
        this.discount = discount;
        this.products = products;
    }

    public int getIdOffer() {
        return idOffer;
    }

    public void setIdOffer(int idOffer) {
        this.idOffer = idOffer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public SimplyLinkedCircularListProduct getProducts() {
        return products;
    }

    public void setProducts(SimplyLinkedCircularListProduct products) {
        this.products = products;
    }
}

