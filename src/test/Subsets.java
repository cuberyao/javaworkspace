package test;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();
		int len = nums.length;
		for (int i = 0; i < Math.pow(2, len); i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < len; j++) {
				if (j % 2 != 0) {
					list.add(nums[j]);
				}
			}
			ret.add(list);
		}
		return ret;
	}
}
