public class M1043 {

    //dp[i] record the maximum sum we can get considering A[0] ~ A[i]
    //To get dp[i], we will try to change k last numbers separately to the maximum of them,
    //where k = 1 to k = K.
    public int maxSumAfterPartitioning(int[] A, int K) {
        int N = A.length, dp[] = new int[N];
        for (int i = 0; i < N; ++i) {
            int curMax = 0;
            for (int k = 1; k <= K && i - k + 1 >= 0; ++k) {
                curMax = Math.max(curMax, A[i - k + 1]);
                dp[i] = Math.max(dp[i], (i >= k ? dp[i - k] : 0) + curMax * k);
            }
        }
        return dp[N - 1];
    }

    public int maxSumAfterPartitioning2(int[] A, int K) {
        int[] memo = new int[A.length];
        int initMax = memo[0] = A[0];
        for(int i = 1; i < K; ++i) {
            if (A[i] > initMax) initMax = A[i];
            memo[i] = (i+1) * initMax;
        }

        for (int i = K; i < A.length; ++i) {
            int cur = 0, kIntervalMax = A[i];
            // Backtrack up to K-1 indices to calculate current maximum for memo[i].
            for (int j = 1; j <= K; ++j) {
                // Keep track of the current maximum in the window [i-j+1, i].
                if (A[i-j+1] > kIntervalMax) kIntervalMax = A[i-j+1];
                // cur is the candidate for the solution to memo[i] as we backtrack the K-1 window.
                cur = memo[i-j] + j * kIntervalMax;
                if (cur > memo[i]) memo[i] = cur;
            }
        }
        return memo[A.length-1];
    }
}
