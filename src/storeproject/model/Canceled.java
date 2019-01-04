/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeproject.model;

public class Canceled {
    
    private boolean canceled;
    private int noCanceled;

    public Canceled(boolean canceled, int noCanceled) {
        this.canceled = canceled;
        this.noCanceled = noCanceled;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public int getNoCanceled() {
        return noCanceled;
    }

    public void setNoCanceled(int noCanceled) {
        this.noCanceled = noCanceled;
    }  
}
