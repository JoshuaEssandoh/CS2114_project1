import student.TestCase;

// -------------------------------------------------------------------------
/**
 * JUnit test class for Team. One test method per Team method.
 *
 * @author Robert Laing (rlaing4308)
 * @author Andrew Park (andrewp04)
 * @author Joshua Essandoh
 * @version Sep 21, 2026
 */

public class TeamTest extends student.TestCase
{
    private Team team;
    
    // ----------------------------------------------------------
    /**
     * Sets up the test Team object
     */
    public void setUp() {
        team = new Team("Hokies", 10, 5, 0, 80.0, 75.0);
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
        assertEquals(80.0, team.getOffensiveRating(), 0.01);
 
        team.setOffensiveRating(90.0);
        assertEquals(90.0, team.getOffensiveRating(), 0.01);
 
        Exception e = null;
        try
        {
            team.setOffensiveRating(-0.1);
        }
        catch (IllegalArgumentException ex)
        {
            e = ex;
        }
        assertNotNull(e);
 
        e = null;
        try
        {
            team.setOffensiveRating(99.1);
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
        assertEquals(75.0, team.getDefensiveRating(), 0.01);
 
        team.setDefensiveRating(60.0);
        assertEquals(60.0, team.getDefensiveRating(), 0.01);
 
        Exception e = null;
        try
        {
            team.setDefensiveRating(-0.1);
        }
        catch (IllegalArgumentException ex)
        {
            e = ex;
        }
        assertNotNull(e);
 
        e = null;
        try
        {
            team.setDefensiveRating(99.1);
        }
        catch (IllegalArgumentException ex)
        {
            e = ex;
        }
        assertNotNull(e);
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
        
        team.setWinStreak(2);
        assertEquals(0, team.getLossStreak());
        assertEquals(2, team.getWinStreak());
        
        Exception negativeEx = null;
        try
        {
            team.setWinStreak(-1);
        }
        catch (IllegalArgumentException ex)
        {
            negativeEx = ex;
        }
        assertNotNull(negativeEx);
        
        Exception exceedEx = null;
        try
        {
            team.setWinStreak(11);
        }
        catch (IllegalArgumentException ex)
        {
            exceedEx = ex;
        }
        assertNotNull(exceedEx);
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

        team.setLossStreak(2);
        assertEquals(2, team.getLossStreak());
        assertEquals(0, team.getWinStreak());
        
        Exception negativeEx = null;
        try
        {
            team.setLossStreak(-1);
        }
        catch (IllegalArgumentException ex)
        {
            negativeEx = ex;
        }
        assertNotNull(negativeEx);

        Exception exceedEx = null;
        try
        {
            team.setLossStreak(6);
        }
        catch (IllegalArgumentException ex)
        {
            exceedEx = ex;
        }
        assertNotNull(exceedEx);
    }
 
 
    // ----------------------------------------------------------
    /**
     * Tests getFatigue() and setFatigue(float).
     */
    public void testFatigue()
    {
        assertEquals(0.0, team.getFatigue(), 0.01);
 
        team.setFatigue(15.5);
        assertEquals(15.5, team.getFatigue(), 0.01);
    }
 
    // ----------------------------------------------------------
    /**
     * Tests getWinRate()
     */
    public void testWinRate()
    {
        assertEquals(10.0 / 15.0, team.getWinRate(), 0.01);

        team.setTies(5);
        assertEquals(0.625, team.getWinRate(), 0.01);

        Team unplayed = new Team("team1", 0, 0, 0, 50.0, 50.0);
        assertEquals(0.500, unplayed.getWinRate(), 0.001);
    }
 
    // ----------------------------------------------------------
    /**
     * Tests equals(Object).
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals()
    {
        assertTrue(team.equals(team));
        assertFalse(team.equals(null));
        assertFalse(team.equals("Hokies"));
 
        Team differentName = new Team("Cavaliers", 10, 5, 0, 80.0, 75.0);
        assertFalse(team.equals(differentName));
 
        Team sameName = new Team("Hokies", 2, 2, 0, 40.0, 40.0);
        assertTrue(team.equals(sameName));
    }
 
 
    // ----------------------------------------------------------
    /**
     * Tests toString().
     */
    public void testToString()
    {
        String expected = "Team[name=Hokies, wins=10, losses=5, ties=0, "
            + "offensiveRating=80.0, defensiveRating=75.0]";
        assertEquals(expected, team.toString());
    }
}
 
