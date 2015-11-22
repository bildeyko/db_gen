package com.bildeyko;

import java.sql.SQLException;
import java.time.LocalDateTime;

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
        System.out.println("Date : " + startDate.toString());
    }
}
