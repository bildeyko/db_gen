package com.bildeyko;

import com.bildeyko.objects.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Nick Bildeyko on 21.11.2015.
 */
public class Generator {
    public static Settings settings;

    private LocalDateTime startDate;
    private Database db;

    public Generator() {
        settings = new Settings("settings.xml");
        settings.load();

        startDate = LocalDateTime.now();
        startDate = startDate.minusDays(settings.getDays());

        db = new Database();
        try {
            db.viewTable();
        }
        catch (SQLException e ) {
            System.out.println(e.getMessage());
        }

        /*Company c1 = new Company();
        ArrayList<Company> c2 = new ArrayList<>(settings.getCompanies());
        for (int i = 0; i < settings.getCompanies(); i++) {
            c2.add(new Company());
        }

        try {
            db.InsertCompanies(c2);
        }
        catch (SQLException e ) {
            System.out.println(e.getMessage());
        }*/


       /* ArrayList<Person> c3 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            c3.add(new Person());
        }
        try {
            db.insertPeople(c3);
        }
        catch (SQLException e ) {
            System.out.println(e.getMessage());
        }*/

        InsertUnits();
        InsertProductTypes();
        InsertProducts();
        InsertPositionTypes();
        insertStates();

        InsertStaff_by_type("менеджер", 3);
        InsertStaff_by_type("брокер", 3);
        InsertStaff_by_type("доставщик", 3);

        lifeCycle();
        System.out.println("Date : " + startDate.toString());
    }

    private void InsertUnits() {
        ArrayList<Unit> units = new ArrayList<>();
        units.add(new Unit("килограмм","кг"));
        units.add(new Unit("тонн","т"));
        units.add(new Unit("грамм","г"));
        units.add(new Unit("литр","л"));
        try {
            db.InsertUnits(units);
        }
        catch (SQLException e ) {
            System.out.println(e.getMessage());
        }
    }

    private void InsertProductTypes() {
        Integer unitId = 1;
        try {
            unitId = db.getUnitId("килограмм");
        }
        catch (SQLException e ) {
            System.out.println(e.getMessage());
            return;
        }

        ArrayList<ProductType> types = new ArrayList<>();
        types.add(new ProductType("хлебные культуры", unitId));
        types.add(new ProductType("зернобобовые культуры", unitId));
        types.add(new ProductType("кормовые зерновые культуры", unitId));
        types.add(new ProductType("миниральные удобрения", unitId));
        types.add(new ProductType("органические удобрения", unitId));
        try {
            db.InsertProductTypes(types);
        }
        catch (SQLException e ) {
            System.out.println(e.getMessage());
        }
    }

