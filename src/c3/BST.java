package c3;

import c1.Queue;

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;
	private class Node{
		private Node right;
		private Node left;
		private Key key;
		private Value val;
		private int N;//子树中结点的总数包括其自身.
		public Node(Key key, Value val, int N) {
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
	public Value get(Key key) {
		return get(root, key);
	}
	private Value get(Node n, Key key) {
		if(n==null) {
			return null;
		}
		else if(key.compareTo(n.key)==0) {
			return root.val;
		}
		else if(key.compareTo(n.key)>0) {
			return get(n.right, key);
		}else {
			return get(n.left, key);
		}
	}
	public void put(Key key,Value val) {
		root = put(root, key, val);
	}
	private Node put(Node n, Key key, Value val) {
		if(n==null) {
			return new Node(key, val, 1);
		}
		else if(key.compareTo(n.key)==0) {
			n.val = val;
		}else if(key.compareTo(n.key)>0) {
			n.right = put(n.right, key, val);
		}else {
			n.left = put(n.left, key, val);
		}
		n.N = size(n.left)+size(n.right)+1;
		return n;
	}
	public Key max() {
		return max(root).key;
	}
	private Node max(Node n) {
		if(n.right==null) return n;
		return max(n.right);
	}
	public Key min() {
		return min(root).key;
	}
	private Node min(Node n) {
		if(n.left==null) return n;
		return min(n.left);
	}
	public Key floor(Key key) {
		Node x = floor(root, key);
		if(x==null) return null;
		return x.key;
	}
	private Node floor(Node x, Key key) {
		if(x==null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp<0) return floor(x.left, key);
		else if(cmp>0) {
			Node n = floor(x.right, key);
			if(n!=null) return n;
			else return x;
		}
		else return x;
	}
	public Key select(int k) {
		return select(root, k).key; 
	}
	private Node select(Node n, int k) {
		if(n==null) return null;
		int t = size(n.left);
		if(t>k) return select(n.left, k);
		else if(t<k) return select(n.right, k-t-1);
		else return n;
	}
	public int rank(Key key) {
		return rank(root, key);
	}
	private int rank(Node n, Key key) {
		if(n==null) return 0;
		int cmp = key.compareTo(n.key);
		if(cmp<0) return rank(n.left, key);
		else if(cmp>0) return 1+size(n.left)+rank(n.right, key);
		else return size(n.left);
	}
	public void delMin() {
		root = delMin(root);
	}
	private Node delMin(Node n) {
		if(n.left==null) {
			return n.right;
		}
		n.left = delMin(n.left);
		n.N = size(n.left)+size(n.right)+1;//这个必须要用递归写不然无法把N的值全改了。
		return n;
	}
	public void delete(Key key) {
		root = delete(root, key);
	}
	private Node delete(Node n, Key key) {
		if(n==null) return null;
		int cmp = key.compareTo(n.key);
		if(cmp<0) n.left = delete(n.left, key);
		else if(cmp>0) n.right = delete(n.right, key);
		else {
			if(n.right == null) return n.left;
			if(n.left == null) return n.right;
			Node t = n;
			n = min(t.right);
			n.left = t.left;
			n.right = delMin(t.right);
		}
		n.N = size(n.left) + size(n.right);
		return n;
	}                                                                                                                                    
	public Iterable<Key> iterator() {
		return iterator(min(), max());
	}
	private Iterable<Key> iterator(Key lo, Key hi) {
		Queue<Key> queue = new Queue<>();
		search(root, queue, lo, hi);
		return queue;
	}
	private void search(Node n, Queue<Key> queue, Key lo, Key hi) {
		if(n==null) {
			return;
		}
		int locmp = lo.compareTo(n.key); 
		int hicmp = hi.compareTo(n.key);
		if(locmp<0) search(n.left, queue , lo, hi);//lo<n.key说明在n的左子树一定范围内可以直到小于lo
		if(locmp<=0&&hicmp>=0) queue.enqueue(n.key);//
		if(hicmp>0) search(n.right, queue, lo, hi);//hi>n.key说明在n的右子树一定范围内可以直到大于hi. 
	}
}




 