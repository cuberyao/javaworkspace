import java.util.Scanner;
public class Main3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        int[] save = new int[n];
        for (int i = 0; i < n; i++) {
        	nums[i] = sc.nextInt();
        }
        sc.close();
        for (int i = 0; i < k; i++) {
        	for (int j = 0; j < n - 1; j++) {
        		save[j] = nums[j];
        		nums[j] = (save[j] + nums[j + 1]) % 100;
        	}
        	nums[n - 1] = (save[0] + nums[n - 1]) % 100;
        }
        System.out.print(nums[0]);
        for (int i = 1; i < n; i++)
        	System.out.print(" "+ nums[i]);
	}

}
