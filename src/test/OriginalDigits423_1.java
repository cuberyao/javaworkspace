package test;

import java.util.Arrays;

public class OriginalDigits423_1 {
	static String[] words = {"two","four","six","zero","three","eight","seven","five","nine","one"};
	static int[] number = {2,4,6,0,3,8,7,5,9,1};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(originalDigits("fviefuro"));
		

	}
    public static String originalDigits(String s) {
        int[] count = new int[26];
        int[] nums = new int[10];
        for (int i = 0; i < s.length(); i++) {
        	count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 10; i++) {
        	int min = 50000;
        	for (int j = 0; j < words[i].length(); j++) {
        		min = Math.min(min, count[words[i].charAt(j) - 'a']);
        	}
        	if (min > 0) {
            	for (int j = 0; j < words[i].length(); j++) {
            		count[words[i].charAt(j) - 'a'] -= min;
            	}
            	nums[number[i]] = min;
        	}
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
        	if (nums[i] > 0) {
        		for (int j = 0; j < nums[i]; j++) {
        			sb.append(i);
        		}
        	}
        }
        return sb.toString();
    }
}
