package goeuro;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;


public class LoadJSONFileTest {

    LoadJSONFile loadJSONfile = new LoadJSONFile();

    @Test
    public void shouldReturnListOfLocationsfromJson() throws IOException {
        String json = "[{\"_id\":398388,\"key\":null,\"name\":\"Opole\",\"fullName\":\"Opole, Poland\"," +
                "\"iata_airport_code\":null,\"type\":\"location\",\"country\":\"Poland\"," +
                "\"geo_position\":{\"latitude\":50.66667,\"longitude\":17.95}}]";

        assertEquals(loadJSONfile.jsonFile(json), Arrays.asList(new Location(398388, "Opole", "location", new GeoPosition("50.66667", "17.95"))));
    }

    @Test
    public void expectedExceptionWhenStringJsonIsInvalid()  {
        try {
            String invalidJson = "[{\"_id\":398388%^&*(,\"key\":null,\"name\":\"Opole\",\"fullName\":\"Opole, Poland\"," +
                    "\"iata_airport_code\":null,\"type\":\"location\",\"country\":\"Poland\"," +
                    "\"geo_position\":{\"latitude\":50.66667,\"longitude\":17.95}}]";
            loadJSONfile.jsonFile(invalidJson);
            fail("Should have thrown an IllegalArgumentException because age is invalid!");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
