/********************************************************
 * 
 * 08-722 Data Structures for Application Programmers
 * Lecture 18 Heaps and Heap Sort
 * 
 * A very simple sorting and display of Max Heap
 *
 ********************************************************/

import java.util.*;

public class MainDriver {

	public static void main(String[] args) {
		MaxHeap theHeap = new MaxHeap(20);
		theHeap.insert(24);
		theHeap.insert(5);
		theHeap.insert(45);
		theHeap.insert(10);
		theHeap.insert(45);
		theHeap.insert(56);
		theHeap.insert(17);
		theHeap.insert(24);
		theHeap.insert(19);
		theHeap.insert(20);
		
		theHeap.display();
		
		double[] sorted = new double[theHeap.size()];
		for(int i=0; i<sorted.length; i++) 
			sorted[i] = theHeap.removeMax();
		
		System.out.println("Sorted in descending order: "+Arrays.toString(sorted));
 	}

}