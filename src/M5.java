public class M5 {
    public String longestPalindrome(String s) {
        if(s.length()<2) return s;
        int l = s.length();
        boolean[][] dp = new boolean[l][l];
        String res = s.substring(0,1);

        for(int i=l-1; i>=0; i--){
            for(int j=i; j<l; j++){
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i<3 || dp[i+1][j-1]);

                if(dp[i][j] && j-i+1 > res.length()) res = s.substring(i, j+1);
            }
        }
        return res;
    }
}
