package test;

import java.util.HashMap;
import java.util.LinkedList;

public class LFUCache460 {
	//Could you do both operations in O(1) time complexity?
	HashMap<Integer, Integer> mapki; //<key,index> 
	HashMap<Integer, Integer> mapik; //<index,key>
	static int time;
	int capacity;
	int[][] freq;//freq[index] = value,freq,time;

    public LFUCache460(int capacity) {
    	 mapki = new HashMap<>();
    	 mapik = new HashMap<>();
    	 this.capacity = capacity;
    	 freq = new int[capacity][3];
    	 time = 0;
    }
    
    public int get(int key) {
    	if (mapki.containsKey(key)) {
    		int idx = mapki.get(key);
    		freq[idx][1]++;
    		freq[idx][2] = ++time;
    		return freq[idx][0];
    		//int[] vft = queue.get(idx);
    	} else 
    		return -1;        
    }
    
    public void set(int key, int value) {
    	if (mapki.containsKey(key)) {
    		int idx = mapki.get(key);
    		freq[idx][0] = value;
    		freq[idx][1]++;
    		freq[idx][2] = ++time;
    	} else if (mapki.size() < capacity) {
    		int idx = mapki.size();
    		mapki.put(key, idx);
    		mapik.put(idx, key);
    		freq[idx][0] = value;
    		freq[idx][1] = 0;
    		freq[idx][2] = ++time;
    	} else {
    		//先找使用频率最低的，如果唯一 则 剔除之，否则找出使用时间最早的剔除
    		int minfreq = Integer.MAX_VALUE;
    		for (int i = 0; i < capacity; i++) {
    			if (minfreq > freq[i][1]) 
    				minfreq = freq[i][1];
    		}
    		int mintime = Integer.MAX_VALUE;
    		int idx = -1;
    		for (int i = 0; i < capacity; i++) {
    			if (freq[i][1] == minfreq && mintime > freq[i][2]) {
    				mintime = freq[i][2];
    				idx = i;
    			}    			
    		}
    		mapki.remove(mapik.get(idx));
    		mapki.put(key, idx);
    		mapik.put(idx, key);
    		freq[idx][0] = value;
    		freq[idx][1] = 0;
    		freq[idx][2] = ++time;
    	}
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	System.out.println();
	}
}

