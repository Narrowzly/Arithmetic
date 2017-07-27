package c2;

public class IndexMinQueue<T> {
	private int[] pq;//维护一个优先队列，维护keys的index.
	private int[] qp;//为了快速找到keys对应于pq的index.
	private Comparable<T>[] keys;
	private int size;
	
	@SuppressWarnings("unchecked")
	public IndexMinQueue(int maxSize) {
		keys = new Comparable[maxSize+1];
		qp = new int[maxSize+1];
		pq = new int[maxSize+1];
		for(int i=0;i<maxSize+1;i++) {
			qp[i] = -1;
		}
	}
	public void insert(int i, Comparable<T> key) {
		size++;
		keys[i] = key;
		qp[i] = size;
		pq[size] = i;
		swim(size);
	}
	public int delMin() {
		int min = pq[1];
		exch(1, size);
		keys[pq[size]] = null;
		qp[pq[size]] = -1;
		pq[size] = -1;
		size--;
		sink(1);
		return min;
	}
	public int minIndex() {
		return pq[1];
	}
	public Comparable<T> minKey(){
		return keys[pq[1]];
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public int getSize() {
		return size;
	}
	public void swim(int k) {
		while(k>1) {
			if(less(pq[k/2], pq[k])) break;
			else exch(k, k/2);
			k = k/2;
		}
	}
	public void sink(int k) {
		while(2*k<=size) {
			int j=2*k;
			if(j<size&&less(pq[j+1], pq[j])) j++;
			if(less(pq[k], pq[j])) break;
			else exch(j, k);
			k = j;
		}
	}
	public void exch(int i, int j) {
		int temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
		qp[pq[i]] = i;
		qp[pq[j]] = j;
	}
	@SuppressWarnings("unchecked")
	public boolean less(int i, int j) {
		return (keys[i].compareTo((T)keys[j])<0);
	}
}