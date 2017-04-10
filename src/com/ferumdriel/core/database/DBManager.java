package com.ferumdriel.core.database;

import java.sql.*;

/**
 * Created by Mati on 4/10/2017.
 */
public class DBManager {
    private DBConnector dbConnector;

    public DBManager() throws Exception {
        dbConnector = new DBConnector();
    }

    /**
     * Not working as intended, needs some adjustments
     * @throws SQLException
     */
    private void listAllTables() throws SQLException {
        DatabaseMetaData md = dbConnector.getConn().getMetaData();
        ResultSet rs = md.getTables(null, null, "%", null);
        while (rs.next()) {
            System.out.println(rs.getString(3));
        }
    }

    public static void main(String[] args) throws Exception {
        DBManager dbm = new DBManager();
//        dbm.listAllTables();
        dbm.createTable();
    }

    private void createTable() throws Exception{
        try {
            dbConnector.useDB();
            PreparedStatement create = dbConnector.getConn().prepareStatement("CREATE TABLE IF NOT EXISTS probamikrofonu5(id int NOT NULL AUTO_INCREMENT, first varchar(255), last varchar(255), PRIMARY KEY(id))");
            create.executeUpdate();
        }catch(Exception e){

        }
    }

}
