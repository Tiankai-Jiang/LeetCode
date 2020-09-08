import java.util.*;

public class H239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k <= 0) return new int[0];
        int[] res = new int[nums.length-k+1];
        int ind = 0;
        Deque<Integer> q = new ArrayDeque<>(); // store the index
        for(int i=0; i<nums.length; i++){
            if(!q.isEmpty() && q.peek() < i - k + 1) q.poll();
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]) q.pollLast();
            q.offer(i);
            if(i >= k-1) res[ind++] = nums[q.peek()];
        }
        return res;
    }
}
