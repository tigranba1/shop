package com.java.shop.components;

import com.java.shop.dto.UserDTO;
import com.java.shop.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapping {
    public UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setId(user.getId());
        userDTO.setUsertype(user.getUsertype());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public User toUser(UserDTO userDTO) {
        User user = new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getUsertype());
        return user;
    }
}
