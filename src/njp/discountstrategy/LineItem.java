/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package njp.discountstrategy;

/**
 *
 * @author Nick
 */
public class LineItem {
    
    private Product product;
    private int qty;

    public LineItem(String prodId, int qty, DatabaseStrategy db) {
        setQty(qty);
        setProduct(db.findProductById(prodId));
        
    }

    public final double getLineTotal() {
        double lineTotal = ((product.getUnitCost() * qty) - 
                product.getDiscount().getDiscountAmt(qty,product.getUnitCost()));
        return lineTotal;
    }
    
    public final double getDiscountTotal() {
        double discTotal =  
                product.getDiscount().getDiscountAmt(qty,product.getUnitCost());
        return discTotal;
    }


    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        //needs validation
        this.product = product;
    }

    public final int getQty() {
        return qty;
    }

    public final void setQty(int qty) {
        //needs validation
        this.qty = qty;
    }
    
    
    
}
