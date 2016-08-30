package goeuro;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ParametersTest {
    Parameters parameters;
    @Before
    public void setUp (){
        parameters = new Parameters();
    }
    @Test
    public void shouldParseAtLeastOneArgument(){
        String [] listArguments  = {"arg1"};
        assertEquals("arg1",  parameters.parseArguments(listArguments) );
    }

}