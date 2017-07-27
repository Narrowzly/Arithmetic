package c2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {
	public static <T> void exch(Comparable<T>[] a, int i, int j) {
		Comparable<T> temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	@SuppressWarnings("unchecked")
	public static <T> boolean less(Comparable<T> a, Comparable<T> b) {
		if (a.compareTo((T) b) < 0)
			return true;
		return false;
	}
	
	public static <T> int partition(Comparable<T>[] a, int start, int end) {
		Comparable<T> partVal = a[start];
		int i = start;
		int j = end + 1;
		while (true) {
			while (less(partVal, a[--j]))
				if (j == start)
					break;// 当a[--j]<partVal时跳出循环.进行交换
			while (less(a[++i], partVal))
				if (i == end)
					break;
			if (i >= j)
				break;
			exch(a, i, j);
		}

		System.out.println(i); // lo和lt相等，lt移到了i的位置
		System.out.println(j);
		System.out.println(partVal);
		exch(a, start, j);// 为什么取j？a[i]>=partVal a[j]<=partVal，跟i换的话第一个数有可能大于等于partVal
		return j;
	}

	public static <T> void sort(Comparable<T>[] a, int start, int end) {
		if (start >= end)
			return;
		int partPos = partition(a, start, end);
		sort(a, start, partPos - 1);
		sort(a, partPos + 1, end);
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
