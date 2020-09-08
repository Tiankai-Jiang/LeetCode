import java.util.*;

public class M253 {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(Comparator.comparingInt(o -> o[1])){{offer(intervals[0]);}};
        for(int i=1; i< intervals.length; i++){
            int[] curr = pq.poll();
            if(curr[1]<=intervals[i][0]) curr[1] = intervals[i][1];
            else pq.offer(intervals[i]);
            pq.offer(curr);
        }
        return pq.size();
    }
}
