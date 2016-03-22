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
    private String store = "Khols";
    //private OutputStrategy output;

    
    public final void startNewSale(String custId, DatabaseStrategy db) throws IllegalArgumentException{
        //validation
        if(custId==null||custId.isEmpty()|| db == null){
            throw new IllegalArgumentException("invalid customer Id or Database");
        }
        receipt = new Receipt(custId, db);
        //output = new Printer(); 
        
    }
    public final void startEndSale(OutputStrategy oc)  throws IllegalArgumentException{
        if(oc==null){
             throw new IllegalArgumentException("no output strategy");
        }
        oc.outputSale(getReceipt(), store);
        //print reciept
        //tell printer / gui to print
    }
    public final void addItemToSale(String prodId, int qty)  throws IllegalArgumentException{
       if(prodId==null||prodId.isEmpty()||qty <= 0){
           throw new IllegalArgumentException("no product or a qty of 0 or less");
       }
       receipt.addItemToReceipt(prodId, qty);
    }
    
    public final Receipt getReceipt() {
        return receipt;
    }

    public final void setReceipt(Receipt receipt)  throws IllegalArgumentException {
        //validation
        if(receipt==null){
            throw new IllegalArgumentException("no receipt");
        }
        this.receipt = receipt;
    }

    public final String getStore() {
        return store;
    }

    public final void setStore(String store)  throws IllegalArgumentException {
        //validation
        if(store==null||store.isEmpty()){
            throw new IllegalArgumentException("no store");
        }
        this.store = store;
    }
    
    
    
}
