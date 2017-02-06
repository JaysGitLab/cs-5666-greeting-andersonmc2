import static org.junit.Assert.assertEquals;
import org.junit.*;
import java.io.*;

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
    public void evaluateOutput() throws IOException {
        String[] name = new String[] {"bobby"};
        Greeting.main(name);
       // assertEquals("Hello, Bobby\n", outContent.toString());
        Greeting.main(new String[0]);
        assertEquals("Hello, Bobby\nHello, Mikeal!\n", outContent.toString());


    }
} 
