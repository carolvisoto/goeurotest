package goeuro;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.File;;
import static org.junit.Assert.*;
import java.nio.charset.StandardCharsets;

public class CSVWriterTest {

    CSVWriter csvWriter = new CSVWriter();

    @Test
    public void fileShouldBeValid() throws IOException {
        List<Location> listLocation = new ArrayList<Location>();
        File  file = null;
        Location location1 = new Location(398388,"Opole","location", new GeoPosition("50.66667", "17.95"));
        Location location2 = new Location(375819,"Opava","location", new GeoPosition("49.93866", "17.90257"));
        Location location3 = new Location(420065,"Opladen","location", new GeoPosition("51.062102399747886", "7.001895904541016"));

        listLocation.add(location1);
        listLocation.add(location2);
        listLocation.add(location3);

        file = csvWriter.writeData(listLocation);

        List<String> lines = Files.readAllLines(Paths.get(file.getPath()), StandardCharsets.UTF_8);
        if (!lines.isEmpty()){
            assertEquals(lines.get(0), "398388,Opole,location,50.66667,17.95");
            assertEquals(lines.get(1), "375819,Opava,location,49.93866,17.90257");
            assertEquals(lines.get(2), "420065,Opladen,location,51.062102399747886,7.001895904541016");
        }
    }

}
