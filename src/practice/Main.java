package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); 
		int k = in.nextInt();
		int[] c = new int[n];
		for (int i = 0; i < n; i++) {
			c[i] = i + 1;
		}
		int count = 0;
		ArrayList<int[]> store = new ArrayList<>();
		Permutation(store, c, 0, c.length, n - k - 1);
		for (int[] i : store) {
			if (InversePairs(i) == n - k - 1) {
				count = (count + 1) % 2017;
			}
		}
		System.out.println(count % 2017);

	}

	public static void Permutation(ArrayList<int[]> store, int[] c, int start, int end, int reverseN) {
		if (start >= end)
			return;
		if (start == end - 1) {
			int[] copy = new int[end];
			for (int i = 0; i < end; i++) {
				copy[i] = c[i];
			}
			store.add(copy);
			return;
		}
		for (int i = start; i < end; i++) {
			int temp1 = c[start];
			int temp2 = c[i];
			c[start] = temp2;
			c[i] = temp1;
			Permutation(store, c, start + 1, end, reverseN);
			c[start] = temp1;
			c[i] = temp2;
		}
	}

	public static int InversePairs(int[] array) {
		if (array.length == 0)
			return 0;
		int largerCount = 0; // > ÄæÐò
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				largerCount++;
			}
		}
		return largerCount;
	}
}