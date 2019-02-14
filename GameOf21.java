/**
 * Program Name: GameOf21.java
 * Purpose: the GameOf21  class
 * Coder: Gang Han,  0811301
 * Date: Mar 5, 2018
 */
import java.util.*;
public class GameOf21
{
	private Deck deck;
	private Hand user;
	private Hand computer;
	
	private static Scanner in =new Scanner(System.in);
	
	private static boolean isBustsOfUser ; // used to check if total value of the user is bust 
	private static boolean isBustsOfComputer ; //used to check if total value of the computer is bust 
	//1-arg constructor 
	public GameOf21(String player)
	{
		deck = new Deck();
		user = new Hand(player);
		computer = new Hand("computer");
	}

	/**
	 * Gets the deck of the object
	 * @return the deck
	 */
	public Deck getDeck()
	{
		return deck;
	}

	/**
	 * Sets the deck of the object
	 * @return the deck
	 */
	public void setDeck(Deck deck)
	{
		this.deck = deck;
	}

	/**
	 * Gets the user of the object
	 * @return the user
	 */
	public Hand getUser()
	{
		return user;
	}

	/**
	 * Sets the user of the object
	 * @return the user
	 */
	public void setUser(Hand user)
	{
		this.user = user;
	}

	/**
	 * Gets the computer of the object
	 * @return the computer
	 */
	public Hand getComputer()
	{
		return computer;
	}

	/**
	 * Sets the computer of the object
	 * @return the computer
	 */
	public void setComputer(Hand computer)
	{
		this.computer = computer;
	}
	
	/**
	 * Method Name:   startGame
	 * Purpose: begin the game by calling the printTitle(),printInstrctuionS() and playGame() methods
	 * Parameters:
	 * Returns:  void
	 */
	public void startGame()
	{
		 printTitle();
		 printInstructions();
		 playGame();
	}
	
	/**
	 * Method Name:   printTitle
	 * Purpose: prints the title of the game
	 * Parameters:
	 * Returns:  void
	 */
	public void printTitle()
	{
		System.out.println("------------------------------------------");
		System.out.println("Welcome to the Game of 21!");
		System.out.println("------------------------------------------");
	}
	
	/**
	 * Method Name:   printInstructions
	 * Purpose: prints the instructions for the game
	 * Parameters:
	 * Returns:  void
	 */
	public void printInstructions()
	{
		System.out.println("HOW TO PLAY:");
		System.out.println("------------------------------------------");
		System.out.println("The objective of the game is get the closest to 21 without going over. \n"
				+          "The player and the computer are dealt 2 cards. The player’s cards are \n"
				+          "both face up, but the computer’s cards are one up and one down. The \n"
				+          "player is allowed to draw additional cards to improve his hand,\n "
				+          "without going over 21. The computer can then choose to draw cards;\n "
				+          "though the computer will not draw if the player has busted.\n");		
	}
	
	/**
	 * Method Name:   playGame
	 * Purpose:displays the decks size.Then playGame()deals two cards to each player.call displayAllCards() and
	 *        call displayVisbleCards().Then playGame() displays each player's hand and printWinner() and playAgain() methods.
	 * Parameters:
	 * Returns:  void
	 */
	public void playGame()
	{
		System.out.println("The deck has "+ deck.size() + " cards.\n");
		user.hit(deck.dealCard());
		user.hit(deck.dealCard());
		computer.hit(deck.dealCard());
		computer.hit(deck.dealCard());
		System.out.println(user.getPlayerName() +" has 2 cards:");
	    user.displayAllCards();
	    System.out.println("\nComputer has 2 cards:");
	    computer.displayVisibleCards();
	    isBustsOfComputer = false;
	    isBustsOfUser = false;
	    if(user.totalHand()==21 ||computer.totalHand()==21)  //check if user or computer has 21 points at beginning of game 
	    {
	    	printWinner();
			playAgain();	    	
	    }
	    else
	    {	
		userDraws();
		computerDraws();	
		printWinner();
		playAgain();
	    }
	}
	
