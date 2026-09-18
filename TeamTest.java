import student.TestCase;

// -------------------------------------------------------------------------
/**
 * JUnit test class for Team. One test method per Team method.
 *
 * @author Robert Laing (rlaing4308)
 * @version Sep 18, 2026
 */

public class TeamTest extends student.TestCase
{
    private Team team;
    
    // ----------------------------------------------------------
    /**
     * Sets up the test Team object
     */
    public void setUp() {
        team = new Team("Hokies", 10, 5, 80.0f, 75.0f, 50.0f);
    }

    // ----------------------------------------------------------
    /**
     * Tests getName() and setName(String).
     */
    public void testName()
    {
        assertEquals("Hokies", team.getName());
 
        team.setName("Cavaliers");
        assertEquals("Cavaliers", team.getName());
 
        Exception e = null;
        try
        {
            team.setName(null);
        }
        catch (IllegalArgumentException ex)
        {
            e = ex;
        }
        assertNotNull(e);
 
        e = null;
        try
        {
            team.setName("   ");
        }
        catch (IllegalArgumentException ex)
        {
            e = ex;
        }
        assertNotNull(e);
    }
 
 
    // ----------------------------------------------------------
    /**
     * Tests getWins() and setWins(int).
     */
    public void testWins()
    {
        assertEquals(10, team.getWins());
 
        team.setWins(20);
        assertEquals(20, team.getWins());
 
        Exception e = null;
        try
        {
            team.setWins(-1);
        }
        catch (IllegalArgumentException ex)
        {
            e = ex;
        }
        assertNotNull(e);
    }
 
 
    // ----------------------------------------------------------
    /**
     * Tests getLosses() and setLosses(int).
     */
    public void testLosses()
    {
        assertEquals(5, team.getLosses());
 
        team.setLosses(8);
        assertEquals(8, team.getLosses());
 
        Exception e = null;
        try
        {
            team.setLosses(-1);
        }
        catch (IllegalArgumentException ex)
        {
            e = ex;
        }
        assertNotNull(e);
    }
 
 
    // ----------------------------------------------------------
    /**
     * Tests getTies() and setTies(int).
     */
    public void testTies()
    {
        assertEquals(0, team.getTies());
 
        team.setTies(3);
        assertEquals(3, team.getTies());
    }
 
 
    // ----------------------------------------------------------
    /**
     * Tests getOffensiveRating() and setOffensiveRating(float).
     */
    public void testOffensiveRating()
    {
        assertEquals(80.0f, team.getOffensiveRating());
 
        team.setOffensiveRating(90.0f);
        assertEquals(90.0f, team.getOffensiveRating());
 
        Exception e = null;
        try
        {
            team.setOffensiveRating(-0.1f);
        }
        catch (IllegalArgumentException ex)
        {
            e = ex;
        }
        assertNotNull(e);
 
        e = null;
        try
        {
            team.setOffensiveRating(99.1f);
        }
        catch (IllegalArgumentException ex)
        {
            e = ex;
        }
        assertNotNull(e);
    }
 
 
    // ----------------------------------------------------------
    /**
     * Tests getDefensiveRating() and setDefensiveRating(float).
     */
    public void testDefensiveRating()
    {
        assertEquals(75.0f, team.getDefensiveRating());
 
        team.setDefensiveRating(60.0f);
        assertEquals(60.0f, team.getDefensiveRating());
 
        Exception e = null;
        try
        {
            team.setDefensiveRating(-0.1f);
        }
        catch (IllegalArgumentException ex)
        {
            e = ex;
        }
        assertNotNull(e);
 
        e = null;
        try
        {
            team.setDefensiveRating(99.1f);
        }
        catch (IllegalArgumentException ex)
        {
            e = ex;
        }
        assertNotNull(e);
    }
 
 
    // ----------------------------------------------------------
    /**
     * Tests getStrength() and setStrength(float).
     */
    public void testStrength()
    {
        assertEquals(50.0f, team.getStrength());
 
        team.setStrength(72.5f);
        assertEquals(72.5f, team.getStrength());
    }
 
 
    // ----------------------------------------------------------
    /**
     * Tests getWinStreak() and setWinStreak(int).
     */
    public void testWinStreak()
    {
        assertEquals(0, team.getWinStreak());
 
        team.setWinStreak(4);
        assertEquals(4, team.getWinStreak());
    }
 
 
    // ----------------------------------------------------------
    /**
     * Tests getLossStreak() and setLossStreak(int).
     */
    public void testLossStreak()
    {
        assertEquals(0, team.getLossStreak());
 
        team.setLossStreak(2);
        assertEquals(2, team.getLossStreak());
    }
 
 
    // ----------------------------------------------------------
    /**
     * Tests getFatigue() and setFatigue(float).
     */
    public void testFatigue()
    {
        assertEquals(0.0f, team.getFatigue());
 
        team.setFatigue(15.5f);
        assertEquals(15.5f, team.getFatigue());
    }
 
 
    // ----------------------------------------------------------
    /**
     * Tests equals(Object).
     */
    public void testEquals()
    {
        assertTrue(team.equals(team));
        assertFalse(team.equals(null));
        assertFalse(team.equals("Hokies"));
 
        Team differentName = new Team("Cavaliers", 10, 5, 80.0f, 75.0f, 50.0f);
        assertFalse(team.equals(differentName));
 
        Team sameName = new Team("Hokies", 2, 2, 40.0f, 40.0f, 10.0f);
        assertTrue(team.equals(sameName));
    }
 
 
    // ----------------------------------------------------------
    /**
     * Tests toString().
     */
    public void testToString()
    {
        String expected = "Team[name=Hokies, wins=10, losses=5, ties=0, "
            + "offensiveRating=80.0, defensiveRating=75.0, strength=50.0]";
        assertEquals(expected, team.toString());
    }
}
 
