package com.bildeyko;

import com.bildeyko.objects.*;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;
import oracle.jdbc.pool.OracleDataSource;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.Date;

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

        for (Unit buf: list) {
            ps.setString(1, buf.name);
            ps.setString(2, buf.short_name);
            ps.addBatch();
        }

        ps.executeBatch();
        con.commit();

        ps.close();
    }

    public void insertStates(ArrayList<String> list) throws SQLException {
        System.out.println("insertStates");
        PreparedStatement ps = con.prepareStatement("insert into STATES(NAME) values (?)");

        for (String buf: list) {
            ps.setString(1, buf);
            ps.addBatch();
        }

        ps.executeBatch();
        con.commit();

        ps.close();
    }

    public void InsertProductTypes(ArrayList<ProductType> list) throws SQLException {
        System.out.println("InsertProductTypes");
        PreparedStatement ps = con.prepareStatement("insert into PRODUCT_TYPES(NAME, UNITS) values (?, ?)");

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

    public void insertProduct_items(ArrayList<Product_item> list) throws SQLException {
        System.out.println("insertProduct_items");
        PreparedStatement ps = con.prepareStatement("insert into PRODUCT_ITEMS(TIN, PRODUCT_ID, SHELF_LIFE, QUANTITY, PRICE) values (?, ?, ?, ?, ?)");

        for (Product_item buf: list) {
            ps.setBigDecimal(1, new BigDecimal(buf.tin));
            ps.setInt(2, buf.productId);
            ps.setTimestamp(3, new Timestamp(buf.shelfLife.getTime()));
            ps.setDouble(4, buf.quantity);
            ps.setDouble(5, buf.price);
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

    public void insertCustomers(ArrayList<Customer> list) throws SQLException {
        System.out.println("insertCustomers");
        PreparedStatement ps = con.prepareStatement("insert into CUSTOMERS(PERSON_ID, POSTCODE, ADDRESS) values (?, ?, ?)");

        for (Customer buf: list) {
            ps.setLong(1, buf.personId);
            ps.setInt(2, buf.postCode);
            ps.setString(3, buf.address);
            ps.addBatch();
        }

        ps.executeBatch();
        con.commit();

        ps.close();
    }

    public void insertContacts(ArrayList<Contract> list) throws SQLException {
        System.out.println("insertContacts");
        PreparedStatement ps = con.prepareStatement("insert into CONTRACTS(CUSTOMER_ID, BROKER_ID, START_TIME, END_TIME, LIMIT_PER_AUCTION) values (?, ?, ?, ?, ?)");

        for (Contract buf: list) {
            ps.setLong(1, buf.customerId);
            ps.setLong(2, buf.brokerId);
            ps.setTimestamp(3, new Timestamp(buf.startTime.getTime()));
            ps.setTimestamp(4, new Timestamp(buf.endTime.getTime()));
            ps.setDouble(5, buf.limit);
            ps.addBatch();
        }

        ps.executeBatch();
        con.commit();

        ps.close();
    }

    public Long insertBatch(Batch batch) throws SQLException {
        System.out.println("insertBatch");
        PreparedStatement ps = con.prepareStatement("insert into BATCHES(STAFF_ID, TYPE_ID, BUILD_DATE) values (?, ?, ?)", new String[]{"BATCH_ID"});

        ps.setLong(1, batch.staffId);
        ps.setLong(2, batch.typeId);
        ps.setTimestamp(3, new Timestamp(batch.buildTime.getTime()));
        ps.addBatch();

        ps.executeBatch();
        con.commit();

        ResultSet rs = ps.getGeneratedKeys();

        Long id = null;
        while(rs.next()) {
            id = rs.getLong(1);
        }

        ps.close();
        return id;
    }

    public void insertBatch_items(ArrayList<Batch_item> list) throws SQLException {
        System.out.println("insertBatch_items");
        PreparedStatement ps = con.prepareStatement("insert into BATCH_ITEMS(PRODITEM_ID, BATCH_ID, QUANTITY) values (?, ?, ?)");

        for (Batch_item buf: list) {
            ps.setBigDecimal(1, new BigDecimal(buf.itemId));
            ps.setLong(2, buf.batchId);
            ps.setDouble(3, buf.quantity);
            ps.addBatch();
        }

        ps.executeBatch();
        con.commit();

        ps.close();
    }

    public void insertAuctions(ArrayList<Auction> list) throws SQLException {
        System.out.println("insertAuctions");
        PreparedStatement ps = con.prepareStatement("insert into AUCTIONS(BATCH_ID, START_TIME, END_TIME) values (?, ?, ?)");

        for (Auction buf: list) {
            ps.setLong(1, buf.batchId);
            ps.setTimestamp(2, new Timestamp(buf.startTime.getTime()));
            ps.setTimestamp(3, new Timestamp(buf.endTime.getTime()));
            ps.addBatch();
        }

        ps.executeBatch();
        con.commit();

        ps.close();
    }

    public void insertBet(Bet bet) throws SQLException {
        System.out.println("insertBet");

        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("insert into BETS(AUCTION_ID, CONTRACT_ID, BET, TIME) values (?, ?, ?, ?)");
            ps.setLong(1, bet.auctionId);
            ps.setLong(2, bet.contractId);
            ps.setDouble(3, bet.bet);
            ps.setTimestamp(4, new Timestamp(bet.time.getTime()));
            ResultSet rs = ps.executeQuery();
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
        } finally {
            if (ps != null) { ps.close(); }
        }
        ps.close();
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

    public ArrayList<Product> getProducts() throws SQLException {
        System.out.println("getProductTypes");

        Statement stmt = null;
        String query = "SELECT * " +
                "FROM PRODUCTS ";

        ArrayList<Product> list = new ArrayList<>();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                list.add(new Product(rs.getInt("PRODUCT_ID"), rs.getBigDecimal("BARCODE").toBigInteger(), rs.getString("NAME")));
            }
            return list;
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
        } finally {
            if (stmt != null) { stmt.close(); }
        }
        return null;
    }

    public ArrayList<Company> getCompanies() throws SQLException {
        System.out.println("getCompanies");

        Statement stmt = null;
        String query = "SELECT * " +
                "FROM COMPANIES ";

        ArrayList<Company> list = new ArrayList<>();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                list.add(new Company(rs.getBigDecimal("TIN").toBigInteger(), rs.getString("NAME"), rs.getInt("POSTCODE"), rs.getString("ADDRESS")));
            }
            return list;
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
        } finally {
            if (stmt != null) { stmt.close(); }
        }
        return null;
    }

    public ArrayList<Customer> getCustomers() throws SQLException {
        System.out.println("getCustomers");

        Statement stmt = null;
        String query = "SELECT * " +
                "FROM CUSTOMERS ";

        ArrayList<Customer> list = new ArrayList<>();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                list.add(new Customer(rs.getLong("CUSTOMER_ID"), rs.getLong("PERSON_ID"), rs.getInt("POSTCODE"), rs.getString("ADDRESS")));
            }
            return list;
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
        } finally {
            if (stmt != null) { stmt.close(); }
        }
        return null;
    }

    public ArrayList<Staff> getStaff(String type) throws SQLException {
        System.out.println("getCustomers");

        Statement stmt = null;
        String query = "SELECT STAFF.* " +
                "FROM STAFF, POSITIONS, POSITION_TYPES " +
                "WHERE STAFF.STAFF_ID=POSITIONS.STAFF_ID AND POSITIONS.POSITION_TYPE_ID = POSITION_TYPES.POSITION_TYPE_ID " +
                "AND POSITION_TYPES.NAME = " + niceStr(type);

        ArrayList<Staff> list = new ArrayList<>();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                list.add(new Staff(rs.getLong("STAFF_ID")));
            }
            return list;
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
        } finally {
            if (stmt != null) { stmt.close(); }
        }
        return null;
    }

    public ArrayList<Product_item> getProductItems() throws  SQLException {
        System.out.println("getProductItems");

        Statement stmt = null;
        String query = "SELECT PRODUCT_ITEMS.PRODITEM_ID, PRODUCT_ITEMS.QUANTITY, PRODUCTS.TYPE, COALESCE(d.sum,0) SUM " +
                "FROM PRODUCTS, PRODUCT_ITEMS " +
                "LEFT JOIN  (SELECT PRODITEM_ID, sum(QUANTITY) sum " +
                "FROM BATCH_ITEMS " +
                "GROUP BY PRODITEM_ID) d ON PRODUCT_ITEMS.PRODITEM_ID = d.PRODITEM_ID " +
                "WHERE PRODUCT_ITEMS.PRODUCT_ID = PRODUCTS.PRODUCT_ID AND PRODUCT_ITEMS.SHELF_LIFE > sysdate " +
                "AND (PRODUCT_ITEMS.QUANTITY > d.sum OR d.sum IS NULL)";

        ArrayList<Product_item> list = new ArrayList<>();
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                list.add(new Product_item(rs.getBigDecimal("PRODITEM_ID").toBigInteger(),rs.getDouble("QUANTITY"),rs.getInt("TYPE"),rs.getDouble("SUM")));
            }
            return list;
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
        } finally {
            if (stmt != null) { stmt.close(); }
        }
        return null;
    }

    public ArrayList<Contract> getContracts(LocalDateTime currentTime) throws  SQLException {
        System.out.println("getContracts");

        PreparedStatement ps = null;

        Instant instant = currentTime.atZone(ZoneId.systemDefault()).toInstant();

        ArrayList<Contract> list = new ArrayList<>();
        try {
            ps = con.prepareStatement("SELECT * FROM CONTRACTS WHERE END_TIME >= ?");
            ps.setTimestamp(1, new Timestamp(Date.from(instant).getTime()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Contract(rs.getLong("CONTRACT_ID"), rs.getDouble("LIMIT_PER_AUCTION")));
            }
            return list;
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
        } finally {
            if (ps != null) { ps.close(); }
        }
        return null;
    }

    public ArrayList<Auction> getAuctions(LocalDateTime currentTime) throws  SQLException {
        System.out.println("getAuctions");

        PreparedStatement ps = null;

        Instant instant = currentTime.atZone(ZoneId.systemDefault()).toInstant();

        ArrayList<Auction> list = new ArrayList<>();
        try {
            ps = con.prepareStatement("SELECT * FROM AUCTIONS WHERE END_TIME >= ?");
            ps.setTimestamp(1, new Timestamp(Date.from(instant).getTime()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Auction(rs.getLong("AUCTION_ID")));
            }
            return list;
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
        } finally {
            if (ps != null) { ps.close(); }
        }
        return null;
    }

    public double getBetsSum(Long contractId, Long auctionId) throws  SQLException {
        System.out.println("getBetsSum");

        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("SELECT AUCTION_ID, sum(BETS.BET) SUM " +
                    "  FROM BETS " +
                    "WHERE CONTRACT_ID = ? AND AUCTION_ID = ? " +
                    "GROUP BY AUCTION_ID");
            ps.setLong(1, contractId);
            ps.setLong(2, auctionId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getDouble("SUM");
            }
        } catch (SQLException e ) {
            System.out.println(e.getMessage());
        } finally {
            if (ps != null) { ps.close(); }
        }
        return 0.0;
    }

    private String niceStr(String s) {
        return "'"+s+"'";
    }
}
