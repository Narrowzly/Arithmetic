package c3;



public class BinarySearchST <Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] vals;
	private int N;
	@SuppressWarnings("unchecked")
	public BinarySearchST(int capcity) {
		keys = (Key[])new Comparable[capcity];
		vals = (Value[])new Object[capcity];
	}
	public int size() {
		return N;
	}
	public boolean isEmpty() {
		return N==0;
	}
	public void put(Key key,Value val) {
		int i = rank(key);
		if(keys[i].compareTo(key)==0&&i<N) {
			vals[i] = val;
			return;
		}
		for(int j=N;j>i;j--) {
			keys[j] = keys[j-1];
			vals[j] = vals[j-1];
		}
		keys[i] = key;
		vals[i] = val;
		N++;
		return;
	}
	public int rank(Key key) {
		int lo = 0;
		int hi = N-1;
		while(lo<=hi) {
			int mid = lo + (hi-lo)/2;
			if(key.compareTo(keys[mid])>0) lo = mid + 1;
			else if(key.compareTo(keys[mid])<0) hi = mid-1;
			else return mid;
		}
		return lo;
	}
	public Value get(Key key) {
		if(N==0) return null;
		int i = rank(key);
		if(keys[i].compareTo(key)==0&&i<N) {
			return vals[i];
		}
		else return null;
		
	}
	public void delete(Key key) {
		if(isEmpty()) {
			return;
		}
		int i = rank(key);
		if(keys[i].compareTo(key)==0&&i<N) {
			keys[i] = null;
			vals[i] = null;
			for(int j=i;j<N-1;j++) {
				keys[j] = keys[j+1];
				vals[j] = vals[j+1];
			}
		}else return;
	}
}
