import java.util.*;
public class H57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int i;
        for (i = 0; i < intervals.length; i++) {
            if(intervals[i][1] < newInterval[0]) ans.add(intervals[i]);
            else if(intervals[i][1] >= newInterval[0] && intervals[i][0] <= newInterval[1]){
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }else break;
        }
        ans.add(newInterval);
        while(i<intervals.length) ans.add(intervals[i++]);
        return ans.toArray(new int[ans.size()][2]);
    }
}
