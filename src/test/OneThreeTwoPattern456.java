package test;

import java.util.Arrays;

public class OneThreeTwoPattern456 {

	public static void main(String[] args) {
		//int[] nums ={3,5,0,3,4};
		int[] nums = {-1,10,-20,-10,-15};
System.out.println(find132pattern(nums));
	}
/*    public static boolean find132pattern(int[] nums) {
    	if (nums.length < 3)
    		return false;
        int[] stack = new int[2];
        stack[0] = nums[0];
        int p = 0;
        for (int i = 1; i < nums.length; i++) {
        	if (p == 0) {
        		if (nums[i] < stack[p])
        			stack[p] = nums[i];
        		else if (nums[i] > stack[p]){
        			p++;
        			stack[p] = nums[i];
        		}
        	} else if (p == 1) {
        		if (nums[i] < stack[1] && nums[i] > stack[0]) 
        			return true;
        		else if (nums[i] > stack[1]) {
        			stack[p] = nums[i];
        		} else if (nums[i] < stack[1] && nums[i] < stack[0]) {
        			int j = i + 1;
        			while (j < nums.length) {
                		if (nums[j] < stack[1] && nums[j] > stack[0]) 
                			return true;
                		j++;
        			}
        			p--;
        			stack[0] = nums[i];
        		}
        	}
        }
        return false;
        
    }*/
	
	public static boolean find132pattern(int[] nums) {
    	if (nums.length < 3)
    		return false;
    	int[] stacki = new int[nums.length];
    	int[] stackk = new int[nums.length];
    	int ai = nums[0];
    	int ak = nums[0];
    	int p = 0;
    	for (int i1 = 0; i1 < nums.length; i1++) {
    		int num = nums[i1];
    		if (num < ai) {
    			stacki[p] = ai;
    			stackk[p] = ak;
    			p++;
    			ai = num;
    			ak = num;
    		} else if (num > ak) {
    			while (p > 0 && stackk[p - 1] <= num) {
    				p--;
    			}
    			if (p > 0 && stacki[p - 1] < num) {
    				return true;
    			}
    			ak = num;
    		} else if (num < ak && num > ai) {
    			return true;
    		}
    		
    		System.out.println(num+",ai="+ai+Arrays.toString(stacki));
    		System.out.println(num+",ak="+ak+Arrays.toString(stackk));
    	}
    	return false;
    }

}
