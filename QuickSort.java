/*********************************************************
 * 
 * 08-722 Data Structures for Application Programmers
 * Lecture 14 Advanced Sorting
 * Naive version of Quick Sort
 * 
 *********************************************************/

import java.util.Arrays;

public class QuickSort {
	public static final int SIZE = 10000;

	public static void main(String[] args) {
		int[] a = new int[SIZE];
		for(int i=0;i<SIZE;i++)
			a[i] = (int)(Math.random()*SIZE);

		quickSort(a);
		
		int[] test = {42, 12, 89, 27, 94, 63, 3, 78};
		quickSort(test);
		System.out.println(Arrays.toString(test));

		// test partition
		/*
		int[] a = {42,89,63,12,94,27,78,3,50,36};
		int right = a.length-1;
		int pivot = a[right];
		int pivotIndex = partition(a, 0, right, pivot);
		System.out.println(Arrays.toString(a));
		System.out.println(pivotIndex);
		*/
	}
	
	public static void quickSort(int[] arr) {
		recQuickSort(arr, 0, arr.length-1);
	}
	
	private static void recQuickSort(int[] arr, int left, int right) {
		if(right <= left) // base case
			return;
		else {
			int pivot = arr[right];
			// partition first
			int partition = partition(arr, left, right, pivot);
			// then recursive calls
			recQuickSort(arr, left, partition-1);
			recQuickSort(arr, partition+1, right);
		}
	}
	
	private static int partition(int[] arr, int left, int right, int pivot) {
		int leftPointer = left-1;
		int rightPointer = right;
		
		while(true) {
			// scanning to find out-of-place values
			while(arr[++leftPointer] < pivot);
			while(rightPointer > 0 && arr[--rightPointer] > pivot);
			
			if(leftPointer >= rightPointer) break; // nothing to swap
			else { // swap out-of-place values
				swap(arr, leftPointer, rightPointer);
			}
		}
		
		swap(arr, leftPointer, right); // put pivot into the proper place
		return leftPointer; // return where the pivot value is (index value)
	}
	
	private static void swap(int[] arr, int dex1, int dex2) {
		int temp = arr[dex1];
		arr[dex1] = arr[dex2];
		arr[dex2] = temp;
	}

}
