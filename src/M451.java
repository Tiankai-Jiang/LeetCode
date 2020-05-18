import java.util.*;
public class M451 {

    // My solution
    public String frequencySort(String s) {
        Map<Integer, Integer> m = new HashMap<>();
        for(char c: s.toCharArray()) m.put(c-'0', m.getOrDefault(c-'0', 0)+1);
        int[][] m2 = new int[m.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> e : m.entrySet()) m2[i++] = new int[]{e.getKey(), e.getValue()};
        Arrays.sort(m2, Comparator.comparingInt(o->o[1]));
        StringBuilder sb = new StringBuilder();
        for(i = m2.length-1; i>=0; --i) for(int j = 0; j < m2[i][1]; ++j) sb.append((char)('0'+ m2[i][0]));
        return sb.toString();
    }

    // Alternative: use Bucket sort or priority queue
}
