package edu.unca.csci202;

import java.util.Arrays;

/**
 * Contains the players hand for use in CardGame.java
 * 
 * Definitely ran out of time on this one...
 * 
 * @author Ben Yaniero
 *
 */
public class CardGameHand<T> implements HandOfCards<PlayingCard> {
	
	private PlayingCard[] hand; //contains the cards
	private int cardNum; //# of cards
	
	public CardGameHand() { //unchecked
		this.hand = new PlayingCard[5];
		this.cardNum = 0;
	}
	
	/** 
	 * Add a Card to the internal data structures
	 * of the class
	 * @param card to be added
	 */
	@Override
	public void add(PlayingCard card) { //unchecked
		if (cardNum == 0) {
			hand[cardNum] = card;
		}
		else { //last effort to try and sort when adding cards...unfinished
			int i = cardNum;
			while(hand[i].getPoints() < card.getPoints() && i>0) {
				hand[i+1] = hand[i];
				hand[i] = card;
			}
		}
		
		
		cardNum++;
	}

	/**
	 * Return the smallest value Card in the hand
	 * @return smallest value Card
	 */
	@Override
	public PlayingCard peekSmallest() { //unchecked
		if (cardNum == 0) {
			return null;
		}
		PlayingCard smallest = hand[0];
		for(int i = 0; i < cardNum; i++) {
			if(smallest.getPoints() < hand[i].getPoints()) {
				smallest = hand[i];
			}
		}
		return smallest;
	}
	
	/** 
	 * Return and remove smallest value Card in the hand
	 * @return smallest value Card
	 */
	@Override
	public PlayingCard removeSmallest() {//untested
		if (cardNum == 0) {
			return null;
		}
		PlayingCard smallest = hand[0];
		for(int i = 0; i < cardNum; i++) {
			if(smallest.getPoints() < hand[i].getPoints()) {
				smallest = hand[i];
			}
		}
		for(int i = 0; i<cardNum; i++) { 
			hand[i] = hand[i+1];
		}
		hand[4] = null;
		
		return smallest;
	}
	
	/**
	 * Get the sum of all the points from all the Cards
	 * in the hand
	 * @return sum of points of Cards in the hand
	 */
	@Override
	public int getTotalScore() {//untested

		if (cardNum == 0) {
			return 0;
		}
		int pointAcc = 0;
		for(int i = 0; i < cardNum; i++) { 
			pointAcc += hand[cardNum].getPoints();
		}
		
		return pointAcc;
	}

	/**
	 * Get a comma separated list of the display
	 * values of all the the Cards in the hand
	 * 
	 * IMPORANT: this list MUST return sorted
	 * high to low.  Face cards/10's must be first, 
	 * and aces should be last.
	 * 
	 * @return
	 */
	@Override
	public String toString() { //untested
		//return "CardGameHand [hand=" + Arrays.toString(hand) + ", cardNum=" + cardNum + "]";
		//assuming a sorted list of card (I won't get to that it seems...)
		String csl = "";
		for (int i = 0; i < cardNum; i++) {
			csl += cardNum + ", ";
		}
		return csl;
		
	}
	
}
