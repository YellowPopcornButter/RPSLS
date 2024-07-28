/*
 * This class displays the game within the console program for RPSLS
 */

public class RPSLS extends ConsoleProgram
{
    private GameLogic gameLogic = new GameLogic();

    /*
     * Runs the main loop for the game
     */
    public void run()
    {
        //Starting Text
        println("Welcome to the Rock, Paper, Scissors, Lizard and Spock Game");// Introduction Text
        println("First to win 4 games will be crowned the champion of this game"); // Explains the game in simple terms
        println();
        int playerWins = 0;// Initializes the Players Wins to zero at the start of the game
        int computerWins = 0; // Initializes the computers wins at zero at the start of the game
        
        while(playerWins < 4 && computerWins < 4) // Continues the game until either player or computer hits 4 wins
        {
            String userChoice = readLine("Enter your choice (Rock, Paper, Scissors, Lizard, Spock). Type 'quit' to exit: ");
            
            if(userChoice.equalsIgnoreCase("quit")) // Checks if the user would like to quit
            {
                println("Game ended"); // Exiting text
                break; // Ends the game
            }
            
            if(!gameLogic.isValidChoice(userChoice)) // Checks if the user inputed a valid choice
            {
                println("Invalid Choice. Please Try again."); // An error message telling them to try again
                continue; // Continues and re-prompts the user
            }
            
            String computerChoice = gameLogic.getComputerChoice(); // Gets a computer a random choice 
            String result = gameLogic.determineWinner(userChoice, computerChoice); // Determines the winner of the game
            
            // The display of score when user wins or looses
            println("=================================");
            println("You chose: " + userChoice);
            println("Computer chose: " + computerChoice);
            println(result);
            println("=================================");
            
            // Updates players or computer wins after each round
            if(result.contains("You win!"))
            {
                playerWins++;
            }
            else if (result.contains("You lose!"))
            {
                computerWins++;
            }
            println("Score: Player " + playerWins + " , Computer " + computerWins);
            println("---------------------------------");
        }
        // The ending message if a player wins or looses
        if(playerWins==4)
        {
            println("Player Wins the game!");
        }
        else if (computerWins==4)
        {
            println("Computer Wins the Game");
        }
    }
}