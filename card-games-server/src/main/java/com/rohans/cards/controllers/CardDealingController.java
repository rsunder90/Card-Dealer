package com.rohans.cards.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rohans.cards.deal.CardDealer;
import com.rohans.cards.entities.Card;

/**
 * A card dealing controller.
 * @author Rohan Sunder
 *
 */
@RestController
public class CardDealingController {
	
	@Autowired
	private CardDealer dealer;
	
	/**
	 * GET Endpoint to shuffle the deck. Calls the Card Dealer shuffle method.
	 * @return
	 */
	@RequestMapping(value="/shuffleDeck", method = RequestMethod.GET)
	public ResponseEntity<String> shuffle() {
		
		//Shuffle deck
		this.dealer.shuffle();
		
		return new ResponseEntity<String>("Deck has been shuffled.", HttpStatus.OK);
	}
	
	/**
	 * GET endpoint to deal one card. Calls the Card Dealer dealOneCard method.
	 * @return
	 */
	@RequestMapping(value="/dealOneCard", method = RequestMethod.GET)
	public ResponseEntity<?> dealOneCard() {
		
		Card result = this.dealer.dealOneCard();
		
		// If no more cards availabe, throw a 400.
		if (result == null) {
			return new ResponseEntity<String>("No more cards available", HttpStatus.BAD_REQUEST); 
		}
		
		return new ResponseEntity<Card>(result, HttpStatus.OK);
	}
	
	/**
	 * Extra endpoint that deals multiple cards at once given a number of cards.
	 * @param num
	 * @return
	 */
	@RequestMapping(value="/dealCards", method = RequestMethod.POST)
	public ResponseEntity<?> dealCards(@RequestParam int num) {
		
		if (num > 52 || num < 1) {
			return new ResponseEntity<String>("Don't be cheeky.", HttpStatus.BAD_REQUEST);
		}
		
		Card result = this.dealer.dealOneCard();
		if (result == null) {
			return new ResponseEntity<String>("No more cards available", HttpStatus.BAD_REQUEST); 
		}
		
		ArrayList<Card> cards = new ArrayList<Card>();
		num--;
		while (num >= 0 && result != null) {
			cards.add(result);
			num--;
			result = this.dealer.dealOneCard();
		}
		
		Card[] cardsToReturn = new Card[cards.size()];
        cardsToReturn = cards.toArray(cardsToReturn);
        
        return new ResponseEntity<Card[]>(cardsToReturn, HttpStatus.OK);
	}

}
