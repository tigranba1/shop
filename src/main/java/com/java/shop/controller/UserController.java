package com.java.shop.controller;

import com.java.shop.api.UserAPI;
import com.java.shop.dto.UserDTO;
import com.java.shop.enums.Status;
import com.java.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserAPI {

    @Autowired
    UserService userService;

    @Override
    public Status registerUser(UserDTO userDTO) {
        return userService.createUser(userDTO);
    }


}
