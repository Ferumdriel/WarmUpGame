package com.ferumdriel.core.java.acc;

import com.ferumdriel.core.database.DBConnector;
import com.ferumdriel.core.database.DBPostable;

import java.sql.PreparedStatement;

/**
 * Created by Mati on 4/9/2017.
 */
public class AccountManager implements DBPostable {
    private Account acc;

    public AccountManager(){
        acc = null;
    }

    /**
     * Checks database if specific login and password matches the one in database
     * @param login
     * @param password
     */
    private void signIn(String login, String password){
        //TODO
        //CHECK DATABASE FOR ACCOUNT
    }

    private void signUp(String login, String password) throws Exception {
        acc = new Account(login, password);
        post();
    }

    @Override
    public void post() throws Exception{
        DBConnector conn = new DBConnector();
        conn.useDB();
        PreparedStatement post = conn.getConn().prepareStatement("INSERT into account(login, password) VALUES ('" + acc.getLogin() + "','" + acc.getPassword() + "')");
        post.executeUpdate();
    }

    public static void main(String[] args) throws Exception {
        AccountManager manager = new AccountManager();
        manager.signUp("tescik","7456b");
    }
}
