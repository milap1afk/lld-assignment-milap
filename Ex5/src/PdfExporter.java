import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter {

    @Override
    protected ExportResult doExport(ExportRequest req) {

        // IMPORTANT:
        // We must NOT tighten preconditions anymore.
        // So we remove the 20-char restriction.

        String body = req.body == null ? "" : req.body;
        String title = req.title == null ? "" : req.title;

        String fakePdf = "PDF(" + title + "):" + body;

        return new ExportResult(
                "application/pdf",
                fakePdf.getBytes(StandardCharsets.UTF_8)
        );
    }
}