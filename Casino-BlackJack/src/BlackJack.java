//Veronica Vergara

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BlackJack {
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Welcome!");
		System.out.println("Please input your name:\n");
		String playerName = in.nextLine();	
		int chips = 100;
		System.out.println(playerName + ", you are starting 100 chips to start betting.");
		
		do {
			int bet = 0;
			do {	
				bet = Integer.parseInt(question("Please input your bet:\n", "\\d+", in));	
			} while (bet > chips || bet <= 0);
			
			
			
			if(loseYourMoney()) {
				chips += bet;
			}
			else {
				chips -= bet;
			}
			System.out.println();
			if(chips == 0) {
				System.out.println("You have run out of chips!   :(");
			}
			
			
		} while(chips != 0 && question("Would you like to keep playing, or cash out?", Arrays.asList("continue", "cash out"), in).equals("continue"));
	}
	
	public static boolean loseYourMoney() {
		
		/*Setting up
		 * 
		 */
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
		String[] ranks = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
						"Ten", "King", "Queen", "Jack", "Ace" };
		int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
		
		Deck deck = new Deck(suits, ranks, values);
		Hand dealer = new Hand();
		Hand user = new Hand();
		
		dealer.add(deck.deal());
		dealer.add(deck.deal());
		user.add(deck.deal());
		user.add(deck.deal());

		/*
		 * Let's get started
		 */
		
		System.out.println("Your Hand\n" + user);
		System.out.println("Dealer's Hand\n" + dealer.get(0));
		
		String doing = "";
		while (user.points() != 0 && !doing.equals("stand")) {
			System.out.println("Hit or Stand?");
			doing = in.nextLine().toLowerCase();
			if (doing.equals("hit")) {
				user.add(deck.deal());
				System.out.println("You get..." + user);
				System.out.println("");
			} 
		} 	
		//bust
		if(user.points() == 0) {
			System.out.println("Sorry, you busted!");
			return false;
		}
		
		//PLAYERS FINAL HAND
		System.out.println("Your Final Hand\n" + user.points());

		
		while(dealer.points() <= 17 && dealer.points() != 0) {
			dealer.add(deck.deal());
		}
		
		if(dealer.points() == 21) {
			System.out.println("Sorry, better luck next time...");
			return false;
		}
		if(dealer.points() == 0) {
			System.out.println("Congratulations, luck is on your side!");
			return true;
		} 
		
		
		//DEALERS FINAL HAND
		System.out.println("Dealer's Final Hand: " + dealer.points());
		
		int result = user.compareTo(dealer);
		if(result == 1) {
			System.out.println("Sorry, better luck next time..."); 
			return true;
		} 
		else {
			System.out.println("Congratulations, luck is on your side!");
			return false;
		}
		
		//For questions
		
	}
	public static String question(String q, List<String> answers, Scanner in) {
		String response = "";
		do {
			System.out.println(q);
			response = in.nextLine().toLowerCase();
		} while(answers.indexOf(response) == -1);
		return response;
	}
	
	public static String question(String q, String format, Scanner in) {
		String response = "";
		do {
			System.out.println(q);
			response = in.nextLine();
		} while(!response.matches(format));
		return response;
	}
	
	
}