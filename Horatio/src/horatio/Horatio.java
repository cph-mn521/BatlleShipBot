/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horatio;

/**
 *
 * @author Martin Wulff
 */
public class Horatio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String out = "";
        for(int i =1; i<100; i++){
            out += "Player turn"+ i + ", enemy turn" +i;
        }
        System.out.println(out);
                
    }
    
}
