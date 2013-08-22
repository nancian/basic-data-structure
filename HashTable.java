/********************************************************
 * 
 * 08-722 Data Structures for Application Programmers
 * Lecture 12 HashTable Implementation 
 * Assumption: It takes only positive integers
 * 
 * A Very Simple and Naive HashTable with linear probing
 * This code is just to show the basic concept and logic.
 * Thus, this is not perfect at all.
 * 
 ********************************************************/

public class HashTable implements MyHTInterface {

	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem;
	
	public HashTable(int size) {
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1); // flag deleted item with -1 value
	}
	
	/**
	 * Returns true when the key is found
	 * @param key int key value to be searched
	 * @return boolean value true if found, false not found
	 */
	@Override
	public boolean search(int key) {
		int hashVal = hashFunc(key);
		
		// as long as, it is not an empty (null) cell
		while(hashArray[hashVal] != null) {
			if(hashArray[hashVal].getKey()==key)
				return true; // found		
			hashVal++; // increase by 1 (step size is 1)
			hashVal = hashVal % arraySize; // wrap around
		}
		
		return false; // not found
	}

	/**
	 * Inserts a new int value to the table
	 * @param value int value to be inserted
	 */
	@Override
	public void insert(int value) {
		DataItem item = new DataItem(value);
		int hashVal = hashFunc(value);
		
		// check if it is empty or deleted
		while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
			hashVal++;
			hashVal = hashVal % arraySize;
		}
		hashArray[hashVal] = item;
	}

	/**
	 * Deletes and returns an int value from the table
	 * @param key int value to be deleted
	 * @return the deleted int value. "-1" indicates that the key is not in the table
	 */
	@Override
	public int delete(int key) {
		int hashVal = hashFunc(key);
		
		while(hashArray[hashVal] != null) {
			if(hashArray[hashVal].getKey() == key) {
				DataItem tmp = hashArray[hashVal];
				hashArray[hashVal] = nonItem; // set the flag
				return tmp.getKey();
			}
			hashVal++;
			hashVal = hashVal % arraySize;
		}
		return -1; // not found
	}
	
	// simple helper method for hashing key value
	private int hashFunc(int key) {
		return key % arraySize;
	}

	// static DataItem class
	private static class DataItem {
		int value;
		
		DataItem(int value) {
			this.value = value;
		}
		
		int getKey() {
			return value;
		}
	}
	
}