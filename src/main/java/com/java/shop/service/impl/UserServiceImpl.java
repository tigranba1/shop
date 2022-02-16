package com.java.shop.service.impl;

import com.java.shop.dto.UserDTO;
import com.java.shop.entity.User;
import com.java.shop.enums.UserType;
import com.java.shop.exceptions.UserAlreadyExistException;
import com.java.shop.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User createUser(UserDTO userDTO) {
        User user = new User(userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail(),
                userDTO.getPassword(), UserType.ADMIN);
        return user;
    }

    public UserServiceImpl() {
    }

    @Override
    public UserDTO getUser(String email) {
       return null;
    }

    @Override
    public UserDTO updateUser(String userId, UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteUser(String userId) {

    }
}
