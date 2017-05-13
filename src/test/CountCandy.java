package test;
import java.util.Scanner;
public class CountCandy {
	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		int[] input = new int[4];
		for (int i = 0; i < 4; i++)
			input[i] = in.nextInt();
		in.close();
		int A_2, B_2, C;
		A_2 = input[0] + input[2];
		B_2 = input[2] - input[0];
		C = (B_2 % 2 == 0 && B_2 >= 0) ? input[3] - B_2 / 2 : -1; 
		if (A_2 >= 0 && A_2 % 2 == 0 
				&& B_2 >= 0 && B_2 % 2 == 0
				&& C >= 0)
			System.out.format("%d %d %d", A_2 / 2, B_2 / 2, C);
		else 
			System.out.println("No");
	}
}
