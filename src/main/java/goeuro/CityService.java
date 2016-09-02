package goeuro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


public class CityService {
    private static final String BASE_URL = "http://api.goeuro.com/api/v2/position/suggest/en/";

    public String fetchCitiesBy(String city) throws IOException, URISyntaxException {
        String inputLine;
        StringBuilder response = new StringBuilder();
        BufferedReader br = null;
        try {
            URL url = new URI(BASE_URL + city).toURL();
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response.toString();
    }
}
