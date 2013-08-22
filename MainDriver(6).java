/********************************************************
 * 
 * 08-722 Data Structures for Application Programmers
 * Lecture 10 Recursion 
 * Examples used in lectures
 *
 ********************************************************/

public class MainDriver {

	public static void main(String[] args) {
		System.out.println(sum(10));
		System.out.println(recursiveSum(10));
		System.out.println("Fib: "+recursiveFib(46));
		System.out.println("Fib: "+recursiveFibTuned(6));
		System.out.println(fact(5));
	}
	
	// iterative implementation of sum from 1 to n
	public static int sum(int n) {
		int result = 0;
		for(int i=1; i <= n; i++) {
			result = result + i;
		}
		return result;
	}
	
	// recursive implementation of sum from 1 to n
	public static int recursiveSum(int n) {
		if(n==1) return n;
		else return n + recursiveSum(n-1);
	}
	
	// naive recursive implementation of fibonacci number 
	public static int recursiveFib(int n) {
		if(n==0 || n==1) return n;
		else return recursiveFib(n-1) + recursiveFib(n-2);
	}
	
	// adjusted recursive implementation of fibonacci number (n > 1)
	public static long recursiveFibTuned(long n) {
		if(n==1 || n==2) return 1;
		else return recursiveFibTuned(n-1) + recursiveFibTuned(n-2);
	}
	
	// recursive implementation of factorial number
	public static long fact(int n) {
        return n < 2 ? n : n * fact(n - 1);
    }
	
	// public method for recursive binary search
	public static int find(int[] data, int key) {
		return recFind(data, key, 0, data.length-1);
	}
	
	// private helper method for recursive binary search
	private static int recFind(int[] data, int key, int lowerBound, int upperBound) {
		if(lowerBound > upperBound) return -1; // base case 1 (not found)
		int mid = lowerBound + (upperBound - lowerBound)/2;
		if(data[mid] == key) return mid; // base case 2 (found)
		else { // recursive cases
			if(data[mid] < key)
				return recFind(data, key, mid+1, upperBound);
			else
				return recFind(data, key, lowerBound, mid-1);
		}
	}

}