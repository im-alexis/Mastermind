/* EE422C Assignment #2 submission by
 * 9/14/2022
 * Alexis Torres
 * at39625
 */
package assignment2;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        boolean training = false;
        Scanner in = new Scanner(System.in);

        if(args.length > 0 && args[0].equals("1")){
        training = true;
        }
        UserText.intro(); //intro just runs
        UserText.gameStartResponse(in);
        while (true) {
            Game runningGame = new Game(training);
            runningGame.runGame(in);
            UserText.newGamePrompt();
            UserText.gameStartResponse(in);
        }






    }
}
