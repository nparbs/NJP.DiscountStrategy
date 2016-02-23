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
public class Customer {
    private String custId;
    private String custName;

    public Customer(String custId, String custName) {
        setCustId(custId);
        setCustId(custName);
    }
    

    public final String getCustId() {
        return custId;
    }

    public final void setCustId(String custId) {
        //validation
        this.custId = custId;
    }

    public final String getCustName() {
        return custName;
    }

    public final void setCustName(String custName) {
        //valitdation
        this.custName = custName;
    }
    
    
}
