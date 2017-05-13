package test;

import java.util.Arrays;

public class LIS300 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LIS300 obj = new LIS300();
		int[] nums = {10, 11, 2, 5, 3, 7, 101, 18};
		obj.lengthOfLIS(nums);
	}
    public int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;
        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
          System.out.println(i+Arrays.toString(dp));
        }
        return len;
    }
}
