import java.util.Arrays;
import java.util.Scanner;
public class Main123 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] Ti = new int[N];
		int[][] Qi = new int[M][2];
		for (int i = 0; i < N; i++)
			Ti[i] = sc.nextInt();
		for (int i = 0; i < M; i++) {
			Qi[i][0] = sc.nextInt();
			Qi[i][1] = i;
		}
		Arrays.sort(Qi, (a, b) -> (a[0] - b[0]));
		int T = 0;
		int Q = 0;
		while (Q < M && T < N) {
			
		}
		
		
		
		

	}
	


}
