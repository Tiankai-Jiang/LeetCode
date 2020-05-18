import java.util.*;
public class E811 {

    // My solution
    // Use int index = indexOf instead of split reduce from 20ms to 7ms.
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> a = new LinkedList<>();
        Map<String, Integer> m = new HashMap<>();
        for(String s : cpdomains){
            String[] s2;
            int index = s.indexOf(' ');
            String domain = s.substring(index + 1);
            int index2 = domain.indexOf(".");
            String domain2 = domain.substring(index2 + 1);
            int index3 = domain2.indexOf(".");
            s2 = index3 == -1 ? new String[]{domain, domain2} : new String[]{domain, domain2, domain2.substring(index3+1)};
            for(String t: s2) m.merge(t, Integer.parseInt(s.substring(0, index)), Integer::sum);
        }
        for(Map.Entry<String, Integer> e : m.entrySet()){
            StringBuilder sb = new StringBuilder();
            a.add(sb.append(e.getValue()).append(" ").append(e.getKey()).toString());
        }
        return a;
    }

    // Use a trie?

}
