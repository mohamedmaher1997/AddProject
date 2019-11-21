package com.primefaces.demo.service;

import com.primefaces.demo.dao.UserDAO;
import com.primefaces.demo.domain.User;
import com.primefaces.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserDAO {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public List<User> getAllUsers() {
        return ((List<User>)userRepository.findAll());
    }

    @Override
    public User saveOrUpdateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Integer deleteUserById(Integer userId) {
        userRepository.deleteById(userId);
        return 1;
    }

    @Override
    public User getLoggedIn(User user) {
        List<User> users = (List<User>) userRepository.findAll();
        for (User u: users
             ) {
            if(u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword()))
            {
                return user;
            }
        }
        return null;
    }
}
