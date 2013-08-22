/********************************************************
 * 
 * 08-722 Data Structures for Application Programmers
 * Lecture 8 Simple Sorting
 * Bubble Sort, Selection Sort, and Insertion Sort
 *
 ********************************************************/

import java.util.*;

public class SimpleSorting {

	public static void main(String[] args) {
		int[] testData = {4,7,2,5,3};
		bubbleSort(testData);
		System.out.println(Arrays.toString(testData));		
	}
	
	// Focus is on the largest value
	public static void bubbleSort(int[] data) {
		/*
		 * invariant : Any values after "out" are sorted.
		 * decrease out variable value as sorted values are accumulated.
		 */
		for(int out = data.length-1; out >= 1; out--) {
			/*
			 * compare and swap values to bubble the biggest value up
			 * to the right side 
			 */
			for(int in=0; in < out; in++) {
				// if left side's value is bigger
				if(data[in] > data[in+1])
					swap(data, in, in+1); // then swap
			}
		}
	}
	
	// Focus is on the smallest value
	public static void selectionSort(int[] data) {
		int min;
		/*
		 * invariant: values less than or equal to "out" variable are sorted. 
		 * Thus, each round, increase out variable
		 */
		for(int out=0; out < data.length-1; out++) {
			min = out; // min variable starts with the out index
			for(int in=out+1; in < data.length; in++) {
				if(data[in] < data[min]) // if any value is smaller than min value
					min = in; // update min index
			}
			// then swap min value with the value of out index
			swap(data, out, min);
		}
	}
	
	/*
	 * imagine that there is an imaginary line
	 * focus is on the partially sorted part that forms on the left hand side
	 */
	public static void insertionSort(int[] data) {
		/*
		 * starts imaginary division line at 1 and increase
		 * Invariant : values less than out variable are sorted.
		 */
		for(int out=1; out < data.length; out++) {
			// save the first value in the right hand side of the line as temp
			int temp = data[out]; 
			int in = out;
			
			/*
			 * traverse values in the left hand side backward
			 * and compare values with the temp value
			 * if necessary, copy the values up by one index
			 */
			while(in > 0 && data[in-1] >= temp) {
				data[in] = data[in-1];
				in--;
			}
			
			/*
			 * finally, insert the temp value into the right position
			 * in the left hand side of the line  
			 */
			data[in] = temp;
		}
	}
	
	private static void swap(int[] data, int one, int two) {
		int tmp = data[one];
		data[one] = data[two];
		data[two] = tmp;
	}

}
