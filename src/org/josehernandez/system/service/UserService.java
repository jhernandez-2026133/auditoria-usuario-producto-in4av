/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.josehernandez.system.service;

import org.josehernandez.system.model.User;
import org.josehernandez.system.repository.UserRepository;

/**
 *
 * @author informatica
 */
public class UserService {
    private UserRepository userRepo = new UserRepository();
    
    public UserStatus createUser(String user, String name, String lastName, String email, String password){
        try{
            User newUser = new User(name,email,lastName,password, user);
            userRepo.create(newUser);
            return UserStatus.USER_CREATED;
        }  catch(Exception e){
            return UserStatus.ERROR_USER_CREATE;
            
        }
    

    }
    }