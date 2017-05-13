package test;

import java.util.Stack;

public class SimplifyPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(simplifyPath("/a/.."));
	}
	
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int start = 0;
        int end = 0;
        while (end < path.length()) {
        	while (start < path.length() && path.charAt(start) == '/') {
        		start++;
        	}
        	end = start;
        	while (end < path.length() && path.charAt(end) != '/') {
        		end++;
        	}
        	 System.out.println("start="+start+" end="+end);
        	 if (start == path.length()) break;
        	String str = path.substring(start, end);
        	start = end;
  System.out.println(str);
        	if (str.equals(".")) {
        		continue;
        	} else if (str.equals("..")) {
        		if (!stack.isEmpty()) {
        			stack.pop();
        		}
        	} else {
        		stack.push(str);
        	}
        	
        }
 System.out.println(stack.size());
 if (stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
        	sb.insert(0, "/"+stack.pop());
        }
        return sb.toString();
    }	

}
