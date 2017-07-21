package c2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MergeSort {
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
	    	sort(a, 0, a.length-1);
	    }
	    private static <T> void sort(Comparable<T>[] a, int start, int end) {
	    	if(start>=end) return;
	    	int middle = (start+end)/2;
	        sort(a, start, middle);
	    	sort(a, middle+1, end);//5   3   8     6 9
	    	merge(a, start, end);
		}
		public static <T> boolean isSorted(Comparable<T>[] a) {
	        for(int i=1;i<a.length;i++) {
	            if(less(a[i], a[i-1])) {
	            	return false;
	            }
	        }
	        return true;
	    }
	    public static <T> void merge(Comparable<T>[] a, int start, int end) {
	    	int middle = (start+end)/2;
	    	Comparable<T>[] stage = new Comparable[a.length];//你根本不知道长度到底有多长只能取最长,并不好每次都要new影响效率
	    	for(int i=start;i<=end;i++) {
	    		stage[i] = a[i];
	    	}
	    	int i=start; 
	    	int j=middle+1;
	    	for(int k=start;k<=end; k++) {//不是length它和end不一样,你如果5到6, 根本循环不起来
	    		if(i>middle) a[k] = stage[j++];
	    		else if(j>end) a[k] = stage[i++];
	    		else if(less(stage[j],stage[i])) a[k] = stage[j++];
	    		else a[k] = stage[i++];	    		
	    	}
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
