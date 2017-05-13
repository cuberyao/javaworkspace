package test;

import java.util.Arrays;

public class ArithmeticSlices413 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,4,5,6,8};
		System.out.println(numberOfArithmeticSlices(A));

	}
    public static int numberOfArithmeticSlices(int[] A) {
    	int len = A.length;
    	if (len < 3) return 0;
        int[] diff = new int[len];
        for (int i = 1; i < len; i++) {
        	diff[i] = A[i] - A[i - 1];
        }
        System.out.println(Arrays.toString(diff));
        int flag = diff[1];
        int count = 1;
        int ret = 0;
        for (int i = 2; i < len; i++) {
        	if (diff[i] == flag) {
        		count++;
        	} else {
        		if (count >= 2) {
        			ret += (count * (count - 1) / 2);
        		} 
        		flag = diff[i];
        		count = 1;
        	}
        }
        if (count >= 2) {
			ret += (count * (count - 1) / 2);
		}
        return ret;
    }
}
