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
public class FakeDatabase implements DatabaseStrategy {
    private Customer[] customers = {
        new Customer("100","Bob James"),
        new Customer("200","Sally Smith"),
        new Customer("300","Peter Piper")
    };
    
    private Product[] products = {
        new Product("11","Brewers Hat", 29.95, new PercentOffDiscount(.10)),
        new Product("22","Womens Blouse", 49.95, new FlatAmtDiscount(5.00)),
        new Product("33","Mens Black Belt", 39.95, new NoDiscount())
    };
    
    @Override
    public final Product findProductById(String prodId){
        //validation
        Product product = null;
        
        for(Product c : products){
            if(c.getProdId().equals(prodId)) {
                product = c;
                break;
            }
        }
        return product;
        
    }
    
    @Override
    public final Customer findCustomerById(String custId) {
        //validation
        Customer customer = null;
        
        for(Customer c : customers){
            if(c.getCustId().equals(custId)) {
                customer = c;
                break;
            }
        }
        return customer;
    }  

        
    
    
}
