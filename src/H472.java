import java.util.*;

public class H472 {

    private boolean canForm(String str, Set<String> dict) {
        if (dict.isEmpty()) return false;
        boolean[] dp = new boolean[str.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= str.length(); i++) {
            for(int j=i-1; j>=0; j--){
                if(!dp[j]) continue;
                if(dict.contains(str.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[str.length()];
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> shorter = new HashSet<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (int i = 0; i < words.length; i++) {
            if (canForm(words[i], shorter)) res.add(words[i]);
            shorter.add(words[i]);
        }
        return res;
    }
}
