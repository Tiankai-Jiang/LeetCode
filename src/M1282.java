import java.util.*;
public class M1282 {

    // My solution, of course it is also ok to use map
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        LinkedList<List<Integer>> a = new LinkedList<>();
        LinkedList<Integer>[] c = new LinkedList[501];
        for(int i = 0; i < groupSizes.length; ++i){
            int s = groupSizes[i];
            if(c[s]==null) c[s] = new LinkedList<>();
            c[s].offer(i);
            if(c[s].size() == s){
                a.offer(c[s]);
                c[s] = null;
            }
        }
        return a;
    }
}
