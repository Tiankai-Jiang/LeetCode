import java.util.*;
public class M1049 {
    public int lastStoneWeightII(int[] stones) {
        Arrays.sort(stones);

        int sum = 0;
        for(int stone: stones){
            sum += stone;
        }

        int half = sum/2;

        int[][] dp = new int[stones.length][half+1];

        for(int i=1; i<=half; i++){
            dp[0][i] = i < stones[0] ? 0 : stones[0];
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(j < stones[i]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], stones[i] + dp[i-1][j-stones[i]]);
                }

            }
        }
        return sum - 2*dp[stones.length-1][half];
    }

    public int lastStoneWeightII2(int[] stones) {
        Arrays.sort(stones);

        int sum = 0;
        for(int stone: stones){
            sum += stone;
        }

        int half = sum/2;

        int[] dp = new int[half+1];

        for(int i=0; i<stones.length; i++){
            for(int j=half; j>=stones[i]; j--){
                dp[j] = Math.max(dp[j], stones[i] + dp[j-stones[i]]);
            }
        }
        return sum - 2*dp[half];
    }
}
