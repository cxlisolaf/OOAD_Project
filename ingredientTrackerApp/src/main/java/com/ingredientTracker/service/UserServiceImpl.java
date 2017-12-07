package com.ingredientTracker.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingredientTracker.dao.UserDAO;
import com.ingredientTracker.entity.UserEntity;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public void setuserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public void addUser(UserEntity u) {
        this.userDAO.addUser(u);
    }

    @Transactional
    public void updateUser(UserEntity u) {
        this.userDAO.updateUser(u);
    }

    @Transactional
    public List<UserEntity> listUsers() {
        return this.userDAO.listUsers();
    }

    @Transactional
    public UserEntity getUserById(int id) {
        return this.userDAO.getUserById(id);
    }

    @Transactional
    public void removeUser(int id) {
        this.userDAO.removeUser(id);
    }

    @Transactional
    public UserEntity getUserByName(String username ) {
        return this.userDAO.getUserByName(username);
    }

    @Transactional
    public boolean isUserValid(String username, String password) {
        System.out.println("checking the user......");
        UserEntity myUser = getUserByName(username);
        if (username.equals(myUser.getUsername()) && password.equals(myUser.getPassword()))
            return true;
        return false;
    }

}
