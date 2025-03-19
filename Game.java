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
    
    // Initializes scan
    public Game()
    {
        scan = new Scanner(System.in);
    }

    
    public Game(Scanner s)
    {
        scan = s;
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
    
    /**
     * Starts the game by creating a new round
     * It continues until the player wins or quits
     */
    public void play()
    {
        Round round = new Round(scan);
        round.play();
    }
}
