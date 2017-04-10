package com.ferumdriel.core.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Mati on 4/10/2017.
 */
public class DBConnector {

    private static final Logger logger = Logger.getLogger("com.ferumdriel.database");
    private Connection conn;

    public DBConnector() throws Exception{
        connect();
        useDB();
    }

    private void connect() throws Exception{
        try {
            String driver = "com.mysql.jdbc.Driver";
            String serverName = "localhost:3306";
            String myDatabase = "MySQL";
            String url = "jdbc:mysql://" + serverName + "/" + myDatabase;
            String user = "gracz";
            String pass = "test";

            Class.forName(driver);

            conn = DriverManager.getConnection(url, user, pass);
            logger.log(Level.INFO, "Connected.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Cannot get connection");
            e.printStackTrace();
            throw (e);
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void useDB() throws Exception{
        PreparedStatement prep = conn.prepareStatement("USE sampledb");
        prep.executeUpdate();
    }


}
