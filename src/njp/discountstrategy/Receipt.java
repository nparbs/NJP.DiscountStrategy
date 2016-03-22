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
public class Receipt {
    private DatabaseStrategy db;
    private Customer customer;
    private LineItem[] lineItems;

    public Receipt(String custId, DatabaseStrategy db) {
        setDb(db);
        setCustomer(db.findCustomerById(custId));
        lineItems = new LineItem[0];
    }
    
    public final void addItemToReceipt(String prodId, int qty) throws IllegalArgumentException{
       if(prodId==null||prodId.isEmpty()||qty <= 0){
           throw new IllegalArgumentException("no product or a qty of 0 or less");
       }
       LineItem item = new LineItem(prodId,qty,db);
       addItemToArray(lineItems, item);
    }
    
    public void addItemToArray(LineItem[] origArray, LineItem item) throws IllegalArgumentException{
       if(item==null){
           throw new IllegalArgumentException("item is null");
       }
       LineItem[] tempArray = new LineItem[lineItems.length + 1];
      
       System.arraycopy(origArray, 0, tempArray, 0, lineItems.length);
       tempArray[tempArray.length - 1] = item; 
       lineItems = tempArray;
    }
    
    public final double getSubTotal(){
        double subTotal = 0;
        for(LineItem l : lineItems){
            subTotal += l.getLineTotal();
        }
        return subTotal;
        
    }
    
    public final Product getProd(String prodId) throws IllegalArgumentException{
        if(prodId==null||prodId.isEmpty()){
           throw new IllegalArgumentException("no product");
       }
        return db.findProductById(prodId);
    }
    
    public final DatabaseStrategy getDb() {
        return db;
    }

    public final void setDb(DatabaseStrategy db)  throws IllegalArgumentException{
        //validation
        if(db==null){
           throw new IllegalArgumentException("no database");
        }
        this.db = db;
    }

    public final Customer getCustomer() {
        return customer;
    }

    public final void setCustomer(Customer customer)  throws IllegalArgumentException{
        //validation
        if(customer == null){
            throw new IllegalArgumentException("no customer info");
        }
        this.customer = customer;
    }

    public final LineItem[] getLineItems() {
        return lineItems;
    }

    public final void setLineItems(LineItem[] lineItems)  throws IllegalArgumentException{
        //validation
        if(lineItems.length<=0){
            throw new IllegalArgumentException("invalid # of items");
        }
        this.lineItems = lineItems;
    }
    
}
