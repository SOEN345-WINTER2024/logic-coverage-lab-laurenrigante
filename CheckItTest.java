import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CheckItTest {


    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        outContent.reset();
    }

    // ------------------------------PREDICATE COVERAGE------------------------------------------
    @Test
    public void testPredicateTrue() {
        CheckIt.checkIt(true, true, true);
        assertEquals("P is true", outContent.toString());
    }

    @Test
    public void testPredicateFalse() {
        CheckIt.checkIt(false, false, false);
        assertEquals("P isn't true", outContent.toString());
    }

    // ----------------------------------CLAUSE COVERAGE---------------------------------------------------
    @Test
    public void testClauseTrue() {
        CheckIt.checkIt(true, true, true);
        assertEquals("P is true", outContent.toString());
    }

    @Test
    public void testClauseFalse() {
        CheckIt.checkIt(false, false, false);
        assertEquals("P isn't true", outContent.toString());
    }


    //------------------------------CACC COVERAGE---------------------------------------------------

    @Test
    public void testCorrelatedActiveClauseTrue() {
        CheckIt.checkIt(true, true, false);
        assertEquals("P is true", outContent.toString());
    }

    @Test
    public void testCorrelatedActiveClauseFalse() {
        CheckIt.checkIt(false, true, false);
        assertEquals("P isn't true", outContent.toString());
    }
    //------------------------------RACC COVERAGE---------------------------------------------------

    @Test
    public void testRACCCoverageTrue() {
        CheckIt.checkIt(true, false, true);
        assertEquals("P is true", outContent.toString());
    }
    @Test
    public void testRACCCoverageFalse() {
        CheckIt.checkIt(false, false, true);
        assertEquals("P isn't true", outContent.toString());
    }

}
