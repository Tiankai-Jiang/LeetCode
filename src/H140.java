import java.util.*;

public class H140 {
    Set<String> d;
    public List<String> wordBreak(String s, List<String> wordDict) {
        d = new HashSet<>(wordDict);
        return DFS(s, new HashMap<>());
    }

    List<String> DFS(String s, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s)) return map.get(s);
        LinkedList<String>res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : d) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), map);
                for (String sub : sublist) res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }
}
