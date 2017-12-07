package com.ingredientTracker.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ingredientTracker.entity.UserEntity;
import com.ingredientTracker.service.UserService;

@Controller
@SessionAttributes("userid") // only use when generic parameter bc it takes memory
public class UserController {

    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "UserService")
    public void setUserService(UserService us) {
        this.userService = us;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterPage(ModelMap model){
        model.addAttribute("user", new UserEntity());
        return "register";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addUser(ModelMap model, UserEntity user) {
        System.out.println(user);
        this.userService.addUser(user);
        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLoginRequest(@RequestParam String username, @RequestParam String password, ModelMap model){
        if(!userService.isUserValid(username, password)){
            model.put("errorMsg", "Invalid user");
            return "login";
        }

        model.addAttribute("userid", Integer.toString(userService.getUserByName(username).getId()));
        return "redirect:/event";
    }


}