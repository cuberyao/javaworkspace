package test;

import java.util.HashMap;
import java.util.Map.Entry;

public class NumberOfBoomerangs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int numberOfBoomerangs(int[][] points) {
        int cnt = 0;
        for (int i = 0; i < points.length; i++) {
        	HashMap<Integer, Integer> map = new HashMap<>();
        	for (int j = 0; j < points.length; j++) {
        		int tmp = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0])
        				+ (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
        		if (map.containsKey(tmp)) {
        			map.put(tmp, map.get(tmp) + 1);
        		} else {
        			map.put(tmp, 1);
        		}
        	}
        	for (Integer value : map.values()) {
        		if (value >= 2) {
        			cnt += value * (value - 1);  
        		}
        	}
        }
        return cnt;
    }
}
