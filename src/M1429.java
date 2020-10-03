import java.util.*;
public class M1429 {

    Map<Integer, Integer> count;
    int cur;
    ArrayList<Integer> q;
    public M1429(int[] nums) {
        count = new HashMap<>();
        q = new ArrayList<>();
        for(int i: nums){
            q.add(i);
            count.merge(i, 1, Integer::sum);
        }
        cur = 0;
        while(cur < q.size() && count.get(q.get(cur))>1) cur++;
    }

    public int showFirstUnique() {
        return cur == count.size() ? -1 : q.get(cur);
    }

    public void add(int value) {
        q.add(value);
        count.merge(value, 1, Integer::sum);
        while(cur < q.size() && count.get(q.get(cur))>1) cur++;
    }
}
