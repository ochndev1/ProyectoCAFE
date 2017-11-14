/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocafe;

/**
 *
 * @author Hannibal
 */
public class Port {
    
    private int type; //Entrada 0 Salida 1
    private Slots s1;
    
    public Port(int type, Slots s1){
        this.type = type;
        this.s1 = s1;
    }
    
    
    
}
