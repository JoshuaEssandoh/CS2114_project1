import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 * SSPgame drives the Super Sports Prediction console application. Full
 * menu/input/prediction logic to be added later.
 *
 * @author Robert Laing (rlaing4308)
 * @author Andrew Park (andrewp04)
 * @version Sep 20, 2026
 */
public class SSPGame
{

    private Scanner scanner; // For user inputs
    private PredictionEngine predictionEngine; // To run predict within the
                                               // class

    
    public SSPGame()
    {
        this.scanner = new Scanner(System.in);
        this.predictionEngine = new PredictionEngine();
    }
                                               // ----------------------------------------------------------
    /**
     * Displays menu, reads input, creates teams, etc.
     */
    public void run()
    {
        // TODO: implement
    }
}
