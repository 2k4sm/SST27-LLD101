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
        this.jsonWriter = Objects.requireNonNull(jsonWriter, "jsonWriter cannot be null");
        this.zipper = Objects.requireNonNull(zipper, "zipper cannot be null");
        this.auditLog = Objects.requireNonNull(auditLog, "auditLog cannot be null");
    }

    public Path export(Map<String, Object> data, Path outDir, String baseName) {
        Objects.requireNonNull(data, "data cannot be null");
        Objects.requireNonNull(outDir, "outDir cannot be null");
        Objects.requireNonNull(baseName, "baseName cannot be null");

        try {
            Path jsonPath = jsonWriter.write(data, outDir, baseName);
            Path z     pPath = zipper.zip(jsonPath, outDir.resolve(baseName + ".zip"));
            auditLog   log("exported " + zipPath);

            return zipPath;
        } catch (UncheckedIOException e) {
            throw e;
        }
    }
}
