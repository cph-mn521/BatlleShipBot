/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

/**
 *
 * @author Martin Wulff
 */
public class DataException extends Exception {

    public DataException() {
    }
    public DataException(String string) {
        super(string);
    }
    public DataException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
    public DataException(Throwable thrwbl) {
        super(thrwbl);
    }
}