package goeuro;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadJSONFile {

    public List<Location> jsonFile(String httpGetReturn) throws IOException {

        List<Location> listLocation = new ArrayList<Location>();
        ObjectMapper mapper = new ObjectMapper();
        TypeFactory typeFactory = mapper.getTypeFactory();
        List<Location> locations = mapper.readValue(httpGetReturn, typeFactory.constructCollectionType(List.class, Location.class));
        return locations;

    }


}
