import java.util.*;
public class M49 {

    // My solution
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for(String str: strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String c2 = new String(c);
            if(m.containsKey(c2)) m.get(c2).add(str);
            else m.put(c2, new LinkedList<String>(){{add(str);}});
        }
        return new ArrayList<>(m.values());
    }
}
