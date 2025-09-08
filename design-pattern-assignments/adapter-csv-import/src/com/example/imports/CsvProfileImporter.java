package com.example.imports;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class CsvProfileImporter implements ProfileImporter {
    private final NaiveCsvReader csvReader;
    private final ProfileService profileService;

    public CsvProfileImporter(NaiveCsvReader csvReader, ProfileService profileService) {
        this.csvReader = Objects.requireNonNull(csvReader, "csvReader");
        this.profileService = Objects.requireNonNull(profileService, "profileService");
    }

    @Override
    public int importFrom(Path csvFile) {
        List<String[]> rows = csvReader.read(csvFile);
        int success = 0;
        for (int i = 0; i < rows.size(); i++) {
            String[] row = rows.get(i);
            if (i == 0 && isHeader(row)) continue;
            if (row.length < 3) {
                System.err.println("skipping row " + (i + 1) + ": insufficient columns");
                continue;
            }
            String id = row[0].trim();
            String email = row[1].trim();
            String displayName = row[2].trim();
            if (id.isEmpty()) {
                System.err.println("skipping row " + (i + 1) + ": missing id");
                continue;
            }
            if (email.isEmpty()) {
                System.err.println("skipping row " + (i + 1) + ": missing email");
                continue;
            }
            try {
                profileService.createProfile(id, email, displayName);
                success++;
            } catch (IllegalArgumentException ex) {
                System.err.println("skipping row " + (i + 1) + ": " + ex.getMessage());
            }
        }
        return success;
    }

    private boolean isHeader(String[] row) {
        return row.length >= 3
                && row[0].toLowerCase().contains("id")
                && row[1].toLowerCase().contains("email");
    }
}


