/********************************************************
 * 
 * 08-722 Data Structures for Application Programmers
 * Lecture 9 Sorting in Java 
 *
 ********************************************************/

import java.util.*;

public class MainDriver {

	public static void main(String[] args) {
		List<Card> cards = new ArrayList<Card>();
		
		Card card1 = new Card("heart", 2);
		Card card2 = new Card("diamond", 2);
		Card card3 = new Card("spade", 3);
		Card card4 = new Card("club", 4);
		Card card5 = new Card("heart", 1);
		
		cards.add(card1); cards.add(card2); cards.add(card3);
		cards.add(card4); cards.add(card5);
		
		Collections.sort(cards);
		//Collections.sort(cards, new CompareBySuit());	
		//Collections.sort(cards, new CompareBySuitRank());
	
		for(Card c: cards) {
			System.out.println(c.toString());
		}
		
		// Testing compareTo, equals, and hashCode methods
		/*
		Card card6 = new Card("heart", 2);
		System.out.println(card1.compareTo(card6));		
		System.out.println(card1.equals(card6));
		System.out.println(card1.hashCode());
		System.out.println(card6.hashCode());
		*/
	}

}
