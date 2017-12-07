package com.ingredientTracker.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ingredientTracker.entity.UserEntity;

@Repository
public class UserDAOImpl implements UserDAO{

    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    public void addUser(UserEntity u) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(u);
        logger.info("User saved successfully, User Details="+u);
    }

    public void updateUser(UserEntity u) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(u);
        logger.info("Event updated successfully, Event Details="+u);
    }

    @SuppressWarnings("unchecked")
    public List<UserEntity> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<UserEntity> usersList = session.createQuery("from UserEntity ").list();
        for(UserEntity u : usersList){
            logger.info("User List::"+u);
        }
        return usersList;
    }

    public UserEntity getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserEntity u = (UserEntity) session.load(UserEntity.class, new Integer(id));
        logger.info("User loaded successfully, User details="+u);
        return u;
    }

    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserEntity u = (UserEntity) session.load(UserEntity.class, new Integer(id));
        if(null != u){
            session.delete(u);
        }
        logger.info("User deleted successfully, User details="+u);

    }

    @SuppressWarnings("unchecked")
    public UserEntity getUserByName(String username ) {
        Session session = this.sessionFactory.getCurrentSession();
        List<UserEntity> usersList = session.createQuery("from UserEntity user where user.username='" + username +"'").list();
        logger.info("User loaded successfully, User details="+ usersList.get(0));
        return usersList.get(0);
    }


}
