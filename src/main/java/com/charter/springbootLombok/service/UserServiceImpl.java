package com.charter.springbootLombok.service;

import com.charter.springbootLombok.model.User;
import com.charter.springbootLombok.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> listAllUser(){
        return userRepository.findAll();
    }

    @Override
    public User findUser(Long userId){
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user){
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user){
        userRepository.delete(user);
    }
}
