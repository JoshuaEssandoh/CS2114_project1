// -------------------------------------------------------------------------
/**
 * Team class with wins, losses, ties, offensiveRating, defensiveRating, strength,
 * winStreak, lossStreak, fatigue
 *
 * @author Robert Laing (rlaing4308)
 * @author Andrew Park (andrewp04)
 * @author Joshua Essandoh
 * @version Sep 21, 2026
 */
public class Team
{

    private String teamName; // Name of the team
    private int wins; // Wins the team has
    private int losses; // Losses the team has
    private int ties; // The amount of ties the team has
    private double offensiveRating; // The team's offensive rating
    private double defensiveRating; // The team's defensive rating
    private int winStreak; // The team's current winning streak
    private int lossStreak; // The team's current loss streak
    private double fatigue; // The team's current fatigue

    // ----------------------------------------------------------
    /**
     * Create a new Team object. Delegates to the setters for name, wins,
     * losses, offensiveRating, and defensiveRating so the same validation
     * rules apply whether a field is set here or later through its setter.
     *
     * @param name the team's name; cannot be null, empty, or whitespace only
     * @param wins the team's win count; cannot be negative
     * @param losses the team's loss count; cannot be negative
     * @param ties the team's tie count; cannot be negative
     * @param offensiveRating the team's offensive rating; must be between 0 and 99
     * @param defensiveRating the team's defensive rating; must be between 0 and 99
     */
    public Team(
        String name,
        int wins,
        int losses,
        int ties, 
        double offensiveRating,
        double defensiveRating)
    {
        setName(name);
        setWins(wins);
        setLosses(losses);
        setTies(ties);
        setOffensiveRating(offensiveRating);
        setDefensiveRating(defensiveRating);
        
        this.winStreak = 0;
        this.lossStreak = 0;
        this.fatigue = 0.0;
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
     * @throws IllegalArgumentException if ties value is negative
     */
    public void setTies(int ties)
    {
        if (ties < 0)
        {
            throw new IllegalArgumentException("Ties cannot be negative.");
        }
        this.ties = ties;
    }


    // ----------------------------------------------------------
    /**
     * Gets a team's offensive rating.
     *
     * @return offensiveRating
     */
    public double getOffensiveRating()
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
    public void setOffensiveRating(double offRate)
    {
        if (offRate < 0.0 || offRate > 99.0)
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
    public double getDefensiveRating()
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
    public void setDefensiveRating(double defRate)
    {
        if (defRate < 0.0 || defRate > 99.0)
        {
            throw new IllegalArgumentException(
                "Defensive rating must be between 0 and 99.");
        }
        this.defensiveRating = defRate;
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
     * @throws IllegalArgumentException 
     *         if win streak is negative or exceeds wins
     */
    public void setWinStreak(int winStreak)
    {
        if (winStreak < 0)
        {
            throw new IllegalArgumentException("Win streak cannot be negative.");
        }
        if (winStreak > this.wins)
        {
            throw new IllegalArgumentException("Win streak cannot exceed total wins.");
        }
        if (winStreak > 0 && this.lossStreak > 0)
        {
            throw new IllegalArgumentException("Cannot have an active win streak while on a loss streak.");
        }
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
     * @throws IllegalArgumentException 
     *         if loss streak is negative or exceeds losses
     */
    public void setLossStreak(int lossStreak)
    {
        if (lossStreak < 0)
        {
            throw new IllegalArgumentException("Loss streak cannot be negative.");
        }
        if (lossStreak > this.losses)
        {
            throw new IllegalArgumentException("Loss streak cannot exceed total losses.");
        }
        if (lossStreak > 0 && this.winStreak > 0)
        {
            throw new IllegalArgumentException("Cannot have an active loss streak while on a win streak.");
        }
        this.lossStreak = lossStreak;
    }


    // ----------------------------------------------------------
    /**
     * Gets a team's current fatigue value.
     *
     * @return fatigue
     */
    public double getFatigue()
    {
        return fatigue;
    }


    // ----------------------------------------------------------
    /**
     * Sets a team's current fatigue value.
     *
     * @param fatigue the new fatigue value
     * @throws IllegalArgumentException if fatigue is negative
     */
    public void setFatigue(double fatigue)
    {
        if (fatigue < 0.0)
        {
            throw new IllegalArgumentException("Fatigue cannot be negative.");
        }
        this.fatigue = fatigue;
    }

    /**
     * Calculates the winrate. Default to 0.500 when no wins or losses.
     * @return win rate (0.0 to 1.0)
     */
    public double getWinRate()
    {
        double totalGames = wins + losses + ties;
        if (totalGames == 0)
        {
            return 0.500;
        }
        return (wins + (0.5 * ties)) / totalGames;
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
            return other.getName().equals(this.teamName);
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
            + offensiveRating + ", defensiveRating=" + defensiveRating + "]";
    }
}