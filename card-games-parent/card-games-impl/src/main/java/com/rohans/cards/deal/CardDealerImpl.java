package com.rohans.cards.deal;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import org.springframework.stereotype.Service;

import com.rohans.cards.entities.Card;

/**
 * Implementation class that deals and shuffles a deck of cards.
 * @author Rohan Sunder
 *
 */
@Service
public class CardDealerImpl implements CardDealer {
	
	/**
	 * Use a stack because a deck is a stack of cards literally.
	 */
	private Stack<Card> deck = new Stack<Card>();

	/**
	 * Shuffles all cards in the deck.
	 */
	@Override
	public void shuffle() {
		
		// Initialize deck
		ArrayList<Card> deckArray = this.initializeDeckOfCards();
		deck = new Stack<Card>();
		
		// Use a random number generator that randomly pulls cards from the array based on index. 
		// Ensured to generate a pseudo random sequence. 
		Random rand = new Random();
		while(deckArray.size() > 0) {
			
			int index = rand.nextInt(deckArray.size());
			Card c = deckArray.remove(index);
			this.deck.push(c);
		}

	}


	/**
	 * Deals one card until no more cards are present. Pretty straightforward.
	 * @return Card
	 */
	@Override
	public Card dealOneCard() {
		
		Card dealtCard = null;
		if (!this.deck.isEmpty()) {
			dealtCard = this.deck.pop();
		}
		
		return dealtCard;
	}
	
	/**
	 * Private method meant to reinitialize the deck of cards when shuffled.
	 * @return
	 */
	private ArrayList<Card> initializeDeckOfCards() {
		
		ArrayList<Card> deckArray = new ArrayList<Card>(52);
		deckArray.add(new Card("2", "Clubs"));
		deckArray.add(new Card("3", "Clubs"));
		deckArray.add(new Card("4", "Clubs"));
		deckArray.add(new Card("5", "Clubs"));
		deckArray.add(new Card("6", "Clubs"));
		deckArray.add(new Card("7", "Clubs"));
		deckArray.add(new Card("8", "Clubs"));
		deckArray.add(new Card("9", "Clubs"));
		deckArray.add(new Card("10", "Clubs"));
		deckArray.add(new Card("Jack", "Clubs"));
		deckArray.add(new Card("Queen", "Clubs"));
		deckArray.add(new Card("King", "Clubs"));
		deckArray.add(new Card("Ace", "Clubs"));
		deckArray.add(new Card("2", "Diamonds"));
		deckArray.add(new Card("3", "Diamonds"));
		deckArray.add(new Card("4", "Diamonds"));
		deckArray.add(new Card("5", "Diamonds"));
		deckArray.add(new Card("6", "Diamonds"));
		deckArray.add(new Card("7", "Diamonds"));
		deckArray.add(new Card("8", "Diamonds"));
		deckArray.add(new Card("9", "Diamonds"));
		deckArray.add(new Card("10", "Diamonds"));
		deckArray.add(new Card("Jack", "Diamonds"));
		deckArray.add(new Card("Queen", "Diamonds"));
		deckArray.add(new Card("King", "Diamonds"));
		deckArray.add(new Card("Ace", "Diamonds"));
		deckArray.add(new Card("2", "Spades"));
		deckArray.add(new Card("3", "Spades"));
		deckArray.add(new Card("4", "Spades"));
		deckArray.add(new Card("5", "Spades"));
		deckArray.add(new Card("6", "Spades"));
		deckArray.add(new Card("7", "Spades"));
		deckArray.add(new Card("8", "Spades"));
		deckArray.add(new Card("9", "Spades"));
		deckArray.add(new Card("10", "Spades"));
		deckArray.add(new Card("Jack", "Spades"));
		deckArray.add(new Card("Queen", "Spades"));
		deckArray.add(new Card("King", "Spades"));
		deckArray.add(new Card("Ace", "Spades"));
		deckArray.add(new Card("2", "Hearts"));
		deckArray.add(new Card("3", "Hearts"));
		deckArray.add(new Card("4", "Hearts"));
		deckArray.add(new Card("5", "Hearts"));
		deckArray.add(new Card("6", "Hearts"));
		deckArray.add(new Card("7", "Hearts"));
		deckArray.add(new Card("8", "Hearts"));
		deckArray.add(new Card("9", "Hearts"));
		deckArray.add(new Card("10", "Hearts"));
		deckArray.add(new Card("Jack", "Hearts"));
		deckArray.add(new Card("Queen", "Hearts"));
		deckArray.add(new Card("King", "Hearts"));
		deckArray.add(new Card("Ace", "Hearts"));
		
		return deckArray;
	}

}
