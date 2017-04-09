package com.ferumdriel.core.java.entities;

/**
 * Created by Mati on 4/9/2017.
 */
public class Entity {
    private String name;
    private int health;

    public Entity(String name){
        this.name = name;
        health = 100;
    }

    public Entity createEntity(String name){
        return new Entity(name);
    }
}
