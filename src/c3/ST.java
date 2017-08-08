package c3;

import c1.Queue;

public class ST<Key, Value> {
	private Node first;
	private int size;
	private class Node {
		private Value val;
		private Key key;
		private Node next;
		public Node(Value val, Key key, Node next) {
			this.val = val;
			this.key = key;
			this.next = next;
		}
		public Value getVal() {
			return val;
		}
		public void setVal(Value val) {
			this.val = val;
		}
		public Key getKey() {
			return key;
		}
		public void setKey(Key key) {
			this.key = key;
		}
	}
	public Value get(Key key) {
		Node x = first;
		while(x!=null) {
			if(x.getKey().equals(key)) {
				return x.getVal();
			}
			x = x.next ;
		}
		return null;
	}
	public void put(Key key, Value val) {
		Node x = first;
		while(x!=null) {
			if(x.getKey().equals(key)) {
				x.setVal(val);
				return;
			}
		}
		first = new Node(val, key, first);
		size++;
	}
	public void delete(Key key) {
		first = delete(first, key);
	}
	private Node delete(Node node, Key key) {
		if(node == null) return null;
		if(node.getKey().equals(key)) {
			size--;
			return node.next;
		}
		node.next = delete(node.next, key);//正常返回它原来的next,若equals key返回它next的next;
		return node;
	}
	public int size() {
		return size;
	}
	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<>();
		Node x = first;
		while(x!=null) {
			queue.enqueue(x.getKey());
			x = x.next;
		}
		return queue;
	}
}
