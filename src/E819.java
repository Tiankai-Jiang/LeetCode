import java.util.*;
public class E819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
        String[] words = paragraph.toLowerCase().replaceAll("[!?',;.]", " ").trim().split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(String word: words) {
            map.merge(word, 1, Integer::sum);
            max = Math.max(max, map.get(word));
        }
        List<String>[] count = new List[max];
        for(int i=0; i<max; i++) count[i] = new ArrayList<>();
        for(Map.Entry<String, Integer>e: map.entrySet()) count[e.getValue()-1].add(e.getKey());
        for(int i=max-1; i>=0; i--) for(String s: count[i]) if(!bannedWords.contains(s)) return s;
        return "";
    }
}
