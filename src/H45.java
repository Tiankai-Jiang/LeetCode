public class H45 {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n < 2) return 0;
        int[] dp = new int[n];
        dp[n-1] = 0;
        for(int i=n-2; i>=0; i--){
            if(i+nums[i]>=n-1) dp[i] = 1;
            else if(nums[i]==0) dp[i] = Integer.MAX_VALUE;
            else{
                int min = dp[i+1];
                for(int j=i+1; j<=i+nums[i]; j++) min = Math.min(min, dp[j]);
                dp[i] = min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1;
            }
        }
        return dp[0];
    }
}
