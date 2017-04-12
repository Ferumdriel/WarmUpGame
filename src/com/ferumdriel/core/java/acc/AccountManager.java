package com.ferumdriel.core.java.acc;

import com.ferumdriel.core.database.DBConnector;
import com.ferumdriel.core.database.DBPostable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Mati on 4/9/2017.
 */
public class AccountManager implements DBPostable {
    private static final Logger LOGGER = Logger.getLogger("com.ferumdriel.database");

    private Account acc;
    private CharacterManager cm;

    public AccountManager(){
        acc = null;
        cm = null;
    }

    /**
     * Checks database if specific login and password matches the one in database
     * @param login - user's entered login
     * @param password - user's entered password
     */
    private void signIn(String login, String password){
        if (authenticationValid(login, password)) {
            loadAccount(login, password);
            LOGGER.log(Level.INFO, "Succesfully signed in.");
        }else{
            LOGGER.log(Level.INFO, "Incorrect login/password");
        }
    }

    /**
     * Checks authentication. If user exists in database and he entered proper login and password he will be given access.
     * @param login - user's entered login
     * @param password - user's entered password
     * @return If login and password match each other (they exist in database) return true.
     */
    private boolean authenticationValid(String login, String password){
        String log = "";
        String pass = "";
        try {
            ResultSet rs = selectAccount(login, password);
            while (rs.next()) {
                log = rs.getString("login");
                pass = rs.getString("password");
            }
            LOGGER.log(Level.INFO, "ResultSet from SELECT statement succesfully completed");
        }catch(SQLException e){
            LOGGER.log(Level.SEVERE, "Unable to get ResultSet from SELECT statement");
            e.printStackTrace();
        }
        return login.equals(log) && password.equals(pass);
    }

    private void signUp(String login, String password){
        acc = new Account(login, password);
        post();
    }

    /**
     * Selects account from the database
     * @param login - user's entered login
     * @param password - user's entered password
     * @return Specific row with player's account information
     */
    private ResultSet selectAccount(String login, String password){
        ResultSet rs = null;
        try {
            DBConnector conn = DBConnector.getInstance();
            PreparedStatement select = conn.getConn().prepareStatement("SELECT login, password FROM account WHERE (login = '" + login + "' AND password = '" + password + "')");
            rs = select.executeQuery();
            LOGGER.log(Level.INFO, "Select statement succesfully completed");
        }catch(SQLException e){
            LOGGER.log(Level.SEVERE, "Unable to get select statement");
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * Adds account to the database
     */
    @Override
    public void post(){
        String login = acc.getLogin();
        String password = acc.getPassword();
        try {
            DBConnector conn = DBConnector.getInstance();
            PreparedStatement post = conn.getConn().prepareStatement("INSERT into account(login, password) VALUES ('" + login + "','" + password + "')");
            post.executeUpdate();
            LOGGER.log(Level.INFO, "Account with Login: " + login + ", password: " + password + " added to the database");
        }catch(SQLException e){
            LOGGER.log(Level.SEVERE, "Unable to add account with Login: " + login + ", password: " + password + " to the database");
            e.printStackTrace();
        }

    }



    private void loadAccount(String login, String password){
        acc = new Account(login, password);
        loadCharacters();
    }

    private void loadCharacters(){
        //TODO
    }

    public Account getAcc() {
        return acc;
    }

    /**
     * Testing field.
     * @param args
     */
    public static void main(String[] args){
        AccountManager manager = new AccountManager();
//        manager.signUp("baza","probamikrofonu");
        manager.signIn("baba","lala");
    }

    /**
     * Testing method
     * @param rs
     */
    private void displayAccountSelect(ResultSet rs){
        int id = 0;
        String log, pass;
        try {
            while (rs.next()) {
//                id = rs.getInt("idAccount");
                log = rs.getString("login");
                pass = rs.getString("password");
                System.out.println("ID: " + id + ", Login: " + log + ", Password: " + pass + "\n");
            }
        }catch(SQLException e){

        }
    }
}
