/********************************************************
 * 
 * 08-722 Data Structures for Application Programmers
 * Lecture 5 LinkedList
 * Simple Singly Linked List Implementation
 *
 ********************************************************/

import java.util.*;

public class SinglyLinkedList<AnyType> implements Iterable<AnyType> {
	
	private Node<AnyType> head;
	
	/**
	 * constructs an empty linkedlist
	 */
	public SinglyLinkedList() {
		head = null;
	}
	
	/**
	 * Add a new element at the beginning of the list.
	 * @param item a new item (element) to add
	 */
	public void addFirst(AnyType item) {
		head = new Node<AnyType>(item, head);
	}
	
	/**
	 * Add a new element to the end of the list.
	 * @param item a new item (element) to add
	 */
	public void addLast(AnyType item) {
		if(head==null) 
			addFirst(item);
		else {
			// traverse to get to the last item
			Node<AnyType> tmp = head;
			while(tmp.next != null) 
				tmp = tmp.next;
			
			// link the item to be the next of tmp
			tmp.next = new Node<AnyType>(item, null);
		}
	}

	/**
	 * Find key item from the list and add a new item after that.
	 * @param key a key value to find from the list
	 * @param toInsert a new item (element) to add
	 */
	public void insertAfter(AnyType key, AnyType toInsert) {
		// find the key item in the list first
		Node<AnyType> tmp = head;
		while(tmp != null && !tmp.data.equals(key)) 
			tmp = tmp.next;
		
		// If the key is found, add toInsert into the list
		if(tmp != null)
			tmp.next = new Node<AnyType>(toInsert, tmp.next);
	}
	
	/**
	 * Find key item from the list and add a new item before that
	 * @param key a key value to find from the list
	 * @param toInsert a new item (element) to add
	 */
	public void insertBefore(AnyType key, AnyType toInsert) {
		// when the list is empty, nothing to do
		if(head == null) return;
		
		// if head has the key data, then call addFirst method
		if(head.data.equals(key)) {
			addFirst(toInsert);
			return;
		}
		
		/*
		 * traverse to find key value
		 * while keeping track of two pointers, prev and curr nodes
		 */
		Node<AnyType> prev = null;
		Node<AnyType> curr = head;		
		while(curr != null && !curr.data.equals(key)) {
			prev = curr;
			curr = curr.next;
		}
		
		// When found the key, add toInsert using prev and curr pointers
		if(curr != null)
			prev.next = new Node<AnyType>(toInsert, curr);		
	}
	
	/**
	 * Delete the first occurrence of the kay from the list
	 * @param key a key value to delete
	 */
	public void delete(AnyType key) {
		if(head==null) throw new RuntimeException("cannot delete");
		
		// if head is the key, simply change the head reference
		if(head.data.equals(key)) {
			head = head.next;
			return;
		}
		
		/*
		 * traverse to find key value
		 * while keeping track of two pointers, prev and curr nodes
		 */
		Node<AnyType> prev = null;
		Node<AnyType> curr = head;
		while(curr != null && !curr.data.equals(key)) {
			prev = curr;
			curr = curr.next;
		}
		
		if(curr == null) 
			throw new RuntimeException("Nothing to delete");
		
		// finally delete the node from the list
		prev.next = curr.next;
	}
	
	/*
	 * Static nested class Node that is only used in the class
	 */
	private static class Node<AnyType> {
		AnyType data;
		Node<AnyType> next;
		
		Node(AnyType data, Node<AnyType> next) {
			this.data = data;
			this.next = next;
		}
	}

	/**
	 * returns list iterator of the elements
	 */
	@Override
	public Iterator<AnyType> iterator() {
		return new SinglyLinkedListIterator();
	}
	
	// inner class for SinglyLinedListIterator that implements Iterator interface
	private class SinglyLinkedListIterator implements Iterator<AnyType> {

		private Node<AnyType> nextNode;
		
		SinglyLinkedListIterator() {
			nextNode = head;
		}
		
		@Override
		public boolean hasNext() {
			return nextNode != null;
		}

		@Override
		public AnyType next() {
			if(!hasNext()) throw new NoSuchElementException();
			AnyType result = nextNode.data;
			nextNode = nextNode.next;
			return result;
		}

		// Do not want anyone to remove any element while iterating
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}

}