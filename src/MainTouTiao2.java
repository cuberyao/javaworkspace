import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class MainTouTiao2 {
    public static void main(String[] args){    
        Scanner scanner = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        int uid = 0;
        while ((uid = (int)(scanner.nextLong() + Integer.MIN_VALUE)) != Integer.MIN_VALUE) {
        	set.add(uid);
        }
        System.out.println(set.size());
        scanner.close();
    }
}

