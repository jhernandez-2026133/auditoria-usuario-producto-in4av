/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.josehernandez.system.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author informatica
 */
public class ConexionDB {
    private static ConexionDB instanciaConexionDB;
    private Connection connection;
    
    
    
    private ConexionDB(){
        try{   
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + Envioremnt.LOCATION_SERVICE+"/"
                            + Envioremnt.DATA_BASE,
                   Envioremnt.USER, Envioremnt.PASSWORD);
        }catch (ClassNotFoundException classNotFound){
            System.out.println("Error clase no encontrada");
            
        }catch (SQLException sQLException){
            System.out.println("ERROR DE CONEXION DB");
        }catch(Exception e){
            System.out.println("Error padre" + e.getMessage());
        }
    }
    public static ConexionDB getInstanciaConexionDB(){
            if (instanciaConexionDB == null) 
            instanciaConexionDB = new ConexionDB();
            return instanciaConexionDB;
            
    }
    
    
    
    
}
