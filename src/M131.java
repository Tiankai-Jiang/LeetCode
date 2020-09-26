import java.util.*;
public class M131 {

    void dfs(List<List<String>> result, String s, int start, List<String> currentList, boolean[][] dp) {
        if (start >= s.length()) result.add(new ArrayList<>(currentList));
        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                currentList.add(s.substring(start, end + 1));
                dfs(result, s, end + 1, currentList, dp);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=0; i<s.length(); i++) dp[i][i] = true;
        for(int i=s.length()-1; i>=0; i--)
            for(int j=i; j<s.length(); j++) dp[i][j] = (s.charAt(i)==s.charAt(j)) && (j-i<=2 || dp[i+1][j-1]);
        dfs(res, s, 0, new ArrayList<>(), dp);
        return res;
    }
}
