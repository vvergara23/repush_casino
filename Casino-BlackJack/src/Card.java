//Author: Veronica Vergara

public class Card implements Comparable<Card> {

	private String suit;
	private String rank;
	private int value;

	public Card(String rank, String suit, int value) {
		this.rank = rank; //initialize rank
		this.suit = suit; //initialize suit
		this.value = value; //initialize point value (numeric)
	}

	//~getters
	
	public String getSuit() {
		return suit;
	}
	public String getRank() {
		return rank;
	}
	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return rank + " of " + suit;
	}

	@Override
	public int compareTo(Card card) {
		if (this.value == card.getValue()) {
			return 0;
		} else if (this.value > card.getValue()) {
			return 1;
		} else {
			return -1;
		}
	}
}