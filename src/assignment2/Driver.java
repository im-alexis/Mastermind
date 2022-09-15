package assignment2;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        String response;
        Boolean training = false;
      if(args.length > 0 && args[0].equals("1")){
      training = true;
        }

        Scanner in = new Scanner(System.in);
        Game.intro();
        response = in.nextLine();
        if(response.equals("Y") || response.equals("y")){
            System.out.println("\nGenerating secret code.....\n");
            Game runningGame = new Game(training);
        }
        else if (response.equals("N")||response.equals("n")){
            System.out.println("\nWelp :(");
            return;
        }
        else{
            System.out.println("\n Invalid Input");
        }
    }
}
