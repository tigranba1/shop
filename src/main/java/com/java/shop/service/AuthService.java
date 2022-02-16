package com.java.shop.service;

import com.java.shop.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    /**
     * User registration
     */
    public UserDTO register(UserDTO userDTO);

    /**
     * Login with email and password
     */
    public boolean login(String email, String password);


    /**
     * User logout
     */
    public void logout();

}
