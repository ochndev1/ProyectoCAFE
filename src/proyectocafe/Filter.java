/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocafe;

import org.w3c.dom.Document;

/**
 *
 * @author Hannibal
 */
public class Filter extends Router{
    
    private String condicion;
    private Slots in, out;

    public Filter(Document doc, Slots in, Slots out) {
        
        
        
    }
    
    public void Filtrar(int condicion){
        //Hace el proceso de filtrado
    }
    
    public String Filtrado(){
        return xml; //Devuelve el xml filtrado ya
    }
    
}
