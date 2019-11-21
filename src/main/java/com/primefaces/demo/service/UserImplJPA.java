package com.primefaces.demo.service;

import com.primefaces.demo.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserImplJPA implements UserService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User saveOrUpdateUser(User user) {

        if(user.getUserId()==null)
        {
            entityManager.persist(user);
        }else {
           entityManager.merge(user);
        }
        return user;
    }

    @Override
    public User getLoggedIn(User user) {
        if(user!=null)
        {
            Query query = entityManager.createNamedQuery("query_find_all_users", User.class);
            System.out.println(user.getEmail()+" "+user.getPassword());
            ArrayList<User> users = (ArrayList<User>) query.getResultList();
            for (User u: users
                 ) {
                if (u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword()))
                {
                    return u;
                }
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        Query query = entityManager.createNamedQuery("query_find_all_users", User.class);
        return new ArrayList<>(query.getResultList());
    }

    @Override
    public User getUserById(Integer userId) {
        return entityManager.find(User.class,userId);
    }

    @Override
    public User deleteUser(User user) {
        User u = entityManager.find(User.class,user.getUserId());
        entityManager.remove(u);
        return user;
    }
}
