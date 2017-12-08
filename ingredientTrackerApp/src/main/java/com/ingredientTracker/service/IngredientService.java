package com.ingredientTracker.service;

import com.ingredientTracker.entity.IngredientsEntity;

import java.util.List;

public interface IngredientService {
    public void addIngredient(IngredientsEntity i);
    public void updateIngredient(IngredientsEntity i);
    public List<IngredientsEntity> listIngredients();
    public void removeIngredient(int id);

}