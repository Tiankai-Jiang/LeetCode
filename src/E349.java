import java.util.*;
import java.util.stream.Collectors;

public class E349 {

    // My solution 1, slow
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        s.retainAll(s2);
        int[] a = new int[s.size()];
        int i = 0;
        for (Integer val : s) a[i++] = val;
        return a;
    }

    // My solution 2, do not use that one line fancy shit to initialize array, much faster
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i < nums1.length; ++i) s.add(nums1[i]);
        Set<Integer> s2 = new HashSet<>();
        for(int i = 0; i < nums2.length; ++i) s2.add(nums2[i]);
        s.retainAll(s2);
        int[] a = new int[s.size()];
        int i = 0;
        for (Integer val : s) a[i++] = val;
        return a;
    }
}
