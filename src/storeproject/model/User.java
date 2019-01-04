/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.model;

public class User {
    
    private int idUser;
    private String name;
    private String email;
    private String nickname;
    private String password;
    private CreditCard creditCard;
    private Cart cart;
    private Canceled canceled;

    public User(int idUser, String name, String email, String nickname, String password, CreditCard creditCard, Cart cart, Canceled canceled) {
        this.idUser = idUser;
        this.name = name;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.creditCard = creditCard;
        this.cart = cart;
        this.canceled = canceled;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Canceled getCanceled() {
        return canceled;
    }

    public void setCanceled(Canceled canceled) {
        this.canceled = canceled;
    }
}
