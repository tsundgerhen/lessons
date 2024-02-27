package lab2;

public class DoubleNode<E> {
	E element;
	DoubleNode<E> nextNode;
	DoubleNode<E> prevNode;
	public DoubleNode() {}
	
	public DoubleNode(E value) {
		element = value;
	}
	
	public DoubleNode(E theElement, DoubleNode<E> theNextNode, DoubleNode<E> thePrevNode) {
		element = theElement;
		nextNode = theNextNode;
		prevNode = thePrevNode;
	}
}