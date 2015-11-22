package com.bildeyko;

import com.bildeyko.objects.*;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;
import oracle.jdbc.pool.OracleDataSource;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

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
                String name = rs.getString("NAME");
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

    public void InsertCompanies(ArrayList<Company> list) throws SQLException {
        PreparedStatement ps = con.prepareStatement("insert into COMPANIES values (?, ?, ?, ?)");
        ((OraclePreparedStatement)ps).setExecuteBatch (list.size());

        Iterator<Company> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Company buf = listIterator.next();
            ps.setBigDecimal(1, new BigDecimal(buf.tin));
            ps.setString(2, buf.name);
            ps.setInt(3, buf.postCode);
            ps.setString(4, buf.address);
            ps.executeUpdate();
        }

        ((OraclePreparedStatement)ps).sendBatch();
        con.commit();

        ps.close();
    }

    public void InsertUnits(ArrayList<Unit> list) throws SQLException {
        PreparedStatement ps = con.prepareStatement("insert into UNITS(NAME, SHORT_NAME) values (?, ?)");
        ((OraclePreparedStatement)ps).setExecuteBatch (list.size());

        Iterator<Unit> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Unit buf = listIterator.next();
            ps.setString(1, buf.name);
            ps.setString(2, buf.short_name);
            ps.executeUpdate();
        }

        ((OraclePreparedStatement)ps).sendBatch();
        con.commit();

        ps.close();
    }

    public void InsertProductTypes(ArrayList<ProductType> list) throws SQLException {
        System.out.println("InsertProductTypes");
        PreparedStatement ps = con.prepareStatement("insert into PRODUCT_TYPES(NAME, UNITS) values (?, ?)");
        ((OraclePreparedStatement)ps).setExecuteBatch (list.size());

        Iterator<ProductType> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            ProductType buf = listIterator.next();
            ps.setString(1, buf.name);
            ps.setInt(2, buf.unitId);
            ps.executeUpdate();
        }

        ((OraclePreparedStatement)ps).sendBatch();
        con.commit();

        ps.close();
    }

    public void insertProducts(ArrayList<Product> list) throws SQLException {
        System.out.println("insertProducts");
        PreparedStatement ps = con.prepareStatement("insert into PRODUCTS(BARCODE, NAME, TYPE) values (?, ?, ?)");
        ((OraclePreparedStatement)ps).setExecuteBatch (list.size());

        Iterator<Product> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Product buf = listIterator.next();
            ps.setBigDecimal(1, new BigDecimal(buf.barcode));
            ps.setString(2, buf.name);
            ps.setInt(3, buf.type.typeId);
            ps.executeUpdate();
        }

        ((OraclePreparedStatement)ps).sendBatch();
        con.commit();

        ps.close();
    }


    public void insertPositionTypes(ArrayList<PositionType> list) throws SQLException {
        System.out.println("insertPositionTypes");
        PreparedStatement ps = con.prepareStatement("insert into POSITION_TYPES(PERCENT, NAME) values (?, ?)");
        ((OraclePreparedStatement)ps).setExecuteBatch (list.size());

        Iterator<PositionType> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            PositionType buf = listIterator.next();
            ps.setDouble(1, buf.percent);
            ps.setString(2, buf.name);
            ps.executeUpdate();
        }

        ((OraclePreparedStatement)ps).sendBatch();
        con.commit();

        ps.close();
    }

    public Integer insertPerson(Person person) throws SQLException {
        String command = "{call BEGIN INSERT INTO PEOPLE (NAME, SURNAME) VALUES (?,?) RETURNING PERSON_ID INTO ? ; END;}";

        CallableStatement statement = con.prepareCall(command);
        statement.setString(1, person.name);
        statement.setString(2, person.surname);
        statement.registerOutParameter( 3, Types.INTEGER );

        int i = statement.executeUpdate();
        if (i > 0) // Update count
            return statement.getInt(3);
        return 0;
    }

    public Integer insertPeople(ArrayList<Person> list) throws SQLException {
        System.out.println("insertPeople");
        PreparedStatement ps = con.prepareStatement("insert into PEOPLE(NAME, SURNAME) values (?, ?)", new String[]{"PERSON_ID"});

        Iterator<Person> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Person buf = listIterator.next();
            ps.setString(1, buf.name);
            ps.setString(2, buf.surname);
            ps.addBatch();
        }

        ps.executeBatch();
        con.commit();

        ResultSet rs = ps.getGeneratedKeys();
        ArrayList<Long> ids = new ArrayList<>();
        while(rs.next()) {
            ids.add(rs.getLong(1));
        }

        ps.close();
        return 0;
    }

    public Integer getUnitId(String fullName) throws SQLException {
        System.out.println("getUnitId");
        Statement stmt = null;
        String query = "select UNITS.UNIT_ID " +
                "from UNITS " +
                "WHERE UNITS.NAME = " + niceStr(fullName);
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer id = rs.getInt("UNIT_ID");
                return id;
            }
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
        } finally {
            if (stmt != null) { stmt.close(); }
        }
        return 0;
    }

    public ArrayList<ProductType> getProductTypes() throws SQLException {
        System.out.println("getProductTypes");

        Statement stmt = null;
        String query = "SELECT * " +
                "FROM PRODUCT_TYPES ";

        ArrayList<ProductType> list = new ArrayList<>();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                list.add(new ProductType(rs.getInt("TYPE_ID"), rs.getString("NAME"), rs.getInt("UNITS")));
            }
            return list;
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
        } finally {
            if (stmt != null) { stmt.close(); }
        }
        return null;
    }

    private String niceStr(String s) {
        return "'"+s+"'";
    }
}
