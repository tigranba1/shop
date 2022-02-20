package com.java.shop.api;

import com.java.shop.dto.UserDTO;
import com.java.shop.enums.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping
public interface AuthAPI {
    @GetMapping("/login")
    public Status loginUser(@Valid @RequestBody UserDTO userDTO);

    @GetMapping("/logout")
    public Status logUserOut(@Valid @RequestBody UserDTO userDTO);

}
