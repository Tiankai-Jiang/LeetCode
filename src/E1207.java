import java.util.*;
public class E1207 {

    // My solution
    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> s = new HashSet<>();
        int[] freq = new int[2001];
        for(int i: arr) freq[1000+i]++;
        for(int i:freq) {
            if(i!=0){
                if(s.contains(i)) return false;
                s.add(i);
            }
        }
        return true;
    }

    // Use combination of Set and Map
    public boolean uniqueOccurrences2(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : arr) count.put(a, 1 + count.getOrDefault(a, 0));
        return count.size() == new HashSet<>(count.values()).size();
    }
}
