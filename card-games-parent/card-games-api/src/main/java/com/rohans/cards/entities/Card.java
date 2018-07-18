package com.rohans.cards.entities;

/**
 * Simple Card Object
 * @author Rohan Sunder
 *
 */
public class Card {
	
	private String faceValue;
	private String suit;
	
	public Card() {
		// Empty constructor for serialization purposes.
	}
	
	public Card(String faceValue, String suit) {
		this.faceValue = faceValue;
		this.suit = suit;
	}
	
	public void setFaceValue(String faceValue) {
		this.faceValue = faceValue;
	}
	
	public String getFaceValue() {
		return this.faceValue;
	}
	
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	public String getSuit() {
		return this.suit;
	}

}
