import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int girlsEnd = 0;
        int p = 0;
        int ret1 = 0;
        while (p < str.length()) {
        	if (str.charAt(p) == 'G') {
        		ret1 += (p - girlsEnd);
        		girlsEnd++;
        	}
        	p++;
        }
        int boysEnd = 0;
        p = 0;
        int ret2 = 0;
        while (p < str.length()) {
        	if (str.charAt(p) == 'B') {
        		ret2 += (p - boysEnd);
        		boysEnd++;
        	}
        	p++;
        }
        System.out.println(Math.min(ret1, ret2));
	}
}