/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.josehernandez.system.service;

import org.josehernandez.system.model.User;
import org.josehernandez.system.repository.AuthenticationRepository;

/**
 *
 * @author informatica
 */
public class AuthenticationService {

    private final AuthenticationRepository authRepository = new AuthenticationRepository();
    private final UserService userService = new UserService();
    private User authenticatedUser;

    public AuthenticationStatus login(String email, String password) {

        // 1. Antes de loguear, se le pregunta al UserService si el usuario existe
        User existingUser = userService.findUser(email);

        if (existingUser == null) {
            return AuthenticationStatus.NOT_EXIST_USER;
        }

        // 2. Si existe, se valida el login (usuario/correo + password) contra el AuthenticationRepository
        User loggedUser = authRepository.login(email, password);

        if (loggedUser == null) {
            return AuthenticationStatus.INVALID_PASSWORD;
        }

        authenticatedUser = loggedUser;
        return AuthenticationStatus.LOGIN_SUCCESS;
    }

    public User getAuthenticatedUser() {
        return authenticatedUser;
    }

}
