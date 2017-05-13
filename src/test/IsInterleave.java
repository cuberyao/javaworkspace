package test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class IsInterleave {
	public static void main(String[] args) {
		//int[] nums = {3,0,6,1,5};
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		System.out.println(isInterleave(s1, s2, s3));
	}
	
    public static boolean isInterleave(String s1, String s2, String s3) {
        int i = 0;
        int j = 0;
        int k = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) 
        	return false;
        while (i < len1 && j < len2) {
        	System.out.println("i="+i+" j="+j+" k="+k);
        	if (s1.charAt(i) == s3.charAt(k)) {
        		i++;
        	} else if (s2.charAt(j) == s3.charAt(k)) {
        		j++;
        	} else
        		return false;
        	k++;
        	
        }
        while (i < len1) {
        	if (s1.charAt(i) == s3.charAt(k)) {
        		i++;
        	} else
        		return false;
        	k++;
        }
        while (j < len2) {
        	if (s2.charAt(j) == s3.charAt(k)) {
        		j++;
        	} else
        		return false;   
        	k++;
        }        
        return true;
    }
}