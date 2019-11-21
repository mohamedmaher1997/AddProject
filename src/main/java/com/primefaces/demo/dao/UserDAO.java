package com.primefaces.demo.dao;

import com.primefaces.demo.domain.User;

import java.util.List;

public interface UserDAO {

    public User getUserById(Integer userId);
    public List<User> getAllUsers();
    public User saveOrUpdateUser(User user);
    public Integer deleteUserById(Integer userId);
    public User getLoggedIn(User user);

}
