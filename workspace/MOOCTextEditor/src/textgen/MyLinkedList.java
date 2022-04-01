package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		LLNode<E> preNode = tail.prev;
		LLNode<E> curNode = new LLNode<E>(element, preNode, tail);
		//point curNode to tail
		tail.prev = curNode;
		
		//point preNode to curNode
		preNode.next = curNode;
		
		//increase size
		size ++;
		
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index)
	{
		// TODO: Implement this method.
		if( size == 0 || index >= size || index < 0 ) {
			throw new IndexOutOfBoundsException();
		}
		//start with first node
		LLNode<E> curNode = head.next;
	
		for(int i = 0; i < index ; i++ ) {
			curNode = curNode.next;
		}
		
		return curNode.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if( index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if ( element == null ) {
			throw new NullPointerException();
		}
		
		//start with head node
		LLNode<E> preNode = head;
		for(int i = 0; i < index ; i++ ) {
			preNode = preNode.next;
		}
		
		LLNode<E> nextNode = preNode.next;
		LLNode<E> curNode = new LLNode<E>(element, preNode, nextNode);
		//point newNode to nextNode
		nextNode.prev = curNode;
		
		//point curNode to newNode
		preNode.next = curNode;
		
		//increase size
		size ++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if ( size == 0 || index > size || index < 0 ) {
			throw new IndexOutOfBoundsException();
		}
		// start with first node
		LLNode<E> curNode = head.next;
		
		for(int i = 0; i < index ; i++ ) {
			curNode = curNode.next;
		}
		
		LLNode<E> preNode = curNode.prev;
		LLNode<E> nextNode = curNode.next;
		//point preNode to nextNode
		preNode.next = nextNode;
		nextNode.prev = preNode;
		
		//decrease size
		
		size --;
		
		return curNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		// TODO: Implement this method
		if ( size == 0 || index >= size || index < 0 ) {
			throw new IndexOutOfBoundsException();
		}
		if ( element == null ) {
			throw new NullPointerException();
		}
		// start with first node
		LLNode<E> oldNode = head.next;
				
		for(int i = 0; i < index ; i++ ) {
			oldNode = oldNode.next;
		}
				
		LLNode<E> preNode = oldNode.prev;
		LLNode<E> nextNode = oldNode.next;
		LLNode<E> newNode = new LLNode<E>(element, preNode, nextNode);
 		
		
		//point preNode to newNode
		preNode.next = newNode;
		
		//point newNode to nextNode
		newNode.next = nextNode;

		return oldNode.data;
	}
	
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) {
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e, LLNode<E> pre, LLNode<E> next) {
		this.data = e;
		this.prev = pre;
		this.next = next;
	}
	
	

}
