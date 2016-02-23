package ru.alejandro.realproject.services;

import org.springframework.transaction.annotation.Transactional;
import ru.alejandro.realproject.dao.UserDao;
import ru.alejandro.realproject.model.User;

import java.util.List;

/**
 * Created by Alejandro on 21.02.2016.
 */
public class UserServiceImpl implements UserService
{
    private UserDao userDao;

    public void setUserDao(UserDao userDao)
    {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void create(User user)
    {
        userDao.create(user);
    }

    @Override
    @Transactional
    public User read(int id)
    {
        return userDao.read(id);
    }

    @Override
    @Transactional
    public int update(User user)
    {
        return userDao.update(user);
    }

    @Override
    @Transactional
    public int delete(int id)
    {
        return userDao.delete(id);
    }

    @Override
    @Transactional
    public List<User> list()
    {
        return userDao.list();
    }
}
