package c1.unionfind;
import edu.princeton.cs.algs4.StdIn;
/**
 * @author NarrowKaKa
 *
 */
public class QuickUnion {
    private int[] id;
    private int count;
    public QuickUnion(int n) {
        id = new int[n];
        count = n;
        for(int i=0; i<n; i++) {
            id[i] = i;
        }
    }
    public int find(int p) {
        while(id[p]!=p) p = id[p];
        return p;
    }
    public void union(int p, int q) {
       int pRoot = find(p);
       int qRoot = find(q);
       if(pRoot==qRoot) return;
       else id[pRoot] = qRoot;
       count--;
    }
    public int getCount() {
        return count;
    }
    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickUnion qu = new QuickUnion(n);
        while(!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            qu.union(p, q);
        }
        System.out.println(qu.getCount());
    }

    
}
