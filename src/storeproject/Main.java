/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject;

import storeproject.list.Lists;
import storeproject.view.LoginWindow;

public class Main {

    public static void main(String[] args) {
        Lists.users.addToFinal("Administrador", "", "ADMIN", "ADMIN", "", "", "");
        Lists.users.addToFinal("Omar", "omarletonaf@gmail.com", "omar", "123", "BAC CREDOMATIC", "11/01/2019", "123");
        LoginWindow login = new LoginWindow();
        login.setVisible(true);
    }
    
}
