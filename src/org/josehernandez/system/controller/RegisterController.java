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
       if(validEmail == true)
            System.out.println(" Si esta valido ");
       else
            System.out.println(" No esta Valido ");
   }

}
