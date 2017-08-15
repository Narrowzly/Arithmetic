package c3;

public class RBBST<Key extends Comparable<Key>, Value> {
	private Node root;
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private class Node {
		private Node left;
		private Node right;
		private boolean color;
		private Key key;
		private Value val;
		private int N;
		public Node(boolean color, Key key, Value val, int N) {
			this.color = color;
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}
	public int size() {
		return size(root);
	}
	private int size(Node n) {
		if(n==null) {
			return 0;
		}
		return n.N;
	}
	private boolean isRed(Node n) {
		if(n==null) return false;
		return n.color == RED;
	}
	private Node rotateLeft(Node n) {
		Node x = n.right;
		n.right = x.left;
		x.left = n;
		x.color = n.color;
		n.color = RED;
		x.N = n.N;
		n.N = size(n.left)+size(n.right)+1;
		return x;
	}
	private Node rotateRight(Node n) {
		Node x = n.left;
		n.left = x.right;
		x.right = n;
		x.color = n.color;
		n.color = RED;
		x.N = n.N;
		n.N = size(n.left)+size(n.right)+1;//变了 变成x了
		return x;
	}
	private void moveCenterKey(Node n) {
		n.left.color = BLACK;
		n.right.color = BLACK;
		n.color = RED;
		//return n;还是原来的
	}
	public void put(Key key, Value val) {
		root = put(root, key, val);
		root.color = BLACK;
	}
	private Node put(Node n, Key key, Value val) {
		if(n==null) {
			return new Node(RED, key, val, 1);
		}
		int cmp = key.compareTo(n.key);
		if(cmp<0) n.left = put(n.left, key, val);
		else if(cmp>0) n.right = put(n.right, key, val);
		else n.val = val; //find key
		
		if(!isRed(n.left)&&isRed(n.right)) n = rotateLeft(n);
		if(isRed(n.left)&&isRed(n.left.left)) n = rotateRight(n);
		if(isRed(n.left)&&isRed(n.right)) moveCenterKey(n);
		
		n.N = size(n.left) + size(n.right) + 1;
		
		return n;
	}
}
