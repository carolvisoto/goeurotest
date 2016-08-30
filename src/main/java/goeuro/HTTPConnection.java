package goeuro;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.io.BufferedReader;


public class HTTPConnection {
    public static final String QUERY = "http://api.goeuro.com/api/v2/position/suggest/en/";

    public String returnedJSOnStringByHttpGet(String parameter) throws IOException, URISyntaxException {
        String inputLine =      null;
        StringBuffer response = new StringBuffer();
        BufferedReader br =     null;
        try {
            URI uri = new URI(QUERY + parameter);
            URL url = uri.toURL();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while ((inputLine = br.readLine()) != null){
                response.append(inputLine);
            }
        }finally {
            try {
                br.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        return response.toString();
    }


}
