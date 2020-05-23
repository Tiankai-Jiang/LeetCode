import java.util.*;

public class E1002 {

    // My solution
    public List<String> commonChars(String[] A) {
        int[][] ls = new int[A.length][26];
        int[] min = new int[26];
        Arrays.fill(min, Integer.MAX_VALUE);
        for(int i = 0; i < A.length; ++i) for(int j = 0; j < A[i].length(); ++j) ls[i][A[i].charAt(j)-'a']++;
        for(int i = 0; i < A.length; ++i) for(int j = 0; j < 26; ++j) min[j] = Math.min(min[j], ls[i][j]);
        List<String> a = new ArrayList<>();
        for(int i = 0; i < 26; ++i) for(int j = 0; j < min[i]; ++j) a.add((Character.toString((char)('a'+i))));
        return a;
    }
}
