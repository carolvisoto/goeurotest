package goeuro;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CSVWriter {
    File file = new File("fromJSONToCSV.csv");

    private static CsvMapper mapper;
    private static CsvSchema schema;
    private static ObjectWriter objectWriter;

    public CSVWriter() {
        this.mapper = new CsvMapper();
        this.schema = mapper.schemaFor(City.class);
        this.objectWriter = mapper.writer(schema);
    }

    public File citiesWrittenOnCsv(List<City> listCity) throws IOException {
        if (!listCity.isEmpty()) {
            writeInCsv(listCity);
        }
        return file;

    }

    private void writeInCsv(List<City> cities) throws IOException {
        objectWriter.writeValue(file, cities);
    }
}
