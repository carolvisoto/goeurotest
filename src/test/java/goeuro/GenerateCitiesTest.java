package goeuro;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class GenerateCitiesTest {

    private GenerateCities generateCities = new GenerateCities();

    @Test
    public void shouldReturnListOfLocationsFromJson() throws IOException {
        String json = "[{\"_id\":398388,\"key\":null,\"name\":\"Opole\",\"fullName\":\"Opole, Poland\"," +
                "\"iata_airport_code\":null,\"type\":\"location\",\"country\":\"Poland\"," +
                "\"geo_position\":{\"latitude\":50.66667,\"longitude\":17.95}}]";

        assertEquals(generateCities.getCities(json), Collections.singletonList(new City(398388, "Opole", "location", new GeoPosition("50.66667", "17.95"))));
    }

    @Test
    public void expectedExceptionWhenStringJsonIsInvalid() {
        try {
            String invalidJson = "[{\"_id\":398388%^&*(,\"key\":null,\"name\":\"Opole\",\"fullName\":\"Opole, Poland\"," +
                    "\"iata_airport_code\":null,\"type\":\"location\",\"country\":\"Poland\"," +
                    "\"geo_position\":{\"latitude\":50.66667,\"longitude\":17.95}}]";
            generateCities.getCities(invalidJson);
            fail("String JSON has invalid characters");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void returnsEmptyArrayWhenJsonHasNoCities() throws IOException {
        String json = "[]";
        assertEquals(generateCities.getCities(json), new ArrayList<City>());
    }

}
