import java.util.Comparator;
import java.util.PriorityQueue;

public class H295 {

    PriorityQueue<Integer> large, small;

    /** initialize your data structure here. */
    public H295() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        large.offer(num);
        small.offer(large.poll());
        if(large.size()<small.size()) large.add(small.poll());
    }

    public double findMedian() {
        return large.size() > small.size() ? large.peek() : (large.peek()+small.peek())/2.0;
    }
}
