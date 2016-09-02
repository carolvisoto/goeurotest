package goeuro;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Parameters parameters = new Parameters();
        CityService cityService = new CityService();

        try {
            String cityName = parameters.parseArguments(args);
            String jsonString = cityService.fetchCitiesBy(cityName);
            GenerateCities generateCities = new GenerateCities();
            CSVWriter csvWriter = new CSVWriter();
            List<City> listLocation = generateCities.getCities(jsonString);
            if (!listLocation.isEmpty()) {
                File csvFile = csvWriter.citiesWrittenOnCsv(listLocation);
                System.out.println("The CSV file was recorded with success in: " + csvFile.getAbsolutePath());
            } else {
                System.out.println("The list of cities is empty!");
            }
        } catch (Exception e) {
            System.err.println("An error has occurred: " + e.getMessage());
            System.exit(1);
        }
    }

}
