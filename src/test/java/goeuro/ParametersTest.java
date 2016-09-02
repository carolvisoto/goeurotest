package goeuro;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParametersTest {
    private final Parameters parameters = new Parameters();

    @Test
    public void shouldParseAtLeastOneArgument() throws Exception {
        assertEquals("Berlin", parameters.parseArguments(new String[]{"Berlin"}));
    }

    @Test(expected = RuntimeException.class)
    public void throwsExceptionWhenAnEmptyArgumentIsPassedBy() throws Exception {
        parameters.parseArguments(new String[]{});
    }

    @Test(expected = RuntimeException.class)
    public void throwsExceptionWhenTwoArgumentsArePassedBy() throws Exception {
        parameters.parseArguments(new String[]{"arg1", "arg2"});
    }

    @Test(expected = RuntimeException.class)
    public void throwsExceptionWhenSpecialCharactersArePassedBy() throws Exception {
        parameters.parseArguments(new String[]{"@#$%^&*"});
    }

    @Test(expected = RuntimeException.class)
    public void throwsExceptionWhenContainsNumbers() throws Exception {
        parameters.parseArguments(new String[]{"Berlin123"});
    }

    @Test(expected = RuntimeException.class)
    public void throwsExceptionWhenContainSpace() throws Exception {
        parameters.parseArguments(new String[]{"Berlin and Paris"});
    }
}