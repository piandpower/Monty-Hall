import java.util.Scanner;
/**
 * @author sramados
 *
 */

public class PlayManyGames {
    public static void main(String[] args) {
        Game theGame = new Game();
        Scanner keyboard = new Scanner(System.in);
    	System.out.println("Do you want to always switch? Enter 'y' (or) 'n'.");
    	String toSwitch = keyboard.nextLine();
    	boolean ifSwitch = false;
    	if (toSwitch.equalsIgnoreCase("y"))
    		ifSwitch = true;
    	else if (!toSwitch.equalsIgnoreCase("n")) {
    		System.out.println("Please re-run program and give a 'y' or a 'n'!");
    		System.exit(0);    	
    	}
    	
    	//Run through the Game sequence for 10000 times.
    	for( int i=0; i<10000; i++) {
    		theGame.setUpGame();
    		theGame.contestantChooseDoor();
    		theGame.monteChooseDoor();
    		if(ifSwitch)
    			theGame.doYouSwitch();
    		theGame.checkIfWon();
    	}
    	int numberWins = theGame.getNumberofWins();
    	System.out.println("Number of wins is "+numberWins+" out of "+"10000");
    }
}