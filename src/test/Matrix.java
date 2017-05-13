package test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Matrix {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int Low = in.nextInt();
		int High = in.nextInt();
		
		Set<Integer> set = new HashSet<>();
		for (int i = Low; i <= High; i++)
			set.add(i);
		in.nextLine();
		int fishNum = in.nextInt();
		in.nextLine();
		for (int i = 0; i < fishNum; i++) {
			int n = in.nextInt();
			int low = Math.max(n / 10, Low);
			int high = Math.min(n / 2, High);
			for (int j = low; j <= high; j++)
				set.remove(j);
			 low = Math.max(n * 2, Low);
			 high = Math.min(n * 10, High);
			for (int j = low; j <= high; j++)
				set.remove(j);
		}
		in.close();
		System.out.println(set.size());

	}

}
