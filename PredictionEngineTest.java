import java.util.Random;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test class for PredictionEngine.
 *
 * @author Robert Laing (rlaing4308)
 * @author Andrew Park (andrewp04)
 * @author Joshua Essandoh (jessandoh7)
 * @version Sep 21, 2026
 */
public class PredictionEngineTest extends student.TestCase
{
    private PredictionEngine engine;
    private Team strongTeam;
    private Team weakTeam;

    // ----------------------------------------------------------
    /**
     * Sets up the fixture using a seeded Random for deterministic behavior.
     */
    public void setUp()
    {
        // Seed 42 ensures predictable pseudorandom values across test runs
        engine = new PredictionEngine(new Random(42));
        strongTeam = new Team("Hokies", 10, 2, 0, 85.0, 70.0);
        weakTeam = new Team("Cavaliers", 3, 9, 0, 60.0, 80.0);
    }

    // ----------------------------------------------------------
    /**
     * Tests engine constructors, including null random exception and default constructor.
     */
    public void testConstructors()
    {
        PredictionEngine defaultEngine = new PredictionEngine();
        assertNotNull(defaultEngine);

        try
        {
            new PredictionEngine(null);
            fail("Expected exception when Random generator is null");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Random cannot be null.", e.getMessage());
        }
    }

    // ----------------------------------------------------------
    /**
     * Tests predictRating() normal behavior and edge case where ratings are 0.
     */
    public void testPredictRating()
    {
        double ratingShare = engine.predictRating(strongTeam, weakTeam);
        assertTrue(ratingShare > 0.5);

        // Edge case: Both teams have 0.0 ratings (triggers total == 0.0)
        Team zeroTeam1 = new Team("Alpha", 5, 5, 0, 0.0, 0.0);
        Team zeroTeam2 = new Team("Beta", 5, 5, 0, 0.0, 0.0);
        assertEquals(0.5, engine.predictRating(zeroTeam1, zeroTeam2), 0.001);
    }

    // ----------------------------------------------------------
    /**
     * Tests predictMomentum() under different streak and fatigue values.
     */
    public void testPredictMomentum()
    {
        strongTeam.setWinStreak(5);
        strongTeam.setFatigue(2.0);
        weakTeam.setLossStreak(4);
        weakTeam.setFatigue(10.0);

        double momentumShare = engine.predictMomentum(strongTeam, weakTeam);
        assertTrue(momentumShare > 0.5);

        // Edge case: Both teams have extreme fatigue leading to 0 momentum
        strongTeam.setFatigue(100.0);
        weakTeam.setFatigue(100.0);
        assertEquals(0.5, engine.predictMomentum(strongTeam, weakTeam), 0.001);
    }

    // ----------------------------------------------------------
    /**
     * Tests predictWinRate() normal behavior and unplayed teams.
     */
    public void testPredictWinRate()
    {
        double winRateShare = engine.predictWinRate(strongTeam, weakTeam);
        assertTrue(winRateShare > 0.5);

        Team tieTeam1 = new Team("TeamA", 0, 0, 0, 50.0, 50.0);
        Team tieTeam2 = new Team("TeamB", 0, 0, 0, 50.0, 50.0);
        assertEquals(0.5, engine.predictWinRate(tieTeam1, tieTeam2), 0.001);
    }

    // ----------------------------------------------------------
    /**
     * Tests predict() output, ensuring winner and confidence bounds are sound.
     */
    public void testPredictOutcome()
    {
        strongTeam.setWinStreak(3);
        weakTeam.setLossStreak(3);

        PredictionResults result = engine.predict(strongTeam, weakTeam);
        assertNotNull(result);
        assertEquals("Hokies", result.getWinner().getName());
        assertTrue(result.getConfidence() >= 50.0);
        assertTrue(result.getConfidence() <= 100.0);
        
        PredictionResults reverseResult = engine.predict(weakTeam, strongTeam);
        assertEquals("Hokies", reverseResult.getWinner().getName());
    }

    // ----------------------------------------------------------
    /**
     * Tests validateTeams() when either team is null.
     */
    public void testValidateTeamsNull()
    {
        try
        {
            engine.predict(null, weakTeam);
            fail("Expected exception when team1 is null");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Teams cannot be null.", e.getMessage());
        }

        try
        {
            engine.predict(strongTeam, null);
            fail("Expected exception when team2 is null");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Teams cannot be null.", e.getMessage());
        }
    }

    // ----------------------------------------------------------
    /**
     * Tests validateTeams() when comparing identical teams or matching names.
     */
    public void testValidateTeamsIdentical()
    {
        try
        {
            engine.predict(strongTeam, strongTeam);
            fail("Expected exception when comparing identical team objects");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Cannot predict matchup between identical teams.", e.getMessage());
        }

        Team duplicateNameTeam = new Team("Hokies", 1, 1, 0, 40.0, 40.0);
        try
        {
            engine.predict(strongTeam, duplicateNameTeam);
            fail("Expected exception when comparing teams with same name");
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Cannot predict matchup between identical teams.", e.getMessage());
        }
    }
}