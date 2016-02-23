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
public class FlatAmtDiscount implements DiscountStrategy {
    private double discountRate;

    public FlatAmtDiscount(double discountRate) {
        setDiscountRate(discountRate);
    }
    
    

    public final double getDiscountRate() {
        return discountRate;
    }

    public final void setDiscountRate(double discountRate) {
        //validation
        this.discountRate = discountRate;
    }
    
    @Override
    public final double getDiscountAmt(int qty, double unitCost) {
        //validation
     return discountRate;  
    }
    
    
}
