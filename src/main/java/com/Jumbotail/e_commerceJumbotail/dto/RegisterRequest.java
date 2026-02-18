package com.Jumbotail.e_commerceJumbotail.dto;

import lombok.Data;

import java.util.Set;

@Data
public class RegisterRequest {

    private String username;
    private String email;
    private Set<String> role;
    private String password;
}
