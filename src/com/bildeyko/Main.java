package com.bildeyko;

public class Main {
    private static Generator gen;
    public static void main(String[] args) {
        if(args.length > 0) {
            switch (args[0]) {
                case "static":
                    gen = new Generator();
                    gen.staticData();
                    gen.statistic();
                    break;
                case "dynamic":
                    gen = new Generator();
                    gen.dynamicData();
                    gen.statistic();
                    break;
                case "all":
                    gen = new Generator();
                    gen.staticData();
                    gen.dynamicData();
                    gen.statistic();
                    break;
                case "full":
                    gen = new Generator();
                    gen.clearTables();
                    gen.staticData();
                    gen.dynamicData();
                    gen.statistic();
                    break;
                case "clear":
                    gen = new Generator();
                    gen.clearTables();
                    break;
                default:
                    usage();
            }
        } else
            usage();
    }
    private static void usage() {
        System.out.println("usage: java -jar db_gen.jar [ all | static | dynamic | clear | full | help ]");
    }
}
