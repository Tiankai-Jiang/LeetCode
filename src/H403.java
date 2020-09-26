import java.util.HashMap;
import java.util.HashSet;

public class H403 {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        hm.put(0, new HashSet<Integer>(){{add(1);}});
        for(int i=1; i<stones.length; i++) hm.put(stones[i], new HashSet<>());
        for (int i = 0; i < stones.length - 1; i++) {
            for(int j: hm.get(stones[i])){
                int next = stones[i] + j;
                if(next == stones[stones.length-1]) return true;
                if(hm.containsKey(next)){
                    hm.get(next).add(j);
                    if(j>1) hm.get(next).add(j-1);
                    hm.get(next).add(j+1);
                }
            }
        }
        return false;
    }

    public boolean canCross2(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n+1];
        dp[0][1] = true;
        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                int dist = stones[i] - stones[j];
                if(dist < 0 || dist > n || !dp[j][dist]) continue;
                dp[i][dist] = true;
                if(dist-1 >= 0) dp[i][dist-1] = true;
                if(dist+1 <= n) dp[i][dist+1] = true;
                if(i==n-1) return true;
            }
        }
        return false;
    }
}
