/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocafe;

import java.sql.*;

/**
 *
 * @author Hannibal
 */
public class CamareroBebidasCalientes {
    

    
    public boolean ConsultarDisponibilidad(Bebida bebida, Connection conn) throws SQLException{
        
        
        int numero = 0;
        String consulta = "SELECT COUNT(*) FROM BEBIDA WHERE nombre = '"+bebida.nombre+"' AND tipo = 'hot'";        
        
        Statement stmt = conn.createStatement();
        
        ResultSet RS = stmt.executeQuery(consulta);
        
        while(RS.next()){
            numero = RS.getInt(1);
        }
        
        RS.close();
        stmt.close();
        
        if(numero > 0){
            return true;
        }else
        {
            return false;
        }
        
    }
    
}
