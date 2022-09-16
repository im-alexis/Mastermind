package assignment2;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        String userInput;
        Boolean training = false;


        Scanner in = new Scanner(System.in);
        if(args.length > 0 && args[0].equals("1")){
        training = true;
        }

        Game.intro();
        while(true) {
        Game runningGame = new Game(training);
        while (runningGame.getAttempts() > 0) {
            runningGame.userPrompt();
            userInput = in.nextLine();
            runningGame.analyseUserInput(userInput);
            if (runningGame.solvedCodeStatus()){
                System.out.print(" - You Win !! \n\n");
                break;
                }
            }
        if(!runningGame.solvedCodeStatus()){
            System.out.println("Sorry, you are out of guesses. You lose, boo-hoo.");
        }
        Game.newGamePrompt();
        }


    }
}
