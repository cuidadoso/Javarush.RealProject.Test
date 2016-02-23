package ru.alejandro.realproject.dao;

import ru.alejandro.realproject.model.User;

import java.util.List;

/**
 * Created by Alejandro on 21.02.2016.
 */
public interface UserDao
{
    void create(User user);
    User read(int id);
    int update(User user);
    int delete(int id);
    List<User> list();
}
