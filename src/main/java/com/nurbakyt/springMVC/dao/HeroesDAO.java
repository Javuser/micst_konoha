package com.nurbakyt.springMVC.dao;

import com.nurbakyt.springMVC.entity.Heroes;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class HeroesDAO {
    private ArrayList<Heroes> heroes;
    private static int id;

    {
        heroes = new ArrayList<>();
        heroes.add(new Heroes(++id, "Naruto", "Hokage"));
        heroes.add(new Heroes(++id, "Kakashi", "Hokage"));
        heroes.add(new Heroes(++id, "Sakura", "Jonin"));
        heroes.add(new Heroes(++id, "Saske", "Jonin"));
    }

    public ArrayList<Heroes> getHeroes(){
        return heroes;
    }
    public void addHero(Heroes hero){
        hero.setId(id);
        heroes.add(hero);
    }

    public Heroes show(int id) {
        return heroes.stream()
                .filter(h -> h.getId() == id).findAny().orElse(null);
    }
}
