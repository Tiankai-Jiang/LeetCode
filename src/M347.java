import java.util.*;

public class M347 {

    // My solution O(nlogn)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i : nums) m.merge(i, 1, Integer::sum);
        int[][] l = new int[m.size()][2];
        int j = 0;
        for (Map.Entry e : m.entrySet()) l[j++] = new int[]{(Integer)e.getKey(), (Integer) e.getValue()};
        Arrays.sort(l, Comparator.comparingInt(o->o[1]));
        int[] a = new int[k];
        for (int i = 0; i <k; ++i) a[i] = l[l.length-1-i][0];
        return a;
    }

    // Bucket sort O(n)
    public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--)
            if (bucket[pos] != null) res.addAll(bucket[pos]);
        return res;
    }
}
