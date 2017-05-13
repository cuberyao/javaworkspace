package test;

public class DetectCapital520 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean detectCapitalUse(String word) {
		boolean isFirstUppercase = Character.isUpperCase(word.charAt(0));
		if (isFirstUppercase) 
			return areUppercaseFromIndex(word, 1) || areLowerCaseFromIndex(word, 1);
		else 
			return areLowerCaseFromIndex(word, 1);
	}
	
	public static boolean detectCapitalUse1(String word) {
		int cnt = 0;
		for (int i = 0; i < word.length(); i++) {
			cnt += Character.isUpperCase(word.charAt(i)) ? 1 : 0;
		}
		return cnt == 0 || (cnt == 1 && Character.isUpperCase(word.charAt(0)));
	}
	
	public static boolean detectCapitalUse2(String word) {
		return word.matches("[A-Z]*|[A-Z]?[a-z]*");
	}

	private static boolean areUppercaseFromIndex(String word, int index) {
		for (int i = index; i < word.length(); i++) {
			if (!Character.isUpperCase(word.charAt(i)))
				return false;
		}
		return true;
	}

	private static boolean areLowerCaseFromIndex(String word, int index) {
		for (int i = index; i < word.length(); i++) {
			if (!Character.isLowerCase(word.charAt(i)))
				return false;
		}
		return true;
    }
}
