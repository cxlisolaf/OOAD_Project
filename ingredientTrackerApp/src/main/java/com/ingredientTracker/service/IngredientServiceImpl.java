package com.ingredientTracker.service;

import com.ingredientTracker.entity.IngredientsEntity;
import com.ingredientTracker.dao.IngredientDAO;
import com.ingredientTracker.entity.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class IngredientServiceImpl implements IngredientService {

    private IngredientDAO ingredientDAO;

    @Transactional
    public void setIngredientDAO(IngredientDAO IngredientDAO){
        this.ingredientDAO = IngredientDAO;
    }

    @Transactional
    public void addIngredient(IngredientsEntity i){
        this.ingredientDAO.addIngredient(i);

    }

    @Transactional
    public void updateIngredient(IngredientsEntity i){
        this.ingredientDAO.updateIngredient(i);

    }

    @Transactional
    public List<IngredientsEntity> listIngredients(){
        return this.ingredientDAO.listIngredients();

    }

    @Transactional
    public void removeIngredient(int id){
        this.ingredientDAO.removeIngredient(id);

    }

    @Transactional
    public IngredientsEntity getIngredientById(int id) {
        return this.ingredientDAO.getIngredientById(id);
    }

    @Transactional
    public List<IngredientsEntity> listUserIngredient(int id){
        return this.ingredientDAO.listUserIngredient(id);
    }


}























