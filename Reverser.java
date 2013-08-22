/******************************************************
 * 
 * 08-722 Data Structures for Application Programmers
 * Lecture 6 Stack 
 * Simple String Reverser
 *
 ******************************************************/

public class Reverser {
	private String input;
	
	public Reverser(String input) {
		this.input = input;
	}
	
	public String doReverse() {
		int stackSize = input.length();
		
		ArrayStack<Character> theStack = new ArrayStack<Character>(stackSize);
		
		for(int i=0; i < input.length(); i++) {
			char ch = input.charAt(i);
			theStack.push(ch);
		}
		
		StringBuilder output = new StringBuilder();
		while(!theStack.isEmpty()) {
			char ch = theStack.pop();
			output.append(ch);
		}
		
		return output.toString();
	}

}
