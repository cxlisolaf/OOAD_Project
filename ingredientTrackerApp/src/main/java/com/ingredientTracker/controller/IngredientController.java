package com.ingredientTracker.controller;

import com.ingredientTracker.entity.IngredientsEntity;
import com.ingredientTracker.entity.UserEntity;
import com.ingredientTracker.service.IngredientService;
import com.ingredientTracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@SessionAttributes("userid")
public class IngredientController {

    private UserService userService;
    private IngredientService ingredientService;

    @Autowired(required = true)
    @Qualifier(value = "ingredientService")
    public void setIngredientService(IngredientService is){

        this.ingredientService = is;
    }

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService us){

        this.userService = us;
    }

    @RequestMapping(value = "/mypantry", method = RequestMethod.GET)
    public String showMainPage(ModelMap model) {

        List<IngredientsEntity> i = this.ingredientService.listIngredients();
        List<String> username = new ArrayList<String>();

        model.addAttribute("ingredients", i);
        return "mypantry";
    }


    @RequestMapping(value = "/add-ingredient", method = RequestMethod.GET)
    public String showAddIngredientPage(ModelMap model) {
        model.addAttribute("ingredients", new IngredientsEntity());
        return "add-ingredient";
    }


    @RequestMapping("/remove/{ingredientId}")
    public String removeEvent(@PathVariable("ingredientId") int ingredientId) {
        this.ingredientService.removeIngredient(ingredientId);
        return "redirect:/manage-event";
    }


}
