package c3;
import c1.Queue;
@SuppressWarnings("unchecked")
public class LinearProbingHashST <Key, Value> {
	private static final int DEFAULT_CAPACITY = 8;
	private int m;
	private int n;//判断已经存在几个键值对用来扩容的.
	private Key[] keys;
	private Value[] vals;
	public LinearProbingHashST() {
		this(DEFAULT_CAPACITY);
	}
	public LinearProbingHashST(int m){
		this.m = m;
		keys = (Key[])new Object[m];
		vals = (Value[])new Object[m];
	}
	public void put(Key key, Value val) {
		if(key==null) throw new IllegalArgumentException("key is null");
		if(n>=m/2) {
			resize(2*m);
		}
		int index = hash(key);
		/*这样不能比较两个key的相等性，无法确定是覆盖还是添加键值对*/
		/*if(keys[index]!=null) {
			for(int j=index+1; j<m;j++) {
				if(keys[j]==null) {
					keys[j] = key;
					vals[j] = val;
					break;
				}
			}
		}*/
		int i;
		for(i = index; keys[i]!=null; i = (i+1)%m) {
			if(keys[i].equals(key)) {
				vals[i] = val;
				return;
			}
		}
		keys[i] = key;
		vals[i] = val;
		n++;
	}
	private void resize(int capacity) {
		LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<>(capacity);
		for(int i=0; i<m; i++) {
			if(keys[i]!=null) {
				temp.put(keys[i], vals[i]);
			}
		}
		this.m = temp.m;
		//this.n = temp  .n;
		this.keys = temp.keys;
		this.vals = temp.vals;
	}
	public boolean contains(Key key) {
		if(get(key)!=null) return true;
		else return false;
	}
	public Value get(Key key) {
		int i = hash(key);
		int j;
		for(j = i; keys[j]!=null; j = (j+1)%m) {
			if(keys[j].equals(key)) {
				return vals[j];
			}
		}
		return null;
	}
	public Iterable<Key> keys(){
		Queue<Key> q = new Queue<>();
		for(int i=0;i<m;i++) {
			if(keys[i]!=null) {
				q.enqueue(keys[i]);
			}
		}
		return q;
	}
	public void delete(Key key) throws Exception {
		if(key==null) return;
		if(!contains(key)) return;
		int i = hash(key);
		int j = i;
		while(!keys[j].equals(key)) {
			j = (j+1)%m;
		}
		keys[j] = null;
		vals[j] = null;
		n--;
	/*	for(j = i; keys[j]!=null; j = (j+1)%m) {
			if(keys[j].equals(key)) {
				keys[j] = null;
				vals[j] = null;
				n--;
				break;
			}
		}*/
		j = (j+1)%m;
		while(keys[j]!=null) {
			Key keyTemp = keys[j];
			Value valTemp = vals[j];
			keys[j] = null;
			vals[j] = null;
			n--;
			put(keyTemp, valTemp);
			j = (j+1)%m;
		}
		if(n>0&&n<=m/8) {
			resize(m/2);
		}
	}
	private int hash(Key key) {
		return (key.hashCode()&0x7fffffff)%m;
	}
}
