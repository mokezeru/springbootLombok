package com.charter.springbootLombok.service;

import com.charter.springbootLombok.model.User;

import java.util.List;

public interface UserService {
    public List<User> listAllUser();
    public User findUser(Long userId);
    public User saveUser(User user);
    public User updateUser(User user);
    public void deleteUser(User user);
}
