package com.nurbakyt.springMVC.controllers;

import com.nurbakyt.springMVC.dao.HeroesDAO;
import com.nurbakyt.springMVC.entity.Heroes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
@RequestMapping("/mist")
public class MistControllers {

    private final HeroesDAO heroesDAO;

    public MistControllers(HeroesDAO heroesDAO) {
        this.heroesDAO = heroesDAO;
    }


    @GetMapping
    public String getHeroes(Model model){

        model.addAttribute("heroes", heroesDAO.getHeroes());

        return "mist/heroes.html";
    }

    @GetMapping("/{id}")
    private String showHero(@PathVariable("id") int id, Model model){
        model.addAttribute("oneHero",  heroesDAO.show(id));
        return "mist/show.html";
    }

    @GetMapping("/newHero")
    public String newHero(Model model){
        model.addAttribute("hero", new Heroes());
        return "mist/newHero.html";
    }

    @PostMapping()
    public String addHero(@ModelAttribute("hero") Heroes heroes){
        heroesDAO.addHero(heroes);
        return "redirect:/mist";
    }



}