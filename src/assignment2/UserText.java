/* EE422C Assignment #2 submission by
 * 9/14/2022
 * Alexis Torres
 * at39625
 */

package assignment2;

import java.util.Scanner;

public class UserText {

public static void gameStartResponse () {
        Scanner in = new Scanner(System.in);
        String response;
        response = in.nextLine();
        if(response.equals("Y") || response.equals("y")){
            System.out.println("\nGenerating secret code.....\n");

        }
        else if (response.equals("N")||response.equals("n")){
            System.out.println("\nWelp ight then :'(");
            System.exit(0);
        }
        else{
            System.out.println("\n Invalid Input");
            System.exit(0);
        }

    }

    public static  void intro (){
        //Scanner in = new Scanner(System.in);
        System.out.println("Welcome to Mastermind.  Here are the rules.\n");
        System.out.println("This is a text version of the classic board game Mastermind.\n");
        System.out.println("""
            The computer will think of a secret code. The code consists of 4
            colored pegs. The pegs MUST be one of six colors: blue, green,
            orange, purple, red, or yellow. A color may appear more than once in
            the code. You try to guess what colored pegs are in the code and
            what order they are in. After you make a valid guess the result
            (feedback) will be displayed.
            """);
        System.out.println("""
            The result consists of a black peg for each peg you have guessed
            exactly correct (color and position) in your guess. For each peg in
            the guess that is the correct color, but is out of position, you get
            a white peg. For each peg, which is fully incorrect, you get no
            feedback.
            """);
        System.out.println("""
            Only the first letter of the color is displayed. B for Blue, R for
            Red, and so forth. When entering guesses you only need to enter the
            first character of each color as a capital letter.
            """);
        System.out.print("You have " + GameConfiguration.guessNumber + " guesses to figure out the secret code or you lose the\n" +
                "game. Are you ready to play? (Y/N): ");
        UserText.gameStartResponse();
    }
    public static void newGamePrompt(){
        System.out.print("Are you ready for another game? (Y/N):");
        UserText.gameStartResponse();
    }

}
