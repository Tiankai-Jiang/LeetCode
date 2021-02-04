import java.util.Arrays;

public class M322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, 1, amount+1, Integer.MAX_VALUE);
        for(int i=1; i<=amount; i++){
            for(int coin: coins){
                if(i-coin>=0 && dp[i-coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
