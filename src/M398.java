import java.util.*;
public class M398 {

    // My solution
    Map<Integer, List<Integer>> m;
    public M398(int[] nums) {
        m = new HashMap<>();
        for(int i=0; i < nums.length; ++i){
            if(m.containsKey(nums[i])) m.get(nums[i]).add(i);
            else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                m.put(nums[i], tmp);
            }
        }
    }

    public int pick(int target) {
        Collections.shuffle(m.get(target));
        return m.get(target).get(0);
    }

    // Reservoir Sampling
    int[] nums;
    Random rnd;

//    public Solution(int[] nums) {
//        this.nums = nums;
//        this.rnd = new Random();
//    }

    public int pick2(int target) {
        int result = -1, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) continue;
            if (rnd.nextInt(++count) == 0) result = i;
        }
        return result;
    }
}
