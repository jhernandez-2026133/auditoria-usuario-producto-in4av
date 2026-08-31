/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.josehernandez.system.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.josehernandez.system.utils.AlertInformation;
import org.josehernandez.system.utils.Validations;
import org.josehernandez.system.utils.ViewFactory;

public class LoginController implements Initializable {

    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField pwdPassword;

    private final Validations validate = new Validations();
    private final AlertInformation alertInfo = new AlertInformation();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    @FXML
    public void onRegister (MouseEvent event){
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewRegister();
    }

    @FXML
    public void onLogin(MouseEvent event){
        String user = txtUser.getText().trim();
        String password = pwdPassword.getText().trim();

        if(validate.validatetextEmpty(user) == true || validate.validatetextEmpty(password) == true){
            alertInfo.viewAlert("ERROR", "CAMPOS VACIOS", "ERROR DE CAMPOS", "Debes ingresar usuario y contraseña.");
            return;
        }

        ViewFactory viewFacto = new ViewFactory();
        viewFacto.loginUser(user, password);
    }

}
