package edu.unca.csci202;

/**
 * Playing Card Objects
 * @author Ben Yaniero
 *
 */
public class PlayingCard implements Card {
	private int points; //represents the vale of this card in the game. 
	/*
	 * Aces are worth 1 point
	 * Face cards (jack, queen, king) are worth 10
	 * Everything else is it's card value 
	 */
	private String display; //String variable representing the rank (Ace, Two,...,Ten,Jack,Queen,King,) and the suit of the card (Spades, Hearts, Diamonds, Clubs)
	
	
	/**
	 * Constructor
	 * Card card = new PlayingCard( points, values[v] + suits[s] ); //how it's used in the CardGame.java Class
	 * @param points //points it's worth
	 * @param display //represents the rank and suit
	 */
	public PlayingCard(int points, String display) {
		//super();
		this.points = points;
		this.display = display;
	}

	

	@Override
	/**
	 * Printable string of the card
	 * @return display value of card
	 */
	public String toString() {
		//return "PlayingCard [points=" + points + ", display=" + display + "]";
		return this.display;
	}



	@Override
	/**
	 * Get the number of points this card is worth
	 * @return points card is worth
	 */
	public int getPoints() {
		return this.points;
	}

	@Override
	/**
	 * Compare to another card
	 * @param card to compare to this card
	 * @return 0 if this object is worth the same number of 
	 * 		   points as the 'card' argument, a positive 
	 *         value (e.g. 1) if this object has more points
	 *         than the argument 'card', and negative 
	 *         (e.g. -1) if this object has fewer points 
	 *         than the 'card' argument.
	 */
	public int compareTo(Card card) {
		
		if(this.points == card.getPoints()) {
			return 0;
		}
		else if (this.points > card.getPoints()) {
			return 1;
		}
		//default case if this < card
		return -1;
	}

}
