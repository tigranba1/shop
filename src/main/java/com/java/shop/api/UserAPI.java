package com.java.shop.api;

import com.java.shop.dto.UserDTO;
import com.java.shop.enums.Status;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;


@RequestMapping("/users/")
public interface UserAPI {

    @PostMapping("register")
    public Status registerUser(@Valid @RequestBody UserDTO userDTO);

}
