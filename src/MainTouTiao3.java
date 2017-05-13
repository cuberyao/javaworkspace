import java.util.Scanner;
public class MainTouTiao3 {
	static String s1 = "***";
	static String s2 = "  *";
	static String s3 = "***";
	static String s4 = "*  ";
	static String s5 = "* *";
	static String s6 = " * ";
	static String s7 = "****";
	static String s8 = "**";
	static String s9 = "   ";//3个空格
	static String s10 = "    ";//4个空格
	static String s11 = "  ";//2个空格
    public static void main(String[] args){    
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] nums = str.split("[+\\-*/]");
        String ans = "";
        String operation = "";
        int num0 = Integer.parseInt(nums[0].trim());
        int num1 = Integer.parseInt(nums[1].trim());
        if (str.contains("+")) {
        	ans = num0 + num1 + "";
        	operation = "+";
        } else if (str.contains("-")) {
        	ans = num0 - num1 + "";
        	operation = "-";
        } else if (str.contains("*")) {
        	ans = num0 * num1 + "";
        	operation = "*";
        } else {
        	operation = "/";
        	if (num0 % num1 == 0) {
        		ans = num0 / num1 + "";
        	} else {
        		ans = String.format("%.2f", num0*1.0 / num1);
        	}
        }
//        String ss1 = "1234567890+-*/.";
//        for (int i = 0; i < ss1.length(); i++) {
//        	String[] pattern = getPattern(ss1.charAt(i));
//        	for (String s : pattern)
//        		System.out.println(s);
//        }
        String output = num0+""+operation+""+num1+"="+ans;
        StringBuilder[] print = new StringBuilder[5];
    	for (int j = 0; j < 5; j++) {
    		String[] pattern = getPattern(output.charAt(0));
    		print[j] = new StringBuilder();
    		print[j].append(pattern[j]);
    	}
        for (int i = 1; i < output.length(); i++) {
        	String[] pattern = getPattern(output.charAt(i));
        	for (int j = 0; j < 5; j++) {
        		print[j].append(s11+pattern[j]);
        	}
        }
    	for (int j = 0; j < 4; j++) {
    		System.out.println(print[j].toString());
    	} 
    	System.out.print(print[4].toString());
        scanner.close();
    }
    public static String[] getPattern(char c) {
    	String[] ret = new String[5];
    	if (c == '0') {
    		ret[0] = s1;
    		ret[1] = s5;
    		ret[2] = s5;
    		ret[3] = s5;
    		ret[4] = s1;    		
    	} else if (c == '1') {
    		for (int i = 0; i < 5; i++)
    			ret[i] = "*";    		
    	} else if (c == '2') {
    		ret[0] = s1;
    		ret[1] = s2;
    		ret[2] = s1;
    		ret[3] = s4;
    		ret[4] = s1;      		
    	} else if (c == '3') {
    		ret[0] = s1;
    		ret[1] = s2;
    		ret[2] = s1;
    		ret[3] = s2;
    		ret[4] = s1;     		
    	} else if (c == '4') {
    		ret[0] = s5;
    		ret[1] = s5;
    		ret[2] = s1;
    		ret[3] = s2;
    		ret[4] = s2;     		
    	} else if (c == '5') {
    		ret[0] = s1;
    		ret[1] = s4;
    		ret[2] = s1;
    		ret[3] = s2;
    		ret[4] = s1;      		
    	} else if (c == '6') {
    		ret[0] = s1;
    		ret[1] = s4;
    		ret[2] = s1;
    		ret[3] = s5;
    		ret[4] = s1;    		
    	} else if (c == '7') {
    		ret[0] = s1;
    		ret[1] = s2;
    		ret[2] = s2;
    		ret[3] = s2;
    		ret[4] = s2;   		
    	} else if (c == '8') {
    		ret[0] = s1;
    		ret[1] = s5;
    		ret[2] = s1;
    		ret[3] = s5;
    		ret[4] = s1;     		
    	} else if (c == '9') {
    		ret[0] = s1;
    		ret[1] = s5;
    		ret[2] = s1;
    		ret[3] = s2;
    		ret[4] = s1;     		
    	} else if (c == '+') {
    		ret[0] = s9;
    		ret[1] = s6;
    		ret[2] = s1;
    		ret[3] = s6;
    		ret[4] = s9;     		
    	} else if (c == '-') {
    		ret[0] = s9;
    		ret[1] = s9;
    		ret[2] = s1;
    		ret[3] = s9;
    		ret[4] = s9;     		
    	} else if (c == '*') {
    		ret[0] = s9;
    		ret[1] = s5;
    		ret[2] = s6;
    		ret[3] = s5;
    		ret[4] = s9;    		
    	} else if (c == '/') {
    		ret[0] = s9;
    		ret[1] = s2;
    		ret[2] = s6;
    		ret[3] = s4;
    		ret[4] = s9;     		
    	} else if (c == '=') {
    		ret[0] = s10;
    		ret[1] = s7;
    		ret[2] = s10;
    		ret[3] = s7;
    		ret[4] = s10;     		
    	} else {//除/
    		ret[0] = s11;
    		ret[1] = s11;
    		ret[2] = s11;
    		ret[3] = s8;
    		ret[4] = s8;     		
    	}
    	return ret;
    }
}

