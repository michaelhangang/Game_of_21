/**
 * Program Name: GameOf21App.java
 * Purpose:this class is used to play the CardGame Application 
 * Coder: Gang Han,  0811301
 * Date: Mar 5, 2018
 */
import java.util.*;
public class GameOf21App
{
	public static void main(String[] args)
	{
		//print a message to the screen 
		System.out.println("------------------------------------------");
		System.out.println("This application allows a player to play\n" + 
				"the Game of 21 against the computer.");
		System.out.println("------------------------------------------");
		
		// get the user's name
		System.out.print("Enter your name: ");
		Scanner in =new Scanner(System.in);
		String userName =in.next();
		System.out.println();
		System.out.println(userName + ",  good luck!\n");
		
		//create a GameOf21 object
		GameOf21 gameOf21 =new GameOf21(userName);
		// begin the game
		gameOf21.startGame();
		//close the input
		in.close();
		
	}
	// End of main method
}
// End of class