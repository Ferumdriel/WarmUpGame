package com.ferumdriel.core.java.entities;

import com.ferumdriel.core.java.acc.Account;

/**
 * Created by Mati on 4/11/2017.
 */
public class Hero extends Entity{
    private Account acc;
    private int level;
    private int exp;

    public Hero(String name, Account acc){
        super(name);
        this.acc = acc;
        level = 1;
        exp = 0;
    }

    private void levelUp(){
        level++;

    }


    public String toString(){
        String s = "";
        s+= "Hero: " + getName() + " from account: " + acc.getLogin();
        return s;
    }





}
