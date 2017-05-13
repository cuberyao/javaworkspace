import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class MainTouTiao1 {
    public static void main(String[] args){    
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] a = new int[m];
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < m; i++) { 
        	a[i] = scanner.nextInt();
        	set1.add(a[i]);
        }
        int n = scanner.nextInt();
        int[] b = new int[n];
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < n; i++) {
        	b[i] = scanner.nextInt();
        	set2.add(b[i]);
        }
        set1.retainAll(set2);
        for (Integer i : set1) {
        	System.out.println(i);
        }
        	
      
        scanner.close();
    }
}

