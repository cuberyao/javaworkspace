package test;

public class CircularArrayLoop457 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println((-1) % 3);
	}
	
    public static boolean circularArrayLoop(int[] nums) {
        //自己指向自己，才是无环
        if (nums.length < 2)
            return false;
        
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] != 0) {
        		
        	}
    		if (nums[Math.abs(nums[i] + i) % nums.length] == nums.length)
    			return false;
    	}
    	return true;
    }
}
