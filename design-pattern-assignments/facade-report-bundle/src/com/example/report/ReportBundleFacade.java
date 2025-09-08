package com.example.report;

import java.io.UncheckedIOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;

public class ReportBundleFacade {
    private final JsonWriter jsonWriter;
    private final Zipper zipper;
    private final AuditLog auditLog;

    public ReportBundleFacade(JsonWriter jsonWriter, Zipper zipper, AuditLog auditLog) {
        this.jsonWriter = Objects.requireNonNull(jsonWriter, "jsonWriter");
        this.zipper = Objects.requireNonNull(zipper, "zipper");
        this.auditLog = Objects.requireNonNull(auditLog, "auditLog");
    }

    public Path export(Map<String,Object> data, Path outDir, String baseName) throws UncheckedIOException {
        Objects.requireNonNull(data, "data");
        Objects.requireNonNull(outDir, "outDir");
        Objects.requireNonNull(baseName, "baseName");
        Path json = jsonWriter.write(data, outDir, baseName);
        Path zip = zipper.zip(json, outDir.resolve(baseName + ".zip"));
        auditLog.log("exported " + zip);
        return zip;
    }
}


