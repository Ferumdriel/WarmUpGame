package com.ferumdriel.core.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Mati on 4/10/2017.
 * DBConnector is singleton.
 */
public class DBConnector{

    private static DBConnector dbc;

    private static final Logger LOGGER = Logger.getLogger("com.ferumdriel.database");
    private static final String USERNAME = "gracz";


    private Connection conn;
    private Properties properties;

    /**
     * Connects to the database and directly specifies database that will be used via this Connector.
     */
    private DBConnector(){
        connect();
        useDB();
    }

    private Properties getProperties(){
        //TODO
        if(properties == null){
            properties = new Properties();
            properties.setProperty("user", USERNAME);
        }
        String driver = "com.mysql.jdbc.Driver";
        String serverName = "localhost:3306";
        String myDatabase = "MySQL";
        String url = "jdbc:mysql://" + serverName + "/" + myDatabase;
        String user = "gracz";
        String pass = "test";
        return properties;
    }

    private void connect(){
        try {
            String driver = "com.mysql.jdbc.Driver";
            String serverName = "localhost:3306";
            String myDatabase = "MySQL";
            String url = "jdbc:mysql://" + serverName + "/" + myDatabase;
            String user = "gracz";
            String pass = "test";

            Class.forName(driver);

            conn = DriverManager.getConnection(url, user, pass);
            LOGGER.log(Level.INFO, "Connected.");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Cannot get connection");
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void useDB(){
        String database = "sampledb";
        try {
            PreparedStatement prep = conn.prepareStatement("USE sampledb");
            prep.executeUpdate();
            LOGGER.log(Level.INFO, "Destination of used DB changed to: " + database);
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "Cannot change destination of used DB to: " + database);
            e.printStackTrace();
        }
    }

    public static DBConnector getInstance(){
        if(dbc == null){
            return new DBConnector();
        }
        return dbc;
    }

    private static void test(){
        System.out.println("Test");
    }

    public static void main(String[] args){
        DBConnector dbc = getInstance();
        dbc.test();

    }


}
