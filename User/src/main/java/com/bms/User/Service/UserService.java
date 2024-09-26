package com.bms.User.Service;

import java.util.List;

import com.bms.User.Model.User;

public interface UserService {
    public String createUser(User user);
    public List<User> readUsers();
    public User readUser(Long userId);
    public boolean deleteUser(Long userId);
    public String updateUser(Long userId, User user);  
} 
