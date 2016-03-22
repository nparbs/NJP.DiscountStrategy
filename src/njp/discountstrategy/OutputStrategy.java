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

//Output
public interface OutputStrategy {
    public abstract void outputSale(Receipt r, String store);
    public abstract void strPrint(String str);
}
