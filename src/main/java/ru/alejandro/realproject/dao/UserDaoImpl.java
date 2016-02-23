package ru.alejandro.realproject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.alejandro.realproject.model.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Alejandro on 21.02.2016.
 */

@Repository
public class UserDaoImpl implements UserDao
{

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    public void create(User user)
    {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.persist(user);
        tx.commit();
        logger.info("User saved successfully, User Details = " + user);
    }

    public User read(int id)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        User user = session.load(User.class, id);
        tx.commit();
        logger.info("User loaded successfully, User details = " + user);
        return user;
    }

    public int update(User user)
    {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        Serializable id = session.getIdentifier(user);
        tx.commit();
        logger.info("User updated successfully, User Details = " + user);
        return (Integer) id;
    }

    public int delete(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        User user = session.load(User.class, id);
        if(null != user){
            session.delete(user);
        }
        Serializable ids = session.getIdentifier(user);
        tx.commit();
        logger.info("User deleted successfully, User details = " + user);
        return (Integer) ids;
    }

    @SuppressWarnings("unchecked")
    public List<User> list()
    {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<User> userList = session.createQuery("from User").list();
        for(User u : userList){
            logger.info("User List: " + u);
        }
        tx.commit();
        return userList;
    }
}