    private void InsertProducts() {
        ArrayList<ProductType> types = null;
        try {
            types = db.getProductTypes();
        }
        catch (SQLException e ) {
            System.out.println(e.getMessage());
            return;
        }


        Iterator<ProductType> typesIterator = types.listIterator();
        ArrayList<Product> products = new ArrayList<>();

        while (typesIterator.hasNext()) {
            ProductType buf = typesIterator.next();
            switch(buf.name) {
                case "хлебные культуры":
                    for(int i=0; i<2; i++) {
                        products.add(new Product("пшеница", buf));
                        products.add(new Product("рис", buf));
                        products.add(new Product("рожь", buf));
                        products.add(new Product("кукуруза", buf));
                        products.add(new Product("ячмень яровой", buf));
                        products.add(new Product("ячмень озимый", buf));
                        products.add(new Product("овес", buf));
                        products.add(new Product("просо", buf));
                        products.add(new Product("сорго", buf));
                        products.add(new Product("гречиха", buf));
                        products.add(new Product("чумиза", buf));
                    }
                    break;
                case "зернобобовые культуры":
                    for(int i=0; i<2; i++) {
                        products.add(new Product("горох", buf));
                        products.add(new Product("фасоль", buf));
                        products.add(new Product("соя", buf));
                        products.add(new Product("чечевица", buf));
                        products.add(new Product("бобы", buf));
                    }
                    break;
                case "кормовые зерновые культуры":
                    for(int i=0; i<2; i++) {
                        products.add(new Product("овес", buf));
                        products.add(new Product("ячмень", buf));
                        products.add(new Product("кукуруза", buf));
                        products.add(new Product("сорго", buf));
                        products.add(new Product("чумиза", buf));
                        products.add(new Product("африканское просо", buf));
                        products.add(new Product("горох", buf));
                        products.add(new Product("бобы конские", buf));
                        products.add(new Product("вика", buf));
                        products.add(new Product("пелюшка", buf));
                        products.add(new Product("люпин кормовой", buf));
                    }
                    break;
                case "миниральные удобрения":
                    for(int i=0; i<2; i++) {
                        products.add(new Product("аммиачная селитра", buf));
                        products.add(new Product("карбамид", buf));
                        products.add(new Product("фосфорная мука", buf));
                        products.add(new Product("суперфосфат", buf));
                        products.add(new Product("азотно-фосфорные", buf));
                        products.add(new Product("фзотно-калийные", buf));
                        products.add(new Product("фосфорно-калийные", buf));
                        products.add(new Product("аммофос", buf));
                        products.add(new Product("калийная сеитра", buf));
                        products.add(new Product("нитрофос", buf));
                        products.add(new Product("митрофоска", buf));
                        products.add(new Product("нитроаммофос", buf));
                        products.add(new Product("нотроаммофоска", buf));
                    }
                    break;
                case "органические удобрения":
                    for(int i=0; i<2; i++) {
                        products.add(new Product("навоз", buf));
                        products.add(new Product("птичий помёт", buf));
                        products.add(new Product("торф", buf));
                        products.add(new Product("ил", buf));
                        products.add(new Product("фекалии", buf));
                        products.add(new Product("опилки", buf));
                        products.add(new Product("сидераты", buf));
                        products.add(new Product("компост", buf));
                    }
                    break;
            }
        }

        try {
            db.insertProducts(products);
        }
        catch (SQLException e ) {
            System.out.println(e.getMessage());
        }
    }

    private void InsertPositionTypes() {
        ArrayList<PositionType> types = new ArrayList<>();
        types.add(new PositionType("менеджер", 5.00));
        types.add(new PositionType("брокер", 5.00));
        types.add(new PositionType("доставщик", 2.00));
        try {
            db.insertPositionTypes(types);
        }
        catch (SQLException e ) {
            System.out.println(e.getMessage());
        }
    }

    private void InsertStaff_by_type(String type, Integer num) {
        Integer id;
        ArrayList<Staff> people = new ArrayList<>();
        try {
            id = db.getPosTypeId(type);

            for (int i = 0; i < num; i++) {
                people.add(new Staff(id,startDate));
            }
            people = (ArrayList<Staff>)db.insertPeople(people);
            System.out.println("Date : " + startDate.toString());

           people = db.insertStaff(people);
           db.insertPositions(people);
        }
        catch (SQLException e ) {
            System.out.println(e.getMessage());
        }
    }

    private void insertStates() {
        ArrayList<String> states = new ArrayList<>(Arrays.asList("ожидает", "доставлен", "доставляется", "зажержан"));
        try {
            db.insertStates(states);
        }
        catch (SQLException e ) {
            System.out.println(e.getMessage());
        }
    }

