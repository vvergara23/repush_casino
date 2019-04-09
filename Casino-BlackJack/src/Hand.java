import java.util.ArrayList;

public class Hand extends ArrayList<Card> implements Comparable<Hand>{
	public Hand() {
		
	}
	/*
	 * The score
	 */
	
	
	public int points() {
		int points = 0;
		boolean ace = false;
		
		
		for(Card card : this) {
			points += card.getValue();
			if(card.getRank() == "ace") {
				ace = true;
			}
		}
		if (points > 21) {
			if(ace) {
				points -= 10;
			}
		}
		return points;
	}
	/*
	 * Compare to
	 */
	
	
	public int compareTo(Hand other) {
		int userpoints = this.points();
		int dealerpoints = other.points();
		if(userpoints == dealerpoints) {
			return 0;
		} 
		else if(userpoints > dealerpoints) {
			return 1;
		} 
		else {
			return -1;
		}
	}
	@Override
	public String toString() {
		String s = "";
		for(Card card : this) {
			s += card;
			s += "\n";
		}
		return s;
	}
	
}