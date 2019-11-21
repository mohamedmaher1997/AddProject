package com.primefaces.demo.service;

import com.primefaces.demo.domain.User;

import java.util.List;

public interface UserService {

    public User saveOrUpdateUser(User user);
    public User getLoggedIn(User user);
    public List<User> getAllUsers();
    public User getUserById(Integer userId);
    public User deleteUser(User user);

}
