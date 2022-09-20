/* EE422C Assignment #2 submission by
 * 9/14/2022
 * Alexis Torres
 * at39625
 */

package assignment2;

import java.util.ArrayList;
import java.util.Arrays;


public class Game {
    private int attempts;
    private final String secretCode;
    private final ArrayList<Object>  resultHistory = new ArrayList<>(); // is going to hold the result history in the format userInput + "-> result: " +pegResult
    private boolean solved = false; // easy way to know when done is having a solved flag


public Game (boolean testing){
    this.secretCode = SecretCodeGenerator.getInstance().getNewSecretCode();
    //secretCode = "YPYB";
    //secretCode = "YOYR";
    //secretCode = "YYYY";
   // secretCode = "GGOG";
    //secretCode = "RBYB";
    //secretCode = "BPBO";
   this.attempts = GameConfiguration.guessNumber;
    if(testing){
        System.out.println("Game is on testing mode:");
        System.out.println("The code is: " + this.secretCode + "\n");
    }
}

public int getAttempts(){
    return attempts;
}
public  boolean solvedCodeStatus(){return solved;}
    public String getSecretCode(){return secretCode;}
    public ArrayList<Object> getResultHistory (){return resultHistory;}

public void userPrompt (){
    System.out.print("You have " + this.attempts + " guesses left.\n"
    +"What is your next guess?\n" + "Type in the characters for your guess and press enter.\n" +
            "Enter guess: ");

}

private boolean isValid(String userInput){
    if(userInput.length() != GameConfiguration.pegNumber){return false;} // if it is not equal to the chars needed then its automatically not valid
    for(int i = 0; i < userInput.length(); i++){
       if(!Arrays.asList(GameConfiguration.colors).contains(userInput.substring(i,i+1))){ // if it dones not cointain the color then it is not valid
           return false;
       }
    }
    return true;
}

public void analyseUserInput (String userInput) {
    ArrayList <Object> bIndex = new ArrayList<>(); // holding the index of the white and black pegs
    ArrayList <Object> wIndex = new ArrayList<>();
    int bPeg = 0;
    int wPeg = 0;
    String pegResult;
    if (userInput.equals("HISTORY") || userInput.equals("history") || userInput.equals("History")) { // can use different variations of history to access
        System.out.println("\nGuess          Result");
        for (int i = 0; i < this.resultHistory.size(); i++) {
            System.out.println(this.resultHistory.get(i));
        }
        System.out.println("\n");
        return;
        }
    boolean valid = isValid(userInput);
    if (!valid) {
        System.out.println("\n" + userInput + "-> INVALID GUESS\n");
        return;
        }
    for (int i = 0; i < userInput.length(); i++) { //doing bPegs first makes tracking what is has been found easier
        if (userInput.substring(i, i + 1).equals(this.secretCode.substring(i, i + 1))) {
            bPeg++;
            bIndex.add(i);
            if (bPeg == GameConfiguration.pegNumber) {
                this.solved = true;
            }
        }
    }
    boolean doneWithCol; // since I am checking multiple pegs, this help to know when the white peg has been placed in the right spot
    for(int i = 0; i < userInput.length(); i++){
        doneWithCol = false;
        if(!bIndex.contains(i)){
            for(int j = 0; j < userInput.length(); j++) {
                if(userInput.substring(i, i+1).equals(this.secretCode.substring(j,j+1))){
                    if(!bIndex.contains(j) && !wIndex.contains(j) && !doneWithCol){ // if the color has not been found and wPeg has not been incremented
                        wPeg++;
                        wIndex.add(j);
                        doneWithCol = true; // this to not go back into the if statements and increment wPeg w/ repeats
                    }
                }
            }
        }
    }
    this.attempts--;
    pegResult = userInput + " -> Result: " + bPeg + "B_" + wPeg + "W";
    this.resultHistory.add(pegResult);
    System.out.print("\n" + pegResult + "\n\n");

}




}
