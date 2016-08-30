package goeuro;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parameters {

	public static void main(String[] args) {
        Parameters parameters = new Parameters();
        int numberOfArguments = args.length;
        HTTPConnection httpConnection = new HTTPConnection();

        if (numberOfArguments == 0) {
            System.out.println("There was no commandline arguments passed!");
        } else if (numberOfArguments == 1) {
           try{
               Pattern p = Pattern.compile("^[a-zA-Z0-9]*$");
               Matcher m = p.matcher(args[0]);
               if (m.matches()){
                   String jsonStringGetFromHttpGet = httpConnection.returnedJSOnStringByHttpGet(parameters.parseArguments(args));
                   recordJsonInCsv(jsonStringGetFromHttpGet);
               }else{
                   System.out.println("This commandline is invalid!");
                   System.exit(0);
               }
           }catch (IOException e){
               e.printStackTrace();
           }catch (URISyntaxException e){
               e.printStackTrace();
           }
        }
    }

    public String parseArguments(String[] args) {
       String parsedArgument = "";
       if (!args[0].equalsIgnoreCase("")){
           parsedArgument = args[0];
       }else{
           System.out.println("The argument is empty!");
           System.exit(0);
       }
        return parsedArgument;
    }

    private static void recordJsonInCsv(String httpGetReturn){
        LoadJSONFile loadJSONFile = new LoadJSONFile();
        CSVWriter csvWriter = new CSVWriter();
        try {
            List<Location> listLocation = loadJSONFile.jsonFile(httpGetReturn);
            if(listLocation != null){
                File csvFile = csvWriter.writeData(listLocation);
                if (csvFile.exists()) {
                    System.out.println("The CVS file was recorded with success in: " + csvFile.getAbsolutePath());
                }
            }else {
                System.out.println("The JSON Object returned null!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
