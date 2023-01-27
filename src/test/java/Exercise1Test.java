import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class Exercise1Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    final String test15 = "1\n" +
            "2\n" +
            "Visual\n" +
            "4\n" +
            "Nuts\n" +
            "Visual\n" +
            "7\n" +
            "8\n" +
            "Visual\n" +
            "Nuts\n" +
            "11\n" +
            "Visual\n" +
            "13\n" +
            "14\n" +
            "Visual Nuts";

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStream() {
        System.setOut(originalOut);
    }

    @Test
    public void testPrint15() {
        try {
            Exercise1.printVisualNuts(15);
            assertEquals(test15, outContent.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Rule
    public final ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testPrintNegative() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("The parameter must be greater then 0 (zero)!");
        Exercise1.printVisualNuts(-15);
    }
}