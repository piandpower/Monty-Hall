import java.util.*;
/**
 * @author sramados
 *
 */

public class Game {
    Door door1, door2, door3;
    static int numberOfWins = 0;			//keeps track of number of wins
    static Random r = new Random();
    int monteDoor = 0;
    int contestantDoor = 0;
    int grandPrizeDoor = 0;
    
    /*
     * Creates 3 door objects. Selects one of the three doors in random as a winning door.
     */
    void setUpGame() {
    	contestantDoor=0;
    	monteDoor=0;
        door1 = new Door();door2 = new Door();door3 = new Door();

        grandPrizeDoor = r.nextInt(3);
        switch(grandPrizeDoor) {
        case 0:
            door1.hasGrandPrize = true; break;
        case 1:
        	door2.hasGrandPrize = true; break;
        case 2:
        	door3.hasGrandPrize = true; break;
        	}
        }
    
    /*
     * Contestant chooses one door in random.
     */
    void contestantChooseDoor() {
    	contestantDoor = r.nextInt(3);
        switch(contestantDoor) {
        case 0: door1.chosenByContestant = true; break;
        case 1: door2.chosenByContestant = true; break;
        case 2: door3.chosenByContestant = true; break;
        }
    }
    
    /*
     * record Monte's selection of door at random and change state of door to open
     */
    void monteChooseDoor() {
    	//boolean isWinDoor;
    	//make sure Monte doesn't choose the same door as the contestant and also doesn't choose door with prize.
    		do {
    			monteDoor = r.nextInt(3);
    		}while((monteDoor == contestantDoor) || (monteDoor == grandPrizeDoor));
    		
    	//Monte opens the door
    	switch(monteDoor) {
        case 0: door1.open = true; break;
        case 1: door2.open = true; break;
        case 2: door3.open = true; break;
        }
    }
    
    /*
     * this method gets called if the contestant has decided to switch.
     * The 'contestantDoor' door is updated accordingly.
     */
    void doYouSwitch() {
    		//find the other door which the contestant can switch to.
    		int otherDoor = 3 - ( monteDoor + contestantDoor );
    		
    		//contestant has chosen to switch. so make his previous door selection false.
    		switch(contestantDoor) {
            case 0: door1.chosenByContestant = false; break;
            case 1: door2.chosenByContestant = false; break;
            case 2: door3.chosenByContestant = false; break;
            }
    		
    		//make his new door selection true.
    		contestantDoor = otherDoor;
    		switch(contestantDoor) {
            case 0: door1.chosenByContestant = true; break;
            case 1: door2.chosenByContestant = true; break;
            case 2: door3.chosenByContestant = true; break;
            }
    }
    
    /*
     * opens the door chosen by contestant and checks if it is the winning door.
     */
    void checkIfWon() {
    	boolean win = false;
    	
    	//Contestant opens his door.
    	switch(contestantDoor) {
        case 0: door1.open = true; break;
        case 1: door2.open = true; break;
        case 2: door3.open = true; break;
        }
    	
    	//check if contestant has won.
    	switch(contestantDoor) {
        case 0:
        	if(door1.hasGrandPrize)
        		win = true;
        	break;
        case 1: 
        	if(door2.hasGrandPrize)
        		win = true;
        	break;
        case 2: 
        	if(door3.hasGrandPrize)
        		win = true;
        	break;
        }    	
    	if(win)
    		numberOfWins++;
    }
    
    /*
     * returns number of times the contestant has won in one simulation
     */
    int getNumberofWins() {
    	return numberOfWins++;
    }
    
    /*
     * set of debug statement to get state of doors
     */
    void printStateOfDoors() {
        System.out.println("Door 1 is " +
            (door1.open ? "    open, " : "not open, ") +
            (door1.hasGrandPrize ? "is     the grand prize, and " : "is not the grand prize, and ") +
            (door1.chosenByContestant ? "is     chosen." : "is not chosen.") );
        System.out.println("Door 2 is " +
            (door2.open ? "    open, " : "not open, ") +
            (door2.hasGrandPrize ? "is     the grand prize, and " : "is not the grand prize, and ") +
            (door2.chosenByContestant ? "is     chosen." : "is not chosen.") );
        System.out.println("Door 3 is " +
            (door3.open ? "    open, " : "not open, ") +
            (door3.hasGrandPrize ? "is     the grand prize, and " : "is not the grand prize, and ") +
            (door3.chosenByContestant ? "is     chosen." : "is not chosen.") );
    }

}