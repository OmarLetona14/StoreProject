/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.model;

import storeproject.list.SimplyLinkedCircularListProduct;

public class Cart {
    
    private SimplyLinkedCircularListProduct cartProducts;
    private double total;

    public Cart(SimplyLinkedCircularListProduct cartProducts, double total) {
        this.cartProducts = cartProducts;
        this.total = total;
    }

    public Cart() {
    }

    public SimplyLinkedCircularListProduct getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(SimplyLinkedCircularListProduct cartProducts) {
        this.cartProducts = cartProducts;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
