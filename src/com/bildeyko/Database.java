package com.bildeyko;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;

/**
 * Created by bilde_000 on 22.11.2015.
 */
public class Database {

    private String DB_DRIVER;
    private String DB_CONNECTION;
    private String DB_USER;
    private String DB_PASSWORD;

    private Connection con;

    public Database() {
        System.out.println("Database initialization");

        DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
        DB_CONNECTION = "jdbc:oracle:thin:@//" + Generator.settings.getDatabase().host + ":"
                + Generator.settings.getDatabase().port + "/" + Generator.settings.getDatabase().serviceName;
        DB_USER = Generator.settings.getDatabase().user;
        DB_PASSWORD = Generator.settings.getDatabase().password;

        System.out.println("DB_CONNECTION : " + DB_CONNECTION);
        con = getDBConnection();
    }

    public void viewTable() throws SQLException {

        Statement stmt = null;
        String query = "select * from COMPANIES";
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {

               /* String coffeeName = rs.getString("COF_NAME");
                int supplierID = rs.getInt("SUP_ID");
                float price = rs.getFloat("PRICE");
                int sales = rs.getInt("SALES");
                int total = rs.getInt("TOTAL");
                System.out.println(coffeeName + "\t" + supplierID +
                        "\t" + price + "\t" + sales +
                        "\t" + total);*/
                String name = rs.getString("NAME");
                System.out.println("name : " + name);
            }
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
        } finally {
            if (stmt != null) { stmt.close(); }
        }
    }

    private Connection getDBConnection() {

        Connection dbConnection = null;

        try {

            Class.forName(DB_DRIVER);

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            OracleDataSource ods = new OracleDataSource();
            ods.setURL(DB_CONNECTION);
            ods.setUser(DB_USER);
            ods.setPassword(DB_PASSWORD);

            dbConnection = ods.getConnection();
            dbConnection.setAutoCommit(false);

            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }
}
