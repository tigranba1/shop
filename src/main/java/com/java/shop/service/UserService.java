package com.java.shop.service;

import com.java.shop.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    /**
     * Create user
     * @param userDTO
     * @return
     */
    public UserDTO createUser(UserDTO userDTO);

    /**
     * Get user by email
     * @param email
     * @return
     */
    public UserDTO getUser(String email);

    /**
     * Update user
     * @param userId
     * @param userDTO
     * @return
     */
    public UserDTO updateUser(String userId,UserDTO userDTO);

    /**
     * Delete user
     * @param userId
     */
    public void deleteUser(String userId);

}
