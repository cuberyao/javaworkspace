import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main1 {
	public static void main(String args[]) {
		int[] nums = new int[] { 2, 1, 5, 4, 3 };
		ArrayList<Integer> test = new ArrayList<>();
		for (int i : nums) {
			test.add(i);

		}

		//Collections.sort(test, new MyComparator());
		for (Object i : test) {
			System.out.print("[" + i + "]" + Collections.binarySearch(test, (Integer) i/*, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			}*/) + ",");
		}		
	}

}
class MyComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {			
		return o2- o1;
	}		
}
