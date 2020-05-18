import java.util.*;

public class M1079 {

    // My solution
    public int numTilePossibilities(String tiles) {
        Set<String> s = new HashSet<String>(){{add("");}};
        for(char c: tiles.toCharArray()){
            Set<String> tmp = new HashSet<>();
            for(String str : s) for(int j = 0; j <= str.length(); ++j) tmp.add(new StringBuilder(str).insert(j, c).toString());
            s.addAll(tmp);
        }
        return s.size()-1;
    }

    // Backtracking again...
    public int numTilePossibilities2(String tiles) {
        int[] count = new int[26];
        for (char c : tiles.toCharArray()) count[c - 'A']++;
        return dfs(count);
    }

    int dfs(int[] arr) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) continue;
            sum++;
            arr[i]--;
            sum += dfs(arr);
            arr[i]++;
        }
        return sum;
    }
}
