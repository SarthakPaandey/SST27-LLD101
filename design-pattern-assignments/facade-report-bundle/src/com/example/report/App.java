package com.example.report;
import java.nio.file.*; import java.util.*;

// app uses the facade for a single export call
public class App {
    public static void main(String[] args) {
        Map<String,Object> data = Map.of("name", "Quarterly");
        // create facade with subsystems
        ReportBundleFacade facade = new ReportBundleFacade(new JsonWriter(), new Zipper(), new AuditLog());
        // perform export and print path
        Path zip = facade.export(data, Path.of("out"), "report");
        System.out.println("DONE " + zip);
    }
}
