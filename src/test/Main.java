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
            //difΪ������ʾǰһ���Ƴ�����ǰ����
            //difΪ������ʾ��ǰ�����Ƴ���ǰһ����
            coins[i][0] += dif[0];
            coins[i][1] += dif[1];

            //�ж��Ƿ���Ҫ��A[i]��B[i]֮���ƶ�
            int bigIdx = coins[i][0] >= coins[i][1] ? 0 : 1;
            int smallIdx = bigIdx == 0 ? 1 : 0;         
            if (coins[i][bigIdx] > mean && coins[i][smallIdx] < mean) {
                long abs = Math.min(coins[i][bigIdx] - mean, 
                        mean - coins[i][smallIdx]); //��ȫ��mean���ӽ��ķ��񣬿��Լ��ٲ���Ҫ���ƶ�
                count += abs;
                coins[i][bigIdx] -= abs;
                coins[i][smallIdx] += abs;
            }

            //���²�ֵ
            //����mean���Ƴ�����һ��
            //С��mean�Ĵ���һ������
            dif[0] = coins[i][0] - mean;
            dif[1] = coins[i][1] - mean;
            count += (Math.abs(dif[0]) + Math.abs(dif[1]));
        }
        System.out.println(count);
    }
}
