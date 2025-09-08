package com.example.imports;

import java.nio.file.Path;

public class App {
	public static void main(String[] args) {
		// require a csv path
		if (args.length == 0) throw new IllegalArgumentException("path required");
		Path csv = Path.of(args[0]);
		// build adapter with its dependencies
		ProfileImporter importer = new CsvProfileImporter(new NaiveCsvReader(), new ProfileService());
		// import and print summary
		int n = importer.importFrom(csv);
		System.out.println("Imported " + n + " profiles");
	}
}
