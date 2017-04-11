package com.ferumdriel.core.java.acc;


import java.util.ArrayList;

/**
 * Created by Mati on 4/11/2017.
 */
public class CharacterManager {
    private Account acc;

    public CharacterManager(){
        acc = null;
    }

    private ArrayList<Character> getCharacterList(){
        return acc.getCharacters();
    }
    


    public static void main(String[] args){

    }
}
