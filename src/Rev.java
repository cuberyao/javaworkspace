
import java.util.Scanner;
public class Rev {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in  = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		in.close();
		System.out.println(rev(rev(x) + rev(y)));

	}
	public static int rev(int x) {
		StringBuilder sb = new StringBuilder(x + "");		
		return Integer.parseInt((sb.reverse().toString()));
	}

}
