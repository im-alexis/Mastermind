/* EE422C Assignment #2 submission by
 * 9/14/2022
 * Alexis Torres
 * at39625
 */

package assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static Scanner in = new Scanner(System.in); //i'm lazy and don't want to make many
    private int attempts;
    private String secretCode;
    private ArrayList resultHistory = new ArrayList<>();
    private boolean solved = false;
//private String secretCode;

public Game (boolean testing){
    secretCode = "YPYB";
    //secretCode = SecretCodeGenerator.getInstance().getNewSecretCode();
    attempts = GameConfiguration.guessNumber;
    if(testing == true){
        System.out.println("Game is on testing mode:");
        System.out.println("The code is: " + secretCode + "\n");
    }
}
public int getAttempts(){
    return attempts;
}
public static void newGamePrompt(){
    System.out.print("Are you ready for another game? (Y/N):");
    String response;
    response = in.nextLine();
    if(response.equals("Y") || response.equals("y")){
        System.out.println("\nGenerating secret code.....\n");
    }
    else if (response.equals("N")||response.equals("n")){
        System.out.println("\nWelp :(");
        System.exit(0);
    }
    else{
        System.out.println("\n Invalid Input");
        System.exit(0);
    }
}
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
   if(valid == false){
       System.out.println("\n-> INVALID GUESS\n");
   }
   if(valid == true){
       for(int i = 0; i < userInput.length(); i++){
           if(userInput.substring(i,i+1).equals(secretCode.substring(i,i+1))){
               bPeg++;
               if(bPeg == GameConfiguration.pegNumber){
                   solved = true;
               }
           } else if (!userInput.substring(i,i+1).equals(secretCode.substring(i,i+1))
                   && userInput.contains(secretCode.substring(i,i+1))) { //secretCode.contains(userInput.substring(i,i+1) ))
               wPeg++;
           }
       }

       attempts--;
       pegResult = userInput + " -> Result: " + bPeg + "B_" + wPeg + "W";
       resultHistory.add(pegResult);
       System.out.print("\n" + pegResult + "\n\n");
       int test;

   }
}

public  boolean solvedCodeStatus(){
    return solved;
}
public String getSecretCode(){
    return secretCode;
}
public static  void intro (){
    //Scanner in = new Scanner(System.in);
    System.out.println("Welcome to Mastermind.  Here are the rules.\n");
    System.out.println("This is a text version of the classic board game Mastermind.\n");
    System.out.println("The computer will think of a secret code. The code consists of 4\n" +
            "colored pegs. The pegs MUST be one of six colors: blue, green,\n" +
            "orange, purple, red, or yellow. A color may appear more than once in\n" +
            "the code. You try to guess what colored pegs are in the code and\n" +
            "what order they are in. After you make a valid guess the result\n" +
            "(feedback) will be displayed.\n");
    System.out.println("The result consists of a black peg for each peg you have guessed\n" +
            "exactly correct (color and position) in your guess. For each peg in\n" +
            "the guess that is the correct color, but is out of position, you get\n" +
            "a white peg. For each peg, which is fully incorrect, you get no\n" +
            "feedback.\n");
    System.out.println("Only the first letter of the color is displayed. B for Blue, R for\n" +
            "Red, and so forth. When entering guesses you only need to enter the\n" +
            "first character of each color as a capital letter.\n");
    System.out.print("You have " + GameConfiguration.guessNumber + " guesses to figure out the secret code or you lose the\n" +
            "game. Are you ready to play? (Y/N): ");
    String response;
    response = in.nextLine();
    if(response.equals("Y") || response.equals("y")){
        System.out.println("\nGenerating secret code.....\n");

    }
    else if (response.equals("N")||response.equals("n")){
        System.out.println("\nWelp :(");
        System.exit(0);
    }
    else{
        System.out.println("\n Invalid Input");
        System.exit(0);
    }

}




}
