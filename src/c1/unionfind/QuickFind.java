package c1.unionfind;
import edu.princeton.cs.algs4.StdIn;
/**
 * @author NarrowKaKa
 *
 */
public class QuickFind{
	private int[] ids;
	private int count;
	public QuickFind(int n) {
		count = n;
		ids = new int[n];
		for(int i=0; i<n; i++) {
			ids[i]=i;//为了简单都是从0到n的
		}
	}
	public int getCount() {
		return count;
	}
	public int find(int p) {
		return ids[p];
	}
	public boolean connect(int p, int q) {
		return find(p) == find(q);
	}
	public void union(int p, int q) {
		int pid = find(p);
		int qid = find(q);
		for(int i=0;i<ids.length;i++) {
			if(pid==ids[i]) ids[i] = qid; 
		}
		count--;
	}

    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickFind uf = new QuickFind(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connect(p, q))
                continue;
            else
                uf.union(p, q);
        }
        System.out.println(uf.getCount());
    }

}
