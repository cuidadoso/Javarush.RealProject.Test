package ru.alejandro.realproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.alejandro.realproject.model.User;
import ru.alejandro.realproject.services.UserService;

/**
 * Created by Alejandro on 21.02.2016.
 */

@Controller
public class UserController
{
    private UserService userService;

    @Autowired(required=true)
    @Qualifier(value="userService")
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listUsers(Model model)
    {
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", userService.list());
        return "index";
    }

    //For add and update person both
    @RequestMapping(value= "/user/add", method = RequestMethod.POST)
    public String createOrUpdateUser(@ModelAttribute("user") User user)
    {
        if(user.getId() == 0){
            //new person, add it
            userService.create(user);
        }
        else
        {
            //existing person, call update
            userService.update(user);
        }
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id)
    {
        userService.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/read/{id}")
    public String readUser(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("user", userService.read(id));
        model.addAttribute("listUsers", userService.list());
        return "index";
    }
}
