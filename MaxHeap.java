/********************************************************
 * 
 * 08-722 Data Structures for Application Programmers
 * Lecture 18 Heaps and Heap Sort
 * 
 * A very simple MaxHeap implementation
 *
 ********************************************************/

public class MaxHeap implements MaxHeapInterface {

	private Node[] heapArray;
	private int currentSize;

	// assuming initialCapacity is > 0
	public MaxHeap(int initialCapacity) {
		heapArray = new Node[initialCapacity];
		currentSize = 0;
	}
	
	/**
	 * Insert a new value into a heap
	 * @param value value to be inserted
	 * @return boolean to check whether it was added or not
	 */
	@Override
	public boolean insert(double value) {
		// no more space to add
		if(currentSize == heapArray.length)
			return false;
		Node newNode = new Node(value);
		
		// put it into the next available cell
		// so that the tree is still complete
		heapArray[currentSize] = newNode;
		
		// percolate up and increase the curren size
		percolateUp(currentSize++);
		return true;
	}

	/**
	 * remove maximum value
	 * @return Max value that is removed from the heap
	 */
	@Override
	public double removeMax() {
		// store the root
		Node root = heapArray[0];
		
		// take the last node into the root
		heapArray[0] = heapArray[--currentSize];
		
		// percolate down
		percolateDown(0);
		
		return root.value;
	}
	
	public int size() {
		return currentSize;
	}
	
	public void display() {
		// Array format
		System.out.print("heap array: ");
		for(int i = 0; i < currentSize; i++) {
			Node node = heapArray[i];
			System.out.print(node.value);
			if(i == currentSize-1) 
				System.out.println("");
			else 
				System.out.print(", ");
		}
		
		// heap tree format
		int nBlanks = 32;
		int itemsPerRow = 1;
		int column = 0;
		int j = 0;
		String dots = "....................................";
		System.out.println("heap tree");
		System.out.println(dots+dots);
		
		while(currentSize>0) {
			if(column == 0)
				for(int k = 0; k < nBlanks; k++)
					System.out.print(" ");
			
			System.out.print(heapArray[j].value);
			
			if(++j == currentSize) break;
			if(++column == itemsPerRow) {
				nBlanks /= 2;
				itemsPerRow *=2;
				column = 0;
				System.out.println();
			} else {
				for(int k=0; k < nBlanks*2-2; k++)
					System.out.print(" ");
			}
		}
		System.out.println("\n"+dots+dots+"\n");
	}
	
	// hepler method to percolate up for insertion
	private void percolateUp(int index) {
		// save the value that was inserted
		Node bottom = heapArray[index];
		// find index's parent
		int parent = (index-1) >>> 1;
		
		// percolating up
		while(index > 0 && heapArray[parent].value < bottom.value) {
			heapArray[index] = heapArray[parent];
			index = parent; 
			parent = (parent-1) >>> 1;
		}
		
		// finally put the bottom data into the right position
		// to restore the heap condition
		heapArray[index] = bottom;
 	}
		
	// helper method to percolate down for remove Max
	private void percolateDown(int index) {
		// store the top value that was just put into the root
		Node top = heapArray[index];
		
		// index for larger child
		int largerChild; 
		
		// as long as there is at lease one child (left child)
		while(index < (currentSize >>> 1)) {
			
			// find the left child
			int leftChild = (index << 1) + 1;
			// we do not know there is right child or not.
			int rightChild = leftChild + 1;
			
			// as long as rightchild is less than the size
			if(rightChild < currentSize 
					&& heapArray[leftChild].value < heapArray[rightChild].value) 
				largerChild = rightChild;
			else 
				largerChild = leftChild;
			
			// and if largerchild's value is not bigger than the top value
			if(top.value >= heapArray[largerChild].value) break;
			
			// percolate down
			heapArray[index] = heapArray[largerChild];
			
			// keep walking down the tree
			index = largerChild; 
		}
		
		// put top Node to the right place
		heapArray[index] = top; 
	}
	
	// private static nested class for Node
	private static class Node {
		double value;
		
		Node(double value) {
			this.value = value;
		}
 	}

}