	/**
	 * Method Name:   userDraws
	 * Purpose:allow user to draw additional cards
	 * Parameters:
	 * Returns:  void
	 */
	public void userDraws()
	{	
		do
		{
		  System.out.print("\nDo you want another card (Y/N)? ");
		  String answer =in.next(); // get user input 
		  if(answer.equals("y") || answer.equals("Y") )
		  {
			if(deck.size()==0)  // if the cards of deck is 0,  end the game
				break;
			else {
			  user.hit(deck.dealCard());
			  System.out.println("\n"+user.getPlayerName() +" has "+ user.cards.size()+ " cards:");
			  user.displayAllCards();
			  //if  user's points are more than 21 and  user will bust 
			  if(user.totalHand()>21) 
			  {
				System.out.println("\n"+user.getPlayerName() + " busts!\n" + "Computer stands.\n");
				isBustsOfUser = true;
				break;
			  }
			} 
		  }//end of if
		 
		  else if(answer.equals("n")|| answer.equals("N"))
		  {		
			System.out.println("\n"+user.getPlayerName()+"  stands.");
			break;
		  }
		  // prints the message to prompt user to enter again 
		  else 
			System.out.println("Invalid input! Please input again!");		     				
	     }while(true);  
		  
		
	}//end of method
	
	/**
	 * Method Name:   computerDraws
	 * Purpose:allow computer to draw additional cards
	 * Parameters:
	 * Returns:  void
	 */
	public void computerDraws()
	{
		//check if user is bust  
		if(isBustsOfUser)
		  {
			System.out.println("Computer has 2 cards:");	
			computer.displayAllCards();
		  }//end of if 
	   else
		  {
		   do {
			   if(deck.size()==0) 
					  break;	   
			   //if  the points computer has are less than points of user' visible cards , computer must hit 
			   else if(computer.totalHand()<user.cards.get(0).findCardValue()+user.cards.get(1).findCardValue())
			       computer.hit(deck.dealCard());
			  // if the points computer has are more than 18, computer must stands 
			   else if(computer.totalHand()>=18)
				   break;
			   // if random number is 2, computer stands 
			   else if((int)(Math.random()*2+1)==2) 
				   break;
			   // else, computer wil hit a card
			   else
				   computer.hit(deck.dealCard());
			       System.out.println("\nComputer has  "+ computer.cards.size()+ "  cards:");	
			       computer.displayAllCards();
			       if(computer.totalHand()>21)
			       {
				    System.out.println( "\nComputer busts!\n");
				    System.out.println("Computer has  "+ computer.cards.size()+ "  cards:");
				    computer.displayAllCards();
				    isBustsOfComputer=true;
				    break;
			       }//end if  
		      }while(true);
		  
		   if(!isBustsOfComputer)
		   System.out.println("\nComputer stands.");	
		  }//end of else
	 }//end of method
	
	/**
	 * Method Name:   printWinner
	 * Purpose: checks the total points of each winner.
	 * Parameters:
	 * Returns:  void
	 */
	public void printWinner()
	{
		 System.out.println("\n--------------------------------");
		 System.out.println("Game of 21 - Final Score"); 
		 System.out.println("--------------------------------");
		 System.out.printf("%-8s %-12s %-2d\n",user.getPlayerName(), "points:",user.totalHand());
		 System.out.printf("%-8s %-12s %-2d\n","Computer", "points:", computer.totalHand());
		 System.out.println("--------------------------------");
		 if(isBustsOfUser)
			 System.out.println("Computer wins!");
		 else if(isBustsOfComputer)
			 System.out.println(user.getPlayerName()+"  wins!");
		 else if(user.totalHand()>computer.totalHand())
			 System.out.println(user.getPlayerName()+"  wins!");
		 else if(user.totalHand()<computer.totalHand())
			 System.out.println("Computer wins!");
		 else 
			 System.out.println("A draw!");
		 System.out.println("--------------------------------\n");
	}
	
	/**
	 * Method Name:   playAgain
	 * Purpose: prompts the user to play again
	 * Parameters:
	 * Returns:  void
	 */
	public void playAgain()
	{
	 do {
		 System.out.print("Play another game (Y/N)? ");
		 String answer =in.next();
		 if(answer.equals("y") || answer.equals("Y"))
		 {
			 if(deck.size()<4)  // if  cards of deck are less than 4 and  end game 
			 {
			 System.out.println("\nThe deck has only "+ deck.size() +" cards left."); 
			 System.out.print("Thanks for playing! Bye!");
			 break;
			 }
			 else
			 {
			 user.emptyHand();
			 computer.emptyHand();
			 playGame();
			 break;
			 }
		 }
		 else if(answer.equals("n")|| answer.equals("N")) {
	         System.out.print("Thanks for playing! Bye!");	
	         break;
		     }
		 else 
			 System.out.println("Invalid input! Please input again!"); // validate the input      				
	   }while(true);
	}	
}// End of class