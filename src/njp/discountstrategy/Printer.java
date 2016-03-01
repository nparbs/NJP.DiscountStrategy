/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njp.discountstrategy;

import java.text.NumberFormat;
import java.time.LocalTime;
import java.util.Locale;

/**
 *
 * @author nparbs
 */
public class Printer implements OutputStrategy{

    @Override
    public void outputSale(Receipt receipt, String store) {
        
        NumberFormat cur = NumberFormat.getCurrencyInstance(Locale.US);
        
        System.out.println("Store: " + store + "        Customer Name: " 
                + receipt.getCustomer().getCustName() + "          Date Time: " 
                + LocalTime.now()+ "\n");
        System.out.println("Product Id       Product Name         Unit Price"
                + "       Qty     Discount        Line Total");
         LineItem[] items = receipt.getLineItems(); 
       for(LineItem i : items){ 
        
       System.out.println("       " + String.format("%-10s",i.getProduct().getProdId()) 
               + String.format("%-25s",i.getProduct().getProdName()) 
               + String.format("%-15s",cur.format(i.getProduct().getUnitCost())) 
               + String.format("%-8s",i.getQty()) 
               + String.format("%-15s",cur.format(i.getDiscountTotal()))
               + String.format("%-15s",cur.format(i.getLineTotal())));
       }
        System.out.println("\n                  Sub Total:        " 
                + cur.format(receipt.getSubTotal()) + "\n\n");       
    
    }
    
}
