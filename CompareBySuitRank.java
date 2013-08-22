/********************************************************
 * 
 * 08-722 Data Structures for Application Programmers
 * Lecture 9 Sorting in Java 
 * Example usage of Comparator implementation
 *
 ********************************************************/

import java.util.*;

public class CompareBySuitRank implements Comparator<Card> {

	@Override
	public int compare(Card x, Card y) {
		int suitResult = x.getSuit().compareTo(y.getSuit());
		return suitResult != 0 ? suitResult : (x.getRank() - y.getRank());
	}

}
