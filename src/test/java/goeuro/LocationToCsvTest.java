package goeuro;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LocationToCsvTest {

    @Test
    public void shouldWriteToCsv() throws JsonProcessingException {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(Location.class);

        Location location = new Location(1, "nome", "tipo", new GeoPosition("2", "3"));
        ObjectWriter writer = mapper.writer(schema);

        assertEquals("1,nome,tipo,2,3", writer.writeValueAsString(Arrays.asList(location)).trim());
    }
}
