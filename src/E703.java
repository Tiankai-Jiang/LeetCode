import java.util.*;

public class E703 {

    PriorityQueue<Integer> large, small;
    int cur, k;
    public E703(int k, int[] nums) {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0; i<nums.length; i++) small.offer(nums[i]);
        for(int i=0; i<k && !small.isEmpty(); i++) large.offer(small.poll());
        this.k = k;
        cur = large.size() == 0 ? 0 : large.peek();
    }

    public int add(int val) {
        if(large.size() < k){
            large.offer(val);
            cur = large.peek();
        }else{
            if(val<=cur) small.offer(val);
            else{
                large.offer(val);
                small.offer(large.poll());
                cur = large.peek();
            }
        }
        return cur;
    }

    // Only 1 pq is sufficient...
//    final PriorityQueue<Integer> q;
//    final int k;
//
//    public KthLargest(int k, int[] a) {
//        this.k = k;
//        q = new PriorityQueue<>(k);
//        for (int n : a)
//            add(n);
//    }
//
//    public int add(int n) {
//        if (q.size() < k)
//            q.offer(n);
//        else if (q.peek() < n) {
//            q.poll();
//            q.offer(n);
//        }
//        return q.peek();
//    }
}
