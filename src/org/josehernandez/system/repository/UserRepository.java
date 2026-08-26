/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.josehernandez.system.repository;

import java.sql.CallableStatement;
import java.sql.SQLException;
import org.josehernandez.system.config.ConexionDB;
import org.josehernandez.system.model.User;


public class UserRepository implements UserInterface{
    private CallableStatement callSP;
    private ConexionDB conexionDB = ConexionDB.getInstanciaConexionDB();
            
      @Override
      public void create (User user){
        try{
            callSP = conexionDB.getConnection().prepareCall("{call sp_create_users(?,?,?,?,?)}");
            callSP.setString(1,user.getName());
            callSP.setString(2,user.getLastname());
            callSP.setString(3,user.getEmail());
            callSP.setString(4,user.getUser());
            callSP.setString(5,user.getPassword());
            callSP.execute();
            callSP.close();
        }catch(SQLException e){
            System.out.println("Error sl crear usuario");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

}

}
 