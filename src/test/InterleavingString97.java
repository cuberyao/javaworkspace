package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InterleavingString97 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isInterleave("abcd","efg","aebfcgd"));
	}
	/*public static boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		if ((s1.length() == 0 && s2.equals(s3)) || (s2.length() == 0 && s1.equals(s3)))
			return true;
		int[] idx1 = new int[s1.length()];
		int[] idx2 = new int[s2.length()];
		List<Integer> same = new LinkedList<>();	
		int i = 0,j = 0;
		boolean isTraceback = false;
		while (i <= s1.length() && j <= s2.length()) {
			if (s1.charAt(i) == s3.charAt(i + j) && s2.charAt(j) != s3.charAt(i + j)) {
				idx1[i] = i + j;
				i++;
			} else if (s2.charAt(j) == s3.charAt(i + j) && s1.charAt(i) != s3.charAt(i + j)) {
				idx2[j] = i + j;
				j++;
			} else if (s1.charAt(i) == s3.charAt(i + j) && s2.charAt(j) == s3.charAt(i + j)){
				if (!isTraceback) {//不是回退的，先填充到idx1
					idx1[i] = i + j;
					i++;
					same.add(i + j);
				} else {//是回退的，填充idx2
					idx2[j] = i + j;
					j++;
				}
			} else {
				if (same.isEmpty()) {
					return false;
				} else {
					int tmp = same.remove(same.size() - 1);
					isTraceback = true;
					while (i >= tmp) {
						i--;
					}
					while (j >= tmp) {
						j--;
					}
				}
			}
		}
		while (i < s1.length() && s1.charAt(i) == s3.charAt(i + j))
			i++;
		while (j < s2.length() && s2.charAt(j) == s3.charAt(i + j))
			j++;
		if (i == s1.length() && j == s2.length())
			return true;
		else 
			return false;
	}
	*/
	public static boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		boolean[][] table = new boolean[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i < s1.length() + 1; i++) {
			for (int j = 0; j < s2.length() + 1; j++) {
				if (i == 0 && j == 0)
					table[i][j] = true;
				else if (i == 0)
					table[i][j] = table[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
				else if (j == 0)
					table[i][j] = table[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
				else
					table[i][j] = (table[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) || (table[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
			}
		}
		for (int i = 0; i < table.length; i++)
			System.out.println(Arrays.toString(table[i]));
		return table[s1.length()][s2.length()];
		
	}
}
