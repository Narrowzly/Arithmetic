package c2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class MultiwayMerge {
	public static void merge(In[] streams) {
		int max = streams.length;
		IndexMinQueue<String> queue = new IndexMinQueue<>(max);
		for(int i=0; i<max; i++) {
			queue.insert(i, streams[i].readString());
		}
		while(!queue.isEmpty()) {
			StdOut.println(queue.minKey());
			int i = queue.delMin();
			if(!streams[i].isEmpty())
			queue.insert(i, streams[i].readString());
		}
	}
	public static void main(String[] args) {
		int len = args.length;
		In[] streams = new In[len];
		for(int i=0;i<len;i++) {
			streams[i] = new In(args[i]);
		}
		merge(streams);
	}
}
