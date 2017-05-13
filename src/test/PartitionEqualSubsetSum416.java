package test;

import java.util.Arrays;

public class PartitionEqualSubsetSum416 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,5,7,3,14,8,6,11,5};
		System.out.println(canPartition(nums));

	}

	public static boolean canPartition(int[] nums) {
		if (nums == null || nums.length == 0)
			return true;
		int sum = 0;
		for (int n : nums)
			sum += n;
		if (sum % 2 != 0)
			return false;
		sum /= 2;
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;
		for (int i = 0; i < nums.length; ++i) {
			for (int j = sum; j >= nums[i]; --j)
				dp[j] = dp[j] || dp[j - nums[i]];
		}
		return dp[sum];
	}

}
