public class M91 {
    public int numDecodings(String s) {
        if(s==null || s.length()==0) return 0;
        int l = s.length();
        int[] dp = new int[l+1];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i=2; i<l+1; i++){
            if(s.charAt(i-1)!='0') dp[i] += dp[i-1];
            int twoDigit = Integer.parseInt(s.substring(i-2, i));
            if(twoDigit >= 10 && twoDigit <= 26) dp[i] += dp[i-2];
        }
        return dp[l];
    }
}
