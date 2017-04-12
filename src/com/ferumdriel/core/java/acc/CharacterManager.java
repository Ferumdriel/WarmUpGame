package com.ferumdriel.core.java.acc;


import com.ferumdriel.core.java.entities.Hero;

import java.util.ArrayList;

/**
 * Created by Mati on 4/11/2017.
 * Class supposed to manage all characters relating to the specific account.
 * It can CREATE, PICK, DELETE characters.
 * CharacterManager is a subclass of AccountManager.
 */
public class CharacterManager {
    private AccountManager am;
    private Hero curr;
    private Account acc;

    public CharacterManager(AccountManager am){
        this.am = am;
        acc = am.getAcc();
        curr = null;
    }

    private ArrayList<Hero> getCharacterList(){
        return acc.getHeroes();
    }

    private Hero createHero(String name){
        return new Hero(name);
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
}
