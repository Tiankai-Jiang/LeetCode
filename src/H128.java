import java.util.*;
public class H128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i: nums) s.add(i);
        int res = 0;
        for(int i: s){
            int cur = 1;
            if(!s.contains(i-1)){
                while(s.contains(i+1)){
                    cur++;
                    i++;
                }
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}
