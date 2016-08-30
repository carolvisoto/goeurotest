package goeuro;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CSVWriter {
    File file = new File("fromJSONToCSV.csv");

    public File writeData(List<Location> listLocation) throws IOException {
        if (!listLocation.isEmpty()) {
            writeInCsv(listLocation);
        }
        return file;
    }

    private void writeInCsv(List<Location> locations) throws IOException {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(Location.class);
        ObjectWriter objectWriter = mapper.writer(schema);
        objectWriter.writeValue(this.file, locations);
    }
}
