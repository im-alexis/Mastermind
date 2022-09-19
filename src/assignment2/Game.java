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
    private final static Scanner in = new Scanner(System.in); //I'm lazy and don't want to make many scanners
    private int attempts;
    private final String secretCode;
    private final ArrayList<Object>  resultHistory = new ArrayList<>();
    private boolean solved = false;
//private String secretCode;

public Game (boolean testing){
    secretCode = SecretCodeGenerator.getInstance().getNewSecretCode();
    //secretCode = "YPYB";
    attempts = GameConfiguration.guessNumber;
    if(testing){
        System.out.println("Game is on testing mode:");
        System.out.println("The code is: " + secretCode + "\n");
    }
}
public int getAttempts(){
    return attempts;
}
public  boolean solvedCodeStatus(){return solved;}
    public String getSecretCode(){return secretCode;}
    public ArrayList<Object> getResultHistory (){return resultHistory;}

public void userPrompt (){
    System.out.print("You have " + attempts + " guesses left.\n"
    +"What is your next guess?\n" + "Type in the characters for your guess and press enter.\n" +
            "Enter guess: ");

}
private boolean isValid(String userInput){
    if(userInput.length() != 4){return false;}
    for(int i = 0; i < userInput.length(); i++){
       if(!Arrays.asList(GameConfiguration.colors).contains(userInput.substring(i,i+1))){
           return false;
       }
    }
    return true;
}
public void analyseUserInput (String userInput){
    int bPeg = 0;
    int wPeg = 0;
    String pegResult;
    if(userInput.equals("HISTORY") ||userInput.equals("history") || userInput.equals("History") ){
        System.out.println("\n");
        for(int i = 0; i < resultHistory.size(); i++){
            System.out.println(resultHistory.get(i));
        }
        System.out.println("\n");
        return;
    }
   boolean valid = isValid(userInput);
   if(!valid){
       System.out.println("\n-> INVALID GUESS\n");
   }
   if(valid){
       for(int i = 0; i < userInput.length(); i++){
           if(userInput.substring(i,i+1).equals(secretCode.substring(i,i+1))){
               bPeg++;
               if(bPeg == GameConfiguration.pegNumber){
                   solved = true;
               }
           } else if (!userInput.substring(i,i+1).equals(secretCode.substring(i,i+1))
                   && userInput.contains(secretCode.substring(i,i+1))
                   && !secretCode.contains(userInput.substring(i,i+1))) { //secretCode.contains(userInput.substring(i,i+1))
               wPeg++;
           }
       }
       attempts--;
       pegResult = userInput + " -> Result: " + bPeg + "B_" + wPeg + "W";
       resultHistory.add(pegResult);
       System.out.print("\n" + pegResult + "\n\n");
   }
}







}
