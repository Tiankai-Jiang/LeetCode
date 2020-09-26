import java.util.PriorityQueue;

public class M179 {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> (o2+o1).compareTo(o1+o2));
        for(int i: nums) pq.offer(String.valueOf(i));
        StringBuilder sb = new StringBuilder();
        if(pq.peek().equals("0")) return "0";
        while(!pq.isEmpty()) sb.append(pq.poll());
        return sb.toString();
    }
}
