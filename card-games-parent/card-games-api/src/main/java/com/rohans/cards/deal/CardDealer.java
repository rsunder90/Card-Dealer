package com.rohans.cards.deal;

import com.rohans.cards.entities.Card;

/**
 * CardDealer interface to enable dependency injection.
 * @author Rohan Sunder
 *
 */
public interface CardDealer {
	
	public void shuffle();
	
	public Card dealOneCard();

}
