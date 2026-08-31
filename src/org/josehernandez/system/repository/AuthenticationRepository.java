/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */	
package org.josehernandez.system.repository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.josehernandez.system.config.ConexionDB;
import org.josehernandez.system.model.User;

/**
 *
 * @author informatica
 */
public class AuthenticationRepository implements AuthenticationInterface {

    private CallableStatement callSP;
    private final ConexionDB conexionDB = ConexionDB.getInstanciaConexionDB();

    @Override
    public User login(String email, String password) {
        User userLogged = null;
        try {
            callSP = conexionDB.getConnection().prepareCall("{call sp_login(?,?)}");
            callSP.setString(1, email);
            callSP.setString(2, password);

            boolean hayResultados = callSP.execute();
            if (hayResultados) {
                try (ResultSet resultSet = callSP.getResultSet()) {
                    if (resultSet.next()) {
                        userLogged = new User(
                                resultSet.getString("name"),
                                resultSet.getString("lastname"),
                                resultSet.getString("email"),
                                resultSet.getString("user"),
                                resultSet.getString("id_user")
                        );
                    }
                }
            }
            callSP.close();
        } catch (SQLException e) {
            System.out.println("Error al iniciar sesion");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return userLogged;
    }

}
