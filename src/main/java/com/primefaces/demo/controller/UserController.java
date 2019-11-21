package com.primefaces.demo.controller;

import com.primefaces.demo.dao.UserDAO;
import com.primefaces.demo.domain.User;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Scope (value = "session")
@Component (value = "userController")
@ELBeanName(value = "userController")
@Join(path = "/", to = "/layout.jsf")
public class UserController {

    private User user = new User();
    private String operation = "Add Record";

    @Autowired
    private UserDAO userDAO;


    public String getOperation() {
        return operation;
    }

    private List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        userList = userDAO.getAllUsers();
        return userList;
    }

    public List<User> getUsers()
    {
        userList = userDAO.getAllUsers();
        return userList;
    }

    public String getUser(User u)
    {
        user = userDAO.getUserById(u.getUserId());
        operation = "Update Record";
        return "users";
    }

    public String saveOrUpdateUser()
    {
        userDAO.saveOrUpdateUser(user);
        user = new User();
        userList = getUsers();
        operation = "Add Record";
        return "/users.xhtml?faces-redirect=true";
    }

    public String employeesPage()
    {
        return "/employees.xhtml?faces-redirect=true";
    }

    public String deleteUser(User u)
    {
        @SuppressWarnings("unused")
		Integer i = userDAO.deleteUserById(u.getUserId());
        userList = getUsers();
        return "redirect:/users";
    }

    public User getUser() {
        return user;
    }

    public String getLoggedIn()
    {
        User u = userDAO.getLoggedIn(user);
        if(u!=null)
        {
            user = new User();
            return "home";
        }
        return "index";
    }

    public String loadIndexPage()
    {
        return "home";
    }

    public String usersPage()
    {
        return "/users.xhtml?faces-redirect=true";
    }

    public String registerationPage()
    {
        return "register";
    }

    public String loginPage()
    {
        return "index";
    }

    public String registerNewUser()
    {
       User u =  userDAO.saveOrUpdateUser(user);
       if(u!=null)
       {
           user = new User();
           return "index";
       }
        return "register";
    }
}
