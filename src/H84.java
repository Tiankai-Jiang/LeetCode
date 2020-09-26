import java.util.*;
public class H84 {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<= heights.length;){
            int h = (i == heights.length ? 0 : heights[i]);
            if(s.isEmpty() || heights[s.peek()] <= h){
                s.push(i);
                i++;
            }else{
                int curHeight = heights[s.pop()];
                int rightBoundary = i - 1;
                int leftBoundary = s.isEmpty() ? 0 : s.peek() + 1;
                int width = rightBoundary - leftBoundary + 1;
                res = Math.max(res, (curHeight * width));
            }
        }
        return res;
    }
}
