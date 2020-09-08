public class H32 {
    public int longestValidParentheses(String s) {
        if(s.length()<=1) return 0;
        int res = 0, dp[] = new int[s.length()];
        char[] chs = s.toCharArray();
        for(int i=1; i<chs.length; i++){
            if(chs[i] == ')'){
                if(chs[i-1] == '('){
                    dp[i] = i-2 >= 0 ? dp[i-2] + 2 : 2;
                    res = Math.max(dp[i], res);
                }else{ // s.charAt(i-1) == ')'
                    if(i-dp[i-1]-1>=0 && chs[i-dp[i-1]-1]=='('){
                        dp[i] = dp[i-1]+2 + ((i-dp[i-1]-2 >= 0) ? dp[i-dp[i-1]-2] : 0);
                        res = Math.max(dp[i], res);
                    }
                }
            }
        }
        return res;
    }
}
