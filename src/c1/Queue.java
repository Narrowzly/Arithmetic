package c1;

import java.util.*;
@SuppressWarnings({"rawtypes","unchecked"})
public class Queue<Item> implements Iterable<Item> {
	private Node<Item> first;
	private Node<Item> last;
	private int N;
	private class Node<Item>{
		public Node<Item> next;
		public Item item;
	}
	public boolean isEmpty() {
		return first==null;//我觉得N==0不是很好，因为出队的时候已经是空队列了，但是N还没有减小，还为1.
	}
	public int size() {
		return N;
	}
	public void enqueue(Item item) {
		Node<Item> newLast = new Node();
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
		return new ListIterator<Item>(first);
	}
	private class ListIterator<Item> implements Iterator<Item>{
		private Node<Item> current;
		private ListIterator(Node<Item> n) {
			current = n;
		}
		public boolean hasNext() {
			return current != null;
		}
		@Override
		public Item next() {
			if(!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
}
