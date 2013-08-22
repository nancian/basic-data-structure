/*****************************************************
 * 
 * 08-722 Data Structures for Application Programmers
 * Lecture 7 Queue
 * Queue Interface
 *
 *****************************************************/

public interface QueueInterface<AnyType> {
	
	/**
	 * This enqueues a new element to the back of the queue in O(1)
	 * @param e a new element to be enqueued to the queue
	 * @throws RunTimeException if it is full
	 */
	void enqueue(AnyType e);
	
    /**
     * This gets and removes the element from the front of the queue in O(1)
     * @return front element
     * @throws NoSuchElementException if it is empty
     */
	AnyType dequeue();
	
    /**
     * This gets the front element but does not delete it in O(1)
     * @return front element
     * @throws NoSuchElementException if it is empty
     */
	AnyType peekFront();
	
    /**
     * This method checks if the queue is empty or not in O(1)
     * @return true if it is empty, false if it is not empty
     */
	boolean isEmpty();
	
}