package com.bildeyko;

import org.w3c.dom.Document;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by Nick Bildeyko on 21.11.2015.
 */
public class Settings {
    private String fileName;

    public Integer getCompanies() {
        return companies;
    }

    private Integer companies;

    private Integer days;
    private Integer products;

    public Integer getCustomers() {
        return customers;
    }

    private Integer customers;

    public Integer getBatchSize() {
        return batchSize;
    }

    private Integer batchSize;

    public DB_settings getDatabase() {
        return database;
    }

    private DB_settings database;

    public Settings(String fileName) {
        this.fileName = fileName;
        database = new DB_settings();
    }

    public void load() {
        try {
            File xmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            Element rootElement = doc.getDocumentElement();

            this.companies = Integer.parseInt(getString("companies_per_day",rootElement));
            this.days = Integer.parseInt(getString("days",rootElement));
            this.products = Integer.parseInt(getString("products_at_time",rootElement));
            this.customers = Integer.parseInt(getString("customers_per_day",rootElement));
            this.batchSize = Integer.parseInt(getString("max_batch_size",rootElement));

            database.host = getString("host",rootElement);
            database.port = Integer.parseInt(getString("port", rootElement));
            database.serviceName = getString("service_name",rootElement);
            database.user = getString("user",rootElement);
            database.password = getString("password",rootElement);

           // System.out.println("Ok : ");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer getDays() {
        return days;
    }

    private String getString(String tagName, Element element) {
        NodeList list = element.getElementsByTagName(tagName);
        if (list != null && list.getLength() > 0) {
            NodeList subList = list.item(0).getChildNodes();

            if (subList != null && subList.getLength() > 0) {
                return subList.item(0).getNodeValue();
            }
        }

        return null;
    }

    public class DB_settings {
        public String host;
        public Integer port;
        public String serviceName;
        public String user;
        public String password;
    }
}
