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

        /*Iterator<Company> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Company buf = listIterator.next();
            ps.setBigDecimal(1, new BigDecimal(buf.tin));
            ps.setString(2, buf.name);
            ps.setInt(3, buf.postCode);
            ps.setString(4, buf.address);
            ps.addBatch();
        }*/
        for (Company buf: list) {
            ps.setBigDecimal(1, new BigDecimal(buf.tin));
            ps.setString(2, buf.name);
            ps.setInt(3, buf.postCode);
            ps.setString(4, buf.address);
            ps.addBatch();
        }

        ps.executeBatch();
        con.commit();

        ps.close();
    }

    public void InsertUnits(ArrayList<Unit> list) throws SQLException {
        System.out.println("InsertUnits");
        PreparedStatement ps = con.prepareStatement("insert into UNITS(NAME, SHORT_NAME) values (?, ?)");

        /*Iterator<Unit> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Unit buf = listIterator.next();
            ps.setString(1, buf.name);
            ps.setString(2, buf.short_name);
            ps.addBatch();
        }*/
        for (Unit buf: list) {
            ps.setString(1, buf.name);
            ps.setString(2, buf.short_name);
            ps.addBatch();
        }

        ps.executeBatch();
        con.commit();

        ps.close();
    }

    public void InsertProductTypes(ArrayList<ProductType> list) throws SQLException {
        System.out.println("InsertProductTypes");
        PreparedStatement ps = con.prepareStatement("insert into PRODUCT_TYPES(NAME, UNITS) values (?, ?)");

        /*Iterator<ProductType> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            ProductType buf = listIterator.next();
            ps.setString(1, buf.name);
            ps.setInt(2, buf.unitId);
            ps.addBatch();
        }*/
        for (ProductType buf: list) {
            ps.setString(1, buf.name);
            ps.setInt(2, buf.unitId);
            ps.addBatch();
        }

        ps.executeBatch();
        con.commit();

        ps.close();
    }

    public void insertProducts(ArrayList<Product> list) throws SQLException {
        System.out.println("insertProducts");
        PreparedStatement ps = con.prepareStatement("insert into PRODUCTS(BARCODE, NAME, TYPE) values (?, ?, ?)");

        /*Iterator<Product> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Product buf = listIterator.next();
            ps.setBigDecimal(1, new BigDecimal(buf.barcode));
            ps.setString(2, buf.name);
            ps.setInt(3, buf.type.typeId);
            ps.addBatch();
        }*/
        for (Product buf: list) {
            ps.setBigDecimal(1, new BigDecimal(buf.barcode));
            ps.setString(2, buf.name);
            ps.setInt(3, buf.type.typeId);
            ps.addBatch();
        }

        ps.executeBatch();
        con.commit();

        ps.close();
    }


    public void insertPositionTypes(ArrayList<PositionType> list) throws SQLException {
        System.out.println("insertPositionTypes");
        PreparedStatement ps = con.prepareStatement("insert into POSITION_TYPES(PERCENT, NAME) values (?, ?)");

        /*Iterator<PositionType> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            PositionType buf = listIterator.next();
            ps.setDouble(1, buf.percent);
            ps.setString(2, buf.name);
            ps.addBatch();
        }*/
        for (PositionType buf: list) {
            ps.setDouble(1, buf.percent);
            ps.setString(2, buf.name);
            ps.addBatch();
        }

        ps.executeBatch();
        con.commit();

        ps.close();
    }

    public void insertPositions(ArrayList<Staff> list) throws SQLException {
        System.out.println("insertPositions");
        PreparedStatement ps = con.prepareStatement("insert into POSITIONS(STAFF_ID, POSITION_TYPE_ID, START_TIME) values (?, ?, ?)");

        for (Staff buf: list) {
            ps.setLong(1, buf.staffId);
            ps.setInt(2, buf.positionTypeId);
            ps.setTimestamp(3, new Timestamp(buf.startTime.getTime()));
            ps.addBatch();
        }

        ps.executeBatch();
        con.commit();

        ps.close();
    }

    /*public Integer insertPerson(Person person) throws SQLException {
        String command = "{call BEGIN INSERT INTO PEOPLE (NAME, SURNAME) VALUES (?,?) RETURNING PERSON_ID INTO ? ; END;}";

        CallableStatement statement = con.prepareCall(command);
        statement.setString(1, person.name);
        statement.setString(2, person.surname);
        statement.registerOutParameter( 3, Types.INTEGER );

        int i = statement.executeUpdate();
        if (i > 0)
            return statement.getInt(3);
        return 0;
    }*/

    public ArrayList<? extends Person> insertPeople(ArrayList<? extends Person> list) throws SQLException {
        System.out.println("insertPeople");
        PreparedStatement ps = con.prepareStatement("insert into PEOPLE(NAME, SURNAME, DOB) values (?, ?, ?)", new String[]{"PERSON_ID"});

        /*Iterator<Person> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Person buf = listIterator.next();
            ps.setString(1, buf.name);
            ps.setString(2, buf.surname);
            ps.addBatch();
        }*/
        for (Person buf: list) {
            ps.setString(1, buf.name);
            ps.setString(2, buf.surname);
            ps.setTimestamp(3, new Timestamp(buf.dob.getTime()));
            ps.addBatch();
        }

        ps.executeBatch();
        con.commit();

        ResultSet rs = ps.getGeneratedKeys();
        ArrayList<Long> ids = new ArrayList<>();
        while(rs.next()) {
            ids.add(rs.getLong(1));
        }

        Iterator<Long> it1 = ids.iterator();
        Iterator<? extends Person> it2 = list.iterator();
        while(it1.hasNext() && it2.hasNext())
        {
            Long value1 = it1.next();
            it2.next().personId = value1;
        }//while

        ps.close();
        return list;
    }

    public ArrayList<Staff> insertStaff(ArrayList<Staff> list) throws SQLException {
        System.out.println("insertStaff");
        PreparedStatement ps = con.prepareStatement("insert into STAFF(PERSON_ID, SNILS) values (?, ?)", new String[]{"STAFF_ID"});

        for (Staff buf: list) {
            ps.setLong(1, buf.personId);
            ps.setBigDecimal(2, new BigDecimal(buf.snils));
            ps.addBatch();
        }

        ps.executeBatch();
        con.commit();

        ResultSet rs = ps.getGeneratedKeys();
        ArrayList<Long> ids = new ArrayList<>();
        while(rs.next()) {
            ids.add(rs.getLong(1));
        }

        Iterator<Long> it1 = ids.iterator();
        Iterator<Staff> it2 = list.iterator();
        while(it1.hasNext() && it2.hasNext())
        {
            Long value1 = it1.next();
            it2.next().staffId = value1;
        }//while

        ps.close();
        return list;
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

    public Integer getPosTypeId(String posType) throws SQLException {
        System.out.println("getPosTypeId");
        Statement stmt = null;
        String query = "select POSITION_TYPES.POSITION_TYPE_ID " +
                "from POSITION_TYPES " +
                "WHERE POSITION_TYPES.NAME = " + niceStr(posType);
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Integer id = rs.getInt("POSITION_TYPE_ID");
                return id;
            }
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
        } finally {
            if (stmt != null) { stmt.close(); }
        }
        return -1;
    }

    private String niceStr(String s) {
        return "'"+s+"'";
    }
}
