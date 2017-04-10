package com.ferumdriel.core.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Mati on 4/9/2017.
 * @deprecated
 */
public class Main {

    private static final Logger logger = Logger.getLogger("com.ferumdriel.database");

    public static void main(String[] args) throws Exception{
        createTable();
    }

    public static Connection getConnection() throws Exception{
        try {
            String driver = "com.mysql.jdbc.Driver";
            //zzz
            String serverName = "localhost:3306";
            String myDatabase = "MySQL";
            String url = "jdbc:mysql://" + serverName + "/" + myDatabase;

            String user = "gracz";
            String pass = "test";

            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, user, pass);
            logger.log(Level.INFO,"Connected.");
            return conn;
        }catch(Exception e){
            logger.log(Level.SEVERE, "Cannot get connection");
            e.printStackTrace();
            throw(e);
        }
    }

    public static void createDatabase(){
        try{
            Connection conn = getConnection();
            PreparedStatement create = conn.prepareStatement("CREATE DATABASE aaaDB");
            create.executeUpdate();
            logger.log(Level.INFO, "Database created");
        }catch(Exception e){
            logger.log(Level.SEVERE, "Cannot create database");
            e.printStackTrace();
        }
    }

    public static void createTable() throws Exception{
        try{
            Connection conn = getConnection();
            PreparedStatement create = conn.prepareStatement("USE aaadb");
            create.executeUpdate();
            create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS aaa(id int NOT NULL AUTO_INCREMENT, first varchar(255), last varchar(255), PRIMARY KEY(id))");
            create.executeUpdate();
            logger.log(Level.INFO, "Table created");
        }catch(Exception e){
            logger.log(Level.SEVERE, "Cannot create table");
            e.printStackTrace();
        }
    }
}
