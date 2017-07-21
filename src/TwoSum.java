import java.util.*;

public class TwoSum {
	public static void main(String[] args) {
		System.out.println(twoSum(new int[]{3,5,8,12},15));
	}
	public static int[] twoSum(int[] numbers, int target) {
	    int[] result = new int[2];
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < numbers.length; i++) {
	        if (map.containsKey(target - numbers[i])) {
	            result[1] = i + 1;
	            result[0] = map.get(target - numbers[i]);
	            return result;
	        }
	        map.put(numbers[i], i + 1);
	    }
	    return result;
	}
}
