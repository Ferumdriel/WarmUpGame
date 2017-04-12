package com.ferumdriel.core.java.acc;

import com.ferumdriel.core.java.entities.Hero;

import java.util.ArrayList;

/**
 * Created by Mati on 4/9/2017.
 */
public class Account {
    private ArrayList<Hero> heroes = new ArrayList<>();
    private String login;
    private String password;

    public Account(String login, String password){
        this.login = login;
        this.password = password;
    }

    public void addPlayer(Hero e){
        heroes.add(e);
    }

    public String getLogin() {
        return login;
    }



    public String getPassword() {
        return password;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }
}
