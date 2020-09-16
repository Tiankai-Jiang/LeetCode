public class M516 {
    public int longestPalindromeSubseq(String s) {
        if(s.length() < 2) return s.length();
        int[][] dp = new int[s.length()][s.length()];
        for(int i=1; i<s.length(); i++) dp[i][i] = 1;
        for(int i=s.length()-1; i>=0; i--) for(int j=i+1; j<s.length(); j++) dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i+1][j-1] + 2 : Math.max(dp[i+1][j], dp[i][j-1]);
        return dp[0][s.length()-1];
    }
}
