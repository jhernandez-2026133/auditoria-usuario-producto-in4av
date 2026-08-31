/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.josehernandez.system.utils;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import org.josehernandez.system.ClasePrincipal;
import org.josehernandez.system.config.ConexionDB;
import org.josehernandez.system.service.UserService;
import org.josehernandez.system.service.UserStatus;

/**
 *
 * @author informatica
 */
public class ViewFactory {
    private final String PATH_VIEWS  = "/org/josehernandez/system/view/";
    private final AlertInformation alertInfo = new AlertInformation();

    public Scene LoadFileFXML(String nameFile, int width, int height) {
        String pathOffFile = PATH_VIEWS + nameFile;
        try {
            
            // Llamar al FXMLLoader
            FXMLLoader loaderFXML = new FXMLLoader();
            //obtener URL del archivo
            //Llamada al archivo Main
            URL urlFile = ClasePrincipal.class.getResource(pathOffFile);
            loaderFXML.setBuilderFactory(new JavaFXBuilderFactory());
            loaderFXML.setLocation(urlFile);

            return new Scene(loaderFXML.load(), width, height);

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
    public void loadScene(String nameFile) {
        Scene scene = null;
        try {
            switch (nameFile) {
                case "login" -> scene = LoadFileFXML("LoginView.fxml", 400, 500);  
                case "register" ->{
                    SceneManager.getInstanciaScenerManager().getStagePrincipal().setTitle("REGISTRO DE USUARIO");
                    SceneManager.getInstanciaScenerManager().getStagePrincipal().setResizable(false);
                    scene = LoadFileFXML("RegisterView.fxml", 350, 400);
                }
                default -> scene = LoadFileFXML("LoginView.fxml", 300, 400);
            }
            
            SceneManager.getInstanciaScenerManager().changeScene(scene);
            

        } catch (NullPointerException objetoNulo) {
            //ALERT
            System.out.println("Error load Scene");
        }    
    
    }
    
    public void viewRegister(){
        loadScene("register");
    }
    public void viewLogin(){
        loadScene("login");
    }
    
    public void registerUser(String user, String name, String lastName, String email, String password){
        UserService userService = new UserService();
        UserStatus status = userService.createUser(user, name, lastName, email, password);
        
        if(status == UserStatus.USER_CREATED){
            alertInfo.viewAlert("INFO", "REGISTRO EXITOSO", "USUARIO CREADO", "El usuario " + user + " fue creado correctamente.");
            viewLogin();
        } else {
            alertInfo.viewAlert("ERROR", "ERROR AL REGISTRAR", "ERROR AL CREAR USUARIO", "No se pudo crear el usuario, intenta nuevamente.");
        }
    }
    
    public void loginUser(String user, String password){
        String sql = "SELECT user FROM Users WHERE user = ? AND password = ?";
        
        try (PreparedStatement statement = ConexionDB.getInstanciaConexionDB().getConnection().prepareStatement(sql)) {
            statement.setString(1, user);
            statement.setString(2, password);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    alertInfo.viewAlert("INFO", "Bienvenido", "Bienvenido " + user, "Has iniciado sesión correctamente.");
                } else {
                    alertInfo.viewAlert("ERROR", "ERROR DE INICIO DE SESION", "USUARIO O CONTRASEÑA INCORRECTOS", "Verifica tus datos e intenta nuevamente.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al iniciar sesion");
            System.out.println(e.getMessage());
            e.printStackTrace();
            alertInfo.viewAlert("ERROR", "ERROR DE CONEXION", "ERROR AL CONSULTAR LA BASE DE DATOS", "Ocurrio un error, intenta nuevamente.");
        }
    }
}
