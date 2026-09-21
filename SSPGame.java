import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 * SSPgame drives the Super Sports Prediction console application. Full
 * menu/input/prediction logic to be added later.
 *
 * @author Robert Laing (rlaing4308)
 * @author Andrew Park (andrewp04)
 * @version Sep 21, 2026
 */
public class SSPGame
{

    private Scanner scanner;
    private PredictionEngine predictionEngine; 

    
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
        System.out.print("Team Name: ");
        String name = scanner.nextLine();

        System.out.print("Wins: ");
        int wins = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Losses: ");
        int losses = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Offensive Rating (0.0 - 99.0): ");
        double offRating = Double.parseDouble(scanner.nextLine().trim());

        System.out.print("Defensive Rating (0.0 - 99.0): ");
        double defRating = Double.parseDouble(scanner.nextLine().trim());

        System.out.print("Team Strength (calculated base, e.g. 50.0): ");
        double strength = Double.parseDouble(scanner.nextLine().trim());

        Team team = new Team(name, wins, losses, offRating, defRating, strength);

        System.out.print("Win Streak: ");
        team.setWinStreak(Integer.parseInt(scanner.nextLine().trim()));

        System.out.print("Loss Streak: ");
        team.setLossStreak(Integer.parseInt(scanner.nextLine().trim()));

        System.out.print("Fatigue (>= 0.0): ");
        team.setFatigue(Double.parseDouble(scanner.nextLine().trim()));

        return team;
    }
}
