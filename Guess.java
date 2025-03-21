
/**
 * Write a description of class Guess here.
 *
 * @author Daniel Lara
 * @version (a version number or a date)
 */
public class Guess
{
    /**
     * Checks if the guess is valid (5 digits or -1)
     * @param g The guessed number
     * @return True if the guess is valid, otherwise false
     */
    public static boolean checkGuess(int g)
    {
        if(g != -1 && (g < 10000 || g > 99999))  // Ensure 5-digit number
        {
            System.out.println("Error - guess must be 5 digits");
            return false;
        }
        return true;
    }
    
    public static int countApples(int guess, int secret)
    {
        int apples = 0;
        String guessStr = String.valueOf(guess);
        String secretStr = String.valueOf(secret);
        
        for (int i = 0; i < 5; i++)
        {
            if(guessStr.charAt(i) == secretStr.charAt(i))
            {
                apples++;
            }
        }
        return apples;
    }
    
    public static int countOranges(int guess, int secret)
    {
        int oranges = 0;
        String guessStr = String.valueOf(guess);
        String secretStr = String.valueOf(secret);
        
        for(int i = 0; i < 5; i++)
        {
            if(guessStr.charAt(i) != secretStr.charAt(i) && secretStr.contains(String.valueOf(guessStr.charAt(i))))
            {
                oranges++;
            }
        }
        return oranges;
    }
}

