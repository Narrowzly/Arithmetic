package c3;

public class AVLBST<Key extends Comparable<Key>, Value> {
	private Node root;
	private class Node{
		private Key key;
		private Value val;
		private int N;
		private int height;
		private Node left;
		private Node right;
		public Node(Key key, Value val, int n, int height) {
			super();
			this.key = key;
			this.val = val;
			this.N = n;
			this.height = height;
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
	public int height() {
		return height(root);
	}
	private int height(Node n) {
		if(n==null) {
			return 0;
		}
		return n.height;
	}
	private Node llRotate(Node n) {
		Node nl = n.left;
		n.left = nl.right;
		nl.right = n;
		n.height = Math.max(n.right.height, n.left.height)+1;
		nl.height = Math.max(nl.right.height, nl.left.height)+1;
		return nl;
	}
	private Node rrRotate(Node n) {
		Node nr = n.right;
		n.right = nr.left;
		nr.left = n;
		n.height = Math.max(n.right.height, n.left.height)+1;
		nr.height = Math.max(nr.right.height, nr.left.height)+1;
		return nr;
	}
	private Node lrRotate(Node n) {
		n.left = rrRotate(n.left);
		n = llRotate(n);
		return n;
	}
	private Node rlRotate(Node n) {
		n.right = llRotate(n.right);
		n = rrRotate(n);
		return n;
	}
	public void insert(Key key,Value val) {
		root = insert(root, key, val);
	}
	private Node insert(Node n, Key key, Value val) {
		if(n==null) {
			return new Node(key, val, 1, 1);
		}
		int cmp = key.compareTo(n.key);
		if(cmp<0) {
			n.left = insert(n.left, key, val);
			if((n.left.height-n.right.height)==2) {
				if(key.compareTo(n.left.key)<0) {
					llRotate(n.left);
				}else {
					lrRotate(n.left);
				}
			}
		}else if(cmp>0){
			n.right = insert(n.right, key, val);
			if((n.right.height-n.left.height)==2) {
				if(key.compareTo(n.right.key)>0) {
					rrRotate(n.right);
				}else {
					rlRotate(n.right);
				}
			}
		}else {
			n.val = val;
		}
		n.height = Math.max(n.left.height, n.right.height)+1;
		return n;
	}
	
}
