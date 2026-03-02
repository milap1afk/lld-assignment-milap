import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {

    @Override
    protected ExportResult doExport(ExportRequest req) {

        String title = req.title == null ? "" : req.title;
        String body = req.body == null ? "" : req.body;

        // Preserve meaning properly by quoting
        String csv = "title,body\n"
                + quote(title) + ","
                + quote(body) + "\n";

        return new ExportResult(
                "text/csv",
                csv.getBytes(StandardCharsets.UTF_8)
        );
    }

    private String quote(String s) {
        return "\"" + s.replace("\"", "\"\"") + "\"";
    }
}