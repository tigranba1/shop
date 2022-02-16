package com.java.shop.controller;

import com.java.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RegistrationController {

    @Autowired
    public UserService userService;



}
