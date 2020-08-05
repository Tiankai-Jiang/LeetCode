import java.util.*;

public class M560 {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, res = 0;
        Map<Integer, Integer> m = new HashMap<Integer, Integer>(){{put(0, 1);}};
        for(int num: nums){
            sum += num;
            if(m.containsKey(sum-k)) res += m.get(sum-k);
            m.merge(sum, 1, Integer::sum);
        }
        return res;
    }
}
