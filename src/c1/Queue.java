package c1;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int N;
	private class Node{
		public Node next;
		public Item item;
		   /*
		   1  2  3  4 
	       5  6  7  8 
	       9  10 11 12 
	       13 14 15 16
	       
	       */
	}
	public boolean isEmpty() {
		return first==null;//我觉得N==0不是很好，因为出队的时候已经是空队列了，但是N还没有减小，还为1.
	}
	public int size() {
		return N;
	}
	public void enqueue(Item item) {
		Node newLast = new Node();
		newLast.next = null;
		newLast.item = item;
		if(isEmpty()) first = newLast;
		else last.next = newLast;
		last = newLast;
		N++;
	}
	public Item outqueue() {
		if(first==null) return null;
		Item item = first.item;
		first.item = null;
		first = first.next;
		if(isEmpty()) last = null; 
		N--;
		return item;
	}
	@Override
	public Iterator<Item> iterator() {
		return null;
	}

}
