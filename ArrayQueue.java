/********************************************************
 * 
 * 08-722 Data Structures for Application Programmers
 * Lecture 7 Queue
 * Simple Queue implementation using an array (circular)
 *
 ********************************************************/

import java.util.*;

public class ArrayQueue<AnyType> implements QueueInterface<AnyType> {

	private static final int DEFAULT_CAPACITY = 15;
	private AnyType[] underlineArray;
	private int front, back, nItems, max;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int initialCapacity) {
		if(initialCapacity <= 0)
			max = DEFAULT_CAPACITY;
		else 
			max = initialCapacity;
		underlineArray = (AnyType[]) new Object[max];
		front = 0;
		back = -1; 
		nItems = 0;
	}
	
	/**
	 * Inserts a new element into the back of the queue.
	 * @param item a new item to insert.
	 */
	@Override
	public void enqueue(AnyType item) {
		if(isFull()) 
			throw new RuntimeException("Queue is full");
		back++; // caution : this can overflow
		int index = back % max; // wrap around!
		underlineArray[index] = item;
		nItems++;
	}


	/**
	 * Returns and removes the element at the front. Wrap around!
	 * @return the element at the front of the queue
	 * @throws NuSuchElementException if it is empty
	 */
	@Override
	public AnyType dequeue() {
		int index = front%max; // wrap around!
		AnyType result = underlineArray[index];
		underlineArray[index] = null;
		front++; // caution: this can overflow
		nItems--;
		return result;
	}

	/**
	 * Returns the first element in the queue without removing it.
	 * @return the first element
	 * @throws NoSuchElementException if it is empty
	 */
	@Override
	public AnyType peekFront() {
		if(isEmpty()) 
			throw new NoSuchElementException();
		return underlineArray[front%max];
	}

	/**
     * checks if the queue is empty or not.
     * @return true if it is empty, false if it is not empty
     */
	@Override
	public boolean isEmpty() {
		return nItems == 0;
	}
	
	// private helper method to check if queue is full or not
	private boolean isFull() {
		return nItems == max;
	}

}
