/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.model;

public class CreditCard {
    
    private String creditCardName;
    private String expirationDate;
    private String CVCCode;

    public CreditCard(String creditCardName, String expirationDate, String CVCCode) {
        this.creditCardName = creditCardName;
        this.expirationDate = expirationDate;
        this.CVCCode = CVCCode;
    }

    public String getCreditCardName() {
        return creditCardName;
    }

    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCVCCode() {
        return CVCCode;
    }

    public void setCVCCode(String CVCCode) {
        this.CVCCode = CVCCode;
    }
}
