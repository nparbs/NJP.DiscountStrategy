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
    public final void outputSale(Receipt receipt, String store) {
        //print to console
        System.out.println(getRecieptText(receipt,store));
    }
    
    private  String getRecieptText(Receipt receipt, String store){
        //NEEDS FORMATTING
        
        //String for Printer to print to console
        NumberFormat cur = NumberFormat.getCurrencyInstance(Locale.US);
        //String header
        String receiptText = 
        "       Store: " + store + "        Customer Name: " 
                + receipt.getCustomer().getCustName() + "          Date Time: " 
                + LocalTime.now()+ "\n"
                + "\nProduct Id           Product Name         Unit Price"
                + "       Qty     Discount        Line Total\n";                 
//                String.format("%10s","Product Id") 
//                + String.format("%-25s","Product Name") 
//                + String.format("%-15s","Unit Price") 
//                + String.format("%-8s","Qty") 
//                + String.format("%-15s","Discount")
//                + String.format("%-15s","Line Total\n");

        //add line items to string        
         LineItem[] items = receipt.getLineItems();
         for(LineItem i : items){  
            receiptText = receiptText +( 
                String.format("%10s",i.getProduct().getProdId()) + "           " 
                + String.format("%-25s",i.getProduct().getProdName()) 
                + String.format("%-15s",cur.format(i.getProduct().getUnitCost())) 
                + String.format("%-8s",i.getQty()) 
                + String.format("%-15s",cur.format(i.getDiscountTotal()))
                + String.format("%-15s",cur.format(i.getLineTotal()))+ "\n");
       }
         //add footer to string
        receiptText = receiptText  +
        "\n                                               Sub Total:        " 
                + cur.format(receipt.getSubTotal()) 
                + "\n\n";
      
        return receiptText;
    }  
}
