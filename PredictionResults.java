

// -------------------------------------------------------------------------
/**
 * Stores and summarizes the result produced by a PredictionEngine.
 *
 * @author Joshua Essandoh
 * @version Sep 21, 2026
 */
public class PredictionResults
{
    private Team winner;
    private double confidence;

    // ----------------------------------------------------------
    /**
     * Creates a prediction result.
     *
     * @param winner the predicted winner; cannot be null
     * @param confidence confidence percentage from 50.0 to 100.0
     */
    public PredictionResults(Team winner, double confidence)
    {
        if (winner == null)
        {
            throw new IllegalArgumentException("Winner cannot be null.");
        }
        if (confidence < 50.0 || confidence > 100.0)
        {
            throw new IllegalArgumentException(
                "Confidence must be between 50 and 100.");
        }
        this.winner = winner;
        this.confidence = confidence;
    }

    // ----------------------------------------------------------
    /**
     * Gets the predicted winner.
     *
     * @return the winning team
     */
    public Team getWinner()
    {
        return winner;
    }

    // ----------------------------------------------------------
    /**
     * Gets the prediction confidence percentage.
     *
     * @return confidence from 50.0 to 100.0
     */
    public double getConfidence()
    {
        return confidence;
    }

    // ----------------------------------------------------------
    /**
     * Describes the prediction in plain language.
     *
     * @return a summary containing the winner and confidence level
     */
    public String summary()
    {
        String message;
        if (confidence >= 75.0)
        {
            message = winner.getName() + " will likely win in a blowout!";
        }
        else if (confidence >= 60.0)
        {
            message = winner.getName() + " has a clear advantage.";
        }
        else
        {
            message = "This game could go either way, but "
                + winner.getName() + " has the slight upper hand.";
        }
        return message + " Confidence: " + Math.round(confidence) + "%.";
    }
}