
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.josehernandez.system.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.josehernandez.system.utils.AlertInformation;
import org.josehernandez.system.utils.Validations;
import org.josehernandez.system.utils.ViewFactory;


public class RegisterController implements Initializable{
    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField pwdPassword;
    @FXML
    private PasswordField pwdConfirmPassword;      
    @FXML
    private Button btnCreateUser;
    @FXML
    private Button btnCancel;    
    private Validations validate = new Validations();
    private AlertInformation alertInfo = new AlertInformation();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    @FXML
    public void onCancelRegister(MouseEvent event){
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewLogin();
    } 
    @FXML
    public void onRegisterUser(MouseEvent event){
       String email = txtEmail.getText().trim();
       boolean validEmail = validate.validateEmail(email);
       if ( validEmail == false){
           alertInfo.viewAlert("ERROR", "ERROR DE EMAIL", "ERROR CAMPO EMAIL", "INGRESASTE UN EMAIL INCORRECTO");
           return;
       }
    
       String user, name, lastname, password, confirmPassword;
       user = txtUser.getText().trim();
       name = txtName.getText().trim();
       lastname = txtLastName.getText().trim();
       password = pwdPassword.getText().trim();
    confirmPassword = pwdConfirmPassword.getText().trim();
    if( validate.validatetextEmpty(user) == true ||
        validate.validatetextEmpty(name) == true ||
        validate.validatetextEmpty(lastname) == true ||
        validate.validatetextEmpty(email) == true ||
        validate.validatetextEmpty(password) == true ||
        validate.validatetextEmpty(confirmPassword)== true){
           return;
    }
    /*
    name varchar (50) lastname varchar (50) 
    email varchar (50) user varchar (25)  
    password varchar (35)    
    */
    String msgField="";
    if(validate.validateTextLenght(user, 25)== false)
        msgField = "El campo Usuario es mayor a 25 letras";
    if(validate.validateTextLenght(name, 50)== false)
        msgField = "El campo Nombre es mayor a 50 letras";
    if(validate.validateTextLenght(lastname, 50)== false)
        msgField = "El campo Apellido es mayor a 50 letras";
    if(validate.validateTextLenght(email, 50)== false)
        msgField = "El campo Correo es mayor a 50 letras";
    if(validate.validateTextLenght(password, 35)== false)
        msgField = "El campo password es mayor a 35 letras";
    if(validate.validateTextLenght(confirmPassword, 35)== false)
        msgField = "El campo Confirmar Contraseña es mayor a 35 letras";
    
    if(msgField.isEmpty() == false){
           alertInfo.viewAlert("ERROR", "ERROR DE CAMPO", "ERROR LONGITUD DE CAMPO", msgField);
           return;
    }
    
    if(validate.equalsText(password, confirmPassword)== false){
           alertInfo.viewAlert("ERROR", "ERROR DE CONFIRMAR CONTRASEÑA", "ERROR LONGITUD DE CAMPO", msgField);
           return;
        
    }
    
    
    }

}
