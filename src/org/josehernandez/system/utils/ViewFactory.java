/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.josehernandez.system.utils;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import org.josehernandez.system.ClasePrincipal;

/**
 *
 * @author informatica
 */
public class ViewFactory {
    private final String PATH_VIEWS  = "/org/josehernandez/system/view/";

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
}
