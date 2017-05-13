package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
public class MS {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		Map<Integer, Integer> row = new HashMap<>();
		Map<Integer, Integer> col = new HashMap<>();
		Map<Integer, Integer> sum = new HashMap<>();
		Map<Integer, Integer> dif = new HashMap<>();
		for (int i = 0; i < N; i++) {
			//row
			int r = scanner.nextInt();
			int c = scanner.nextInt();
			row.put(r, row.containsKey(r) ? row.get(r) + 1 : 1);
			col.put(c, col.containsKey(c) ? col.get(c) + 1 : 1);
			sum.put(r + c, sum.containsKey(r + c) ? sum.get(r + c) + 1 : 1);
			dif.put(r - c, dif.containsKey(r - c) ? dif.get(r - c) + 1 : 1);
		}
		scanner.close();
		
		long pair = 0;
		for (Entry<Integer, Integer> entry : row.entrySet()) {
			if (entry.getValue() > 1) {
				pair += (entry.getValue() - 1) * entry.getValue() / 2;				
			}
		}
		for (Entry<Integer, Integer> entry : col.entrySet()) {
			if (entry.getValue() > 1) {
				pair += (entry.getValue() - 1) * entry.getValue() / 2;				
			}
		}
		for (Entry<Integer, Integer> entry : sum.entrySet()) {
			if (entry.getValue() > 1) {
				pair += (entry.getValue() - 1) * entry.getValue() / 2;				
			}
		}
		for (Entry<Integer, Integer> entry : dif.entrySet()) {
			if (entry.getValue() > 1) {
				pair += (entry.getValue() - 1) * entry.getValue() / 2;				
			}
		}
		System.out.println(pair);
		

	}

}
