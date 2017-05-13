
import java.util.Scanner;
public class ElegantPoint {

	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		int sqr = in.nextInt();
		in.close();
		int ret = 0;
		int tmp = 0;
		for (int i = 0; i <= Math.sqrt(sqr / 2); i++) {
			if (i * i + (tmp = (int) Math.sqrt(sqr - i * i)) * tmp == sqr) {
				if (i == 0 || i == tmp) {
					ret += 4;
				} else {
					ret += 8;
				}				
			}			
		}
		System.out.println(ret);
	}
}
