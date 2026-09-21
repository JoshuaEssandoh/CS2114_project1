import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 * SSPgame drives the Super Sports Prediction console application. Full
 * menu/input/prediction logic to be added later.
 *
 * @author Robert Laing (rlaing4308)
 * @author Andrew Park (andrewp04)
 * @author Joshua Essandoh
 * @version Sep 21, 2026
 */
public class SSPGame
{

    private Scanner scanner;
    private PredictionEngine predictionEngine; 

    
    // ----------------------------------------------------------
    /**
     * Create a new SSPGame object.
     */
    public SSPGame()
    {
        this.scanner = new Scanner(System.in);
        this.predictionEngine = new PredictionEngine();
    }
// ----------------------------------------------------------
    // ----------------------------------------------------------
    /**
     * Entry point to run the console
     * @param args command line args
     */
    public static void main(String[] args)
    {
        SSPGame game = new SSPGame();
        game.run();
    }
    
    /**
     * Displays menu, reads input, creates teams, etc.
     */
    public void run()
    {
        System.out.println("========================================");
        System.out.println(" Welcome to Super Sports Predictor (SSP) ");
        System.out.println("========================================");

        try
        {
            System.out.println("\n--- Enter Details for Team 1 ---");
            Team team1 = promptForTeam();

            System.out.println("\n--- Enter Details for Team 2 ---");
            Team team2 = promptForTeam();

            System.out.println("\nEvaluating matchup...");
            PredictionResults results = predictionEngine.predict(team1, team2);

            System.out.println("\n========================================");
            System.out.println("           PREDICTION RESULTS           ");
            System.out.println("========================================");
            System.out.println("Matchup: " + team1.getName() + " vs " + team2.getName());
            System.out.println("Predicted Winner: " + results.getWinner().getName());
            System.out.println("Summary: " + results.summary());
            System.out.println("========================================");
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("\n[Error] Invalid team data: " + e.getMessage());
        }
        finally
        {
            scanner.close();
        }
    }
    
    /**
     * method to prompt the user for team statistics.
     * 
     * @return constructed Team object.
     */
    private Team promptForTeam()
    {
        String name;
        while (true)
        {
            System.out.print("Team Name: ");
            name = scanner.nextLine();
            if (name != null && !name.trim().isEmpty())
            {
                break;
            }
            System.out.println("[Error] Team name cannot be null, empty, or "
                + "whitespace only. Please try again.");
        }

        int wins;
        while (true)
        {
            System.out.print("Wins: ");
            wins = Integer.parseInt(scanner.nextLine().trim());
            if (wins >= 0)
            {
                break;
            }
            System.out.println("[Error] Wins cannot be negative. Please try again.");
        }

        int losses;
        while (true)
        {
            System.out.print("Losses: ");
            losses = Integer.parseInt(scanner.nextLine().trim());
            if (losses >= 0)
            {
                break;
            }
            System.out.println("[Error] Losses cannot be negative. Please try again.");
        }

        int ties;
        while (true)
        {
            System.out.print("Ties: ");
            ties = Integer.parseInt(scanner.nextLine().trim());
            if (ties >= 0)
            {
                break;
            }
            System.out.println("[Error] Ties cannot be negative. Please try again.");
        }

        double offRating;
        while (true)
        {
            System.out.print("Offensive Rating (0.0 - 99.0): ");
            offRating = Double.parseDouble(scanner.nextLine().trim());
            if (offRating >= 0.0 && offRating <= 99.0)
            {
                break;
            }
            System.out.println("[Error] Offensive rating must be between 0 and 99. Please try again.");
        }

        double defRating;
        while (true)
        {
            System.out.print("Defensive Rating (0.0 - 99.0): ");
            defRating = Double.parseDouble(scanner.nextLine().trim());
            if (defRating >= 0.0 && defRating <= 99.0)
            {
                break;
            }
            System.out.println("[Error] Defensive rating must be between 0 and 99. Please try again.");
        }

        Team team = new Team(name, wins, losses, ties, offRating, defRating);

        while (true)
        {
            try
            {
                System.out.print("Win Streak: ");
                team.setWinStreak(Integer.parseInt(scanner.nextLine().trim()));
                break;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("[Error] " + e.getMessage() + " Please try again.");
            }
        }

        while (true)
        {
            try
            {
                System.out.print("Loss Streak: ");
                team.setLossStreak(Integer.parseInt(scanner.nextLine().trim()));
                break;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("[Error] " + e.getMessage() + " Please try again.");
            }
        }

        while (true)
        {
            try
            {
                System.out.print("Fatigue (>= 0.0): ");
                team.setFatigue(Double.parseDouble(scanner.nextLine().trim()));
                break;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("[Error] " + e.getMessage() + " Please try again.");
            }
        }

        return team;
    }
}
