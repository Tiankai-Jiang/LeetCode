public class E70 {
    public int climbStairs(int n) {
        if(n<3) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2; i<n; i++) dp[i] = dp[i-2]+dp[i-1];
        return dp[n-1];
    }
}
