import student.TestCase;

// -------------------------------------------------------------------------

/**
 * Test class for PredictionResults.
 *
 * @author Robert Laing (rlaing4308)
 * @author Andrew Park (andrewp04)
 * @author Joshua Essandoh
 * @version Sep 21, 2026
 */
public class PredictionResultsTest extends student.TestCase
{
    private Team winner;

    // ----------------------------------------------------------
    /**
     * Sets up the fixture.
     */
    public void setUp()
    {
        winner = new Team("Hokies", 10, 2, 0, 85.0, 75.0);
    }

    // ----------------------------------------------------------
    /**
     * Testing getter methods.
     */
    public void testGetters()
    {
        PredictionResults result = new PredictionResults(winner, 65.5);
        assertEquals(winner, result.getWinner());
        assertEquals(65.5, result.getConfidence(), 0.001);
    }

    // ----------------------------------------------------------
    /**
     * Tests constructor exceptions for bad input (null winner, out of range confidence).
     */
    public void testConstructorExceptions()
    {
        try
        {
            new PredictionResults(null, 75.0);
            fail("Expected exception when winner is null");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Winner cannot be null.", e.getMessage());
        }

        try
        {
            new PredictionResults(winner, 49.9);
            fail("Expected exception when confidence is below 50.0");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Confidence must be between 50 and 100.", e.getMessage());
        }

        try
        {
            new PredictionResults(winner, 100.1);
            fail("Expected exception when confidence is above 100.0");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Confidence must be between 50 and 100.", e.getMessage());
        }
    }

    // ----------------------------------------------------------
    /**
     * Tests summary() when confidence is 75% or higher (blowout).
     */
    public void testSummaryBlowout()
    {
        PredictionResults result = new PredictionResults(winner, 75.0);
        String text = result.summary();
        assertTrue(text.contains("Hokies will likely win in a blowout!"));
        assertTrue(text.contains("Confidence: 75%."));

        PredictionResults extremeBlowout = new PredictionResults(winner, 100.0);
        assertTrue(extremeBlowout.summary().contains("blowout"));
    }

    // ----------------------------------------------------------
    /**
     * Tests summary() when confidence is between 60% and 74.9% (clear advantage).
     */
    public void testSummaryClearAdvantage()
    {
        PredictionResults result = new PredictionResults(winner, 60.0);
        String text = result.summary();
        assertTrue(text.contains("Hokies has a clear advantage."));
        assertTrue(text.contains("Confidence: 60%."));
    }

    // ----------------------------------------------------------
    /**
     * Tests summary() when confidence is below 60% (close game).
     */
    public void testSummarySlightUpperHand()
    {
        PredictionResults result = new PredictionResults(winner, 55.4);
        String text = result.summary();
        assertTrue(text.contains("This game could go either way, but Hokies has the slight upper hand."));
        assertTrue(text.contains("Confidence: 55%."));
    }
}