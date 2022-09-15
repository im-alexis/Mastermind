/* EE422C Assignment #2 submission by
 * 9/14/2022
 * Alexis Torres
 * at39625
 */

package assignment2;

public class Game {

private int attempts;
private String secretCode;
//private String secretCode;

public Game (boolean testing){
    secretCode = SecretCodeGenerator.getInstance().getNewSecretCode();
    attempts = GameConfiguration.guessNumber;
    if(testing == true){
        System.out.println("Game is on testing mode");
        System.out.println("The code is: " + secretCode);
    }


}
public void userPrompt (){

}
public void analyseUserInput (){

}

static public void intro (){
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

}




}
