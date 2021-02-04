public class M650 {
    public int minSteps(int n) {
        int[] dp = new int[n+1];
        for(int i=2; i<=n; i++){
            if(i%2==0){
                dp[i] = 2 + dp[i>>1];
            }else{
                int min = i;
                for(int j = 3; j<i; j+=2){
                    if(i%j==0){
                        min = Math.min(min, dp[j]+(i/j));
                    }
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }

    public int minSteps2(int n) {
        int[] dp = new int[n+1];
        for(int i=2; i<=n; i++){
            if(i%2==0){
                dp[i] = 2 + dp[i/2];
            }else{
                for(int j=i/2; j>0; j--){
                    if(i%j==0){
                        dp[i] = dp[j]+(i/j);
                        break;
                    }
                }
            }
        }
        return dp[n];
    }
}
