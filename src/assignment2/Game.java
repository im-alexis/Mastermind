/* EE422C Assignment #2 submission by
 * 9/14/2022
 * Alexis Torres
 * at39625
 */

package assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Game {
    private int attempts;
    private final String secretCode;
    private final ArrayList<String>  resultHistory = new ArrayList<>(); // is going to hold the result history in the format userInput + "-> result: " +pegResult
    private boolean solved = false; // easy way to know when done is having a solved flag


public Game (boolean testing){
    this.secretCode = SecretCodeGenerator.getInstance().getNewSecretCode();
   this.attempts = GameConfiguration.guessNumber;
    if(testing){
        System.out.println("(for this example the secret code is " + secretCode + ")\n");
    }
    else {
        System.out.println("\n");
    }
}

    public int getAttempts(){
    return attempts;
}
    public  boolean getSolved(){return solved;}
    public String getSecretCode(){return secretCode;}
    public ArrayList<String> getResultHistory (){return resultHistory;}

    public void setSolved(boolean status){
        solved = status;
    }
    public void addToHistory (String peg){
        this.resultHistory.add(peg);
    }
    public void usedAttempt (){
        attempts -- ;
    }

    public void runGame(Scanner in){
       String userInput;
            while (this.getAttempts() > 0) { // constant loop of prompting user, analyzing the input and checking if they solved it
                UserText.userPrompt(this);
                userInput = in.nextLine();
                Pegs.analyseUserInput(userInput, this);
                if (solved){
                    System.out.print(" - You win !! \n\n");
                    break;
                }
            }
            if(!solved){
                System.out.println("Sorry, you are out of guesses. You lose, boo-hoo.\n");
                //System.out.println("The secret code was: " + secretCode + "\n");
            }

    }









}
