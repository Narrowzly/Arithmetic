package c2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ShellSort {
	public static <T> void exch(Comparable<T>[] a, int i, int j) {
        Comparable<T> temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static <T> boolean less(Comparable<T> a,Comparable<T> b) {
        if(a.compareTo((T)b)<0) return true;
        return false;
    }
    public static <T> void sort(Comparable<T>[] a) {
    	int len = a.length;
    	int gap= len/2;
    	/*int gap = 1;
    	while (gap < N/3) gap = 3*gap+1;*/
    	while(gap>=1) {
    		for(int i=gap;i<len;i++) {
    			for(int j=i;j>=gap&&less(a[j],a[j-gap]);j-=gap) {
    				exch(a, j, j-gap);
    			}
    		}
    		gap = gap/2;
    		//gap = gap/3;
    	}
    }
    public static <T> boolean isSorted(Comparable<T>[] a) {
        for(int i=1;i<a.length;i++) {
            if(less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }
    public static <T> void show(Comparable<T>[] a) {
        for(int i=0; i<a.length; i++) {
            StdOut.print(a[i]+" ");
        }
        StdOut.println();
    }
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        StdOut.println(isSorted(a));
        show(a);
    }
}
