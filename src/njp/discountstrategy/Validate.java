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
public class Validate {
    
    //String Validation
    public final String checkString(String s){
        if (s==null){
            throw new IllegalArgumentException("Cannot be null");//msg=privite var
        } else if(s.length() >= 128) {
            throw new IllegalArgumentException("String must be less than 128 chars");
        } else {
          return s;  
        }
    
    }
    
}
