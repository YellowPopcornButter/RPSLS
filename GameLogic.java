import java.util.Random;
/*
 * Handles the main code behind RPSLS
 */
public class GameLogic 
{

    private String[] choices = {"Rock", "Paper", "Scissors", "Lizard", "Spock"}; // An Array of all possible choices
    private Random random = new Random(); // Random object for the computers choice generation
    
    /**
     *Checks if the users choice is a valid choice
     *@pram choice is the users choice
     *@return will return true if the users input is valid, elsewise will reutrn false
     */
    public boolean isValidChoice (String choice)
    {
        for(String validChoice : choices)
        {
            if(validChoice.equalsIgnoreCase(choice))
            {
                return true; //Will return true if the players choice was valid
            }
        }
        return false; //Will return false if the players choice was invalid 
    }
    
    /**
     *Generates a random choice for the computer
     *@return is the computers choice
     */
    public String getComputerChoice()
    {
        int index = random.nextInt(choices.length);// Gets a random index 
        return choices[index]; // Returns the choice back at that index
    }

    /**
     * Determines the winner based on what the user and computer chose
     * @pram userChoice is the players Choice
     * @pram computerChoice is the computers choice
     * @return is a string that will display the outcome of the game
     */

    public String determineWinner(String userChoice, String computerChoice)
    {
        if(userChoice.equalsIgnoreCase(computerChoice))
        {
            return "It's a tie"; // Returns a tie message if the computer and players choices are the same
        }
        //Switch the statement to determine an outcome
        switch (userChoice.toLowerCase())
        {
            case "rock":
                return (computerChoice.equals("Scissors") || computerChoice.equals("Lizard")) ? "Rock crushes " + computerChoice + ". You win!" : computerChoice + " beats Rock. You lose!";
            case "paper":
                return (computerChoice.equals("Rock") || computerChoice.equals("Spock")) ? "Paper covers " + computerChoice + ". You win!" : computerChoice + " beats Paper. You lose!";
            case "scissors":
                return (computerChoice.equals("Paper") || computerChoice.equals("Lizard")) ? "Scissors cuts " + computerChoice + ". You win!" : computerChoice + " beats Scissors. You lose!";
            case "lizard":
                return (computerChoice.equals("Paper") || computerChoice.equals("Spock")) ? "Lizard eats " + computerChoice + ". You win!" : computerChoice + " beats Lizard. You lose!";
            case "spock":
                return (computerChoice.equals("Rock") || computerChoice.equals("Scissors")) ? "Spock smashes " + computerChoice + ". You win!" : computerChoice + " beats Spock. You lose!";
            default:
                return "INVALID CHOICE";//Returns as an invalid choice if userChoice doesn't match any of these cases
        }
    }
}