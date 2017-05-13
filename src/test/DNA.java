package test;

import java.util.Scanner;

public class DNA {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		in.close();
		String[] dna = s.split(" ");
		int count = 0;
		for (int i = 0; i < dna[0].length(); i++) {
			count += compare(dna[0].charAt(i), dna[1].charAt(i)) ? 0 : 1;
		}
		System.out.println(count);

	}
	public static boolean compare(char c1, char c2) {
		return (c1 == 'A' && c2 == 'T') || (c1 == 'T' && c2 == 'A')
				|| (c1 == 'C' && c2 == 'G') || (c1 == 'G' && c2 == 'C');
	}

}
