package c2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ThreeQuickSort {
	public static <T> void exch(Comparable<T>[] a, int i, int j) {
		Comparable<T> temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static <T> boolean less(Comparable<T> a, Comparable<T> b) {
		if (a.compareTo((T) b) < 0)
			return true;
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> void sort(Comparable<T>[] a, int start, int end) {
		if(start>=end) return;
		int lt = start;
		int i = start+1;
		int gt = end;
		Comparable<T> compareVal = a[start];
		while(i<=gt) {
			int result = a[i].compareTo((T) compareVal);
			if(result<0) exch(a, lt++, i++);
			else if(result>0) exch(a, i, gt--);//i的值换完就变了
			else i++;
		}
		sort(a, start, lt-1);
		sort(a, gt+1, end);
	}

	public static <T> boolean isSorted(Comparable<T>[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	public static <T> void show(Comparable<T>[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}

	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
		StdOut.println(isSorted(a));
		show(a);
	}
}
