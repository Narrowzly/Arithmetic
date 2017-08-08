import java.util.*;

public class TestBitSet {
	public static void main(String[] args) {
		long startMillis = System.currentTimeMillis();
		int n = 2000000;
		int count = 0;
		BitSet b = new BitSet(n+1);
		b.set(2);
		for(int i=3;i<b.size();i+=2)//2000000
		b.set(i);//a[0], a[1], a[2], a[2000000]
		int i=2;
		while(i*i<n) {//首先n递增的话，肯定是有一个合数小于n的开平方，因为n的合数是最大了了，所以节省了时间。
			if(b.get(i)) {
				count++;
				int j=2;
				while(j*i<=n) {
					b.clear(j*i);
					j++;
				}
			}
			i++;
		}
		while(i<=n) {//不用归零接着计算而已。
			if(b.get(i)) {
				count++;
			}
			i++;
		}
		long endMillis = System.currentTimeMillis();
		System.out.println("prime num:"+ count);
		System.out.println("time:" + (endMillis-startMillis));
	}
}
