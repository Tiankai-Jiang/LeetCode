import java.util.*;
public class M877 {

    // My solution
    public boolean stoneGame(int[] piles) {
        return true;
    }

    // DP
    // dp[i][j] means the biggest number of stones you can get more than opponent picking piles in piles[i] ~ piles[j].
    public boolean stoneGame2(int[] p) {
        int n = p.length;
        int[][] dp  = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = p[i];
        for (int d = 1; d < n; d++)
            for (int i = 0; i < n - d; i++)
                dp[i][i + d] = Math.max(p[i] - dp[i + 1][i + d], p[i + d] - dp[i][i + d - 1]);
        return dp[0][n - 1] > 0;
    }

    public boolean stoneGame3(int[] p) {
        int[] dp = Arrays.copyOf(p, p.length);;
        for (int d = 1; d < p.length; d++) for (int i = 0; i < p.length - d; i++) dp[i] = Math.max(p[i] - dp[i + 1], p[i + d] - dp[i]);
        return dp[0] > 0;
    }
}
