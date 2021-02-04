import java.util.*;
public class M474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] counts = new int[strs.length][2];
        for(int i=0; i<strs.length; i++){
            for(char c: strs[i].toCharArray()){
                counts[i][c - '0']++;
            }
        }

        int[][][] dp = new int[strs.length+1][m+1][n+1];

        for(int i=1; i<=strs.length; i++){
            for(int j=0; j<=m; j++){
                for(int k=0; k<=n; k++){
                    if(counts[i-1][0]<=j && counts[i-1][1]<=k){
                        dp[i][j][k] = Math.max(1 + dp[i-1][j-counts[i-1][0]][k-counts[i-1][1]], dp[i-1][j][k]);
                    }else{
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    public int findMaxForm2(String[] strs, int m, int n) {
        int[][] counts = new int[strs.length][2];
        for(int i=0; i<counts.length; i++){
            for(char c: strs[i].toCharArray()){
                counts[i][c - '0']++;
            }
        }

        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<counts.length; i++){
            for(int zero=m; zero >= counts[i][0]; zero--){
                for(int one=n; one >=counts[i][1]; one--){
                    dp[zero][one] = Math.max(1 + dp[zero-counts[i][0]][one-counts[i][1]], dp[zero][one]);
                }
            }
        }
        return dp[m][n];
    }
}
