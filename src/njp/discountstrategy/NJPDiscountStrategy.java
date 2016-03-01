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
public class NJPDiscountStrategy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //KLUDGE: do config here
        DatabaseStrategy db = new FakeDatabase();
        
        //Start talking to objects
        Register register = new Register();
        OutputStrategy printer = new Printer();
        OutputStrategy Screen = new Screen(); 
        
        register.startNewSale("100", db);
        register.addItemToSale("11", 2);
        register.addItemToSale("22", 3);
        register.addItemToSale("33", 2);       
        register.startEndSale(Screen);
        register.startEndSale(printer);
        
        register.startNewSale("200", db);
        register.addItemToSale("33", 2);
        register.addItemToSale("11", 4);      
        register.startEndSale(Screen);
        register.startEndSale(printer);
        
        
    }
    
    
            
        //Customer customer = register.getReceipt().getCustomer();
       //System.out.println("c " + customer.getCustName() + " added to receipt");
//       LineItem[] items = register.getReceipt().getLineItems(); 
//       for(LineItem i : items){ 
//       System.out.println("sale " + i.getProduct().getProdName() + " qty: " + i.getQty()
//       + " disc " + i.getDiscountTotal()+ " line total " + i.getLineTotal()
//       );
   // }
    
}
