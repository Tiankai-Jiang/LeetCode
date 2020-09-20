import java.util.*;
public class H317 {

    int[][] distance; //count sum of distance from 0 to all building
    int[][] reach; //count how many building each '0' can be reached
    int[][] dirs=new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid[0].length == 0) return 0;
        int m  = grid.length, n = grid[0].length;
        distance = new int[m][n];
        reach = new int[m][n];
        int buildingNum = 0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(grid[i][j]==1){
                    buildingNum++;
                    bfs(grid,i,j);
                }
            }
        }
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
                    shortest = Math.min(shortest, distance[i][j]);
                }
            }
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;

    }
    private void bfs(int[][] grid,int x, int y){
        int m  = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        boolean[][] visited = new boolean[m][n];
        int level=1;
        while (!q.isEmpty()){
            int size=q.size();
            for (int i=0;i<size;i++){
                int[] curr=q.poll();
                for (int[] dir:dirs){
                    int x1=dir[0]+curr[0], y1=dir[1]+curr[1];
                    if(x1<0||x1>=m||y1<0||y1>=n||grid[x1][y1]!=0 ||visited[x1][y1]) continue;
                    //find next 0: level++;
                    distance[x1][y1] += level;
                    reach[x1][y1]++;
                    visited[x1][y1]=true;
                    q.offer(new int[]{x1,y1});
                }
            }
            level++;
        }
    }
}
