import java.util.*;
public class E350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hs1 = new HashMap<>(), hs2 = new HashMap<>();
        for(int i: nums1) hs1.merge(i, 1, Integer::sum);
        for(int i: nums2) hs2.merge(i, 1, Integer::sum);
        List<Integer> l = new ArrayList<>();
        for(Integer i: hs1.keySet()) if(hs2.containsKey(i)) for(int j=0; j<Math.min(hs1.get(i), hs2.get(i)); j++) l.add(i);
        return l.stream().mapToInt(i->i).toArray();
    }
}
