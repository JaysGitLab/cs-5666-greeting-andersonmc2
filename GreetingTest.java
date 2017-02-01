import static org.junit.Assert.assertEquals;
import org.junit.*;
import java.io.*;

public class GreetingTest{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();    
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
    public void evaluateOutput() {
        Greeting.main(new String[0]);
        assertEquals("Hello, World!\n", outContent.toString());
    }
} 
