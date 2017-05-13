
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class JumpBoard {

	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		in.close();
		int[] count = new int[M - N + 1];
		Arrays.fill(count, Integer.MAX_VALUE);
		count[0] = 0;
		for (int i = 0; i < count.length; i++) {
			//N + i 的约数
			if (count[i] != Integer.MAX_VALUE) { 
				for (Integer n : getDivisor(i + N)) {
					if (n + i < M - N + 1)
						count[n + i] = Math.min(count[n + i], 1 + count[i]);
				}
			}
		}
		int ret = count[count.length - 1] == Integer.MAX_VALUE ? -1 : count[count.length - 1];
		System.out.println(ret);
	}
	
	public static ArrayList<Integer> getDivisor(int num) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				list.add(i);
				if (i != num / i)
					list.add(num / i);
			}
		}
		return list;
	}

}
