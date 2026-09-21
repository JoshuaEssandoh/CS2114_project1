

import java.util.Random;

// -------------------------------------------------------------------------
/**
 * Compares two teams and predicts the winner of their matchup.
 *
 * @author Robert Laing (rlaing4308)
 * @author Andrew Park (andrewp04)
 * @author Joshua Essandoh (jessandoh7)
 * @version Sep 21, 2026
 */
public class PredictionEngine
{
    private static final double EVEN_CHANCE = 0.5;
    private static final double RATING_WEIGHT = 0.50;
    private static final double WIN_RATE_WEIGHT = 0.35;
    private static final double MOMENTUM_WEIGHT = 0.15;
    private static final double MAX_RANDOM_ADJUSTMENT = 0.05;
    private Random random;

    // ----------------------------------------------------------
    /**
     * Creates an engine whose random results vary each time the program runs.
     */
    public PredictionEngine()
    {
        this(new Random());
    }

    // ----------------------------------------------------------
    /**
     * Creates an engine using a supplied random-number generator. Passing a
     * seeded Random makes unit tests repeatable.
     *
     * @param random the random-number generator to use
     */
    public PredictionEngine(Random random)
    {
        if (random == null)
        {
            throw new IllegalArgumentException("Random cannot be null.");
        }
        this.random = random;
    }

    // ----------------------------------------------------------
    /**
     * Compares the teams' Pythagorean ratings. A result above 0.5 favors
     * team1, while a result below 0.5 favors team2.
     *
     * @param team1 the first team
     * @param team2 the second team
     * @return team1's share of the two teams' ratings, from 0.0 to 1.0
     */
    public double predictRating(Team team1, Team team2)
    {
        validateTeams(team1, team2);
        double rating1 = pythagoreanRating(team1);
        double rating2 = pythagoreanRating(team2);
        return compareScores(rating1, rating2);
    }

    // ----------------------------------------------------------
    /**
     * Compares recent momentum using win streaks, loss streaks, and fatigue.
     * A result above 0.5 favors team1.
     *
     * @param team1 the first team
     * @param team2 the second team
     * @return team1's momentum share, from 0.0 to 1.0
     */
    public double predictMomentum(Team team1, Team team2)
    {
        validateTeams(team1, team2);
        double momentum1 = momentumScore(team1);
        double momentum2 = momentumScore(team2);
        return compareScores(momentum1, momentum2);
    }

    // ----------------------------------------------------------
    /**
     * Compares the teams' win rates. A result above 0.5 favors team1.
     *
     * @param team1 the first team
     * @param team2 the second team
     * @return team1's share of the two win rates, from 0.0 to 1.0
     */
    public double predictWinRate(Team team1, Team team2)
    {
        validateTeams(team1, team2);
        return compareScores(team1.getWinRate(), team2.getWinRate());
    }

    // ----------------------------------------------------------
    /**
     * Predicts a winner by combining rating, win rate, and momentum.
     *
     * @param team1 the first team
     * @param team2 the second team
     * @return the winner and a confidence percentage from 50.0 to 100.0
     */
    public PredictionResults predict(Team team1, Team team2)
    {
        validateTeams(team1, team2);

        double team1Score = RATING_WEIGHT * predictRating(team1, team2)
            + WIN_RATE_WEIGHT * predictWinRate(team1, team2)
            + MOMENTUM_WEIGHT * predictMomentum(team1, team2);

        // Adds an unpredictable game-day factor between -0.05 and +0.05.
        double randomAdjustment = (random.nextDouble() * 2.0 - 1.0)
            * MAX_RANDOM_ADJUSTMENT;
        team1Score = Math.max(0.0, Math.min(1.0,
            team1Score + randomAdjustment));

        Team winner = team1Score >= EVEN_CHANCE ? team1 : team2;
        double confidence = 50.0 + Math.abs(team1Score - EVEN_CHANCE) * 100.0;
        return new PredictionResults(winner, confidence);
    }


    /**
     * Calculates one team's Pythagorean expectation.
     */
    private double pythagoreanRating(Team team)
    {
        double offenseSquared = Math.pow(team.getOffensiveRating(), 2);
        double defenseSquared = Math.pow(team.getDefensiveRating(), 2);
        double total = offenseSquared + defenseSquared;

        if (total == 0.0)
        {
            return EVEN_CHANCE;
        }
        return offenseSquared / total;
    }


    /**
     * Produces a nonnegative score for recent team momentum.
     */
    private double momentumScore(Team team)
    {
        return Math.max(0.0, 50.0 + team.getWinStreak()
            - team.getLossStreak() - team.getFatigue());
    }


    /**
     * Converts two nonnegative scores into team1's comparative share.
     */
    private double compareScores(double score1, double score2)
    {
        double total = score1 + score2;
        if (total == 0.0)
        {
            return EVEN_CHANCE;
        }
        return score1 / total;
    }


    /**
     * Ensures that a prediction has two different, non-null teams.
     */
    private void validateTeams(Team team1, Team team2)
    {
        if (team1 == null || team2 == null)
        {
            throw new IllegalArgumentException("Teams cannot be null.");
        }
        if (team1.equals(team2) || team1.getName().equals(team2.getName()))
        {
            throw new IllegalArgumentException(
                "Cannot predict matchup between identical teams.");
        }
    }
}
