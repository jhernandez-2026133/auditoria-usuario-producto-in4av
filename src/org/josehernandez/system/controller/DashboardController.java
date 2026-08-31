/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.josehernandez.system.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import org.josehernandez.system.model.User;
import org.josehernandez.system.utils.ViewFactory;

public class DashboardController implements Initializable {

    @FXML
    private Label lblWelcome;
    @FXML
    private Label lblUser;
    @FXML
    private Label lblEmail;

    private User user;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setUser(User user) {
        this.user = user;
        if (user != null) {
            lblWelcome.setText("Bienvenido, " + user.getName() + " " + user.getLastname());
            lblUser.setText("Usuario: " + user.getUser());
            lblEmail.setText("Correo: " + user.getEmail());
        }
    }

    @FXML
    public void onLogout(MouseEvent event) {
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewLogin();
    }

}
