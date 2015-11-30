package com.bildeyko;

import com.bildeyko.objects.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

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

        Company c1 = new Company();
        ArrayList<Company> c2 = new ArrayList<>(settings.getCompanies());
        for (int i = 0; i < settings.getCompanies(); i++) {
            c2.add(new Company());
        }

        try {
            db.InsertCompanies(c2);
        }
        catch (SQLException e ) {
            System.out.println(e.getMessage());
        }


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

        /*InsertUnits();
        InsertProductTypes();
        InsertProducts();
        InsertPositionTypes();*/

        InsertStaff_by_type("менеджер", 10);
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
}
