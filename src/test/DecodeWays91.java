package test;

public class DecodeWays91 {

	public static void main(String[] args) {
		System.out.println(numDecodings("1024"));
	}
    public static int numDecodings(String s) {
    	if (s == null || s.length() == 0)
    		return 0;
        int[] dp = new int[s.length() + 1];
        char[] ch = s.toCharArray();
        dp[0] = 1;
        dp[1] = ch[0] == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
        	int single = ch[i - 1] - '0';
        	int twins = (ch[i - 1] - '0') + (ch[i - 2] - '0') * 10;
        	if (single > 0 && single <= 9)
        		dp[i] += dp[i - 1];
        	if (twins >= 10 && twins <= 26)
        		dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }
}
