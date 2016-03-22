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
        OutputStrategy screen = new Screen(); 
        
        //sale ex1
        try{
        register.startNewSale("100", db);
        register.addItemToSale("11", 2);
        register.addItemToSale("22", 3);
        register.addItemToSale("33", 2);       
        register.startEndSale(screen);
        register.startEndSale(printer);
        
        //sale ex2
        register.startNewSale("", db);//throws
        //register.startNewSale("200", db);
        register.addItemToSale("33", 2);
        register.addItemToSale("11", 4);      
        register.startEndSale(screen);
        register.startEndSale(printer);
        } catch(IllegalArgumentException e){
            printer.strPrint(e.getMessage());
        }
        
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
