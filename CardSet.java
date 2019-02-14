/**
 * Program Name: CardSet.java
 * Purpose: this is an abstract superclass
 * Coder: Gang Han,  0811301
 * Date: Mar 4, 2018
 */
import java.util.*;
public abstract class CardSet
{
	protected ArrayList<Card> cards;
	
	//constructor
	public CardSet()
	{
		cards =new ArrayList<Card>();
	}
	// 1-arg constructor 
	public CardSet(int numberOfCards)
	{
		cards =new ArrayList<Card>(numberOfCards);
	}
	
	//abstract methods 
	public abstract void displayAllCards();
	
	public abstract void displayVisibleCards();
	
}
// End of class