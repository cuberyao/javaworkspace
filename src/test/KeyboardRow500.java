package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyboardRow500 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {"Hello", "Alaska", "Dad", "Peace"};
		System.out.println(Arrays.toString(findWords(s)));

	}
	
	public static String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (String s : words) {
        	if (s.matches("[qwertyuiopQWERTYUIOP]+") || s.matches("[asdfghjklASDFGHJKL]+")
        		|| s.matches("[zxcvbnmZXCVBNM]+"))
        		list.add(s);
        }
        String[] ret = new String[list.size()];
        for (int i = 0; i < ret.length; i++) 
        	ret[i] = list.get(i);
        return ret;
    }
	
    public String[] findWords1(String[] words) {
        if (words.length == 0)
            return new String[0];
        StringBuilder sb = new StringBuilder();
        for (String s : words) {
        	if (s.matches("[qwertyuiopQWERTYUIOP]+") || s.matches("[asdfghjklASDFGHJKL]+")
        		|| s.matches("[zxcvbnmZXCVBNM]+"))
        		sb.append(s + " ");
        }
        return sb.toString().trim().split(" "); 
    }

}
