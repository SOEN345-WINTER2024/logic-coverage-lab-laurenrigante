import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CheckItTest {

    // ------------------------------PREDICATE COVERAGE------------------------------------------
    @Test
    public void testPredicateTrue() {
        assertTrue(checkItPredicate(true, true, true));
    }

    @Test
    public void testPredicateFalse() {
        assertFalse(checkItPredicate(false, false, false));
    }

    // ----------------------------------CLAUSE COVERAGE---------------------------------------------------
    @Test
    public void testClauseTrue() {
        assertTrue(checkItClause(true, true, true));
    }

    @Test
    public void testClauseFalse() {
        assertFalse(checkItClause(false, false, false));
    }

    //------------------------------CACC COVERAGE---------------------------------------------------

    @Test
    public void testCorrelatedActiveClause1() {
        assertTrue(checkItClause(true, true, false));
    }

    @Test
    public void testCorrelatedActiveClause2() {
        assertFalse(checkItClause(false, true, true));
    }

    //------------------------------CACC COVERAGE---------------------------------------------------

    @Test
    public void testRACCCoverage1() {
        assertTrue(checkItClause(true, false, true));
    }

    @Test
    public void testRACCCoverage2() {
        assertFalse(checkItClause(false, false, true));
    }



    // Helper method to test the predicate condition
    private boolean checkItPredicate(boolean a, boolean b, boolean c) {
      
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        CheckIt.checkIt(a, b, c);

        String printedOutput = outContent.toString();
        System.setOut(System.out);

        if (a || (b && c)) {
            return printedOutput.trim().equals("P is true");
        } else {
            return printedOutput.trim().equals("P isn't true");
        }
    }

}
