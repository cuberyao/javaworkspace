package test;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[][] coins = new long[N][2];
        long sum = 0;
        for (int i = 0; i < N; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            sum += (A + B);
            coins[i][0] = A;
            coins[i][1] = B;
        }
        scanner.close();
        final long mean = sum / 2 / N;
        long count = 0;
        long[] dif = new long[2];

        for (int i = 0; i < N; i++) {
            //dif为正，表示前一格移出到当前方格
            //dif为负，表示当前方格移出到前一方格
            coins[i][0] += dif[0];
            coins[i][1] += dif[1];

            //判断是否需要在A[i]，B[i]之间移动
            int bigIdx = coins[i][0] >= coins[i][1] ? 0 : 1;
            int smallIdx = bigIdx == 0 ? 1 : 0;         
            if (coins[i][bigIdx] > mean && coins[i][smallIdx] < mean) {
                long abs = Math.min(coins[i][bigIdx] - mean, 
                        mean - coins[i][smallIdx]); //成全跟mean更接近的方格，可以减少不必要的移动
                count += abs;
                coins[i][bigIdx] -= abs;
                coins[i][smallIdx] += abs;
            }

            //更新差值
            //大于mean的移出到下一格
            //小于mean的从下一格移入
            dif[0] = coins[i][0] - mean;
            dif[1] = coins[i][1] - mean;
            count += (Math.abs(dif[0]) + Math.abs(dif[1]));
        }
        System.out.println(count);
    }
}
