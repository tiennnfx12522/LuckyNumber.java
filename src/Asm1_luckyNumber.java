/*
    This program was developed to create a simple game called luckyNumber
    The game starts with the program creates a random number between 0 and maximum (the pre-defined maximum here is 50)
    The player interact with prompts appear in the console to play the game
    When the player decides to stop playing, the program displays the overall results
*/
import java.util.Scanner; // import Scanner
public class Asm1_luckyNumber {

    // main method to control the flow of the program
    public static void main(String[] args) {
        // call report method
        report();
    }

    // create method to initiate the game and return an array with information for report method
    public static int[] play() {

        // create new Scanner object
        Scanner input = new Scanner(System.in);

        // declare variables
        char choice;
        int guessCounter;
        int totalGames = 0;
        int totalGuesses = 0;
        int bestGame = 100;

        // create array with 3 values corresponding to totalGames, totalGuesses, bestGame
        int[] arr = new int[3];

        // use do while loop to keep the game going until the player decides to stop
        do {
            // Generate a random number between 0 and 50
            int luckyNumber = (int) (Math.random() * 50 + 1);

            System.out.println("I'm thinking of a number between 0 and 50...");
            System.out.print("Your guess? ");
            int guess = input.nextInt();
            guessCounter = 1; // reset guess counter for each iteration

            // use if else to check whether the guess is greater than or less than the lucky number
            while (guess != luckyNumber) {
                if (guess > luckyNumber) {
                    System.out.println("It's lower.");
                } else {
                    System.out.println("It's higher.");
                }

                // update counter before the new guess
                guessCounter++;
                System.out.print("Your guess? ");
                guess = input.nextInt();
            }

            // announce correct guess
            System.out.println("You got it right in " + guessCounter + " guesses!");

            // update variables
            totalGames++;
            totalGuesses += guessCounter;
            if (guessCounter < bestGame) {
                bestGame = guessCounter;
            }

            // update values in array
            arr[0] = totalGames;
            arr[1] = totalGuesses;
            arr[2] = bestGame;

            // ask player whether to play again
            System.out.print("Do you want to play again? ");
            choice = input.next().toLowerCase().charAt(0);
        }
        while (choice == 'y');
        // end do while loop and return the array
        return arr;
    }

    public static void report() {
        // initiate play method to get the array
        int[] arr = play();

        //calculate guesses/games and round it to 1 decimal
        double avgGuess = (double) arr[1] / arr[0];
        avgGuess = Math.round(avgGuess* 10) / 10.0;

        // display results
        System.out.println("Overall results:");
        System.out.println("Total games   = " + arr[0]);
        System.out.println("Total guesses = " + arr[1]);
        System.out.println("Guesses/games = " + avgGuess);
        System.out.println("Best games = " + arr[2]);
    }
}


