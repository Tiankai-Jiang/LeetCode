import java.util.*;
public class M56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2) return intervals;
        List<int[]> a = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int slow = 0, fast = 1;
        while(fast < intervals.length){
            if(intervals[slow][1] >= intervals[fast][1]) fast++;
            else if(intervals[slow][1] >= intervals[fast][0]) intervals[slow][1] = intervals[fast++][1];
            else{
                a.add(intervals[slow]);
                slow = fast++;
            }
        }
        a.add(intervals[slow]);
        return a.toArray(new int[a.size()][]);
    }
}
