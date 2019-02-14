/**
 * Program Name: Hand.java
 * Purpose: a subclass of CardSet and an aggregate class for GameOf21 class
 * Coder: Gang Han,  0811301
 * Date: Mar 4, 2018
 */

public class Hand extends CardSet
{
	private String playerName;
	
	//1-arg construtor 
	public Hand(String playerName)
	{
		super();
		this.playerName = playerName;		
	}

	/**
	 * Gets the playerName of the object
	 * @return the playerName
	 */
	public String getPlayerName()
	{
		return playerName;
	}

	/**
	 * Sets the playerName of the object
	 * @return the playerName
	 */
	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
	}
	
	/**
	 * Method Name:   hit
	 * Purpose: adds a Card object to a play's hand 
	 * Parameters:Card
	 * Returns:  void
	 */
	public void hit(Card c)
	{
		cards.add(c);
	}
	
	/**
	 * Method Name:   discard
	 * Purpose:removes a card object from a player's hand 
	 * Parameters:int
	 * Returns:  void
	 */
	public void discard(int index)
	{
		cards.remove(index);
	}
	
	/**
	 * Method Name:   discard
	 * Purpose: removes card objects from a player's hand given the beginning positon and the end position 
	 * Parameters:int
	 * Returns:  void
	 */
	public void discard(int begIndex,int endIndex)
	{
		for(int i=begIndex; i<endIndex;++i)
		{
			cards.remove(i);
		}
	}
	
	/**
	 * Method Name:   totalHand
	 * Purpose:finds the total value of a player's hand 
	 * Parameters:
	 * Returns:  int
	 */
	public int totalHand()
	{
		int totalValue = 0;
		for(Card a:cards)
		{
			if( a.findFaceValue() =="Ace")
				totalValue += findAceValue(totalValue);
			else
			totalValue += a.findCardValue();			
		}
		return totalValue;		
	}
	
	/**
	 * Method Name:   totalVisibleHand
	 * Purpose: returns the total of the cards that are visible 
	 * Parameters:
	 * Returns:  int
	 */
	public int totalVisibleHand()
	{
		int totalValue = 0;
		for(int i = 1; i<cards.size();++i )
		{
			if( cards.get(i).findFaceValue() =="Ace")
				totalValue += findAceValue(totalValue);
			else
			totalValue += cards.get(i).findCardValue();		
		}
		return totalValue;		
	}
		
	/**
	 * Method Name:   findAceValue
	 * Purpose: a helper method which check if the player's current hand total plus 11 goes over 21. then returns acs as 1,
	 *          otherwise retunrs ace as 11
	 * Parameters:int
	 * Returns:  int
	 */
	private int findAceValue(int total)
	{
		if(total +11>21)
		return 1;
		else
		return 11;
	}
	
	/**
	 * Method Name:   emptyHand
	 * Purpose: empties a player's hand of cards
	 * Parameters:
	 * Returns:  void
	 */
	public void emptyHand()
	{		
		cards.clear();
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
		 for(int i =0; i <cards.size();++i)
		 {
	     System.out.println((i+1) +") "+ cards.get(i));
		 }
		 else if(start == 1)
		 for(int i =1;i<cards.size();i++)
		 {
	     System.out.println((i+1) +") "+cards.get(i));
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