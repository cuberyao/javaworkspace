package test;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberofArrowstoBurstBalloons452 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length < 1) return 0;
        Arrays.sort(points, (a, b)->(a[0]-b[0]));
        int result = 1;
        int end = points[0][1];
        for(int i = 1; i < points.length; i ++) {
            if(points[i][0] > end) {
                result ++;
                end = points[i][1];
            } else {
                end = Math.min(end, points[i][1]);
            }
        }
        return result;
    }
	
	class Mycomparator implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			return o1[0] - o2[0];
		}
		
	}
}
