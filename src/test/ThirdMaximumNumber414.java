package test;

public class ThirdMaximumNumber414 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,-1,Integer.MIN_VALUE,Integer.MIN_VALUE};
		System.out.println(thirdMax(nums));

	}
    public static int thirdMax(int[] nums) {
    	long max = Long.MIN_VALUE;
    	long mid = Long.MAX_VALUE;
    	long min = Long.MAX_VALUE;
    	//max = nums[0];
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] > max) {
    			min = mid;
    			mid = max;
    			max = nums[i];
    		} else if (nums[i] < max && nums[i] > mid) {
    			min = mid;
    			mid = nums[i];
    		} else if (nums[i] < mid && nums[i] > min){
    			min = nums[i];
    		}
 System.out.println("max="+max+",mid="+mid+",min="+min);
    	}
    	if (min != Long.MIN_VALUE) return (int)min;
    	else return (int)max;
        
        
    }
}
