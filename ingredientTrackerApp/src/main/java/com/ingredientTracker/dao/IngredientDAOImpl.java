package com.ingredientTracker.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ingredientTracker.entity.IngredientsEntity;
import com.ingredientTracker.entity.UserEntity;
import com.ingredientTracker.entity.UserIngredientsEntity;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class IngredientDAOImpl implements IngredientDAO {


    private static final Logger logger = LoggerFactory.getLogger(IngredientDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
            this.sessionFactory = sf;
        }

    public void addIngredient(IngredientsEntity i){

        Session session = this.sessionFactory.getCurrentSession();
        session.persist(i);
        logger.info("ingredients saved, ingredients detail=" + i);
    }

    public void updateIngredient(IngredientsEntity i){

        Session session = this.sessionFactory.getCurrentSession();
        session.update(i);
        logger.info("Ingrediet updated, ingredients detail=" +i);

    }

    @SuppressWarnings("unchecked")
    public List<IngredientsEntity> listIngredients(){
        Session session = this.sessionFactory.getCurrentSession();
        List<IngredientsEntity> ingredientsEntityList = session.createQuery("from IngredientsEntity ").list();

        for (IngredientsEntity i : ingredientsEntityList) {
            logger.info("ingredient list:" + i);
        }
        return ingredientsEntityList;

    }


    public void removeIngredient(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        IngredientsEntity i = (IngredientsEntity) session.load(IngredientsEntity.class, new Integer(id));
        if (null != i) {
            session.delete(i);
        }
        logger.info("Event deleted successfully, Event details=" + i);

    }


}
