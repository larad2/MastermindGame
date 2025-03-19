import java.util.Scanner;

/**
 * The Round class represents a single round of the number-guessing game.
 * The class tracks the number of guesses, whether the player won, and whether they quit.
 * The game continues until the player either guesses the correct number or decides to quit.

 * @author Daniel Lara
 */
public class Round
{
    // Instance variables
    private int secret;  // The number the player is trying to guess
    private int numGuesses;  // The number of guesses the player makes
    private boolean win;    // Tracks if the player won
    private boolean quit;   // Tracks if the player quit
    private Scanner scan;   // Scans for the player's inputs
    
    /**
     * Intializes the secret, guess counter, win/quit, and the scanner
     * @param s The scanner object used for user input
     */
    public Round(Scanner s) 
    {
        secret = 12345;
        numGuesses = 0;
        win = false;
        quit = false;
        scan = s;
    }
    
    // Accessor methods
    
    /**
     * Returns the secret number
     * 
     * @return The secret number
     */
    public int getSecret()
    {
        return secret;
    }
    
    /**
     * Returns the number of guesses made
     * 
     * @return The number of guesses
     */
    public int getNumGuesses()
    {
        return numGuesses;
    }
    
    /**
     * Returns whether the player has won
     * 
     * @return True if the player won, false if not
     */
    public boolean getWin()
    {
        return win;
    }
    
    /**
     * Returns whether the player has quit
     * 
     * @return True if the player has quit, false otherwise
     */
    public boolean getQuit()
    {
        return quit;
    }
    
    /**
     * Returns the scanner
     * 
     * @return The Scanner object
     */
    public Scanner getScan()
    {
        return scan;
    }
    
    /**
     * Asks the player for a guess and reads their input
     * If the player enters -1, it sets quit to true
     * Increases the guess counter if a guess is made
     * 
     * @return The player's guess
     */
    private int askForGuess()
    {
        System.out.println("Enter a guess or enter -1 to quit: ");
        int guess = scan.nextInt();
        scan.nextLine();
        
        if(guess == -1)
        {
            quit = true;
        }
        else {
            numGuesses++;
        }
        
        return guess;
    }
    
    /**
     * Method to check if the player won
     * 
     * @param guess The number guessed by the player
     */
    private void checkWin(int g)
    {
        if(g == secret)
        {
            win = true;
        }    
    }
    
    // Method to play the round
    public void play()
    {
        while(!win && !quit)
        {
            int guess = askForGuess();
            System.out.println("You guessed: " + guess);
            checkWin(guess);
        }
        if(win)
        {
            System.out.println("You won the round!");
        }
        else {
            System.out.println("You quit the round");
        }
        System.out.println("Number of guesses: " + numGuesses);
    }
}
