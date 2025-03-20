import java.util.Scanner;

/**
 * The Game class manages the overall number-guessing game.
 * The game consists of one or more rounds where the player tries to guess a secret number.
 * The game continues until the player chooses to stop.
 * 
 * @author Daniel Lara
 */
public class Game
{
    private Scanner scan;
    private int numGuesses;  // Count the number of guesses made
    private int numRoundsWon; // Counts the rounds that are won
    private boolean quitGame; // Tracks if the player quit the game
    
    // Initializes scan
    public Game()
    {
        scan = new Scanner(System.in);
        numGuesses = 0;
        numRoundsWon = 0;
        quitGame = false;
    }

    
    public Game(Scanner s)
    {
        scan = s;
        numGuesses = 0;
        numRoundsWon = 0;
        quitGame = false;
    }    
    
    /**
     * Returns the Scanner
     * 
     * @return The Scanner object
     */    
    public Scanner getScan()
    {
        return scan;
    }
    
    public int getNumGuesses()
    {
        return numGuesses;
    }
    
    public int getNumRoundsWon()
    {
        return numRoundsWon;
    }
    
    public boolean getQuitGame()
    {
        return quitGame;
    }
    
    private void playAgain()
    {
        System.out.println("Play again? Enter y or n: ");
        String response = scan.nextLine();
        if(response.equals("n"))
        {
            quitGame = true;
        }
    }
    
    private double getAverage()
    {
        double avg = 0.0;
        if(numRoundsWon > 0)
        {
            return(double) numGuesses / numRoundsWon ;
        }
        return avg;
    }
    
    /**
     * Starts the game by creating a new round
     * It continues until the player wins or quits
     */
    public void play()
    {
        while(!quitGame)
        {
            Round round = new Round(scan);
            round.play();
            
            // If the round was won, update the game stats
            if(round.getWin())
            {
                numGuesses += round.getNumGuesses();
                numRoundsWon++;
            }
            
            // Calls the method playAgain
            playAgain();
        }
        
        // Display final game message
        System.out.println("You quit the game");
        System.out.println("Number of rounds won: " + numRoundsWon);
        System.out.println("Average number of guesses: " + getAverage());
    }
}
