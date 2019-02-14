/**
 * Program Name: Deck.java
 * Purpose: this a subclass of CardSet and an aggregate class for GameOf21 class
 * Coder: Gang Han,  0811301
 * Date: Mar 4, 2018
 */
import java.util.*;
public class Deck extends CardSet
{
	
	public static  final int SIZE =52;
	//0-arg constructor
	public Deck()
	{
		super(SIZE);
		populateDeck();
		shuffle();		
	}
	
	/**
	 * Method Name:   populateDeck
	 * Purpose: loads an ArrayList<Card> deck with 52 Card objects made up of 4 suits
	 * Parameters:
	 * Returns:  void
	 */
	public void populateDeck()
	{
		Suit [] suit = {Suit.CLUBS, Suit.DIAMONDS, Suit.HEARTS, Suit.SPADES};
		for(int i =0; i<suit.length;i++)
		{
			for(int l =1; l<=13; l++)
			{	
		        this.cards.add ( new Card(suit[i],l));
			}//inner loop end
		}//outter loop end	
	}
	
	/**
	 * Method Name:   shuffle
	 * Purpose: shuffles the deck in random order
	 * Parameters:
	 * Returns:  void
	 */
	public void shuffle()
	{
	ArrayList<Card> cardsHolder =new ArrayList<Card>(SIZE); // create a new Arraylist in order to hold elements of cards object
	int number =51;
	for (int i =0; i<52;++i)  //  to take  52 cards   out of cards object
	  {
		int randomIndexOfcards =(int)(Math.random()*number ); //generate a random index of cards object  
		cardsHolder.add( cards.get(randomIndexOfcards));// copy the element in cards object to the new Arraylist
		cards.remove(randomIndexOfcards);  //  remove the element in cards object
		number--;	
	  }//end  of loop 
	
	cards.addAll(cardsHolder);  // copy new Arraylist to cards object  		
	}//end method
	
	/**
	 * Method Name:   dealCard
	 * Purpose: deal cards to player and computer 
	 * Parameters:
	 * Returns:  Card
	 */
	public Card dealCard()
	{
		Card dealCard = cards.get(0);
		cards.remove(0);
		return  dealCard ;
	}
	
	/**
	 * Method Name:   size
	 * Purpose: re
	 * Parameters: returns the size of the deck
	 * Returns:  int
	 */
	public int size()
	{
		return cards.size();
	}
	
	/**
	 * Method Name:   displayCards
	 * Purpose: a helper method to show  the cards
	 * Parameters:int
	 * Returns:  void
	 */
	private void displayCards(int start)
	{
	    if(start == 0)
	    for(Card a: cards)
        {
	       System.out.println(a);
	    }
	    else if(start == 1)
	    for(int i =1;i<cards.size();i++)
	    {
	       System.out.println(cards.get(i));
	    }	
	}
	
	/**
	 * Method Name:   displayAllCards
	 * Purpose: a helper method to show all the cards
	 * Parameters:
	 * Returns:  void
	 */
	public void displayAllCards()
	{
		displayCards(0);
	}
	
	/**
	 * Method Name:   displayAllCards
	 * Purpose: a helper method to show visible the cards
	 * Parameters:
	 * Returns:  void
	 */
	public void displayVisibleCards()
	{
		displayCards(1);		
	}
}
// End of class