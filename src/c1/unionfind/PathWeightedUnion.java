package c1.unionfind;

import edu.princeton.cs.algs4.StdIn;

/**
 * @author NarrowKaKa
 *
 */
public class PathWeightedUnion {
    private int id[];
    private int count;
    private int sz[];
    public PathWeightedUnion(int n) {
        id = new int[n];
        sz = new int[n];
        count = n;
        for(int i=0;i<n;i++) {
            id[i] = i;
        }
        for(int i=0;i<n;i++) {
            sz[i] = 1;
        }
    }
    public int find(int p) {
        int root = p;
        while(id[root]!=root) root=id[root];
        while(root!=p) {
            int temp = id[p];
            id[p] = root;
            p = temp;
        }
        return root;
    }
    public int getCount() {
        return count;
    }
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot==qRoot) return;
        if(sz[pRoot]<sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot]; 
        }else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        count--;
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int n = StdIn.readInt();
        PathWeightedUnion pwu = new PathWeightedUnion(n);
        while(!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            pwu.union(p, q);
        }
        long end = System.currentTimeMillis();
        System.out.println("spend time:"+(end-start));
        System.out.println(pwu.getCount());
    }
}
