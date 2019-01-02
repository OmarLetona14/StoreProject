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
        LoginWindow login = new LoginWindow();
        login.setVisible(true);
    }
    
}
