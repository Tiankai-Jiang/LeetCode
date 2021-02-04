public class M264 {
    public int nthUglyNumber(int n) {
        long[] dp = new long[n];
        dp[0] = 1;
        for(int i=1; i<n; i++){
            long minGreater = 5 * dp[i-1];
            for(int j = 0; j<i; j++){
                if(dp[j]*2 > dp[i-1]) minGreater = Math.min(minGreater, dp[j]*2);
                if(dp[j]*3 > dp[i-1]) minGreater = Math.min(minGreater, dp[j]*3);
                if(dp[j]*5 > dp[i-1]) minGreater = Math.min(minGreater, dp[j]*5);
            }
            dp[i] = minGreater;
        }
        return (int)dp[n-1];
    }

    public int nthUglyNumber2(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int ind2 = 0, ind3 = 0, ind5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            dp[i] = min;
            if(factor2 == min) factor2 = 2*dp[++ind2];
            if(factor3 == min) factor3 = 3*dp[++ind3];
            if(factor5 == min) factor5 = 5*dp[++ind5];
        }
        return dp[n-1];
    }
}
