package ru.alejandro.realproject.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.alejandro.realproject.dao.UserDao;
import ru.alejandro.realproject.model.User;

import java.util.Date;

/**
 * Created by Alejandro on 21.02.2016.
 */
public class MainTest
{
    public static void main(String[] args)
    {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = context.getBean(UserDao.class);
        User user = new User();
        user.setName("Alejandro Pere 2222");
        user.setAge(40);
        user.setAdmin(true);
        Date today = new Date();
        user.setCreatedDate(today);

        //User newUser = userDao.read(5);
        //userDao.delete(5);
        //userDao.create(user);

        //User newUser = userDao.read(user);

        System.out.println("User: " + user);

        //List<User> users = userDao.list();

        /*for(User u : users)
        {
            System.out.println("User list : " + u);
        }*/
        //close resources
        context.close();
    }
}
