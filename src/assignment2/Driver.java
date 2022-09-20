/* EE422C Assignment #2 submission by
 * 9/14/2022
 * Alexis Torres
 * at39625
 */
package assignment2;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        String userInput;
        boolean training = false;
        Scanner in = new Scanner(System.in);

        if(args.length > 0 && args[0].equals("1")){
        training = true;
        }

        UserText.intro(); //intro just runs
        while(true) {// runs an infinite loop so the game keeps looping until the user puts no or invalid for the game start prompt
        Game runningGame = new Game(training); // creates a game objects
        while (runningGame.getAttempts() > 0) { // constant loop of prompting user, analyzing the input and checking if they solved it
            runningGame.userPrompt();
            userInput = in.nextLine();
            runningGame.analyseUserInput(userInput);
            if (runningGame.solvedCodeStatus()){
                System.out.print("You Win !! \n\n");
                break;
                }
            }
        if(!runningGame.solvedCodeStatus()){
            System.out.println("Sorry, you are out of guesses. You lose, boo-hoo. ");
            System.out.println("The secret code was: " + runningGame.getSecretCode() + "\n");
        }
            UserText.newGamePrompt();
        }


    }
}
