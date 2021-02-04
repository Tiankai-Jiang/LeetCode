import java.util.*;

public class M983 {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        Set<Integer> hs = new HashSet<>();
        for(int i: days){
            hs.add(i);
        }

        for(int i=1; i<=365; i++){
            if(!hs.contains(i)){
                dp[i] = dp[i-1];
            }else{
                dp[i] = Math.min(Math.min(costs[0] + dp[i-1], costs[1]+dp[Math.max(0, i-7)]), costs[2] + dp[Math.max(0, i-30)]);
            }
        }
        return dp[365];
    }

}
