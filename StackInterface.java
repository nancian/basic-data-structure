/*****************************************************
 * 
 * 08-722 Data Structures for Application Programmers
 * Lecture 6 Stack 
 * Stack Interface
 *
 *****************************************************/
public interface StackInterface<AnyType> {
	/**
	 * This pushes a new element onto the stack in O(1)
	 * @param e a new element to be pushed onto the stack
	 * @throws StackException if it is full
	 */
    void push(AnyType e);
    
    /**
     * This gets and removes the element on the top in O(1)
     * @return Top element
     * @throws StackException if it is empty
     */
    AnyType pop();
    
    /**
     * This gets the top element but does not delete it in O(1)
     * @return Top element
     * @throws StackException if it is empty
     */
    AnyType peek();
    
    /**
     * This method checks if the stack is empty or not in O(1)
     * @return true if it is empty, false if it is not empty
     */
    boolean isEmpty();
}