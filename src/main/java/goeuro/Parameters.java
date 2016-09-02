package goeuro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parameters {
    private final Pattern pattern;

    public Parameters() {
        this.pattern = Pattern.compile("^[a-zA-Z]*$");
    }

    public String parseArguments(String[] args) throws Exception {
        if (args.length == 1) {
            Matcher matcher = pattern.matcher(args[0]);
            if (!matcher.matches()) {
                throw new RuntimeException("The argument passed is invalid: " + args[0]);
            } else {
                return args[0];
            }
        } else {
            throw new RuntimeException("Only one parameter is accepted!");
        }
    }

}
