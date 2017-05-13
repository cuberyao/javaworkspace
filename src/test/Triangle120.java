package test;

import java.util.List;

public class Triangle120 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int minimumTotal(List<List<Integer>> triangle) {
    	int layer = triangle.size();
        int[] layerSum = new int[layer];
        layerSum[0] = triangle.get(0).get(0);
        for (int i = 1; i < layer; i++) {
        	int last = triangle.get(i).size() - 1;
        	layerSum[last] = layerSum[last - 1] + triangle.get(i).get(i);
        	for (int j = last - 1; j > 0; j--) {
        		int min = layerSum[j];
        		min = Math.min(min, layerSum[j - 1]);
        		layerSum[j] = min + triangle.get(i).get(j);
        	}
        	layerSum[0] += triangle.get(i).get(0);
        }
        int ret = Integer.MAX_VALUE;
        for (int n : layerSum) {
        	if (n < ret)
        		ret = n;
        }
        return ret;
        
    }
}
