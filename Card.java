/**
 * Program Name: Card.java
 * Purpose: the class is an aggregate class for CardSet
 * Coder: Gang Han,  0811301
 * Date: Mar 4, 2018
 */

public class Card
{
//Declare instance fields
	private Suit suit;
	private int rank;

// o-arg construtor	
	public Card()
	{
	 suit =suit.CLUBS;	
	 rank = 1;			
	}

// 1-arg construtor
	public Card(Suit suit)
	{
		this.suit =suit;
		rank =1;
	}
	
// 1-arg construtor
	public Card(Suit suit, int rank)
	{
		this.suit =suit;
		this.rank =rank;
	}

// getter and setter methods	
	/**
	 * Gets the suit of the object
	 * @return the suit
	 */
	public Suit getSuit()
	{
		return suit;
	}

	/**
	 * Sets the suit of the object
	 * @return the suit
	 */
	public void setSuit(Suit suit)
	{
		this.suit = suit;
	}

	/**
	 * Gets the rank of the object
	 * @return the rank
	 */
	public int getRank()
	{
		return rank;
	}

	/**
	 * Sets the rank of the object
	 * @return the rank
	 */
	public void setRank(int rank)
	{
		this.rank = rank;
	}
		
	/**
	 * Method Name:   isSameSuit
	 * Purpose:determine if two card have the same suit
	 * Parameters:Card
	 * Returns:  boolean
	 */
	public boolean isSameSuit(Card c)
	{		
		if(this.suit == c.suit)
			return true;
		else
			return false;
	}
		
	/**
	 * Method Name:   findFaceValue
	 * Purpose: checks the rank of this card and return one of face values
	 * Parameters:
	 * Returns:  String
	 */
	public String findFaceValue()
	{
	    String faceValue;
		switch(this.rank)
		{
		case 1: faceValue ="Ace"; break;
		case 2: faceValue ="Two"; break;
		case 3: faceValue ="Three"; break;
		case 4: faceValue ="Four"; break;
		case 5: faceValue ="Five"; break;
		case 6: faceValue ="Six"; break;
		case 7: faceValue ="Seven"; break;
		case 8: faceValue ="Eight"; break;
		case 9: faceValue ="Nine"; break;
		case 10: faceValue ="Ten"; break;
		case 11: faceValue ="Jack"; break;
		case 12: faceValue ="Queen"; break;
		case 13: faceValue ="King"; break;	
		default: faceValue = "the faceValue is invalid.";	
		}
		return faceValue;
	}
		
	/**
	 * Method Name:   findCardValue
	 * Purpose: checks the rank of this card, returns its card value
	 * Parameters:
	 * Returns:  int
	 */
	public int findCardValue()
	{
		int cardValue=0;
		switch(this.rank)
		{
		case 1: 
		case 2: 
		case 3: 
		case 4: 
		case 5: 
		case 6:
		case 7: 
		case 8: 
		case 9: 
		case 10: cardValue =this.rank; break;
		case 11: 
		case 12:
		case 13: cardValue = 10;	
		}
		return cardValue;
	}
	
	/**
	 * Method Name:   isGreaterThan
	 * Purpose: compares the rank of two cards to determine if this card's rank is greater   
	 * Parameters:Card
	 * Returns:  boolean
	 */
	public boolean isGreaterThan(Card c)
	{
		if(this.rank>c.rank)
		return true;
		else
		return false;
	}
	
	/**
	 * Method Name:   equals
	 * Purpose: compares the rank of two cards to determine if they are equal
	 * Parameters:Card
	 * Returns:  boolean
	 */
	public boolean equals(Card c)
	{
		if(this.rank==c.rank)
			return true;
		else
			return false;
		
		
	}
	
	//override toStirng() method
	public String toString()
	{
		return String.format("%-3s of %s", findFaceValue(),suit);			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
// End of class