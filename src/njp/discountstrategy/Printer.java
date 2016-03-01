/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njp.discountstrategy;

import java.time.LocalTime;

/**
 *
 * @author nparbs
 */
public class Printer implements OutputStrategy{

    @Override
    public void outputSale(Receipt receipt, String store) {
        double total = 0;
        System.out.println("Store: " + store + "        Customer Name: " 
                + receipt.getCustomer().getCustName() + "          Date Time: " 
                + LocalTime.now());
        System.out.println("Product Id          Product Name            Unit Price"
                + "            Qty         Discount         Line Total");
         LineItem[] items = receipt.getLineItems(); 
       for(LineItem i : items){ 
        total += i.getLineTotal();
       System.out.println(i.getProduct().getProdId()+ "         " 
               + i.getProduct().getProdName() + "         " 
               + i.getProduct().getUnitCost() + "        " + i.getQty()
       + "      " + i.getDiscountTotal()+ "         " + i.getLineTotal());
       }
        System.out.println("Total:               " + total);       
    
    }
    
}
