package lab2;

import java.util.*;

public class DoubleLinkedList<E> {
	protected DoubleNode<E> firstNode;
	protected DoubleNode<E> lastNode;
	protected int size;
	
	DoubleLinkedList(int initilalCapacity){
		
	}
	DoubleLinkedList(){this(0);}
	
	public boolean isEmpty() {
		return size == 0;
	}
	public int size() {
		return size;
	}
	void checkIndex(int index){
	      if (index < 0 || index >= size)
	         throw new IndexOutOfBoundsException
	             ("index = " + index + "  size = " + size);
	}
	
	public E get(int index) {
		checkIndex(index);
		DoubleNode<E> currentNode;
		if (index < size / 2){
	         currentNode = firstNode;
	         for (int i = 0; i < index; i++)
	            currentNode = currentNode.nextNode;
	      }
	      else{
	         currentNode = lastNode;
	         int numberToMove = size - index - 1;
	         for (int i = 0; i < numberToMove; i++)
	            currentNode = currentNode.prevNode;
	      }
	      return currentNode.element;
	}
	public E remove(int index) {
		checkIndex(index);
	      DoubleNode<E> currentNode;
	      
	      if (index < size / 2){
	         currentNode = firstNode;
	         for (int i = 0; i < index; i++)
	            currentNode = currentNode.nextNode;
	      }
	      else {
	         currentNode = lastNode;
	         int numberToMove = size - index - 1;
	         for (int i = 0; i < numberToMove; i++)
	            currentNode = currentNode.prevNode;
	      }

	      if (size == 1)
	         firstNode = null;
	      else
	         if (index == 0) {
	            firstNode = firstNode.nextNode;
	            firstNode.prevNode = null;
	         }
	         else
	            if (index == size - 1) {
	               lastNode = lastNode.prevNode;
	               lastNode.nextNode = null;
	            }
	            else {
	               currentNode.prevNode.nextNode = currentNode.nextNode;
	               currentNode.nextNode.prevNode = currentNode.prevNode;
	            }
	      size--;
	      return currentNode.element;
	}
	public void add(int index, E theElement){
	      if (index < 0 || index > size)
	         throw new IndexOutOfBoundsException
	                   ("index = " + index + "  size = " + size);

	      if (index == 0){
	         firstNode = new DoubleNode<E>(theElement, null, firstNode);
	         if (firstNode.nextNode == null)
	            lastNode = firstNode;
	         else
	            firstNode.nextNode.prevNode = firstNode;
	      }
	      else
	         if (index == size){
	            lastNode.nextNode = new DoubleNode<E>(theElement, lastNode, null);
	            lastNode = lastNode.nextNode;
	         }
	         else {
	            DoubleNode<E> currentNode;
	            if (index <= size / 2) {
	               currentNode = firstNode;
	               for (int i = 0; i < index - 1; i++)
	                  currentNode = currentNode.nextNode;
	            }
	            else {
	               currentNode = lastNode;
	               int numberToMove = size - index;
	               for (int i = 0; i < numberToMove; i++)
	                  currentNode = currentNode.prevNode;
	            }

	            currentNode.nextNode =
	                   new DoubleNode<E>(theElement, currentNode, currentNode.nextNode);
	            currentNode.nextNode.nextNode.prevNode = currentNode.nextNode;
	      }
	      size++;
	 }
	 public void clear(){
		 firstNode = null;
	     size = 0;
	 }
	 
	 public void add(E theElement){
	      DoubleNode<E> newNode = new DoubleNode<E>(theElement, lastNode, null);
	      if (size == 0){
	         firstNode = lastNode = newNode;
	         firstNode.prevNode = null;
	      }
	      else{
	          lastNode.nextNode = newNode;
	          newNode.prevNode = lastNode;
	          lastNode = newNode;
	      }
	      size++;
	 }
	 public Iterator<E> iterator(){
		 return new DoubleIterator<E>();
	 }

	 private class DoubleIterator<E> implements Iterator<E>{
		 private DoubleNode<E> theNextNode;
		 @SuppressWarnings("unchecked")
		 public DoubleIterator(){
			 theNextNode = (DoubleNode<E>) firstNode;
		 }
  
		 public boolean hasNext(){
			 return theNextNode != null;
		 }
		 
		 public E next(){
			 if (theNextNode != null){
				 E elementToReturn = theNextNode.element;
				 theNextNode = theNextNode.nextNode;
				 return elementToReturn;
			 }
			 else throw new NoSuchElementException("No next element");
		 }
		 
		 public void remove(){
			 throw new UnsupportedOperationException
                  ("remove not supported");
		 }   
	 }
	 
	 public static void main() {
		 
	 }
}
