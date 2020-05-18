import java.util.*;

public class E1 {

    // My solution O(nlogn)
    private int binarySearch(int[] nums, int l, int h, int k){
        if(l>h) return -1;
        int m = l + (h-l)/2;
        if(nums[m]==k) return m;
        return nums[m]>k ? binarySearch(nums, l, m-1, k) : binarySearch(nums, m+1, h, k);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] o = new int[nums.length];
        System.arraycopy(nums, 0, o, 0, nums.length);
        Arrays.sort(nums);
        int a=0, b=0, c=-1, d=-1;
        for(int i = 0; i < nums.length; ++i){
            int j = binarySearch(nums, i+1, nums.length-1, target- nums[i]);
            if(j != -1) {
                a = nums[i];
                b = nums[j];
            }
        }
        for(int i = 0; i < o.length; ++i){
            if(o[i] == a && c== -1) c = i;
            else if(o[i] == b) d = i;
        }
        return c<d ? new int[]{c,d} : new int[]{d,c};
    }

    // O(n)??
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; map.put(nums[i], i++))
            if(map.containsKey(target - nums[i])) return new int[]{map.get(target - nums[i]),i};
        return new int[]{0,0};
    }
}
