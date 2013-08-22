/********************************************************
 * 
 * 08-722 Data Structures for Application Programmers
 * Lecture 15 Binary Trees, mainly Binary Search Trees
 * A simple app to test BST
 *
 ********************************************************/

public class BSTApp {

	public static void main(String[] args) {
		BST theBST = new BST();
		
		//theBST.traverse();	
		System.out.println(theBST.find(45));
		theBST.delete(45);
		
		theBST.insert(50, 0.5);
		theBST.insert(69, 0.4);
		theBST.insert(45, 1.4);
		theBST.insert(72, 3.4);
		theBST.insert(46, 3.3);
		theBST.insert(46, 3.4);
		
		//theBST.traverse();	
		System.out.println(theBST.find(45));
		theBST.delete(45);
		System.out.println(theBST.find(45));
		theBST.delete(40);
		//theBST.traverse();
	}

}