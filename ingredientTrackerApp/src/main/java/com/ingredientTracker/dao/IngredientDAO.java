package com.ingredientTracker.dao;

import java.util.List;
import java.util.Set;

import com.ingredientTracker.entity.IngredientsEntity;
import com.ingredientTracker.entity.UserEntity;

public interface IngredientDAO {
    public void addIngredient(IngredientsEntity i);
    public void updateIngredient(IngredientsEntity i);
    public List<IngredientsEntity> listIngredients();
    public List<IngredientsEntity> listUserIngredient(int id);
    public IngredientsEntity getIngredientById(int id);
    public void removeIngredient(int id);

}

