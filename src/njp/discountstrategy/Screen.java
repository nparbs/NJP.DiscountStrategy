/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njp.discountstrategy;

import java.text.NumberFormat;
import java.time.LocalTime;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author nparbs
 */
public class Screen implements OutputStrategy{

    @Override
    public void outputSale(Receipt receipt, String store) {
            
        NumberFormat cur = NumberFormat.getCurrencyInstance(Locale.US);
        
        String itemList = ""; 
        LineItem[] items = receipt.getLineItems(); 
        //Create concat string of items list
        for(LineItem i : items){  
            itemList = itemList +( 
                String.format("%10s",i.getProduct().getProdId()) + "         " 
                + String.format("%-25s",i.getProduct().getProdName()) 
                + String.format("%-15s",cur.format(i.getProduct().getUnitCost())) 
                + String.format("%-10s",i.getQty()) 
                + String.format("%-15s",cur.format(i.getDiscountTotal()))
                + String.format("%-15s",cur.format(i.getLineTotal()))+ "\n");
       } 
        //Print to gui 
        //NEEDS FORMATTING hard coded header / footer
        JOptionPane.showMessageDialog(null, "Store: " + store + "        Customer Name: " 
                + receipt.getCustomer().getCustName() + "          Date Time: " 
                + LocalTime.now()+ "\nProduct Id     Product Name      Unit Price"
                + "       Qty     Discount        Line Total\n" + itemList        
                + String.format("%5s","\nSub Total:     " 
                        + cur.format(receipt.getSubTotal()) + "\n\n"));        
    
    }
    
    @Override
    public final void strPrint(String str){

        System.out.println(str);

    }
}
