package com.ingredientTracker.service;


import java.util.List;

import com.ingredientTracker.entity.UserEntity;

public interface UserService {

    public void addUser(UserEntity u);
    public void updateUser(UserEntity u);
    public List<UserEntity> listUsers();
    public UserEntity getUserById(int id);
    public UserEntity getUserByName(String username);
    public void removeUser(int id);
    boolean isUserValid(String username, String password);
}
