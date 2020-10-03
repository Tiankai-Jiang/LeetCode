import java.util.PriorityQueue;

public class M1167 {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i: sticks) pq.offer(i);
        int res = 0;
        while(pq.size() > 1) {
            int a = pq.poll(), b = pq.poll();
            res += a+b;
            pq.offer(a+b);
        }
        return res;
    }
}
