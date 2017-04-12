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
        dbConnector = DBConnector.getInstance();
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
     * Sample create: "CREATE TABLE IF NOT EXISTS aaa(id int NOT NULL AUTO_INCREMENT, first varchar(255), last BIGINT, PRIMARY KEY(id))"
     */
    private void createTable(String sqlTask) {
        try {
//            String tableName = "testowa";
//            String varName0 = "id";
//            String varName1 = "pierwszy";
//            String varName2 = "ostatni";
//            dbConnector.useDB();
//            String sample = "CREATE TABLE IF NOT EXISTS aaa(id int NOT NULL AUTO_INCREMENT, first varchar(255), last varchar(255), PRIMARY KEY(id))";
            PreparedStatement create = dbConnector.getConn().prepareStatement(sqlTask);
            create.executeUpdate();
            logger.log(Level.INFO, "Table created");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Cannot create table");
        }
    }

    /**
     * Testing method
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        DBManager dbm = new DBManager();
//        dbm.listAllTables();
        String sqlTask = "CREATE TABLE IF NOT EXISTS ExpTable(id int NOT NULL AUTO_INCREMENT, expPerLevel BIGINT, PRIMARY KEY(id))";
        dbm.createTable(sqlTask);
    }

    private class DatabaseStats {

        private int[] generateExpArray(int levelRange) {
            int[] exp = new int[levelRange];
            for (int i = 0; i < levelRange; i++) {
                exp[i] = 100 * (i + 1);
            }
            return exp;
        }

        /**
         * Insert exp ranges to the database.
         */
        private void prepareExpDB() {
            try {
                PreparedStatement create = dbConnector.getConn().prepareStatement("CREATE TABLE IF NOT EXISTS aaa(id int NOT NULL AUTO_INCREMENT, first varchar(255), last varchar(255), PRIMARY KEY(id))");
                create.executeUpdate();
                logger.log(Level.INFO, "Table created");
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Cannot create table");
            }
        }
    }
}
