package com.java.shop.controller;

import com.java.shop.api.AuthAPI;
import com.java.shop.dto.UserDTO;
import com.java.shop.enums.Status;
import com.java.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthAPI {

    @Autowired
    UserService userService;
    @Override
    public Status loginUser(UserDTO userDTO) {
        return userService.loginUser(userDTO);
    }

    @Override
    public Status logUserOut(UserDTO userDTO) {
        return userService.logUserOut(userDTO);
    }
}
