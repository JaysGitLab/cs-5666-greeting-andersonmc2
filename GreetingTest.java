import static org.junit.Assert.assertEquals;
import org.junit.*;
import java.io.*;
import org.apache.commons.cli.*;

public class GreetingTest{
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();    
    PrintStream oldSystOut = System.out;
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    
    @After
    public void cleanUpStreams() {
        System.setOut(oldSystOut);
    }

    @Test
    public void noInputTest() throws ParseException{
        Greeting.main(new String[0]);
        assertEquals("Hello, Mikeal!\n", outContent.toString());
    }

    @Test
    public void evaluateOutput1() throws ParseException {
        String[] name = new String[] {"Bobby"};
        Greeting.main(name);
        assertEquals("Hello, Bobby\n", outContent.toString());
    }

   @Test
    public void evaluateOutput1lower() throws ParseException {
        String[] name = new String[] {"bobby"};
        Greeting.main(name);
        assertEquals("Hello, Bobby\n", outContent.toString());
    }
 

    @Test
    public void evaluateOutput2() throws ParseException{
        Greeting.main(new String[] {"-me", "Hal", "Bowman"});
        assertEquals("Hello, Bowman\n", outContent.toString());
    }

   @Test
    public void evaluateOutput3() throws ParseException{
        Greeting.main(new String[] {"-me", "Hal"});
        assertEquals("Hello, Mikeal!\n", outContent.toString());
    }
} 
