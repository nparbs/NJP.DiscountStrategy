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
public interface DatabaseStrategy {

    public Customer findCustomerById(String custId);
    
    public Product findProductById(String prodId);
    

    
}
