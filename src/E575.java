import java.util.*;
public class E575 {

    // My solution
    public int distributeCandies(int[] candies) {
        Set<Integer> s = new HashSet<>();
        for(int i: candies) s.add(i);
        return s.size() >= candies.length/2 ? candies.length/2 : s.size();
    }
}
