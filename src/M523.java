import java.util.*;

public class M523 {

    //in case of the array [23,2,6,4,7] the running sum is [23,25,31,35,42]
    // and the remainders are [5,1,1,5,0]. We got remainder 5 at index 0 and at index 3.
    // That means, in between these two indexes we must have added a number which is multiple of the k.
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length == 1) return false;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,-1);}};
        int s = 0;
        for (int i=0;i<nums.length;i++) {
            s += nums[i];
            if(k != 0) s %= k;
            Integer prev = map.get(s);
            if (prev != null){
                if (i - prev > 1) return true;
            }
            else map.put(s, i);
        }
        return false;
    }
}
