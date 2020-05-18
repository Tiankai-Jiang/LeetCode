import java.util.*;
public class M64 {

    // My solution 1, Dijkstra
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for(int[] row: dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = grid[0][0];
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(2)));
        pq.add(new LinkedList<Integer>(){{add(0);add(0);add(grid[0][0]);}});
        while (!pq.isEmpty()){
            List<Integer> l = pq.poll();
            int i = l.get(0), j = l.get(1);
            if(i == m-1 && j== n-1) return dist[i][j];
            if(i+1<m && dist[i+1][j] > dist[i][j] + grid[i+1][j]){
                dist[i+1][j] = dist[i][j] + grid[i+1][j];
                pq.add(new LinkedList<Integer>(){{add(i+1);add(j);add(dist[i+1][j]);}});
            }
            if(j+1<n&& dist[i][j+1] > dist[i][j] + grid[i][j+1]){
                dist[i][j+1] = dist[i][j] + grid[i][j+1];
                pq.add(new LinkedList<Integer>(){{add(i);add(j+1);add(dist[i][j+1]);}});
            }
        }
        return dist[m-1][n-1];
    }

    // My solution 2, DP
    public int minPathSum2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        dist[0][0] = grid[0][0];
        for(int i = 1; i < grid.length; ++i) dist[i][0] = dist[i-1][0] + grid[i][0];
        for(int i = 1; i < grid[0].length; ++i) dist[0][i] = dist[0][i-1] + grid[0][i];
        for(int i = 1; i < m; ++i) for(int j = 1; j < n; ++j) dist[i][j] = grid[i][j] + Math.min(dist[i-1][j], dist[i][j-1]);
        return dist[m-1][n-1];
    }

    // dist is not necessary
    public int minPathSum3(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i=1;i<n;i++) grid[0][i] += grid[0][i-1];
        for(int i=1;i<m;i++) grid[i][0] += grid[i-1][0];
        for(int i=1;i<m;i++) for(int j=1;j<n;j++) grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
        return grid[m-1][n-1];
    }

}
