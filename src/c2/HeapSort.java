package c2;

import edu.princeton.cs.algs4.StdIn;

public class HeapSort {
	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		sort(a);
		show(a);
	}
	
	private static <T>void sink(Comparable<T>[] a, int k, int len) {
		while(2*k<len) {
			int j=2*k;
			if(j<len&&less(a, j, j+1)) j++;
			if(less(a, j, k)) break;
			exch(a, j, k);
			k = j;
		}
	}
	private static <T>void exch(Comparable<T>[] a, int i, int j) {
		Comparable<T> temp = a[i-1];
		a[i-1] = a[j-1];
		a[j-1] = temp;
	}
	@SuppressWarnings("unchecked")
	private static <T> boolean less(Comparable<T>[] a, int i, int j) {
		return a[i-1].compareTo((T)a[j-1])<0;
	}
	private static <T> void sort(Comparable<T>[] a) {
		int len = a.length;
		for(int i=len/2;i>=1;i--) {
			sink(a, i, len);//0123->1234(操作exch和less index即可)
		}
		while(len>1) {
			exch(a, 1, len--);
			sink(a, 1, len);//=1变0，已经到底一次了
		}
		
	}

	private static <T> void show(Comparable<T>[] a) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}
}

