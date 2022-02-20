package com.java.shop.controller;

import com.java.shop.api.UserAPI;
import com.java.shop.dto.UserDTO;
import com.java.shop.enums.Status;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserAPI {
    @Override
    public Status registerUser(UserDTO userDTO) {
        return null;
    }


}