    private void lifeCycle() {
        Integer days = settings.getDays();
        LocalDateTime date = startDate.minusDays(days).withHour(0).withMinute(0).withSecond(0).withNano(0);
        Integer currentDay = 1;
        ArrayList<Product> products = null;
        ArrayList<Staff> brokers = null;
        ArrayList<Staff> menegers = null;
        Random rand = new Random();

        try {
            products = db.getProducts();
            brokers = db.getStaff("брокер");
            menegers = db.getStaff("менеджер");
        }
        catch (SQLException e ) {
            System.out.println(e.getMessage());
        }

        while (currentDay <= days) {

            System.out.println("*** DAY " + currentDay.toString() + " ***");

            /*
                Add companies
            */
            ArrayList<Company> companies = new ArrayList<>();
            for (int i = 0; i < settings.getCompanies(); i++) {
                companies.add(new Company());
            }
            try {
                db.InsertCompanies(companies);
            }
            catch (SQLException e ) {
                System.out.println(e.getMessage());
            }

            /*
                Add product items every week
            */

            if (currentDay % 7 == 0.0 || currentDay == 1) {
                ArrayList<Company> comp_buf = null;
                ArrayList<Product_item> product_items = new ArrayList<>();

                try {
                    comp_buf = db.getCompanies();
                    comp_buf = Tools.generateRandomArray(comp_buf, 0.3);
                }
                catch (SQLException e ) {
                    System.out.println(e.getMessage());
                }

                for(Company buf: comp_buf) {
                    ArrayList<Product> randProducts = Tools.generateRandomArray(products, 0.05);
                    for(Product buf_2: randProducts) {
                        product_items.add(new Product_item(buf.tin,buf_2.productId,date.plusDays(days)));
                    }
                }

                try {
                    db.insertProduct_items(product_items);
                }
                catch (SQLException e ) {
                    System.out.println(e.getMessage());
                }
            }

            /*
                Add customers
            */

            ArrayList<Customer> customers = new ArrayList<>();
            for (int i = 0; i < settings.getCustomers(); i++) {
                customers.add(new Customer());
            }

            try {
                customers = (ArrayList<Customer>)db.insertPeople(customers);
                db.insertCustomers(customers);

                customers = db.getCustomers();
                customers = Tools.generateRandomArray(customers, 0.1);

                ArrayList<Contract> contracts = new ArrayList<>();

                for(Customer buf: customers) {
                    Integer index = rand.nextInt(brokers.size());
                    Staff item = brokers.get(index);
                    contracts.add(new Contract(buf.customer_id,item.staffId,date));
                }
                db.insertContacts(contracts);

            }
            catch (SQLException e ) {
                System.out.println(e.getMessage());
            }

            /*
                Add batches
            */

            ArrayList<Staff> menegersRand = Tools.generateRandomArray(menegers, 0.5);
            try {
                for(Staff buf: menegersRand) {
                    ArrayList<Auction> auctions = new ArrayList<>();
                    ArrayList<Product_item> items = db.getProductItems();

                    Integer index = rand.nextInt(items.size());
                    Product_item item = items.get(index);

                    Batch batch = new Batch(buf.staffId, item.type.longValue(), date);
                    Long batchId = db.insertBatch(batch);
                    auctions.add(new Auction(batchId, date));

                    int num = rand.nextInt(settings.getBatchSize()) +1;
                    ArrayList<Batch_item> newItems = selectProdItems(items, batchId, num,item.type);
                    db.insertBatch_items(newItems);

                    /*
                        Add auctions
                    */
                    db.insertAuctions(auctions);
                }

            }
            catch (SQLException e ) {
                System.out.println(e.getMessage());
            }

            try {
                LocalDateTime dayTime = startDate.withHour(8).withMinute(0).withSecond(0).withNano(0);
                int windows = 20; // one window every 30 minutes
                for(int i=0; i<=windows; i++) {
                    ArrayList<Contract> contracts = db.getContracts(dayTime);
                    contracts = Tools.generateRandomArray(contracts, 0.2);

                    //System.out.println("Nice");
                    for(Contract buf: contracts) {

                        ArrayList<Auction> auctions = Tools.generateRandomArray(db.getAuctions(dayTime),0.2);
                        for(Auction buf2: auctions) {
                            Double sum = db.getBetsSum(buf.contractId, buf2.auctionId);
                            Double diff = buf.limit - sum;

                            if (diff > 10.0) {
                                Double bet = 1 + (diff - 1) * rand.nextDouble();
                                db.insertBet(new Bet(buf2.auctionId, buf.contractId, bet, dayTime));
                            }
                        }

                    }
                    dayTime = dayTime.plusMinutes(30);
                }
            }
            catch (SQLException e ) {
                System.out.println(e.getMessage());
            }

            currentDay ++;
            date = date.plusDays(1);

        }

    }

    private ArrayList<Batch_item> selectProdItems(ArrayList<Product_item> items, Long batchId, Integer num, Integer type) {
        int i = 0;
        ArrayList<Batch_item> res = new ArrayList<>();
        Random rand = new Random();

        for(Product_item buf: items) {
            if (buf.type == type ) {
                Double diff = buf.quantity - buf.sum;
                Double quantity;
                if (diff < 50)
                    quantity = diff;
                else
                    quantity = 1 + (diff - 1) * rand.nextDouble();
                res.add(new Batch_item(batchId,buf.itemId,quantity));
                i ++;
                if(i >= num)
                    break;
            }
        }
        return res;
    }
}
