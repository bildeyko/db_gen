package com.bildeyko;

public class Main {
    private static Settings settings;
    public static void main(String[] args) {
	    settings = new Settings("settings.xml");
        settings.load();
    }
}
