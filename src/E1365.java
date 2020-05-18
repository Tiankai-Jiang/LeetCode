import java.util.*;
public class E1365 {

    // My solution
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> m = new TreeMap<>(), m2 = new HashMap<>();
        for(int i = 0; i < nums.length; ++i) m.merge(nums[i], 1, Integer::sum);
        int count = 0;
        int[] a = new int[nums.length];
        for(Map.Entry<Integer, Integer> e : m.entrySet()){
            m2.put(e.getKey(), count);
            count += e.getValue();
        }
        for(int i = 0; i < nums.length; ++i) a[i] = m2.get(nums[i]);
        return a;
    }

    // Since the range of number is 0 <= n <= 100, array is way faster
    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] count = new int[101], res = new int[nums.length];
        for (int i=0; i<nums.length; i++) count[nums[i]]++;
        for (int i=1; i<=100; i++) count[i] += count[i-1];
        for (int i=0; i<nums.length; i++) res[i] = nums[i] == 0 ? 0 : count[nums[i] - 1];
        return res;
    }
}
