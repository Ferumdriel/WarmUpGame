package com.ferumdriel.core.java.acc.managers;


import com.ferumdriel.core.java.acc.Account;
import com.ferumdriel.core.java.entities.heroes.Hero;

import java.util.ArrayList;

/**
 * Created by Mati on 4/11/2017.
 * Class supposed to manage all characters relating to the specific account.
 * It can CREATE, PICK, DELETE characters.
 * CharacterManager is a subclass of AccountManager.
 */
public class CharacterManager {
    private Hero curr;
    private Account acc;

    public CharacterManager(Account acc){
        this.acc = acc;
        curr = null;
    }

    private ArrayList<Hero> getCharacterList(){
        return acc.getHeroes();
    }

    public Hero createHero(String name){
        return new Hero(name, acc);
    }

    private void addHero(Hero p){
        acc.getHeroes().add(p);
    }

    /**
     * Player chooses hero he wants to play and it's checked if such name exists in player's account.
     * @param name - hero's name
     * @return exact hero that player wants to play. CAN RETURN NULL if there's no such named hero.
     */
    private void pickHero(String name){
        Hero pickedHero = grantAccessToHero(name);
        if(pickedHero == null){
            System.out.println(name + " does not exist.");
        }else{
            System.out.println("Succesfully picked " + name);
        }
        curr = pickedHero;
    }

    private Hero grantAccessToHero(String name){
        ArrayList<Hero> checkList = acc.getHeroes();
        Hero pickedHero = null;
        for(Hero h: checkList){
            if(h.getName().equals(name)){
                pickedHero = h;
            }
        }
        return pickedHero;
    }


    public static void main(String[] args){

    }

    private void setAcc(Account acc){
        this.acc = acc;
    }
}
