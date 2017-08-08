package c2;

public class PriorityQueue<T> {
	private Comparable<T>[] keys;
	private int size;
	@SuppressWarnings("unchecked")
	public PriorityQueue (int max) {
		keys = new Comparable[max+1];
		size = 0;
	}
	public int getSize() {
		return size;
	}
	public void insert(Comparable<T> a) {
		/*keys[size+1] = a;
		size++;*/
		keys[++size] = a;
		swim(size);
	}
	public Comparable<T> delMax() {
		Comparable<T> max = keys[1];
		exch(1, size);
		keys[size] = null;
		size--;
		sink(1);
		return max;
	}
	public void exch(int i, int j) {
		Comparable<T> temp = keys[i];
		keys[i] = keys[j];
		keys[j] = temp;
	}

	@SuppressWarnings("unchecked")
	public boolean less(int i, int j) {
		if (keys[i].compareTo((T)keys[j]) < 0)
			return true;
		return false;
	}
	public void swim(int k) {
		Comparable<T> key = keys[k];
		while(k>1) {//到1就停止了也就是k=2时进行最后一次可能的交换。
			/*if(less(k/2 , k))
			exch(k, k/2);       
			k = k/2;*/
			if(less(k, k/2)) break;
			keys[k] = keys[k/2];		
			k = k/2;
		}
		keys[k]  = key;//赋值次数变少
	}
	public boolean isEmpty() {
		return size==0;
	}
	public void sink(int k) {
		while(2*k<=size) {
			int j=2*k;
			if(less(j, j+1)) j++;
			if(!less(k, j)) break;//不直接break不小于不交换一直到倒数第二行才停止。浪费时间         
			else exch(k, j);
			k=j;
		}
	}
}
