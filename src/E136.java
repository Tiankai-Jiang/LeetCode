import java.util.*;
public class E136 {

    // My solution, which does use extra memory
    public int singleNumber(int[] nums) {
        Set<Integer> a = new HashSet<>();
        for(int n : nums){
            if(a.contains(n)) a.remove(n);
            else a.add(n);
        }
        return a.iterator().next();
    }

    // Using XOR!
    public int singleNumber2(int[] nums) {
        int a = 0;
        for(int i=0; i<nums.length; ++i) a ^= nums[i];
        return a;
    }

}
