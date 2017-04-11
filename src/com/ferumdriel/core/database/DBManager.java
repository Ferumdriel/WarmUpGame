package com.ferumdriel.core.database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Mati on 4/10/2017.
 */
public class DBManager {
    private static final Logger logger = Logger.getLogger("com.ferumdriel.database");

    private DBConnector dbConnector;

    public DBManager() throws Exception {
        dbConnector = new DBConnector();
    }

    /**
     * Not working as intended, needs some adjustments
     *
     * @throws SQLException
     */
    private void listAllTables() throws SQLException {
        DatabaseMetaData md = dbConnector.getConn().getMetaData();
        ResultSet rs = md.getTables(null, null, "%", null);
        while (rs.next()) {
            System.out.println(rs.getString(3));
        }
    }

    /**
     * Allows to create table if needed.
     * @throws Exception
     */
    private void createTable() throws Exception {
        try {
//            String tableName = "testowa";
//            String varName0 = "id";
//            String varName1 = "pierwszy";
//            String varName2 = "ostatni";
            dbConnector.useDB();
            PreparedStatement create = dbConnector.getConn().prepareStatement("CREATE TABLE IF NOT EXISTS aaa(id int NOT NULL AUTO_INCREMENT, first varchar(255), last varchar(255), PRIMARY KEY(id))");
            create.executeUpdate();
            logger.log(Level.INFO, "Table created");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Cannot create table");
        }
    }

    /**
     * Testing method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        DBManager dbm = new DBManager();
//        dbm.listAllTables();
        dbm.createTable();
    }

}
