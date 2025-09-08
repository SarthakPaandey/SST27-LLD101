package com.example.imports;
import java.nio.file.Path;
// abstraction for importing profiles from a source
public interface ProfileImporter {
    int importFrom(Path csvFile);
}
