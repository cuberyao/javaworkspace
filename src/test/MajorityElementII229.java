package test;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII229 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if (nums.length == 0)
        	return ret;
        int num1 = nums[0];int num2 = nums[0];int cnt1 = 0;int cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == num1) {
        		cnt1++;
        	} else if (nums[i] == num2) {
        		cnt2++;
        	} else if (cnt1 == 0) {
        		num1 = nums[i];
        		cnt1 = 1;
        	} else if (cnt2 == 0) {
        		num2 = nums[i];
        		cnt2 = 1;
        	} else {
        		cnt1--;
        		cnt2--;
        	}
        }
        cnt1 = 0;cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == num1) {
        		cnt1++;
        	} else if (nums[i] == num2) {
        		cnt2++;
        	}
        }
        if (cnt1 > nums.length / 3) 
        	ret.add(num1);
        if (cnt2 > nums.length / 3) 
        	ret.add(num2);        
        return ret;
    }

}
