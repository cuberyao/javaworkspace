package test;
import java.util.Arrays;
import java.util.Scanner;
public class SortedArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
		System.out.println(m + n);	
        sc.close();
	}
	
	public static int func(int[] array, int k) {
		int index = Arrays.binarySearch(array, k);
		if (index < 0)
			return -1;
		else {
			int tmp = index;
			int ret = 0;
			while(tmp >= 0 && array[tmp--] == k)
				ret++;
			tmp = index;
			while(tmp < array.length - 1 && array[++tmp] == k)
				ret++;
			return ret;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int GetNumberOfK(int[] array, int k) {  
        int result = 0;  
        if (array == null || array.length == 0) {  
            return 0;  
        }    
        int start = 0, end = array.length - 1;    
        int firstIndex = getFirstIndex(array, start, end, k);  
        int lastIndex = getLastIndex(array, start, end, k);    
        if (firstIndex > -1 && lastIndex > -1) {  
            result = lastIndex - firstIndex + 1;  
        }    
        return result;  
    } 
	
	private static int getLastIndex(int[] array, int start, int end, int k) {  
        if (start > end) {  
            return -1;  
        }  
  
        int midIndex = (start + end) / 2;  
        int midData = array[midIndex];  
  
        if (midData == k) {  
            if (midIndex < array.length - 1 && array[midIndex + 1] != k  
                    || midIndex == array.length - 1) {  
                return midIndex;  
            } else {  
                start = midIndex + 1;  
            }  
        } else if (midData > k) {  
            end = midIndex - 1;  
        } else {  
            start = midIndex + 1;  
        }  
  
        return getLastIndex(array, start, end, k);  
    } 
	
	private static int getFirstIndex(int[] array, int start, int end, int k) {  
        if (start > end) {  
            return -1;  
        }    
        int midIndex = (start + end) / 2;  
        int midData = array[midIndex];  
  
        if (midData == k) {  
            if (midIndex > 0 && array[midIndex - 1] != k || midIndex == 0) {  
                return midIndex;  
            } else {  
                end = midIndex - 1;  
            }  
        } else if (midData > k) {  
            end = midIndex - 1;  
        } else {  
            start = midIndex + 1;  
        }    
        return getFirstIndex(array, start, end, k);  
    } 

}
