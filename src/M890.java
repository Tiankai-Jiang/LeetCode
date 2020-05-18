import java.util.*;
public class M890 {

    // My solution
    private int countChar(String pattern){
        int total = 0;
        boolean[] c = new boolean[26];
        for(char ch: pattern.toCharArray()){
            if(!c[ch-'a']){
                c[ch-'a']=true;
                total++;
            }
        }
        return total;
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        Map<Character, List<Integer>> m = new HashMap<>();
        List<String> a = new LinkedList<>();

        for(int i = 0; i < pattern.length(); ++i){
            if(m.containsKey(pattern.charAt(i))) m.get(pattern.charAt(i)).add(i);
            else{
                List<Integer> l = new LinkedList<>();
                l.add(i);
                m.put(pattern.charAt(i), l);
            }
        }

        List<List<Integer>> l = new LinkedList<>();
        for(List<Integer> li : m.values()) if(li.size()>1) l.add(li);
        int total = countChar(pattern);
        for(String str: words){
            if(countChar(str) != total) continue;
            else{
                boolean match = true;
                for(List<Integer> li : l){
                    for(int i = 0; i < li.size()-1; ++i){
                        if(str.charAt(li.get(i))!= str.charAt(li.get(i+1))){
                            match = false;
                            break;
                        }
                    }
                    if(!match) break;
                }
                if(match) a.add(str);
            }
        }
        return a;
    }

    // FInd the pattern in a more concise way
    public List<String> findAndReplacePattern2(String[] words, String pattern) {
        int[] p = F(pattern);
        List<String> res = new ArrayList<String>();
        for (String w : words) if (Arrays.equals(F(w), p)) res.add(w);
        return res;
    }

    public int[] F(String w) {
        HashMap<Character, Integer> m = new HashMap<>();
        int n = w.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            m.putIfAbsent(w.charAt(i), m.size());
            res[i] = m.get(w.charAt(i));
        }
        return res;
    }
}
