package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RandomPickIndex398 {
	HashMap<Integer,List<Integer>> map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,2,3,3,3};
		RandomPickIndex398 cls = new RandomPickIndex398(nums);
		System.out.println(cls.pick(1));
		
		

	}
    

    public RandomPickIndex398(int[] nums) {
        map = new HashMap<Integer,List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
            	map.get(nums[i]).add(i);
            } else {
            	List<Integer> list = new ArrayList<>();
            	list.add(i);
            	map.put(nums[i], list);
            }
        }        
    }
    
    public int pick(int target) {
    	List<Integer> list = map.get(target);
    	System.out.println(list.size());
    	int rand = list.get(0);
    	for (int i = 1; i < list.size(); i++) {
    		int p = (int) (Math.random() * (i + 1));
    		if (p == i)
    			rand = list.get(i);
    	}
    	return rand;
    }
}
