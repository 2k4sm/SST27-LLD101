package com.example.imports;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class CsvProfileImporter implements ProfileImporter {
    private final NaiveCsvReader csvReader;
    private final ProfileService profileService;

    public CsvProfileImporter(NaiveCsvReader csvReader, ProfileService profileService) {
        this.csvReader = Objects.requireNonNull(csvReader, "csvReader cannot be null");
        this.profileService = Objects.requireNonNull(profileService, "profileService cannot be null");
    }

    @Override
    public int importFrom(Path csvFile) {
        Objects.requireNonNull(csvFile, "csvFile cannot be null");

        List<String[]> rows = csvReader.read(csvFile);
        int successfulImports = 0;

        for (String[] row : rows) {
            try {
                if (row.length < 3) {
                    System.out.println("Skipping invalid row: insufficient columns");
                    continue;
                }

                String id = row[0];
                String email = row[1];
                String displayName = row[2];

                if (id == null || id.trim().isEmpty()) {
                    System.out.println("Skipping row: missing id");
                    continue;
                }

                if (email == null || email.trim().isEmpty()) {
                    System.out.println("Skipping row: missing email");
                    continue;
                }

                profileService.createProfile(id, email, displayName);
                successfulImports++;
            } catch (IllegalArgumentException e) {
                System.out.println("Skipping row: " + e.getMessage());
            }
        }

        return successfulImports;
    }
}
