package goeuro;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.List;

public class GenerateCities {
    private static ObjectMapper mapper;

    public GenerateCities() {
        this.mapper = new ObjectMapper();
    }

    public List<City> getCities(String jsonResponse) throws IOException {
        TypeFactory typeFactory = mapper.getTypeFactory();
        return mapper.readValue(jsonResponse, typeFactory.constructCollectionType(List.class, City.class));

    }
}
