package nowCoder;

public class BitCount {
	 public static int bitCount(int i) {
		i = i - ((i >>> 1) & 0x55555555);//求出每两位的个数
		System.out.println(Integer.toBinaryString(i));
		i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
		System.out.println(Integer.toBinaryString(i));
		i = (i + (i >>> 4)) & 0x0f0f0f0f;
		System.out.println(Integer.toBinaryString(i));
		i = i + (i >>> 8);
		System.out.println(Integer.toBinaryString(i));
		i = i + (i >>> 16);
		System.out.println(Integer.toBinaryString(i));
		return i & 0x3f;
	 }
	 public static void main(String[] args) {
		 System.out.println(bitCount(-1));
	 }
}
