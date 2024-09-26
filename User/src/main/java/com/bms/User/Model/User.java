package com.bms.User.Model;

import java.util.List;

import jakarta.persistence.Column;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long userId;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;
    
    private String password;
    
    private List <City> cities = new ArrayList<>();
}
