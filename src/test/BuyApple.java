package test;
import java.util.Scanner;
public class BuyApple {
	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		int sum = in.nextInt();
		int a = 0;
		int b = sum / 8;
		int ret = -1;
		while (b >= 0) {
			if ((a = sum - 8 * b) % 6 == 0) {
				ret = a / 6 + b;
				break;
			}
			b--;
		}		
		in.close();
		System.out.println(ret);
	}
}
