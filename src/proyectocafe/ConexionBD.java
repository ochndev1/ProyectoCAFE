/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocafe;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hannibal
 */
public class ConexionBD {
    
    Connection conn;
    
    void Conexion(){
        try {
            Class.forName("mariadb-java-client-1.1.8");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        try {
            Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/DB?user=root&password=myPassword");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void Desconexion(){
        
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
