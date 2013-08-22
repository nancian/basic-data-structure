/*********************************************************
 * 
 * 08-722 Data Structures for Application Programmers
 * Lecture 14 Advanced Sorting
 * Naive version of Merge Sort
 * 
 *********************************************************/

import java.util.Arrays;

public class MergeSort {

	public static final int SIZE = 10000;
	
	public static void main(String[] args) {
		int[] a = new int[SIZE];
		for(int i=0;i<SIZE;i++)
			a[i] = (int)(Math.random()*SIZE);

		mergeSort(a);
		
		int[] test = {42, 12, 89, 27, 94, 63, 3, 78};
		System.out.println(Arrays.toString(mergeSort(test)));
		
		// test merging process
		/*
		int[] a = {12,42,63,89};
		int[] b = {3,27,78,94};		
		System.out.println(Arrays.toString(merge(a, b)));
		*/
	}
	
	public static int[] mergeSort(int[] unsorted) {
		// base case
		if(unsorted.length == 1) return unsorted;
		
		// create two arrays and divide unsorted array into the two
		int[] left = new int[unsorted.length/2];
		System.arraycopy(unsorted, 0, left, 0, unsorted.length/2);
		
		int[] right = new int[unsorted.length-left.length];
		System.arraycopy(unsorted, left.length, right, 0, right.length);
		
		// recursive calls first
		// call itself to sort the left and right halves
		left = mergeSort(left);		
		right = mergeSort(right);
		
		// then merge them to create the sorted array
		return merge(left, right);
		
	}
	
	private static int[] merge(int[] a, int[] b) {
		// create a new array to hold merged items
		int[] merged = new int[a.length+b.length];
		// initial indices
		int index_a = 0, index_b = 0, index_m = 0;
		
		// traverse and add proper values to the merged array
		while(index_a < a.length && index_b < b.length) {
			// find smaller value and add it to the merged array
			if(a[index_a] < b[index_b]) {
				merged[index_m] = a[index_a];
				index_a++; // move index up
			} else {
				merged[index_m] = b[index_b];
				index_b++; // move index up
			}
			index_m++; // move index up for the merged array
		}
		
		// need to handle cases that there are still items to be copied
		if(index_a < a.length) { // items left in array a
			for(int i = index_a; i < a.length; i++)
				merged[index_m++] = a[i];
		} else { // items left in array b
			for(int i = index_b; i < b.length; i++)
				merged[index_m++] = b[i];
		}
		
		return merged;
	}

}
