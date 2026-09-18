// -------------------------------------------------------------------------
/**
 * Team class with wins, losses, ties, offensiveRating, defensiveRating, strength,
 * winStreak, lossStreak, fatigue
 *
 * @author Robert Laing (rlaing4308)
 * @version Sep 18, 2026
 */
public class Team
{

    private String teamName; // Name of the team
    private int wins; // Wins the team has
    private int losses; // Losses the team has
    private int ties; // The amount of ties the team has
    private float offensiveRating; // The team's offensive rating
    private float defensiveRating; // The team's defensive rating
    private float strength; // The team's calculated strength
    private int winStreak; // The team's current winning streak
    private int lossStreak; // The team's current loss streak
    private float fatigue; // The team's current fatigue

    // ----------------------------------------------------------
    /**
     * Create a new Team object. Delegates to the setters for name, wins,
     * losses, offensiveRating, and defensiveRating so the same validation
     * rules apply whether a field is set here or later through its setter.
     *
     * @param name the team's name; cannot be null, empty, or whitespace only
     * @param wins the team's win count; cannot be negative
     * @param losses the team's loss count; cannot be negative
     * @param offensiveRating the team's offensive rating; must be between 0 and 99
     * @param defensiveRating the team's defensive rating; must be between 0 and 99
     * @param strength the team's calculated strength
     */
    public Team(
        String name,
        int wins,
        int losses,
        float offensiveRating,
        float defensiveRating,
        float strength)
    {
        setName(name);
        setWins(wins);
        setLosses(losses);
        setOffensiveRating(offensiveRating);
        setDefensiveRating(defensiveRating);
        this.strength = strength;
    }


    // ----------------------------------------------------------
    /**
     * Gets a team's name.
     *
     * @return teamName
     */
    public String getName()
    {
        return teamName;
    }


    // ----------------------------------------------------------
    /**
     * Sets a team's name.
     *
     * @param name the new team name; cannot be null, empty, or whitespace only
     * @throws IllegalArgumentException if name is null, empty, or whitespace only
     */
    public void setName(String name)
    {
        if (name == null || name.trim().isEmpty())
        {
            throw new IllegalArgumentException(
                "Team name cannot be null, empty, or whitespace only.");
        }
        this.teamName = name;
    }


    // ----------------------------------------------------------
    /**
     * Gets a team's win count.
     *
     * @return wins
     */
    public int getWins()
    {
        return wins;
    }


    // ----------------------------------------------------------
    /**
     * Sets a team's win count.
     *
     * @param wins the new win count; cannot be negative
     * @throws IllegalArgumentException if wins is negative
     */
    public void setWins(int wins)
    {
        if (wins < 0)
        {
            throw new IllegalArgumentException("Wins cannot be negative.");
        }
        this.wins = wins;
    }


    // ----------------------------------------------------------
    /**
     * Gets a team's loss count.
     *
     * @return losses
     */
    public int getLosses()
    {
        return losses;
    }


    // ----------------------------------------------------------
    /**
     * Sets a team's loss count.
     *
     * @param losses the new loss count; cannot be negative
     * @throws IllegalArgumentException if losses is negative
     */
    public void setLosses(int losses)
    {
        if (losses < 0)
        {
            throw new IllegalArgumentException("Losses cannot be negative.");
        }
        this.losses = losses;
    }


    // ----------------------------------------------------------
    /**
     * Gets a team's tie count.
     *
     * @return ties
     */
    public int getTies()
    {
        return ties;
    }


    // ----------------------------------------------------------
    /**
     * Sets a team's tie count.
     *
     * @param ties
     *            the new tie count
     */
    public void setTies(int ties)
    {
        this.ties = ties;
    }


    // ----------------------------------------------------------
    /**
     * Gets a team's offensive rating.
     *
     * @return offensiveRating
     */
    public float getOffensiveRating()
    {
        return offensiveRating;
    }


    // ----------------------------------------------------------
    /**
     * Sets a team's offensive rating.
     *
     * @param offRate
     *            the new offensive rating; must be between 0 and 99
     * @throws IllegalArgumentException
     *             if offRate is outside the range [0, 99]
     */
    public void setOffensiveRating(float offRate)
    {
        if (offRate < 0.0f || offRate > 99.0f)
        {
            throw new IllegalArgumentException(
                "Offensive rating must be between 0 and 99.");
        }
        this.offensiveRating = offRate;
    }


    // ----------------------------------------------------------
    /**
     * Gets a team's defensive rating.
     *
     * @return defensiveRating
     */
    public float getDefensiveRating()
    {
        return defensiveRating;
    }


    // ----------------------------------------------------------
    /**
     * Sets a team's defensive rating.
     *
     * @param defRate the new defensive rating; must be between 0 and 99
     * @throws IllegalArgumentException if defRate is outside the range [0, 99]
     */
    public void setDefensiveRating(float defRate)
    {
        if (defRate < 0.0f || defRate > 99.0f)
        {
            throw new IllegalArgumentException(
                "Defensive rating must be between 0 and 99.");
        }
        this.defensiveRating = defRate;
    }


    // ----------------------------------------------------------
    /**
     * Gets a team's calculated strength.
     *
     * @return strength
     */
    public float getStrength()
    {
        return strength;
    }


    // ----------------------------------------------------------
    /**
     * Sets a team's calculated strength.
     *
     * @param strength the new strength value
     */
    public void setStrength(float strength)
    {
        this.strength = strength;
    }


    // ----------------------------------------------------------
    /**
     * Gets a team's current winning streak.
     *
     * @return winStreak
     */
    public int getWinStreak()
    {
        return winStreak;
    }


    // ----------------------------------------------------------
    /**
     * Sets a team's current winning streak.
     *
     * @param winStreak the new winning streak value
     */
    public void setWinStreak(int winStreak)
    {
        this.winStreak = winStreak;
    }


    // ----------------------------------------------------------
    /**
     * Gets a team's current losing streak.
     *
     * @return lossStreak
     */
    public int getLossStreak()
    {
        return lossStreak;
    }


    // ----------------------------------------------------------
    /**
     * Sets a team's current losing streak.
     *
     * @param lossStreak the new losing streak value
     */
    public void setLossStreak(int lossStreak)
    {
        this.lossStreak = lossStreak;
    }


    // ----------------------------------------------------------
    /**
     * Gets a team's current fatigue value.
     *
     * @return fatigue
     */
    public float getFatigue()
    {
        return fatigue;
    }


    // ----------------------------------------------------------
    /**
     * Sets a team's current fatigue value.
     *
     * @param fatigue the new fatigue value
     */
    public void setFatigue(float fatigue)
    {
        this.fatigue = fatigue;
    }


    // ----------------------------------------------------------
    /**
     * Compares this Team to another object for equality. Two teams are
     * considered equal if they are the same class and share the same team
     * name.
     *
     * @param obj the object to compare against
     * @return true if obj is a Team with the same name, false otherwise
     */
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (obj == null)
        {
            return false;
        }

        if (obj.getClass() == this.getClass())
        {
            Team other = (Team)obj;
            if (other.getName().equals(this.teamName))
            {
                return true;
            }
        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * Returns a string representation of this Team, including its name,
     * record, and ratings.
     *
     * @return a string describing this Team
     */
    public String toString()
    {
        return "Team[name=" + teamName + ", wins=" + wins + ", losses="
            + losses + ", ties=" + ties + ", offensiveRating="
            + offensiveRating + ", defensiveRating=" + defensiveRating
            + ", strength=" + strength + "]";
    }
}