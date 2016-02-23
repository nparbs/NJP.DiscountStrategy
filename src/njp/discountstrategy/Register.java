/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njp.discountstrategy;

/**
 *
 * @author nparbs
 */
public class Register {
    private Receipt receipt;
    private String store;
    
    public final void startNewSale(String custId, DatabaseStrategy db){
        //validation
        receipt = new Receipt(custId, db);
        
    }
    public final void startEndSale(){
        
    }
    public final void addItemToSale(){
        
    }

    public final Receipt getReceipt() {
        return receipt;
    }

    public final void setReceipt(Receipt receipt) {
        //validation
        this.receipt = receipt;
    }

    public final String getStore() {
        return store;
    }

    public final void setStore(String store) {
        //validation
        this.store = store;
    }
    
    
    
}
