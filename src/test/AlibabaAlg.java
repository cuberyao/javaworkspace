package test;
//import java.util.Random;
import java.math.BigDecimal;
public class AlibabaAlg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(heartCurve(2, 11, 2, 11));
	}
	public static double heartCurve(double mu1, double sigma1, double mu2, double sigma2) {
		long num = 10000;
		long[] x_y = new long[4];//正正 正负 负正 负负
		long[] in = new long[4];
		java.util.Random rand = new java.util.Random();
		double x, y;
		for (long i = 0; i < num; i++) {
			x = sigma1 * rand.nextGaussian()+mu1;
			y = sigma2 * rand.nextGaussian()+mu2;
			if (x >= 0 && y >= 0 ) {
				x_y[0]++;
				if (x * x + y * y -1 - x * y <= 0) 
					in[0]++;
			} else if (x >= 0 && y < 0) {
				x_y[1]++;
				if (x * x + y * y -1 + x * y <= 0) 
					in[1]++;
			} else if (x < 0 && y >= 0) {
				x_y[2]++;
				if (x * x + y * y -1 + x * y <= 0) 
					in[2]++;
			} else {
				x_y[3]++;
				if (x * x + y * y -1 - x * y <= 0) 
					in[3]++;
			}
		}
		long tmp = 0;
		for (int i = 0; i < 4; i++) {
			tmp += in[i]; 
		}
		double prob = (double) tmp / num;  
		BigDecimal bd = new BigDecimal(prob);  
		return bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		
	}

}
