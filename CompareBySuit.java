/********************************************************
 * 
 * 08-722 Data Structures for Application Programmers
 * Lecture 9 Sorting in Java 
 * Example usage of Comparator implementation
 *
 ********************************************************/

import java.util.*;

public class CompareBySuit implements Comparator<Card> {

	@Override
	public int compare(Card x, Card y) {
		return x.getSuit().compareTo(y.getSuit());
	}
	
}
