package com.java.shop.entity;

import com.java.shop.enums.UserType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {

    private @Id @GeneratedValue long id;
    private @NotBlank String username;
    private @NotBlank String password;
    private @NotBlank UserType usertype;
    private @NotBlank boolean loggedin;

    public User(String username, String password, UserType usertype) {
        this.username = username;
        this.password = password;
        this.usertype = usertype;
        this.loggedin = false;
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUsertype() {
        return usertype;
    }

    public void setUsertype(UserType usertype) {
        this.usertype = usertype;
    }

    public boolean isLoggedin() {
        return loggedin;
    }

    public void setLoggedin(boolean loggedin) {
        this.loggedin = loggedin;
    }
}
