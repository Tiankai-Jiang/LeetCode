import java.util.Stack;

public class H85 {
    public int maximalRectangle(char[][] matrix) {

        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<n; i++) dp[0][i] = matrix[0][i]-'0';
        for(int i=1; i<m; i++) for(int j=0; j<n; j++) if(matrix[i][j]=='1') dp[i][j] = dp[i-1][j] + 1;
        int res = 0;
        for(int[] row: dp) res = Math.max(res, largestRectangleArea(row));
        return res;
    }

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
