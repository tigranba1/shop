package com.java.shop.service;

import com.java.shop.dto.UserDTO;
import com.java.shop.enums.Status;


public interface UserService {

    public Status createUser(UserDTO userDTO);
    public Status loginUser(UserDTO userDTO);
    public Status logUserOut(UserDTO userDTO);

}
