import java.util.*;
public class E217 {

    // My solution
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i: nums) {
            if(s.contains(i)) return true;
            else s.add(i);
        }
        return false;
    }
}
