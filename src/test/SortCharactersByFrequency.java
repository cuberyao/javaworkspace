package test;

import java.util.Arrays;
import java.util.Comparator;

public class SortCharactersByFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortCharactersByFrequency scf = new SortCharactersByFrequency();
System.out.println(scf.frequencySort("helloworld"));
	}
    public String frequencySort(String s) {
        char[] ch = s.toCharArray();
        int[][] count = new int[256][2];
        for (int i = 0; i < 256; i++) {
        	count[i][0] = i;
        }
        for (char c : ch) {
        	count[c][1]++;
        }
        Arrays.sort(count, new MyComparator());
        int i = 255;
        int j = 0;
        while (j < ch.length && i < 256 && count[i][1] > 0) {
        	for (int cnt = 0; cnt < count[i][1]; cnt++) {
        		ch[j] = (char) count[i][0];
        		j++;
        	}
        	i--;
        }
        return new String(ch);
    }
	class MyComparator implements Comparator<int[]> {
		public int compare(int[] o1, int[] o2) {
			return o1[1] - o2[1];
		}
	}
}
