package com.bms.User.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.User.Entity.UserEntity;
import com.bms.User.Model.User;
import com.bms.User.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String createUser(User user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userRepository.save(userEntity);
        return "user added successfully";
    }

    @Override
    public List<User> readUsers() {
        List<UserEntity> usersList = userRepository.findAll();
        List<User> users = new ArrayList<>();
        for (UserEntity userEntity : usersList) {
            User user = new User();
            BeanUtils.copyProperties(userEntity, user);
            users.add(user);
        }
        return users;
    }

    @Override
    public User readUser(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).get();
        User user = new User();
        BeanUtils.copyProperties(userEntity, user);
        return user;
    }

    @Override
    public String updateUser(Long userId, User user) {
        UserEntity existingUser = userRepository.findById(userId).get();
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        userRepository.save(existingUser);
        return "user updated successfully";
    }

    @Override
    public boolean deleteUser(Long userId) {
        UserEntity user = userRepository.findById(userId).get();
        userRepository.delete(user);
        return true;
    }

    
}
