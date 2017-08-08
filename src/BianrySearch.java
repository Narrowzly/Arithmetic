public class BianrySearch {
	public static void main(String[] args) {
		int[] a = {9, 3, 17, 23, 45, 78, 54, 41};
		a = rank(a);
		System.out.println(pArray(a));
		System.out.println(search(17, a));
	}
	public static int[] rank(int[] a) {
		for(int i=0; i<a.length; i++) {
			for(int j=i+1; j<a.length; j++) {
				if(a[i]>a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}
	public static int search(int key, int[] a) {	
		int start = 0;
		int end = a.length-1;
		while(start<=end) {
			int middle = start+(end-start)/2;//int middle = (end+start)/2;溢出	
			if(key==a[middle]) {
				return middle;
			}else if(key<a[middle]) {
				end = middle-1;
			}else if(key>a[middle]) {
				start = middle+1;
			}
		}		
		return -1;
	}
	public static String pArray(int[] a) {
		String array = "";
		for(int i=0;i<a.length;i++) {
			array+=a[i]+" ";
		}
		return array;
	}

}
