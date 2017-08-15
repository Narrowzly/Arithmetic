package c3;
@SuppressWarnings("unchecked")
public class SeparateChainingHashST<Key, Value> {
	private ST<Key, Value>[] sts;
	private static final int DEFAULT_CAPACITY = 10;
	private int n;
	private int m;
	public SeparateChainingHashST() {
		this(DEFAULT_CAPACITY);
	}
	public SeparateChainingHashST(int m) {
		sts = (ST<Key,Value>[])new ST[m];
		this.m  = m;
		for(int i=0;i<m;i++) {//你这边不打雷电后面会抛NullPointer异常的
			sts[i] = new ST<>();
		}
	}
	public void put(Key key, Value val) {
		int i = hash(key);
		if(i>m) {
			resize();
		}
		sts[i].put(key, val);
	}
	
	public int hash(Key key) {
		return (key.hashCode()&0x7fffffff)%m;//通过hash方法得到下标.
	}
	
	public Value get(Key key) {
		int i = hash(key);
		Value val = sts[i].get(key);
		return val;
	}
	
	private void resize() {
		ST<Key, Value>[] temp = (ST<Key,Value>[])new ST[m*2];
		for(int i=0;i<temp.length;i++) {
			temp[i] = sts[i];
		}
		sts = temp;
	}
}
