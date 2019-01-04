/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.model;

public class Bill {
    
    private int idBill;
    private User user;
    private CreditCard creditCard;
    private String address;
    private String name;
    private String NIT;

    public Bill(int idBill, User user, CreditCard creditCard, String address, String name, String NIT) {
        this.idBill = idBill;
        this.user = user;
        this.creditCard = creditCard;
        this.address = address;
        this.name = name;
        this.NIT = NIT;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }  
}
