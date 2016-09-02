package goeuro;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CSVWriterTest {

    CSVWriter csvWriter = new CSVWriter();

    @Test
    public void fileShouldBeValid() throws IOException {
        List<City> listCities = new ArrayList<City>();
        File file;
        City location1 = new City(398388, "Opole", "location", new GeoPosition("50.66667", "17.95"));
        City location2 = new City(375819, "Opava", "location", new GeoPosition("49.93866", "17.90257"));
        City location3 = new City(420065, "Opladen", "location", new GeoPosition("51.062102399747886", "7.001895904541016"));

        listCities.add(location1);
        listCities.add(location2);
        listCities.add(location3);

        file = csvWriter.citiesWrittenOnCsv(listCities);

        List<String> lines = Files.readAllLines(Paths.get(file.getPath()), StandardCharsets.UTF_8);
        if (!lines.isEmpty()) {
            assertEquals(lines.get(0), "398388,Opole,location,50.66667,17.95");
            assertEquals(lines.get(1), "375819,Opava,location,49.93866,17.90257");
            assertEquals(lines.get(2), "420065,Opladen,location,51.062102399747886,7.001895904541016");
        }
    }

}
