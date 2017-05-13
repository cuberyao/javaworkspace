import java.util.Arrays;

public class Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 100000;
		int[] nums = new int[N + 1];
		primeNums(nums);
		int ret = 0;
		for (int i = 2; i <= N / 2; i++) {
			if (nums[i] == 0 && nums[N - i] == 0)
				ret++;
		}			
		System.out.println(ret);

	}
	
	public static void primeNums(int[] nums) {
//		int start = 2;
//		int count = 0;
//		while (start < nums.length) {
//			int i = 2 * start;
//			while (i < nums.length) {
//				nums[i] = -1;
//				i += start;
//				count++;
//			}
//			start++;
//			while (start < nums.length && nums[start] == -1) 
//				start++;
//		}
		int count = 0;
		for (int i = 2; i < nums.length; i++) {
			if (nums[i] == 0) {
				for (int j = 2 * i; j < nums.length; j += i) {
					nums[j] = 1;
					count++;					
				}
			}
		}
		System.out.println(count);
	}

}
