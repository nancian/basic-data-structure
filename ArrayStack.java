/******************************************************
 * 
 * 08-722 Data Structures for Application Programmers
 * Lecture 6 Stack 
 * Simple Stack implementation with an array
 *
 ******************************************************/

public class ArrayStack<AnyType> implements StackInterface<AnyType> {

	private static final int DEFAULT_CAPACITY = 15;
	private AnyType[] underlineArray;
	private int top;
	
	/**
	 * construct a stack with initial capacity
	 * @param initialCapacity an int value for initial capacity
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack(int initialCapacity) {
		if(initialCapacity <= 0)
			underlineArray = (AnyType[]) new Object[DEFAULT_CAPACITY];
		else
			underlineArray = (AnyType[]) new Object[initialCapacity];
		
		top = -1;
	}
	
	/**
	 * construct a stack with the default capacity
	 */
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Inserts a new element onto the top of the stack
	 * @throws Exception 
	 */
 	@Override
	public void push(AnyType e) {
		if(top == underlineArray.length)
			throw new StackException("Stack is full already. Overflow");
		top++;
		underlineArray[top] = e;
	}


	/**
	 * Removes and returns the element at the top
	 */
	@Override
	public AnyType pop() {
		AnyType result = underlineArray[top];
		underlineArray[top] = null;
		top--;
		return result;
	}

	/**
	 * Returns top item without removing it
	 */
	@Override
	public AnyType peek() {
		if(isEmpty()) throw new StackException("Stack is empty.");
		return underlineArray[top];
	}

	/**
	 * Checks if the stack is empty or not
	 */
	@Override
	public boolean isEmpty() {
		return top == -1;
	}

}

/**  StackException  **/
@SuppressWarnings("serial")
class StackException extends RuntimeException {
   public StackException(String name) {
      super(name);
   }

   public StackException() {
      super();
   }
}
