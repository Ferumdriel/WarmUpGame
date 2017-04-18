package com.ferumdriel.core.database;

/**
 * Created by Mati on 4/10/2017.
 */
public interface DBPostable {
    public default void post(){};
    public default void postCharacter(String name){};
}
