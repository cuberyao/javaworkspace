import java.util.ArrayList;
import java.util.List;

public class Divide {

	public static void main(String[] args) {
		System.out.println(method(18, 4).toString());

	}
	
	public static List<Integer> method(int N, int L) {
		ArrayList<Integer> list = new ArrayList<>();
		int length = 0;
		int begin = 0;
		for (int i = L; i <= 2 * N; i++) {
			if ((2 * N) % i == 0) {
				int tmp = (2 * N) / i - i + 1;
				if (tmp > 0 && tmp % 2 == 0) {
					length = i;
					begin = tmp / 2;
					break;
				}
			}
		}
		if (begin != 0) {
			for (int i = begin; i < begin + length; i++)
				list.add(i);
		}
		return list;
	}

}
