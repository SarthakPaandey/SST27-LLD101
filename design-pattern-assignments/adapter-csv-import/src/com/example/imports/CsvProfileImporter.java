package com.example.imports;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

// adapter that converts raw csv rows into validated profile creations
public class CsvProfileImporter implements ProfileImporter {
    // dependencies used by the adapter
    private final NaiveCsvReader csvReader;
    private final ProfileService profileService;

    // ensure dependencies are present
    public CsvProfileImporter(NaiveCsvReader csvReader, ProfileService profileService) {
        this.csvReader = Objects.requireNonNull(csvReader, "csvReader");
        this.profileService = Objects.requireNonNull(profileService, "profileService");
    }

    @Override
    public int importFrom(Path csvFile) {
        // read all rows from csv
        List<String[]> rows = csvReader.read(csvFile);
        int success = 0;
        // iterate through rows and create profiles when valid
        for (int i = 0; i < rows.size(); i++) {
            String[] row = rows.get(i);
            // skip header row when detected
            if (i == 0 && isHeader(row)) continue;
            // require at least 3 columns: id,email,displayName
            if (row.length < 3) {
                System.err.println("skipping row " + (i + 1) + ": insufficient columns");
                continue;
            }
            String id = row[0].trim();
            String email = row[1].trim();
            String displayName = row[2].trim();
            // validate required fields
            if (id.isEmpty()) {
                System.err.println("skipping row " + (i + 1) + ": missing id");
                continue;
            }
            if (email.isEmpty()) {
                System.err.println("skipping row " + (i + 1) + ": missing email");
                continue;
            }
            try {
                // delegate validation of email format to domain service
                profileService.createProfile(id, email, displayName);
                success++;
            } catch (IllegalArgumentException ex) {
                System.err.println("skipping row " + (i + 1) + ": " + ex.getMessage());
            }
        }
        return success;
    }

    // heuristic to detect a header line
    private boolean isHeader(String[] row) {
        return row.length >= 3
                && row[0].toLowerCase().contains("id")
                && row[1].toLowerCase().contains("email");
    }
}


