import java.util.*;

public class M490 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> q = new LinkedList<int[]>(){{offer(start);}};
        boolean[][] visited = new boolean[m][n];
        while(!q.isEmpty()){
            int p[] = q.poll();
            if(p[0] == destination[0] && p[1] == destination[1]) return true;
            if(visited[p[0]][p[1]]) continue;
            visited[p[0]][p[1]] = true;
            for(int[] dir : new int[][]{{-1,0},{1,0},{0,-1},{0,1}}){
                int x = p[0], y = p[1];
                while(x>=0&&x<m&&y>=0&&y<n&&maze[x][y]==0){
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];
                q.offer(new int[]{x, y});
            }
        }
        return false;
    }
}
