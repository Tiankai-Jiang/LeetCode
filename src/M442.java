import java.util.*;
public class M442 {

    // My solution, which uses O(n) space
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> a = new LinkedList<>();
        boolean[] c = new boolean[nums.length];
        for(int i : nums){
            if(c[i-1]) a.add(i);
            else c[i-1] = true;
        }
        return a;
    }

    // when find a number i, flip the number at position i-1 to negative.
    // if the number at position i-1 is already negative, i is the number that occurs twice.
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0) res.add(index+1);
            nums[index] *= -1;
        }
        return res;
    }
}
