package com.java.shop.service.impl;

import com.java.shop.components.UserMapping;
import com.java.shop.dto.UserDTO;
import com.java.shop.entity.User;
import com.java.shop.enums.Status;
import com.java.shop.exceptions.IncorrectCredentialsException;
import com.java.shop.exceptions.UserNotFoundException;
import com.java.shop.repository.UserRepository;
import com.java.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapping userMapping;

    @Override
    public Status createUser(UserDTO userDTO) {
        List<User> users = userRepository.findAll();
        System.out.println("New user: " + userDTO.toString());
        if (!users.isEmpty()) {
            for (User user : users) {
                if (user.getUsername().equals(userDTO.getUsername())) {
                    System.out.println("User is already exist");
                    return Status.USER_ALREADY_EXISTS;
                }
            }
        }
        userRepository.save(userMapping.toUser(userDTO));
        return Status.SUCCESS;
    }

    @Override
    public Status loginUser(UserDTO userDTO) {
        User user = userRepository.findByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        if (!user.getUsername().equals(userDTO.getUsername())) {
            throw new UserNotFoundException("User not found");
        }
        if (!user.getPassword().equals(userDTO.getPassword())) {
            throw new IncorrectCredentialsException("Incorrect  credentials");
        }
        if (user.getUsername().equals(userDTO.getUsername()) && user.getPassword().equals(userDTO.getPassword())) {
            user.setLoggedin(true);
            return Status.SUCCESS;
        }
        return Status.FAILURE;
    }

    @Override
    public Status logUserOut(UserDTO userDTO) {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getUsername().equals(userDTO.getUsername())) {
                user.setLoggedin(false);
                userRepository.save(user);
                System.out.println("User is logged is" + user.isLoggedin());
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }

}
