package com.ingredientTracker.dao;

import java.util.List;

import com.ingredientTracker.entity.UserEntity;

public interface UserDAO {

    public void addUser(UserEntity u);
    public void updateUser(UserEntity u);
    public List<UserEntity> listUsers();
    public UserEntity getUserById(int id);
    public UserEntity getUserByName(String username);
    public void removeUser(int id);

}
