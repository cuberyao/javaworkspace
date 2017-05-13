package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicatesinanArray442 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,3,2,7,8,2,3,1};
		findDisappearedNumbers(nums);

	}
    public static List<Integer> findDisappearedNumbers(int[] nums) {
    	//int flag = nums[0];
        for (int i = 0; i < nums.length; i++) {
        	int j = nums[i];
        	while (nums[j - 1] != j) {
        		int tmp = nums[j - 1];
        		nums[j - 1] = j;
        		j = tmp;
        	}
        }
        System.out.println(Arrays.toString(nums));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] != i + 1) {
        		list.add(nums[i]);
        	}
        }
        return list;
    }
}
