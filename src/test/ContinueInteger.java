package test;
import java.util.Scanner;
public class ContinueInteger {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = in.nextInt();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int[] nums = new int[count];
		for (int i = 0; i < count; i++) {
			int tmp = in.nextInt();
			max = Math.max(max, tmp);
			min = Math.min(min, tmp);
			nums[i] = tmp;				
		}
		in.close();
		if ((max - min) == count || (max - min) == count - 1) {
			int[] continus = new int[count + 1];
			for (int i = 0; i < count; i++) {
				continus[nums[i] - min] = 1;
			}
			int emptyCount = 0;
			int index = 0;
			for (int i = 0; i < count + 1; i++) {
				if (continus[i] == 0) {
					emptyCount++;
					index = i;					
				}
			}
			if (emptyCount == 1) {
				if (index == count) {
					if (min == 1) {
						System.out.println(max + 1);
					} else {
						System.out.println((min - 1) + " " + (max + 1));
					}					
				} else { 
					System.out.println(index + min);
				}
			} else { 
				System.out.println("mistake");
			}
		} else {
			System.out.println("mistake");
		}
	}

}
