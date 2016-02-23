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
public class NoDiscount implements DiscountStrategy {
    private double discountRate;
    private final int NO_DISCOUNT = 0;
    
    public NoDiscount() {
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
     return NO_DISCOUNT;
    }
    
    
}
