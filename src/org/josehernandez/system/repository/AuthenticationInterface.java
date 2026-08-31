/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.josehernandez.system.repository;

import org.josehernandez.system.model.User;

/**
 *
 * @author informatica
 */
public interface AuthenticationInterface {

    User login(String email, String password);

}
