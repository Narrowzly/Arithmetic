package c2;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class InsertSort {
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
        for(int i=1; i<len; i++) {
           /* for(int j=i; j>0; j--) {
               if(less(a[j], a[j-1]))
                   exch(a, j, j-1);
               else break;
            }*/
            for(int j=i; j>0&&less(a[j],a[j-1]); j--) {
                exch(a, j, j-1);
            }
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
