package com.example.report;

import java.nio.file.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        Map<String, Object> data = Map.of("name", "Quarterly");

        // Create the facade with all necessary components
        ReportBundleFacade facade = new ReportBundleFacade(
                new JsonWriter(),
                new Zipper(),
                new AuditLog());

        // Use the facade to handle the entire export process
        Path zip = facade.export(data, Path.of("out"), "report");

        System.out.println("DONE " + zip);
    }
}
