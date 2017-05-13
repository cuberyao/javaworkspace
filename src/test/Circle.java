package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Circle {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String s = in.nextLine();
			Set<String> set = map.keySet();
			boolean isFind = false;
			for (String key : set) {
				String keykey = key + key;
				if (key.length() == s.length() && keykey.indexOf(s) > -1) {
					map.put(key, map.get(key) + 1);					
					isFind = true;
					break;
				}
			}
			if (!isFind) {
				map.put(s, 1);
			}
			//System.out.println(map.size());
		}
		int ret = 0;
		for (int num : map.values()) {
			ret += num == 1 ? 0 : 1;
		}
		in.close();
		System.out.println(ret);

	}

}
