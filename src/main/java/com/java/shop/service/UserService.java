package com.java.shop.service;

import com.java.shop.dto.UserDTO;
import com.java.shop.enums.Status;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public Status createUser(UserDTO userDTO);
    public Status loginUser(UserDTO userDTO);
    public Status logUserOut(UserDTO userDTO);

}
